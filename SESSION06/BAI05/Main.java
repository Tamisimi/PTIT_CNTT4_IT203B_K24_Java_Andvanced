package SESSION06.BAI05;
public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 6);
        TicketPool roomC = new TicketPool("C", 7);

        TicketPool[] pools = {roomA, roomB, roomC};

        for (int i = 1; i <= 5; i++) {

            Thread t =
                    new Thread(new BookingCounter(
                            "Quầy " + i, pools));

            t.start();
        }

        Thread timeout =
                new Thread(new TimeoutManager(pools));

        timeout.start();
    }
}
