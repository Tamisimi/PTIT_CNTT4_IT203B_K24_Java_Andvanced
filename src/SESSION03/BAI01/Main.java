package SESSION03.Main;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        User alice   = new User("alice",   "alice@example.com",   Status.ACTIVE);
        User bob     = new User("bob",     "bob@example.com",     Status.INACTIVE);
        User charlie = new User("charlie", "charlie@example.com", Status.ACTIVE);
        
        List<User> users = List.of(alice, bob, charlie);
        
        System.out.println("Danh sách người dùng:");        
        users.forEach(user -> {
            System.out.printf("Username: %-10s | Email: %-25s | Status: %s%n",
                user.username(),
                user.email(),
                user.status());
        });
    }
}
