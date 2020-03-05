package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {
    public int p1Point = 0;
    public int p2Point = 0;

    public String p1Res = "";
    public String p2Res = "";
    private String player1Name = "player1";
    private String player2Name = "player2";

    private String[] scores = {Constant.LOVE, Constant.FIFTEEN, Constant.THIRTY, Constant.FORTY};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (p1Point == p2Point && p1Point < 4) {
            score += scores[p1Point] + Constant.HYPHEN + Constant.ALL;
        }
        if (p1Point == p2Point && p1Point >= 3) {
            score = Constant.DEUCE;
        }

        if (p1Point > 0 && p2Point == 0) {
            score = getOneScoreZeroOtherMoreThanZero(p1Point);
        }
        if (p2Point > 0 && p1Point == 0) {
            score = getOneScoreZeroOtherMoreThanZero(p2Point);
        }

        if (p1Point > p2Point && p1Point < 4) {
            score = getOneScoreLessFourAndMoreThanOther();
        }
        if (p2Point > p1Point && p2Point < 4) {
            score = getOneScoreLessFourAndMoreThanOther();
        }

        if (p1Point > p2Point && p2Point >= 3) {
            score = Constant.ADVANTAGE + Constant.SPACE + player1Name;
        }

        if (p2Point > p1Point && p1Point >= 3) {
            score = Constant.ADVANTAGE + Constant.SPACE + player2Name;
        }

        if (p1Point >= 4 && p2Point >= 0 && (p1Point - p2Point) >= 2) {
            score = Constant.WIN_FOR + Constant.SPACE + player1Name;
        }
        if (p2Point >= 4 && p1Point >= 0 && (p2Point - p1Point) >= 2) {
            score = Constant.WIN_FOR + Constant.SPACE + player2Name;
        }
        return score;
    }

    private String getOneScoreZeroOtherMoreThanZero(int point) {
        p1Res = point < 4 ? scores[point] : "";
        p2Res = Constant.LOVE;
        return p1Res + Constant.HYPHEN + p2Res;
    }

    private String getOneScoreLessFourAndMoreThanOther() {
        p1Res = scores[p1Point];
        p2Res = scores[p2Point];
        return p1Res + Constant.HYPHEN + p2Res;
    }

    public void setp1Score(int number) {
        for (int i = 0; i < number; i++) {
            p1Score();
        }

    }

    public void setp2Score(int number) {
        for (int i = 0; i < number; i++) {
            p2Score();
        }
    }

    public void p1Score() {
        p1Point++;
    }

    public void p2Score() {
        p2Point++;
    }

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            p1Score();
        } else
            p2Score();
    }
}