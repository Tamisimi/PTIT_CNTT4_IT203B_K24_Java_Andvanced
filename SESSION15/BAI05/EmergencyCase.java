package SESSION15.BAI05;

import java.util.Stack;

public class EmergencyCase {

    private Patient patient;
    private Stack<TreatmentStep> steps;

    public EmergencyCase(Patient patient) {
        this.patient = patient;
        this.steps = new Stack<>();
    }

    public Patient getPatient() {
        return patient;
    }

    // PUSH
    public void addStep(TreatmentStep step) {
        steps.push(step);
        System.out.println("Đã thêm bước xử lý.");
    }

    // POP (Undo)
    public TreatmentStep undoStep() {
        if (steps.isEmpty()) {
            System.out.println("Không có bước nào để undo.");
            return null;
        }
        return steps.pop();
    }

    public void displaySteps() {
        if (steps.isEmpty()) {
            System.out.println("Chưa có bước xử lý.");
            return;
        }

        System.out.println("=== Các bước xử lý (mới nhất trước) ===");
        for (int i = steps.size() - 1; i >= 0; i--) {
            System.out.println(steps.get(i));
        }
    }
}
