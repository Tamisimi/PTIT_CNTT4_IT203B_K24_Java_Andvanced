package SESSION15.BAI05;

public class BAI05 {
    public static void main(String[] args) {

        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        EmergencyCase case1 = new EmergencyCase(
                new Patient("BN01", "An", 25));
        EmergencyCase case2 = new EmergencyCase(
                new Patient("BN02", "Bình", 40));

        queue.addCase(case1);
        queue.addCase(case2);

        EmergencyCase current = queue.getNextCase();

        System.out.println("\nĐang xử lý: " + current.getPatient());

        current.addStep(new TreatmentStep("Tiếp nhận", "10:00"));
        current.addStep(new TreatmentStep("Chẩn đoán", "10:05"));
        current.addStep(new TreatmentStep("Điều trị", "10:15"));

        current.displaySteps();

        System.out.println("\nUndo bước:");
        System.out.println(current.undoStep());

        System.out.println("\nSau khi undo:");
        current.displaySteps();
    }
}
