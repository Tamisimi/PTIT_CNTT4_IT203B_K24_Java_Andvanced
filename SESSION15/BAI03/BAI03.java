package SESSION15.BAI03;

public class BAI03 {
    public static void main(String[] args) {

        MedicationProcessChecker checker = new MedicationProcessChecker();

        String[] case1 = {"PUSH", "PUSH", "POP", "POP"};
        String[] case2 = {"PUSH", "POP", "POP"};
        String[] case3 = {"PUSH", "PUSH", "POP"};

        System.out.println("Case 1:");
        checker.checkProcess(case1);

        System.out.println("\nCase 2:");
        checker.checkProcess(case2);

        System.out.println("\nCase 3:");
        checker.checkProcess(case3);
    }
}
