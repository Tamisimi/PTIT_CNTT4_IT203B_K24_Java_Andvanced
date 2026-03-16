package SESSION07.BAI02;

public class Main {
    public static void main(String[] args) {

        double total = 1000000;

        OrderCalculator percentCalc =
                new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Số tiền sau giảm: " + percentCalc.calculate(total));

        OrderCalculator fixedCalc =
                new OrderCalculator(new FixedDiscount(50000));
        System.out.println("Số tiền sau giảm: " + fixedCalc.calculate(total));

        OrderCalculator noCalc =
                new OrderCalculator(new NoDiscount());
        System.out.println("Số tiền sau giảm: " + noCalc.calculate(total));

        OrderCalculator holidayCalc =
                new OrderCalculator(new HolidayDiscount());
        System.out.println("Số tiền sau giảm: " + holidayCalc.calculate(total));
    }
}
