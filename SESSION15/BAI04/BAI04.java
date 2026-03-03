package SESSION15.BAI04;

public class BAI04 {
    public static void main(String[] args) {

        EmergencyQueue eq = new EmergencyQueue();

        eq.addPatient("BN01", "An", 2);
        eq.addPatient("BN02", "Bình", 1);
        eq.addPatient("BN03", "Chi", 2);
        eq.addPatient("BN04", "Dũng", 1);

        System.out.println("\nGọi khám:");
        System.out.println(eq.callNextPatient());
        System.out.println(eq.callNextPatient());
    }
}
