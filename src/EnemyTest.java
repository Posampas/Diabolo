import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void isDead() {
        Enemy enemy = new Enemy(1);
        assertFalse(enemy.isDead());
        enemy.inflictDamage(101);
        assertTrue(enemy.isDead());

    }

    @Test
    void inflictDamage() {

        Enemy enemy = new Enemy(1);
        int hpBeforeAttack = enemy.getHp();
        enemy.inflictDamage(10);
        int hpAfterAttack = enemy.getHp();

        assertFalse(hpAfterAttack>=hpBeforeAttack);
    }
}