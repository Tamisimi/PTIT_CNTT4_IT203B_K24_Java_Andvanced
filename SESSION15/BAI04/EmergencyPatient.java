package SESSION15.BAI04;

public class EmergencyPatient {
    private String id;
    private String name;
    private int priority; 
    private int arrivalOrder; 

    public EmergencyPatient(String id, String name, int priority, int arrivalOrder) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.arrivalOrder = arrivalOrder;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Tên: " + name +
                " | Mức độ: " + (priority == 1 ? "CẤP CỨU" : "THƯỜNG");
    }
}
