//Problem Statement:
//Develop an inheritance-based Cricket Match system using command line arguments to input team names and 
//scores and display the match result.
//Base class
class Match {

    String team1;
    String team2;

    // Constructor
    Match(String t1, String t2) {
        team1 = t1;
        team2 = t2;
    }

    void showTeams() {
        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);
    }
}

// Child class using inheritance
class CricketMatch extends Match {

    int score1;
    int score2;

    // Constructor
    CricketMatch(String t1, String t2, int s1, int s2) {
        super(t1, t2); // calling parent constructor
        score1 = s1;
        score2 = s2;
    }

    void displayResult() {

        System.out.println("Score of " + team1 + ": " + score1);
        System.out.println("Score of " + team2 + ": " + score2);

        if (score1 > score2) {
            System.out.println(team1 + " wins the match!");
        } else if (score2 > score1) {
            System.out.println(team2 + " wins the match!");
        } else {
            System.out.println("Match is a draw.");
        }
    }
}

public class Program5 {

    public static void main(String[] args) {

        // Validate command line arguments
        if (args.length < 4) {
            System.out.println("Error: Please provide 4 arguments!");
            System.out.println("java Program5 <team1> <team2> <score1> <score2>");
            System.out.println("java Program5 India Pakistan 180 165");
            return;
        }

        try {
            // Reading command line arguments
            String team1 = args[0];
            String team2 = args[1];
            int score1 = Integer.parseInt(args[2]);
            int score2 = Integer.parseInt(args[3]);

            // Validate scores are non-negative
            if (score1 < 0 || score2 < 0) {
                System.out.println("Error: Scores cannot be negative!");
                return;
            }

            CricketMatch match = new CricketMatch(team1, team2, score1, score2);

            match.showTeams();
            match.displayResult();

        } catch (NumberFormatException e) {
            System.out.println("Error: Scores must be valid integers!");
            System.out.println("Usage: java Program5 <team1> <team2> <score1> <score2>");
            System.out.println("Example: java Program5 India Pakistan 180 165");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}