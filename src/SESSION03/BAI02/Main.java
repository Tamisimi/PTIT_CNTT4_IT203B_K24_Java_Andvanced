package SESSION03.BAI02;

import java.util.List;

public class Main {
    public static void main(String[] args) {
         User loc   = new User("loc",   "loc@gmail.com",   Status.ACTIVE);
        User minh     = new User("minh",     "minh@example.com",     Status.INACTIVE);
        User thang = new User("thang", "thang@example.com", Status.ACTIVE);

        List<User> users = List.of(loc, minh, thang);

        System.out.println("Username của người dùng có email @gmail.com:");
        users.stream()
             .filter(user -> user.email().endsWith("@gmail.com"))
             .forEach(user -> System.out.println(user.username()));
    }
}
