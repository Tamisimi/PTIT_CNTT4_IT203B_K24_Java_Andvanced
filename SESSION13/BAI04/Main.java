package SESSION13.BAI04;

import java.util.LinkedList;

public class Main {
    private LinkedList<String> queue = new LinkedList<>();
    public void patientCheckIn(String name) {
        queue.addLast(name);
    }
    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
    }
    public void treatPatient(){
        if(queue.isEmpty()){
            System.out.println("Không còn bệnh nhân.");
            return;
        }
        String patient = queue.removeFirst();
        if (patient.equals("C")) {
            System.out.println("Đang cấp cứu: " + patient);
        } else {
            System.out.println("Đang khám: " + patient);
        }
    }

    static void main(String[] args) {
        SS13_04 er = new SS13_04();

        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}
