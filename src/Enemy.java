public class Enemy {
    private int hp;
    private int lvl;
    public Enemy(int heroLvl){
        hp = (int)(Math.random()*heroLvl)+10;
        lvl = (int)(Math.random()*heroLvl)+1;
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

    public int getLvl() {
        return lvl;
    }
}
