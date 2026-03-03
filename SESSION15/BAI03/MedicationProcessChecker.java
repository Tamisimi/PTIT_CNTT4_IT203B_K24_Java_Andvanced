package SESSION15.BAIO3;

import java.util.Stack;

public class MedicationProcessChecker {

    private Stack<String> stack;

    public MedicationProcessChecker() {
        stack = new Stack<>();
    }

    public boolean checkProcess(String[] actions) {
        reset();

        for (int i = 0; i < actions.length; i++) {
            String action = actions[i];

            if (action.equalsIgnoreCase("PUSH")) {
                stack.push("MEDICATION");
            }

            else if (action.equalsIgnoreCase("POP")) {
                if (stack.isEmpty()) {
                    System.out.println("Lỗi tại bước " + (i + 1) +
                            ": POP khi chưa phát thuốc.");
                    return false;
                }
                stack.pop();
            }

            else {
                System.out.println("Thao tác không hợp lệ tại bước "
                        + (i + 1) + ": " + action);
                return false;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Kết thúc ca trực nhưng còn "
                    + stack.size() + " thuốc chưa hoàn tất.");
            return false;
        }

        System.out.println(" Quy trình hợp lệ.");
        return true;
    }

    public void reset() {
        stack.clear();
    }
}
