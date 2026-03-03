package SESSION15.BAI05;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyCaseQueue {

    private Queue<EmergencyCase> cases;

    public EmergencyCaseQueue() {
        cases = new LinkedList<>();
    }

    public void addCase(EmergencyCase c) {
        cases.offer(c);
        System.out.println("Đã thêm ca cấp cứu.");
    }

    public EmergencyCase getNextCase() {
        if (cases.isEmpty()) {
            System.out.println("Không có ca nào.");
            return null;
        }
        return cases.poll();
    }
}
