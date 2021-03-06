public class TennisGame2 implements TennisGame {
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    private String player1result = "";
    private String player2result = "";

    public String getScore() {
        String score = "";
        if (isScoreDeuce())
            return "Deuce";
        if (isScoreAll()) {
            return getScoreAll(score);
        }

        if (secondPlayerScoreIsZero()) {
            player1result = getOnePlayerScore(scorePlayer1);
            player2result = "Love";
            score = player1result + "-" + player2result;
        }
        if (firstPlayerScoreIsZero()) {
            player1result = "Love";
            player2result = getOnePlayerScore(scorePlayer2);
            score = player1result + "-" + player2result;
        }

        if (playerOneLeadsWithoutAdvantage()) {
            score = getScorePlayer(scorePlayer1, scorePlayer2);
        }
        if (playerTwoLeadsWithoutAdvantage()) {
            if (scorePlayer2 == 2)
                player2result = "Thirty";
            if (scorePlayer2 == 3)
                player2result = "Forty";
            if (scorePlayer1 == 1)
                player1result = "Fifteen";
            if (scorePlayer1 == 2)
                player1result = "Thirty";
            score = player1result + "-" + player2result;
        }

        if (player1LeadsWithAdvantage()) {
            score = "Advantage player1";
        }

        if (player2LeadsWithAdvantage()) {
            score = "Advantage player2";
        }

        if (player1Wins()) {
            score = "Win for player1";
        }
        if (player2Wins()) {
            score = "Win for player2";
        }
        return score;
    }

    private String getScorePlayer(int scorePlayer1, int scorePlayer2) {
        String score;
        if (scorePlayer1 == 2)
            player1result = "Thirty";
        if (scorePlayer1 == 3)
            player1result = "Forty";
        if (scorePlayer2 == 1)
            player2result = "Fifteen";
        if (scorePlayer2 == 2)
            player2result = "Thirty";
        score = player1result + "-" + player2result;
        return score;
    }

    private String getOnePlayerScore(int scorePlayer1) {
        if (scorePlayer1 == 1)
            return "Fifteen";
        if (scorePlayer1 == 2)
            return "Thirty";
        return "Forty";
    }

    private String getScoreAll(String score) {
        if (scorePlayer1 == 0)
            score = "Love";
        if (scorePlayer1 == 1)
            score = "Fifteen";
        if (scorePlayer1 == 2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    private boolean player2Wins() {
        return scorePlayer2 >= 4 && (scorePlayer2 - scorePlayer1) >= 2;
    }

    private boolean player1Wins() {
        return scorePlayer1 >= 4 && (scorePlayer1 - scorePlayer2) >= 2;
    }

    private boolean player2LeadsWithAdvantage() {
        return scorePlayer2 > scorePlayer1 && scorePlayer1 >= 3;
    }

    private boolean player1LeadsWithAdvantage() {
        return scorePlayer1 > scorePlayer2 && scorePlayer2 >= 3;
    }

    private boolean playerTwoLeadsWithoutAdvantage() {
        return scorePlayer2 > scorePlayer1 && scorePlayer2 < 4;
    }

    private boolean playerOneLeadsWithoutAdvantage() {
        return scorePlayer1 > scorePlayer2 && scorePlayer1 < 4;
    }

    private boolean firstPlayerScoreIsZero() {
        return scorePlayer2 > 0 && scorePlayer1 == 0;
    }

    private boolean secondPlayerScoreIsZero() {
        return scorePlayer1 > 0 && scorePlayer2 == 0;
    }

    private boolean isScoreDeuce() {
        return scorePlayer1 == scorePlayer2 && scorePlayer1 >= 3;
    }

    private boolean isScoreAll() {
        return scorePlayer1 == scorePlayer2 && scorePlayer1 < 4;
    }

    private void P1Score() {
        scorePlayer1++;
    }

    private void P2Score() {
        scorePlayer2++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }
}