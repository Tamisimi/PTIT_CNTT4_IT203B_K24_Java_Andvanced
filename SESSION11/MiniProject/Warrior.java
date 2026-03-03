package SESSION11.MiniProject;

public class Warrior extends GameCharacter implements ISkill{
    private int armor;

    public Warrior(int armor) {
        this.armor = armor;
    }

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Chiến binh] " + getName() + " tấn công " + target.getName() + "!");
        int damage = getAttackPower();
        int realDamage = target.takeDamage(damage);
        System.out.println("   -> " + target.getName() + " mất " + realDamage + " máu. HP còn: " + target.getHp() + ".");
    }

    @Override
    public int takeDamage(int damage) {
        int realDamage = damage - armor;
        if(realDamage < 0) realDamage = 0;
         return super.takeDamage(realDamage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Chiến binh] " + getName() + " dùng chiêu cuối lên " + target.getName() + "!");
        int damage = getAttackPower() * 2;
        target.takeDamage(damage);

        int selfDamage = (int)(getHp() * 0.1);
        setHp(getHp() - selfDamage);
    }
}
