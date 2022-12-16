package Project3;

import java.util.Scanner;
import java.util.ArrayList;

public class Ladder {
    // Panels are the physical glass or tempered glass sheets
    public int panels;
    // ladder is the ladder structure (2d array)
    public int[][] ladder;
    // round counter
    public int round;

    // make a ladder object with no parameter (default 5 panels)
    public Ladder() {
        this.panels = 5;
        this.ladder = createLadder();
    }

    // make a ladder object with a panel parameter and assign the panels to that int
    public Ladder(int panels) {
        this.panels = panels;
        this.ladder = createLadder();
    }

    // create an array list called selections of integers for the selections the user will enter
    ArrayList<Integer> selections = new ArrayList<Integer>();


    // ----make a int method to get the selection from the user called getSelection()---

   
    // other class variables and methods

    public int getSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your selection (L/R): ");
        String selection = scanner.nextLine();

        int convertedSelection = -1;
        if (selection.equalsIgnoreCase("L")) {
            convertedSelection = 0;
            System.out.println("You selected L.");
        } else if (selection.equalsIgnoreCase("R")) {
            convertedSelection = 1;
            System.out.println("You selected R.");
        } else {
            System.out.println("Invalid selection.");
        }
        return convertedSelection;
    }

   

    
    public int[][] createLadder() {
        int[][] ladder = new int[10][2]; // create a 2D array with 10 rows and 2 columns
      
        for (int i = 0; i < ladder.length; i++) {
          for (int j = 0; j < ladder[i].length; j++) {
            ladder[i][j] = (int)(2 * Math.random()); // assign a random int between 0 and 1 to each element
          }
        }
      
        for (int i = 0; i < ladder.length; i++) {
          if (ladder[i][0] == ladder[i][1]) { // check if values in the same row are equal
            if (ladder[i][0] == 0) { // if equal and 0, assign 1 to the first column
              ladder[i][0] = 1;
            } else { // if equal and 1, assign 0 to the first column
              ladder[i][0] = 0;
            }
          }
        }
      
        return ladder; // return the completed ladder
      }
      
    
        public boolean calcPanel(int[][] ladder, ArrayList<Integer> selections) {
            int size = selections.size();
            System.out.println("Round: " + round);
            int[] temp = new int[2];
            for (int i = 0; i < ladder[0].length; i++) {
                temp[i] = ladder[size][i];
            }
            int currentSelection = getSelection();
            selections.add(currentSelection);
            int choice = selections.get(selections.size() - 1);
            if (temp[choice] == 1) {
                System.out.println("Answer is correct!");
                round++;
                return true;
            } else {
                selections.remove(selections.size() - 1);
                round++;
                System.out.println("You lose 1 life!");
                return false;
            }
        }
        
    // EVERYTHING AFTER THIS POINT IS TO PRINT THE LADDER
    // HERE IS HOW TO PRINT A BLANK LADDER
    public void printLadderBlank(){
        try {
            System.out.println("|||||| ---- Start");
            for (int i = 0; i < ladder.length; i++) {
                System.out.print("|"+" || "+"|");
                System.out.println();
            }
            System.out.println("|||||| ---- Finish");
        } catch (Exception e) {
            System.out.println("ERROR LADDER IS NOT CREATED OR IS NULL...");
        }
    }
    

    public void printLadder() {
        try {
            System.out.println("|||||| ---- Start");
            for (int i = 0; i < ladder.length; i++) {
                for (int j = 0; j < ladder[i].length; j++) {
                    System.out.print("|" + ladder[i][j] + "|");
                }
                System.out.println();
            }
            System.out.println("|||||| ---- Finish");
        } catch (Exception e) {
            System.out.println("ERROR LADDER IS NOT CREATED OR IS NULL...");
        }
    }
    
    public void printCurrentLadder() {
        try {
            System.out.println("|||||| ---- Start");
            for (int i = 0; i < selections.size(); i++) {
                for (int j = 0; j < ladder[i].length; j++) {
                    System.out.print("|" + ladder[i][j] + "|");
                }
                System.out.println();
            }
            System.out.println("|?||?|");
            System.out.println("|||||| ---- Finish");
        } catch (Exception e) {
            System.out.println("ERROR LADDER IS NOT CREATED OR IS NULL...");
        }
    }
}