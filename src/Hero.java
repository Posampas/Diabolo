public class Hero {
    String name;
    int hp;
    private int lvl;

    public Hero(String name){
        this.name = name;
        hp = 100;
        lvl = 0;
    }

    public String toString(){
         return name + " hp: " + hp;
    }

    public int getHp() {
        return hp;
    }
    public boolean isDead(){
        return hp <= 0;
    }

    void lvlUP (){
        lvl += 1;
        System.out.println("You are now on "+ lvl + " lvl!!!");
    }
}
