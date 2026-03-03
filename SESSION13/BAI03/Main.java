package SESSION13.BAI03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB){
        List<T> commonList = new ArrayList<>();
        for (T item : listA){
            if (listB.contains(item) && !commonList.contains(item)) {
                commonList.add(item);
            }
        }
        return commonList;
    }

    static void main(String[] args) {
        List<Integer> listIntA  = Arrays.asList(101, 102, 105);
        List<Integer> listIntB = Arrays.asList(102, 105, 108);

        List<Integer> resultInt = findCommonPatients(listIntA, listIntB);
        System.out.println("Test Case 1 Output: " + resultInt);

        List<String> listStrA = Arrays.asList("DN01", "DN02", "DN03");
        List<String> listStrB = Arrays.asList("DN02", "DN04");

        List<String> resultStr = findCommonPatients(listStrA, listStrB);
        System.out.println("Test Case 2 Output: " + resultStr);
    }
}
