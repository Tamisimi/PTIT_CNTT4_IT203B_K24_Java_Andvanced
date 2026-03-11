package SESSION02.BAI05;

interface AdminActions {

    default void logActivity(String activity) {
        System.out.println("Admin Activity: " + activity);
    }

}
