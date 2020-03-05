package cn.xpbootcamp.tennis;

public class TennisGame3 implements TennisGame {

    private int p2Point;
    private int p1Point;
    private String p1Name;
    private String p2Name;
    private final String[] points = new String[]{Constant.LOVE, Constant.FIFTEEN, Constant.THIRTY, Constant.FORTY};

    public TennisGame3(String p1N, String p2N) {
        this.p1Name = p1N;
        this.p2Name = p2N;
    }

    public String getScore() {
        String score;
        if (p1Point < 4 && p2Point < 4 && p1Point + p2Point != 6) {
            score = points[p1Point] + Constant.HYPHEN;
            return (p1Point == p2Point) ? score + Constant.ALL : score + points[p2Point];
        }
        if (p1Point == p2Point) {
            return Constant.DEUCE;
        }
        score = Constant.SPACE + (p1Point > p2Point ? p1Name : p2Name);
        return ((p1Point - p2Point) * (p1Point - p2Point) == 1) ? Constant.ADVANTAGE + score : Constant.WIN_FOR + score;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            this.p1Point += 1;
        } else
            this.p2Point += 1;

    }

}