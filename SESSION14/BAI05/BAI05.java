package session14.hw05;

import java.util.Comparator;
import java.util.TreeSet;

class Patient {
    String name;
    int severity;      
    int arrivalTime;   

    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (Mức " + severity + ", đến lúc " + arrivalTime + ")";
    }
}

public class SS14_05 {
    public static void main(String[] args) {

        Comparator<Patient> triageComparator = (p1, p2) -> {
            if (p1.severity != p2.severity) {
                return p1.severity - p2.severity; 
            }
            return p1.arrivalTime - p2.arrivalTime;
        };

        TreeSet<Patient> queue = new TreeSet<>(triageComparator);

        queue.add(new Patient("Bệnh nhân A", 3, 800));
        queue.add(new Patient("Bệnh nhân B", 1, 815));
        queue.add(new Patient("Bệnh nhân C", 1, 805));

        System.out.println("Thứ tự xử lý:");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}
