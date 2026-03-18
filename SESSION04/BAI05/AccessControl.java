package SESSION04.BAI05;

public class AccessControl {

    public boolean canPerformAction(Role role, Action action) {
        if (role == null || action == null) {
            return false;
        }

        switch (role) {
            case ADMIN:
                return true;  // ADMIN có tất cả quyền

            case MODERATOR:
                return action == Action.LOCK_USER || action == Action.VIEW_PROFILE;

            case USER:
                return action == Action.VIEW_PROFILE;

            default:
                return false;
        }
    }
}
