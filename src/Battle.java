import java.util.Timer;
import java.util.TimerTask;

public class Battle {

    String action = "";
    boolean isWon = false;



    public static void battleMain() {
        Battle battle = new Battle();
    }

    public void Fight(Hero player) {
        Enemy monster = new Enemy();

        boolean stillFighting = true;

        while (stillFighting) {


            boolean reacted =false;
            long attackStartTime = System.nanoTime();
            long reactionTime=0;

            // Enemy is choosing were to attack
            int wereEnemyIsAttacking = wereToAttack(attackRandomize(9,1));
            System.out.println(wereEnemyIsAttacking);


            switch (Main.inputNumeric()) {
                case 1:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(1,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                case 2:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(2,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                case 3:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(3,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                case 4:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(4,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                case 5:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(5,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                case 6:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(6,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                case 7:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(7,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                case 8:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(8,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                case 9:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(9,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    System.out.println(reacted);
                    break;
                default:
                    System.out.println("Not a proper action");
            }
            if (reacted) {
                monster.inflictDamage(50);
                System.out.println("Monster hp:" + monster.getHp());

            } else {
                player.hp -= 50;
                System.out.println("Player hp:" + player.getHp());
            }

            if (monster.isDead()) {
                player.lvlUP();
                isWon = true;
                stillFighting = false;
            }

        }
    }
    private int attackRandomize(int upperBound, int lowerBound){
        return  (int)(Math.random()*upperBound) + lowerBound ;
    }
    private int wereToAttack (int random){

        switch (random){
            case 1:
                System.out.println("He want to kick you witch RIGHT LEG");
                return 1;
            case 2:
                System.out.println("He is reaching for your LEGS");
                return 2;
            case 3:
                System.out.println("He want to kick you witch LEFT LEG");
                return 3;
            case 4:
                System.out.println("He is attacking with RIGHT HAND");
                return 3;
            case 5:
                System.out.println("He is targeting your CHEST");
                return 5;
            case 6:
                System.out.println("He is attacking with LEFT HAND");
                return 6;
            case 7:
                System.out.println("He is drinking a POTION");
                return 7;
            case 8:
                System.out.println("He is reaching for your HEAD");
                return 8;
            case 9:
                System.out.println("He is going to THROW something");
                return 9;
            default:
                return 0;
        }
    }
    private boolean isReactionGood( int action, int properAction, long attackTime, long reactionTime){
        System.out.printf(" Reaction: %10d ns = %.3f sec%n",
                reactionTime-attackTime, (reactionTime-attackTime)*1e-9);
        if (action == properAction){
            return (reactionTime - attackTime) <= 3000000000L;
        }
        return false;
    }

}
