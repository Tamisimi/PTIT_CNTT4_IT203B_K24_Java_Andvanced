package SESSION04.BAI06;

import java.time.LocalDate;
import java.util.List;

public class ProfileUpdater {

    public User updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers) {
        if (existingUser == null || newProfile == null) {
            return null;
        }

        LocalDate birthDate = newProfile.getBirthDate();
        if (birthDate != null && birthDate.isAfter(LocalDate.now())) {
            return null;  // Ngày sinh tương lai → từ chối
        }

        String newEmail = newProfile.getEmail();
        if (newEmail != null && !newEmail.equals(existingUser.getEmail())) {
            boolean emailExists = allUsers.stream()
                    .anyMatch(u -> u != existingUser && newEmail.equals(u.getEmail()));
            if (emailExists) {
                return null;  // Email trùng với user khác → từ chối
            }
        }

        // Cập nhật thành công
        existingUser.setEmail(newProfile.getEmail());
        existingUser.setBirthDate(newProfile.getBirthDate());
        // Có thể cập nhật thêm các field khác nếu cần...

        return existingUser;
    }
}
