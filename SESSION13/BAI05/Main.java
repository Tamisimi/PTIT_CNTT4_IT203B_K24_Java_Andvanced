package SESSION13.BAI05;
import java.util.*;
public class Main {

    static ArrayList<Patient> patientList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    dischargePatient();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    displayPatients();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);
    }

    public static void showMenu() {
        System.out.println("============== MENU ==============");
        System.out.println("1. Tiếp nhận bệnh nhân");
        System.out.println("2. Cập nhật chẩn đoán");
        System.out.println("3. Xuất viện");
        System.out.println("4. Sắp xếp danh sách bệnh nhân");
        System.out.println("5. Hiển thị danh sách bệnh nhân");
        System.out.println("6. Thoát");
        System.out.println("==================================");
    }

    public static void addPatient() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = sc.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.println("ID đã tồn tại! Không thể thêm.");
                return;
            }
        }

        System.out.print("Nhập tên bệnh nhân: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        patientList.add(new Patient(id, name, age, diagnosis));
        System.out.println("Bệnh nhân đã được thêm thành công.");
    }

    public static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân để cập nhật: ");
        String id = sc.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.print("Nhập chẩn đoán mới: ");
                String newDiagnosis = sc.nextLine();
                p.setDiagnosis(newDiagnosis);
                System.out.println("Cập nhật thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
    }

    public static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân để xuất viện: ");
        String id = sc.nextLine();

        Iterator<Patient> iterator = patientList.iterator();

        while (iterator.hasNext()) {
            Patient p = iterator.next();
            if (p.getId().equals(id)) {
                iterator.remove();
                System.out.println("Bệnh nhân đã được xuất viện.");
                return;
            }
        }

        System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
    }

    public static void sortPatients() {
        Collections.sort(patientList, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {

                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge();
                }

                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });

        System.out.println("Danh sách đã được sắp xếp.");
    }

    public static void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        System.out.println("======= Danh sách bệnh nhân =======");
        for (Patient p : patientList) {
            System.out.println(p);
        }
    }
}
