package SESSION02.BAI05;

class SuperAdmin implements AdminActions {

    @Override
    public void logActivity(String activity) {

        AdminActions.super.logActivity(activity);

    }
}
