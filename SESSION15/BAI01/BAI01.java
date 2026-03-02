package SESSION15.BAI01;

public class BAI01 {
    public static void main(String[] args) {

        MedicalRecordHistory history = new MedicalRecordHistory();

        history.addEdit(new EditAction("Thêm chẩn đoán: Cảm cúm", "10:00"));
        history.addEdit(new EditAction("Cập nhật đơn thuốc", "10:15"));
        history.addEdit(new EditAction("Sửa liều lượng thuốc", "10:30"));

        history.displayHistory();

        System.out.println("\nChỉnh sửa gần nhất:");
        System.out.println(history.getLatestEdit());

        System.out.println("\nUndo chỉnh sửa:");
        System.out.println(history.undoEdit());

        System.out.println("\nDanh sách sau khi undo:");
        history.displayHistory();
    }
}
