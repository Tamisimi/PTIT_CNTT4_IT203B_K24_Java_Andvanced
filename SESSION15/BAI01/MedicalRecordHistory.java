package SESSION15.BAI01;

import java.util.Stack;

public class MedicalRecordHistory {

    private Stack<EditAction> history;

    public MedicalRecordHistory() {
        history = new Stack<>();
    }

    // Push
    public void addEdit(EditAction action) {
        history.push(action);
        System.out.println("Đã thêm chỉnh sửa.");
    }

    // Pop
    public EditAction undoEdit() {
        if (history.isEmpty()) {
            System.out.println("Không có chỉnh sửa nào để undo.");
            return null;
        }
        return history.pop();
    }

    // Peek
    public EditAction getLatestEdit() {
        if (history.isEmpty()) {
            System.out.println("Stack rỗng.");
            return null;
        }
        return history.peek();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("Chưa có chỉnh sửa nào.");
            return;
        }

        System.out.println("=== Danh sách chỉnh sửa (mới nhất trước) ===");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }
}
