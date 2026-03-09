package SESSION02.BAI05;

class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {

        AdminActions.super.logActivity(activity);

    }
}
