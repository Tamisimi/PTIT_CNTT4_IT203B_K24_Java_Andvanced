package SESSION06.BAI02;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private Queue<Ticket> tickets = new LinkedList<>();
    private String roomName;

    public TicketPool(String roomName) {
        this.roomName = roomName;
    }

    public synchronized Ticket sellTicket(String counterName) {

        while (tickets.isEmpty()) {

            System.out.println(counterName +
                    ": Hết vé phòng " + roomName + ", đang chờ...");

            try {
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Ticket t = tickets.poll();

        System.out.println(counterName +
                " bán vé " + t.getId());

        return t;
    }

    public synchronized void addTickets(int number) {

        int start = tickets.size() + 1;

        for (int i = 0; i < number; i++) {

            String id = roomName + "-0" + (start + i);
            tickets.add(new Ticket(id));
        }

        System.out.println("Nhà cung cấp: Đã thêm "
                + number + " vé vào phòng " + roomName);

        notifyAll(); // đánh thức tất cả quầy
    }
}
