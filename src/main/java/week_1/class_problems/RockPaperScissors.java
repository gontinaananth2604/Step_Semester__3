package week_1.class_problems;

import java.util.Random;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;
        int rounds = 5;
        
        // Simulating predefined player moves for demo
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        for (int i = 0; i < rounds; i++) {
            String pMove = playerMoves[i % playerMoves.length];
            String cMove = moves[rand.nextInt(3)];
            String result = playRound(pMove, cMove);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            
            System.out.println("Round " + (i + 1) + " - Player: " + pMove + ", Computer: " + cMove + " -> " + result);
        }
        
        double winPercentage = (wins * 100.0) / rounds;
        System.out.printf("\nFinal Summary (after %d rounds)\n", rounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
}
