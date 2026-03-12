package SESSION04.BAI06;

import java.time.LocalDate;

public record User(
    String email,
    LocalDate birthDate
) {
    public User withEmail(String email) {
        return new User(email, this.birthDate);
    }

    public User withBirthDate(LocalDate birthDate) {
        return new User(this.email, birthDate);
    }
}
