package SESSION11.MiniProject;

public abstract class GameCharacter {
    private  String name;
    private  int hp;
    private  int attackPower;//Sức tấn công cơ bản
    static int count;

    public GameCharacter() {
    }

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        GameCharacter.count = count;
    };

    public abstract void attack(GameCharacter target);
    public int takeDamage(int damage){
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            System.out.println(name + " đã bị hạ gục!");
        }
        return damage;
    }
    public void displayInfo(){
        System.out.println("Tên: " + name + " | HP: " + hp);
    }

}
