package SESSION03.BAI01;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User alice   = new User("alice",   "alice@example.com",   Status.ACTIVE);
        User bob     = new User("bob",     "bob@example.com",     Status.INACTIVE);
        User charlie = new User("charlie", "charlie@example.com", Status.ACTIVE);

        List<User> users = List.of(alice, bob, charlie);

        users.stream().forEach(System.out::println);
    }
}
