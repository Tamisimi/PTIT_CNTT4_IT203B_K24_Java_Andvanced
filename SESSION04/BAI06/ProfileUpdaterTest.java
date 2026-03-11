package SESSION04.BAI06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProfileUpdaterTest {

    private ProfileUpdater updater;
    private User existing;
    private List<User> users;

    @BeforeEach
    void setUp() {
        updater = new ProfileUpdater();
        existing = new User("old@example.com", LocalDate.of(2000, 5, 15));
        users = List.of(
            existing,
            new User("other1@gmail.com", LocalDate.of(1995, 1, 1)),
            new User("other2@yahoo.com", LocalDate.of(2001, 10, 20))
        );
    }

    @Test void ok(){
      assertNotNull(updater.updateProfile(existing, new UserProfile("new@gmail.com", LocalDate.of(1998, 3, 10)), users));
    }
    @Test void future(){
      assertNull(updater.updateProfile(existing, new UserProfile("new@gmail.com", LocalDate.now().plusDays(1)), users));
    }
    @Test void dupEmail(){
      assertNull(updater.updateProfile(existing, new UserProfile("other1@gmail.com", LocalDate.of(2000, 5, 15)), users));
    }
    @Test void sameEmail(){
      assertNotNull(updater.updateProfile(existing, new UserProfile("old@example.com", LocalDate.of(2002, 7, 20)), users));
    }
    @Test void emptyList(){
      assertNotNull(updater.updateProfile(existing, new UserProfile("new@gmail.com", LocalDate.of(1999, 12, 5)), List.of()));
    }
    @Test void multiFail(){
      assertNull(updater.updateProfile(existing, new UserProfile("other2@yahoo.com", LocalDate.now().plusYears(1)), users));
    }
}
