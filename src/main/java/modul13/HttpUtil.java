package modul13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
public class HttpUtil {
    private final static HttpClient CLIENT = HttpClient.newHttpClient();
    private final static String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static Gson GSON = new Gson();

    static void createUser(User user) throws Exception {
        String userJson = GSON.toJson(user);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(USERS_URL))
                .POST(HttpRequest.BodyPublishers.ofString(userJson))
                .header("content-type", "application/json")
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    static User updateUser(User user, int id) throws Exception {
        String userJson = GSON.toJson(user);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(USERS_URL + "/" + id))
                .PUT(HttpRequest.BodyPublishers.ofString(userJson))
                .header("content-type", "application/json")
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return GSON.fromJson(response.body(), User.class);
    }

    static void deleteUser(int id) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(USERS_URL + "/" + id))
                .DELETE()
                .header("content-type", "application/json")
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    static List<User> readUsers() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(USERS_URL))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
    }

    static User readUserId(int id) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(USERS_URL + "/" + id))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return GSON.fromJson(response.body(), User.class);
    }

    static User readUserName(String username) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(USERS_URL + "?username=" + username))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        List<User> result = GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
        return result.get(0);
    }

    static void readUserComments(int userId) throws Exception {
        int maxPostId = getMaxPostId(userId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/" + maxPostId + "/comments"))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<Comment> comments = GSON.fromJson(response.body(), new TypeToken<List<Comment>>(){}.getType());
        writeCommentsToJson(comments, userId, maxPostId);
    }

    static int getMaxPostId(int userId) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(USERS_URL + "/" + userId + "/posts"))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<Post> posts = GSON.fromJson(response.body(), new TypeToken<List<Post>>(){}.getType());
        Integer maxPostId = posts.stream()
                .map(Post::getId)
                .max(Integer::compare)
                .get();
        return maxPostId;
    }

    static void writeCommentsToJson (List<Comment> comments, Integer userId, int maxPostId){
        GSON = new Gson().newBuilder().setPrettyPrinting().create();

        try (PrintWriter out = new PrintWriter(new FileWriter("user-"+ userId + "-post-" + maxPostId + "-comments.json")))
        {
            out.write(GSON.toJson(comments));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static List<Task> readUserTasks(int userId) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(USERS_URL + "/" + userId + "/todos?completed=false"))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return GSON.fromJson(response.body(), new TypeToken<List<Task>>(){}.getType());
    }
}
