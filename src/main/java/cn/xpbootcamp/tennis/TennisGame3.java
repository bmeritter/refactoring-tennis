package cn.xpbootcamp.tennis;

public class TennisGame3 implements TennisGame {

    private int p2Point;
    private int p1Point;
    private String p1Name;
    private String p2Name;

    public TennisGame3(String p1N, String p2N) {
        this.p1Name = p1N;
        this.p2Name = p2N;
    }

    public String getScore() {
        String s;
        if (p1Point < 4 && p2Point < 4 && !(p1Point + p2Point == 6)) {
            String[] p = new String[]{Constant.LOVE, Constant.FIFTEEN, Constant.THIRTY, Constant.FORTY};
            s = p[p1Point];
            return (p1Point == p2Point) ? s + Constant.HYPHEN + Constant.ALL : s + Constant.HYPHEN + p[p2Point];
        } else {
            if (p1Point == p2Point)
                return Constant.DEUCE;
            s = p1Point > p2Point ? p1Name : p2Name;
            return ((p1Point - p2Point)*(p1Point - p2Point) == 1) ? Constant.ADVANTAGE + Constant.SPACE + s : Constant.WIN_FOR + Constant.SPACE+ s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1Point += 1;
        else
            this.p2Point += 1;

    }

}