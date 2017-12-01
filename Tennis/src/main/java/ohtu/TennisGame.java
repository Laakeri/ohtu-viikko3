package ohtu;

public class TennisGame {
    
    private int score1 = 0;
    private int score2 = 0;
    private final String player1Name;
    private final String player2Name;
    
    private final int winningScore = 4;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            score1++;
        else
            score2++;
    }
    
    public String numToScore(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }
    
    public String overScore(int score1, int score2) {
        int diff = Math.abs(score1 - score2);
        String leader;
        if (score1 > score2) leader = player1Name;
        else leader = player2Name;
        if (diff == 1) return "Advantage " + leader;
        else return "Win for " + leader;
    }

    public String getScore() {
        if (score1 == score2) {
            if (score1 < winningScore) return numToScore(score1) + "-All";
            else return "Deuce";
        }
        else if (score1 >= winningScore || score2 >= winningScore) {
            return overScore(score1, score2);
        }
        else {
            return numToScore(score1) + "-" + numToScore(score2);
        }
    }
}