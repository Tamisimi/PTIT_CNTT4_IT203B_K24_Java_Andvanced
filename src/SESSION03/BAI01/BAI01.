package SESSION03.BAI01;

public class BAI01 {

    record User(String username, String email, Status status) {}

    enum Status {
        ACTIVE, INACTIVE
    }

    public static void main(String[] args) {
       User loc = new User("Loc", "loc@gmail.com", Status.ACTIVE);
      User minh = new User("Minh", "minh@gmail.com", Status.INACTIVE);
      User thang = new User("Thang", "thang@gmail.com", Status.ACTIVE);

        User[] users = {loc, minh, thang};

        users.forEach(user ->
            System.out.println(user.username() + " - " + user.status())
        );
    }
}
