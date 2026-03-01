package SESSION14.BAI01;

import java.util.LinkedHashSet;
import java.util.Set;

public class BAI01 {
    public static void main(String[] args) {

        Set<String> patients = new LinkedHashSet<>();

        String[] input = {
                "Nguyễn Văn A – Yên Bái",
                "Trần Thị B – Thái Bình",
                "Nguyễn Văn A – Yên Bái",
                "Lê Văn C – Hưng Yên"
        };

        for (String name : input) {
            patients.add(name); // tự loại bỏ trùng
        }

        System.out.println("Danh sách gọi khám:");
        for (String name : patients) {
            System.out.println(name);
        }
    }
}
