package game.card;

import java.util.Random;
import java.util.Scanner;

/**
 * @author mboullouz
 */
public class CardMain {
    static int[] deck = {3, 4, 9, 9, 10, 11, 11, 11, 13};
    static boolean in11Case = false;

    public static void main(String[] args) {
        System.out.println("Start game: please press anykey other than 0");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (Integer.parseInt(line) != 0) {
            play(1);
            System.out.println("Play again ? press anykey but 0");
            line = scanner.nextLine();
        }
        System.out.println("Bye! Nice to have playing the game");


    }

    public static void play(int trys) {
        while (trys > 0) {
            int systemPickedCard = getRandCard();
            System.out.println(" *** " + systemPickedCard + " is picked ***");
            if (systemPickedCard == 13) {
                System.out.println("Yii, you won 1€");
                return;
            } else if (systemPickedCard == 4) {
                System.out.println("You have 3 new trys");
                trys += 3;
                in11Case = false;
            } else if (systemPickedCard == 11) {
                if (trys > 1) {
                    System.out.println("you loose all your: " + trys + " trys");
                } else if (in11Case) {
                    System.out.println("you loose 1€");
                    in11Case = false;
                    return;
                } else {
                    System.out.println("you have already picked an eleven: you loose if you pick another J");
                    in11Case = true;
                }
                trys = 1;
            } else {
                trys--;
                if (trys <= 0) {
                    System.out.println("Nothing to earn or loose!");
                }
            }
        }
    }

    private static int getRandCard() {
        Random r = new Random();
        int index = r.nextInt(deck.length);
        return deck[index];
    }
}
