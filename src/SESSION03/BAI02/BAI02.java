package SESSION03.BAI02;

import java.util.Arrays;

public class BAI02 { 

    record User(String username, String email, Status status) {}

    enum Status {
        ACTIVE, INACTIVE
    }

    public static void main(String[] args) {
        User[] users = {
            new User("loc","loc@gmail.com",Status.ACTIVE),
            new User("minh","minh@yahoo.com",Status.INACTIVE),
            new User("thang", "thang@gmail.com",Status.ACTIVE)
        };

        Arrays.stream(users)
              .filter(user -> user.email().endsWith("@gmail.com"))
              .forEach(user -> System.out.println(user.username()));
    }
}
