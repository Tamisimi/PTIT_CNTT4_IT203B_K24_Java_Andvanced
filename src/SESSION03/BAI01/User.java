package SESSION03.BAI01;

public record User(
    String username,
    String email,
    Status status
) {
}

enum Status {
    ACTIVE,INACTIVE
}
