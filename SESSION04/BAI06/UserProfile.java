package SESSION04.BAI06;

import java.time.LocalDate;

public record UserProfile(
    String email,
    LocalDate birthDate
) {}
