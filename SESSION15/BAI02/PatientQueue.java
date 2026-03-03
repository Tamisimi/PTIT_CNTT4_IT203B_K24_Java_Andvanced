package SESSION15.BAI02;

import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {

    private Queue<Patient> queue;

    public PatientQueue() {
        queue = new LinkedList<>();
    }

    // Enqueue
    public void addPatient(Patient p) {
        queue.offer(p);
        System.out.println("Đã thêm bệnh nhân vào hàng đợi.");
    }

    // Dequeue
    public Patient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân nào.");
            return null;
        }
        return queue.poll();
    }

    // Peek
    public Patient peekNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Hàng đợi rỗng.");
            return null;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân đang chờ.");
            return;
        }

        System.out.println("=== Danh sách bệnh nhân đang chờ ===");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}
