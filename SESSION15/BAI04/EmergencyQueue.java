package SESSION15.BAI04;

import java.util.PriorityQueue;

public class EmergencyQueue {

    private PriorityQueue<EmergencyPatient> queue;
    private int counter = 0; 

    public EmergencyQueue() {
        queue = new PriorityQueue<>((p1, p2) -> {
            if (p1.getPriority() != p2.getPriority()) {
                return p1.getPriority() - p2.getPriority(); 
            }
            return p1.getArrivalOrder() - p2.getArrivalOrder(); 
        });
    }

    public void addPatient(String id, String name, int priority) {
        queue.offer(new EmergencyPatient(id, name, priority, counter++));
        System.out.println("Đã thêm bệnh nhân.");
    }

    public EmergencyPatient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân.");
            return null;
        }
        return queue.poll();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân đang chờ.");
            return;
        }

        System.out.println("=== Danh sách chờ ===");
        for (EmergencyPatient p : queue) {
            System.out.println(p);
        }
    }
}
