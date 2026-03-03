package SESSION11.MiniProject;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ARENA OF HEROES ===");
        Warrior yasuo = new Warrior("Yasuo", 500, 50, 20);
        Mage veigar = new Mage("Veigar", 300, 60, 200);
        GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("3. [Quái vật] Goblin (Anonymous Class) tấn công!");
                System.out.println("   -> Goblin cắn trộm " + target.getName() + "... Gây 10 sát thương.");
                target.takeDamage(10);
            }
        };

        System.out.println("Đã khởi tạo " + GameCharacter.getCount() + " nhân vật tham gia đấu trường.\n");

        yasuo.attack(veigar);
        veigar.attack(yasuo);
        veigar.attack(yasuo);
        veigar.useUltimate(yasuo);

        System.out.println("\n=== THÔNG SỐ SAU LƯỢT ĐẤU ===");

        System.out.println("Tên: Yasuo | HP: " + yasuo.getHp() + " | Giáp: " + yasuo.getArmor());
        System.out.println("Tên: Veigar | HP: " + veigar.getHp() + " | Mana: "+ veigar.getMana());
        System.out.println("Tên: Goblin | HP: " + goblin.getHp());
    }
}
