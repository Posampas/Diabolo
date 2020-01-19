public class Enemy {
    private int hp;
    public Enemy(){
        hp = 100;
    }

    public int getHp() {
        return hp;
    }

    boolean isDead(){
        return hp <= 0;
    }
    void inflictDamage( int damage){
        hp -= damage;
    }
}
