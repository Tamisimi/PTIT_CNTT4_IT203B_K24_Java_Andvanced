package SESSION14.BAI06;

import java.util.*;

public class BAI06 {
    public static void main(String[] args) {

        List<Patient> patients = Arrays.asList(
                new Patient("Lan", 30, "Tim mạch"),
                new Patient("Hùng", 45, "Nội tiết"),
                new Patient("Mai", 28, "Tim mạch")
        );

        Map<String, List<Patient>> departmentMap = new HashMap<>();

        for (Patient p : patients) {
            if (!departmentMap.containsKey(p.department)) {
                departmentMap.put(p.department, new ArrayList<>());
            }
            departmentMap.get(p.department).add(p);
        }

        System.out.println("Danh sách theo khoa:");
        for (Map.Entry<String, List<Patient>> entry : departmentMap.entrySet()) {
            System.out.println("Khoa " + entry.getKey() + " -> " + entry.getValue());
        }

        String maxDepartment = "";
        int maxSize = 0;

        for (Map.Entry<String, List<Patient>> entry : departmentMap.entrySet()) {
            if (entry.getValue().size() > maxSize) {
                maxSize = entry.getValue().size();
                maxDepartment = entry.getKey();
            }
        }

        System.out.println("\nKhoa " + maxDepartment +
                " đang đông nhất (" + maxSize + " bệnh nhân)");
    }
}
