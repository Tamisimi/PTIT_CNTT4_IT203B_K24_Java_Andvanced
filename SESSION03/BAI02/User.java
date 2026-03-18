package SESSION03.BAI02;

public record User(
    String username,
    String email,
    Status status
) {
}

enum Status {
    ACTIVE,INACTIVE
}
