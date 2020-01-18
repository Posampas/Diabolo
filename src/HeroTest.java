import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void getHp() {
        Hero hero = new Hero("koo");
        assertEquals(100,hero.hp);
    }

    @Test
    void isDead() {
        Hero hero = new Hero("ll");
        assertFalse(hero.isDead());
        hero.hp = -1;
        assertTrue(hero.isDead());

    }
}