package Project3;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Squid Games Ladder Game"); 
        System.out.println("How many lives do you want to start with?");
        int lives = scan.nextInt();
        System.out.println("How many panels do you want in the ladder?");
        int panels = scan.nextInt();
        Player play = new Player(lives);
        Ladder ladder = new Ladder(panels);
        int[][] laddercreate = ladder.createLadder();
        ladder.printLadderBlank();
        System.out.println("Total Lives: "+play.getLives());
        while(ladder.selections.size() < ladder.panels){
            System.out.println("---------LEGEND-----------"); 
            System.out.println("0: Glass ");
            System.out.println("1: Tempered Glass ");
            System.out.println("--------------------------"); 
            if(play.getLives()==0){
                System.out.println("YOU DIED");
                System.exit(0);
            }
            System.out.println("Current Place in Ladder: " +ladder.selections.size());
            if(ladder.calcPanel(laddercreate, ladder.selections) == false){
                play.death();
            }
            System.out.println("Total Lives: "+play.getLives());
            System.out.println("-------------------------------------");
            ladder.printCurrentLadder();
        }
        System.out.println("Congrats You Won!!");
        ladder.printLadder();
    }
}
