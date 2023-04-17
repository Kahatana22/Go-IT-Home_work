package Modul10.Tasks.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserOverwriting {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/main/java/Modul10/Resource/user.txt");
        BufferedReader bf = new BufferedReader(fr);
        String str = "";
        String line = bf.readLine();
        while (line != null) {
            str += line + "\n";
            line = bf.readLine();
        }
        users(str);
        System.out.println("str = " + str);
        bf.close();
    }

    private static void users(String str) throws IOException {
        List<User> list = new ArrayList<>();
        String[] array = str.split("\n");
        for (int i = 1; i < array.length; i += 1) {
            String[] newArray = array[i].split(" ");
            list.add(new User((newArray[0]), Integer.parseInt(newArray[1])));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonWriter jw = gson.newJsonWriter(new FileWriter("src/main/java/Modul10/Resource/user.json"));
        String json = gson.toJson(list);
        jw.jsonValue(json);
        System.out.println("json = " + json);
        jw.close();
    }
}
