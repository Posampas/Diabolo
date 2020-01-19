public class Hero {
    private String name;
    private int hp;
    private int lvl;
    private int strength;
    private int maxHp;
    private int upgradePoints;
    private int intelligence;

    public Hero(String name) {
        this.name = name;
        hp = 100;
        lvl = 1;
        strength = 1;
        maxHp = 100;
        upgradePoints = 0;
    }

    public String toString() {
        return name + "  lvl:" + lvl + "\n" +
                "Health points " + hp + "\\" + maxHp + "\n" +
                "Strength: " + strength + "\n" +
                "Intelligence: " + intelligence + "\n" +
                "upgradePoints: " + upgradePoints;
    }

    public int getHp() {
        return hp;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    void lvlUP() {
        lvl += 1;
        upgradePoints += 5;
        System.out.println("You are now on " + lvl + " lvl!!!" +
                "You have " + upgradePoints + " upgrade points left");


    }

    void inflictDamage(int damage) {
        this.hp -= damage;
    }

    public int getStrength() {
        return strength;
    }

    public int getLvl() {
        return lvl;
    }

    void upgrading() {
        boolean isUpgrading = true;
        while (isUpgrading) {
            System.out.println("You have " + upgradePoints + " upgrade points choose wisely");
            System.out.println("1. - Add strength " +
                    "2. - Add intelligence " +
                    "3. - Increase max health " +
                    "0. - Return");
            switch (Main.inputNumeric()) {
                case 1:
                    if (upgradePoints > 0) {
                        strength += 1;
                        upgradePoints -= 1;
                    }
                    break;
                case 2:
                    if (upgradePoints > 0) {
                        intelligence += 1;
                        upgradePoints -= 1;
                    }
                    break;
                case 3:
                    if (upgradePoints > 0) {
                        maxHp += 5;
                        upgradePoints -= 1;
                    }
                    break;
                case 0:
                    isUpgrading = false;
                    break;
                default:
                    System.out.println("There is no such perk");
            }
        }
    }


}
