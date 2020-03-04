package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {
    public int p1Point = 0;
    public int p2Point = 0;

    public String p1Res = "";
    public String p2Res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (p1Point == p2Point && p1Point < 4) {
            if (p1Point == 0)
                score = Constant.LOVE;
            if (p1Point == 1)
                score = Constant.FIFTEEN;
            if (p1Point == 2)
                score = Constant.THIRTY;
            score += Constant.HYPHEN + Constant.ALL;
        }
        if (p1Point == p2Point && p1Point >= 3)
            score = Constant.DEUCE;

        if (p1Point > 0 && p2Point == 0) {
            if (p1Point == 1)
                p1Res = Constant.FIFTEEN;
            if (p1Point == 2)
                p1Res = Constant.THIRTY;
            if (p1Point == 3)
                p1Res = Constant.FORTY;

            p2Res = Constant.LOVE;
            score = p1Res + Constant.HYPHEN + p2Res;
        }
        if (p2Point > 0 && p1Point == 0) {
            if (p2Point == 1)
                p2Res = Constant.FIFTEEN;
            if (p2Point == 2)
                p2Res = Constant.FORTY;
            if (p2Point == 3)
                p2Res = Constant.LOVE;

            p1Res = Constant.LOVE;
            score = p1Res + Constant.HYPHEN + p2Res;
        }

        if (p1Point > p2Point && p1Point < 4) {
            if (p1Point == 2)
                p1Res = Constant.THIRTY;
            if (p1Point == 3)
                p1Res = Constant.FORTY;
            if (p2Point == 1)
                p2Res = Constant.FIFTEEN;
            if (p2Point == 2)
                p2Res = Constant.THIRTY;
            score = p1Res + Constant.HYPHEN + p2Res;
        }
        if (p2Point > p1Point && p2Point < 4) {
            if (p2Point == 2)
                p2Res = Constant.THIRTY;
            if (p2Point == 3)
                p2Res = Constant.FORTY;
            if (p1Point == 1)
                p1Res = Constant.FIFTEEN;
            if (p1Point == 2)
                p1Res = Constant.THIRTY;
            score = p1Res + Constant.HYPHEN + p2Res;
        }

        if (p1Point > p2Point && p2Point >= 3) {
            score = Constant.ADVANTAGE + Constant.SPACE + "player1";
        }

        if (p2Point > p1Point && p1Point >= 3) {
            score = Constant.ADVANTAGE + Constant.SPACE + "player2";
        }

        if (p1Point >= 4 && p2Point >= 0 && (p1Point - p2Point) >= 2) {
            score = Constant.WIN_FOR + Constant.SPACE + "player1";
        }
        if (p2Point >= 4 && p1Point >= 0 && (p2Point - p1Point) >= 2) {
            score = Constant.WIN_FOR + Constant.SPACE + "player2";
        }
        return score;
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