package session06.BAI01;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A");
        TicketPool roomB = new TicketPool("B");

        for (int i = 1; i <= 3; i++) {
            roomA.addTicket(new Ticket("A-00" + i));
            roomB.addTicket(new Ticket("B-00" + i));
        }

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomB, roomA);

        counter1.start();
        counter2.start();
    }
}
