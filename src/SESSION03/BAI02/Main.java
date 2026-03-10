package SESSION03.BAI02;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User alice   = new User("alice",   "alice@gmail.com",   Status.ACTIVE);
        User bob     = new User("bob",     "bob@yahoo.com",     Status.INACTIVE);
        User charlie = new User("charlie", "charlie@gmail.com", Status.ACTIVE);
        User david   = new User("david",   "david@outlook.com", Status.ACTIVE);
        User eve     = new User("eve",     "eve@gmail.com",     Status.INACTIVE);

        List<User> users = List.of(alice, bob, charlie, david, eve);

        System.out.println("Username của người dùng có email @gmail.com:");
        users.stream()
             .filter(user -> user.email().endsWith("@gmail.com"))
             .forEach(user -> System.out.println(user.username()));
    }
}
