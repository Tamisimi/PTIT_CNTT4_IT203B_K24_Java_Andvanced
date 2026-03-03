package SESSION14.BAI03;

import java.util.HashSet;
import java.util.Set;

public class BAI03 {
    public static void main(String[] args) {

        Set<String> drugIngredients = new HashSet<>();
        drugIngredients.add("Aspirin");
        drugIngredients.add("Caffeine");
        drugIngredients.add("Paracetamol");

        Set<String> allergies = new HashSet<>();
        allergies.add("Penicillin");
        allergies.add("Aspirin");

        Set<String> warning = new HashSet<>(drugIngredients);
        warning.retainAll(allergies);

        Set<String> safeIngredients = new HashSet<>(drugIngredients);
        safeIngredients.removeAll(allergies);

        System.out.println("Cảnh báo dị ứng: " + warning);
        System.out.println("Thành phần an toàn: " + safeIngredients);
    }
}
