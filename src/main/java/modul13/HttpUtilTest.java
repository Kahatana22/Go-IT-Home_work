package modul13;

import lombok.SneakyThrows;

import static modul13.HttpUtil.*;

public class HttpUtilTest {

    @SneakyThrows
    public static void main(String[] args) {

        User newUser = User.builder()
                .name("Chelsey Dietrich")
                .username("Elw")
                .email("Telly.Hoeger@billy.biz")
                .address(new Address("Ho Mall", "Apt. 692", "South Elvis", "53919-4257", new Geo("29.4572", "-164.2990")))
                .phone("(775)976-6794 x41206")
                .website("conrad.com")
                .company(new Company("Abernathy Group", "Configurable multimedia task-force", "revolutionize end-to-end systems"))
                .build();

        createUser(newUser);
        newUser.setName("Valentina Silyaeva");
        updateUser(newUser, 7);
        deleteUser(5);
        readUsers();
        readUserId(4);
        readUserName("Samantha");
        readUserComments(2);
        readUserTasks(2);
    }
}
