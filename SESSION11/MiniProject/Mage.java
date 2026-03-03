package SESSION11.MiniProject;

public class Mage extends GameCharacter implements  ISkill{
    private  int mana;

    public Mage(int mana) {
        this.mana = mana;
    }

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("1. [Phap su] " + getName() + " tấn công " + target.getName() + "!");
        int damage;
        if(mana >= 5){
            damage = getAttackPower();
            mana  -= 5;
            int realDame = target.takeDamage(damage);
            System.out.println("   -> " + target.getName() + " mất " +  realDame + " máu. HP còn: " + target.getHp() + ".");
        }else{
            damage = getAttackPower()/2;
             int realDame = target.takeDamage(damage);
            System.out.println("   -> " + target.getName() + " mất " +  realDame + " máu. HP còn: " + target.getHp() + ".");
        }
    };

    @Override
    public int takeDamage(int damage) {
        return super.takeDamage(damage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Pháp sư] " + getName() + " dùng chiêu cuối lên " + target.getName() + "!");
        if(mana >= 50){
            mana -= 50;
            int damage = getAttackPower() * 2;
            int realDame =   target.takeDamage(damage);

            System.out.println("   -> " + getName() + " tốn 50 mana. "
                    + target.getName() + " mất " + realDame + " máu.");
        }
    }
}
