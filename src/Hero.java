public class Hero {
    String name;
    int hp;

    public Hero(String name){
        this.name = name;
        hp = 100;
    }

    public String toString(){
         return name + " hp: " + hp;
    }

    public int getHp() {
        return hp;
    }
    public boolean isDead(){
        return hp < 0;
    }
}
