package SESSION04.BAI05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessControlTest {

    private AccessControl control;

    @BeforeEach
    void setUp() {
        control = new AccessControl();
    }

    // ADMIN tests
    @Test void adminDelete() {
        assertTrue(control.canPerformAction(Role.ADMIN, Action.DELETE_USER));
    }

    @Test void adminLock() {
        assertTrue(control.canPerformAction(Role.ADMIN, Action.LOCK_USER));
    }

    @Test void adminView() {
        assertTrue(control.canPerformAction(Role.ADMIN, Action.VIEW_PROFILE));
    }

    // MODERATOR tests
    @Test void modDelete() {
        assertFalse(control.canPerformAction(Role.MODERATOR, Action.DELETE_USER));
    }

    @Test void modLock() {
        assertTrue(control.canPerformAction(Role.MODERATOR, Action.LOCK_USER));
    }

    @Test void modView() {
        assertTrue(control.canPerformAction(Role.MODERATOR, Action.VIEW_PROFILE));
    }

    // USER tests
    @Test void userDelete() {
        assertFalse(control.canPerformAction(Role.USER, Action.DELETE_USER));
    }

    @Test void userLock() {
        assertFalse(control.canPerformAction(Role.USER, Action.LOCK_USER));
    }

    @Test void userView() {
        assertTrue(control.canPerformAction(Role.USER, Action.VIEW_PROFILE));
    }
}
