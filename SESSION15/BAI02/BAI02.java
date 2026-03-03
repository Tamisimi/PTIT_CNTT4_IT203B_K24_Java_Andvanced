package SESSION15.BAI02;

public class BAI02 {
    public static void main(String[] args) {

        PatientQueue patientQueue = new PatientQueue();

        patientQueue.addPatient(new Patient("BN01", "An", 25));
        patientQueue.addPatient(new Patient("BN02", "Bình", 40));
        patientQueue.addPatient(new Patient("BN03", "Chi", 30));

        patientQueue.displayQueue();

        System.out.println("\nBệnh nhân tiếp theo:");
        System.out.println(patientQueue.peekNextPatient());

        System.out.println("\nGọi khám:");
        System.out.println(patientQueue.callNextPatient());

        System.out.println("\nDanh sách sau khi gọi:");
        patientQueue.displayQueue();
    }
}
