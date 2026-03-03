package SESSION13.BAI02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main{
    static void main(String[] args) {
        List<String> input = Arrays.asList(
                "Paracetamol",
                "Ibuprofen",
                "Panadol",
                "Paracetamol",
                "Aspirin",
                "Ibuprofen"
        );
        System.out.println("Input: " + input);

        List<String> result = getUniqueSortedMedicines(input);

        System.out.println("Output: " + result);
    }
    public static List<String> getUniqueSortedMedicines(List<String>inputList){

        ArrayList<String> uniqueList = new ArrayList<>();

        for (String medicine : inputList) {
            if (!uniqueList.contains(medicine)) {
                uniqueList.add(medicine);
            }
        }

        Collections.sort(uniqueList);

        return uniqueList;
    }
}
