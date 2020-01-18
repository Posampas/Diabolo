import java.util.Timer;
import java.util.TimerTask;

public class Battle {

    String action = "";

    boolean reacted = true;

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (action.equals("")) {
                System.out.println("To slow");
                reacted = false;
                return;
            }
        }
    };


    public static void battleMain() {
        Battle battle = new Battle();
    }

    public void Fight(Hero player) {
        Enemy monster = new Enemy();
        boolean stillFighting = true;
        while (stillFighting) {

            Timer timer = new Timer();
            try {
                timer.schedule(task, 3 * 1000);
            } catch (IllegalStateException e) {
                reacted = true;
                return;
            }

            switch (Main.inputNumeric()) {
                case 1:
                    System.out.println(1);
                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
                default:
                    System.out.println("Not a proper action");
            }
            if (reacted) {
                monster.hp -= 50;
                System.out.println("Monster hp:" + monster.getHp());

            } else {
                player.hp -= 50;
                System.out.println("Player hp:" + monster.getHp());
            }
        }
    }
}
