package Project2;

import java.util.ArrayList;


public class Medals {
    public static void main(String[] args) {
        final int COUNTRIES = 7;
        final int MEDALS = 3;

        String[] countries = {
            "Canada",
            "China",
            "Germany",
            "Korea",
            "Japan",
            "Russia",
            "United States"
        };

        int[][] counts = 
        { 
            { 1, 0, 1 },
            { 1, 1, 0 }, 
            { 0, 0, 1 }, 
            { 1, 0, 1 }, 
            { 0, 1, 1 }, 
            { 0, 1, 1 },
            { 1, 1, 0 }
        };
        System.out.println("        Country    Gold    Silver    Bronze   Total");

        // Print countries, counts, and row totals (IE total medals by country)
        for (int i = 0; i < COUNTRIES; i++) {
            // Process the ith row
            int total = 0; // Holds the total medal count for the country

            // Print the country name
            System.out.printf("%15s", countries[i]);

            // Print the medal counts for the country
            for (int j = 0; j < MEDALS; j++) {
                System.out.printf("%8d", counts[i][j]);
                total += counts[i][j]; // Update the total medal count for the country
            }

            // Print the total medal count for the country
            System.out.printf("%8d\n", total);
        }

        // Create an ArrayList to hold the total number of medals of each type
        ArrayList<Integer> medalCounts = new ArrayList<>();

        // Calculate the total number of medals of each type
        for (int i = 0; i < MEDALS; i++) {
            int sum = 0; // Holds the sum of the counts for the current medal type

            // Calculate the sum of the counts for the current medal type
            for (int j = 0; j < COUNTRIES; j++) {
                sum += counts[j][i];
            }

            medalCounts.add(sum); // Add the sum to the ArrayList
        }

        // Print the total number of medals of each type
        System.out.printf("%15s", "Total");
        for (int i = 0; i < MEDALS; i++) {
            System.out.printf("%8d", medalCounts.get(i));
        }
        System.out.println();

    }
}
