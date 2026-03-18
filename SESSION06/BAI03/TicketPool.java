package SESSION06.BAI03;

<<<<<<< HEAD
import SESSION06.BAI01.Ticket;
=======
import session06.hw01.Ticket;
>>>>>>> 18f89c6adf82826124be9ab10499bfde3e6e91e4

import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private Queue<Ticket> tickets = new LinkedList<>();
    private String roomName;
    private int ticketCounter = 1;

    public TicketPool(String roomName, int initial) {
        this.roomName = roomName;

        for (int i = 0; i < initial; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", ticketCounter++)));
        }
    }

    public synchronized Ticket sellTicket() {

        if (tickets.isEmpty()) {
            return null;
        }

        return tickets.poll();
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {

            tickets.add(new Ticket(
                    roomName + "-" + String.format("%03d", ticketCounter++)
            ));
        }

        System.out.println("Nhà cung cấp: Đã thêm "
                + count + " vé vào phòng " + roomName);
    }

    public synchronized int getRemainingTickets() {
        return tickets.size();
    }
}
