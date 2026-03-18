package SESSION12.BAI05;

interface UserActions {

    default void logActivity(String activity) {
        System.out.println("User Activity: " + activity);
    }

}
