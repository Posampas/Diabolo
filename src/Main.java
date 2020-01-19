
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private boolean justOpened = true;
    private boolean goFighting;
    private boolean rest;
    private boolean search;
    private boolean adjust;
    private boolean saving;
    private boolean heroInfo;


    private Main(){
        boolean justOpened = true;
        boolean goFighting = false;
        boolean rest = false;
        boolean search = false;
        boolean adjust = false;
        boolean saving = false;
        boolean heroInfo = false;
    }
    static {
        scan = new Scanner(System.in);
    }


    public static void main(String[] args) {

        Main game = new Main();


        int action = 0;
        Hero player = null ;

        while (true) {
            while (game.justOpened) {
                action = firstScreen();
                game.justOpened = false;
                if (action == 1){
                    player = newGame();
                }else {
                    player = loadGame();
                    break;
                }
            }
            System.out.println("What to do");
            game.city();
            while(game.goFighting){
                System.out.println("fight");

                Battle fight = new Battle();
                fight.Fight(player);
                if(fight.isWon)
                    game.goFighting = false;
            }
            while(game.heroInfo){
                System.out.println( "heroInfo\n"+
                                    "1. Add points\n" +
                                    "2. Hero info");
                switch (Main.inputNumeric()){
                    case 1:
                        player.upgrading();
                        break;
                    case 2:
                        System.out.println(player);
                        break;
                }

                game.heroInfo = false;
            }
            while (game.saving){
                System.out.println("Save");
                game.saving = false;
            }
            while (game.adjust){
                System.out.println("Adjust");
                 game.adjust  = false;
            }
            while (game.search){
                System.out.println("Search");
                game.search = false;
            }
            while (game.rest){
                System.out.println("rest");
                game.rest =false;
            }
        }
    }

    private static int firstScreen() throws InputMismatchException {

        int action = 0;
        while ((action != 1) && (action != 2)) {
            System.out.println("Welcome wanderer\n" +
                    "1. New game\n" +
                    "2. Load Game");
            action = inputNumeric();
            if ((action != 1) && (action != 2)) System.out.println("Choose correct action");
        }
        return action;
    }

    public static int inputNumeric() {
        int action = -1;
        while (true) {
            try {
                action = scan.nextInt();
                if ((action < 0) || (action > 9)) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Choose correct action");
                scan.nextLine();
            }
            break;
        }
        return action;
    }

    public static String inputString(){
        String action = "";
        while (true) {
            try {
                action = scan.next();
            } catch (InputMismatchException e) {
                System.out.println("Use only characters");
                scan.nextLine();
            }
            break;
        }
        return action;
    }

    public static Hero newGame(){
        System.out.println("Whats your name?");
        return new Hero(inputString());
    }

    public static Hero loadGame(){ // Not implemented
        System.out.println("Not implemneted yet so start new game");
        return newGame();
    }

    public void city(){
        System.out.println(" Choose your action:\n" +
                "1 - Go fighting\n" +
                "2 - Rest for a while\n" +
                "3 - Search for loot\n" +
                "4 - Adjust your equipment\n" +
                "5 - Save\n" +
                "6 - Hero info");
        int action = inputNumeric();
        switch (action){
            case 1 :
                this.goFighting = true;
                break;
            case 2 :
                this.rest = true;
                break;
            case 3 :
                this.search = true;
                break;
            case 4 :
                this.adjust = true;
                break;
            case 5 :
                this.saving = true;
                break;
            case 6 :
                this.heroInfo = true;
                break;
        }


    }
}

