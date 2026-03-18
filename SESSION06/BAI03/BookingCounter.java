package SESSION06.BAI03;

<<<<<<< HEAD
import SESSION06.BAI01.Ticket;

=======
>>>>>>> 18f89c6adf82826124be9ab10499bfde3e6e91e4
public class BookingCounter implements Runnable {

    private String name;
    private TicketPool pool;
    private int soldCount = 0;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            Ticket t = pool.sellTicket();

            if (t != null) {

                soldCount++;

                System.out.println(name +
                        " đã bán vé " + t.getId());

            } else {

                // nếu hết vé thì nghỉ chút
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    public int getSoldCount() {
        return soldCount;
    }
}
