package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private String[] scores = {Constant.LOVE, Constant.FIFTEEN, Constant.THIRTY, Constant.FORTY};

    private int mScore1 = 0;
    private int mScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            mScore1 += 1;
        } else {
            mScore2 += 1;
        }
    }

    public String getScore() {
        if (isEqualScore(mScore1, mScore2)) {
            return mScore1 < 3 ? scores[mScore1] + Constant.HYPHEN + Constant.ALL : Constant.DEUCE;
        }

        if (isOneScoreMoreThanFour()) {
            return getOneScoreMoreThanFourScore();
        }

        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = mScore1;
            } else {
                score += Constant.HYPHEN;
                tempScore = mScore2;
            }
            score += scores[tempScore];
        }
        return score;
    }

    private String getOneScoreMoreThanFourScore() {
        int minusResult = mScore1 - mScore2;

        String playerName = minusResult > 0 ? "player1" : "player2";
        String score = Math.abs(minusResult) == 1 ? "Advantage" : "Win for";

        return score + " " + playerName;
    }

    private boolean isOneScoreMoreThanFour() {
        return mScore1 >= 4 || mScore2 >= 4;
    }

    private boolean isEqualScore(int mScore1, int mScore2) {
        return mScore1 == mScore2;
    }
}