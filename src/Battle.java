import java.util.Timer;
import java.util.TimerTask;

public class Battle {

    String action = "";
    boolean isWon = false;



    public static void battleMain() {
        Battle battle = new Battle();
    }

    public void Fight(Hero player) {
        Enemy monster = new Enemy(player.getLvl());

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
                    break;
                case 2:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(2,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    break;
                case 3:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(3,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    break;
                case 4:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(4,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    break;
                case 5:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(5,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    break;
                case 6:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(6,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    break;
                case 7:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(7,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    break;
                case 8:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(8,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    break;
                case 9:
                    reactionTime = System.nanoTime();
                    reacted = isReactionGood(9,wereEnemyIsAttacking,attackStartTime,reactionTime);
                    break;
                default:
                    System.out.println("Not a proper action");
            }
            monster.inflictDamage(counterAttack(reacted,player,monster));
            System.out.println("Monster hp " + monster.getHp());


             if(!reacted){
                player.inflictDamage(50);
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
                return 4;
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

    private int counterAttack(boolean reacted, Hero player, Enemy monster){
//            choose your counter attack, or action
        System.out.println("Show him what you got: 1 - 9");
        if (!reacted) return 0;

        int attack=0;
        if (attackRandomize(monster.getLvl(), player.getHp())>= ((player.getLvl()+monster.getLvl())/2)){
            // attack is get through
           attack = Main.inputNumeric();
        }
        return (int)playerAttackModifiers(player,monster,attack);


    }
    private int playerAttackModifiers( Hero player, Enemy monster, int action){
        switch (action){
            case 1:
                return player.getStrength();
            case 2:
                return player.getStrength();
            case 3:
                return player.getStrength();
            case 4:
                return player.getStrength();
            case 5:
                return player.getStrength();
            case 6:
                return player.getStrength();
            case 7:
                return player.getStrength();
            case 8:
                return player.getStrength();
            case 9:
                return player.getStrength();
            default:
                return player.getStrength();


        }
    }

}
