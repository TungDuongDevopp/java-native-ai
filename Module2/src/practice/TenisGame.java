package practice;

public class TenisGame {
    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        StringBuilder score;

        if (m_score1 == m_score2)
        {
            score = new StringBuilder(switch (m_score1) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                case 3 -> "Forty-All";
                default -> "Deuce";
            });
        }

        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1 - m_score2;
            if (minusResult==1) score = new StringBuilder(String.format("Advantage %s", player1Name));
            else if (minusResult ==-1) score = new StringBuilder(String.format("Advantage %s", player2Name));
            else if (minusResult>=2) score = new StringBuilder(String.format("Win for %s", player1Name));
            else score = new StringBuilder(String.format("Win for %s", player2Name));
        }
        else {
            return scoreName(m_score1)
                    + "-"
                    + scoreName(m_score2);
        }
        return score.toString();
    }
    private static String scoreName(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException("Invalid score");
        };
    }

    public static void main(String[] args) {
        String score = TenisGame.getScore("Duong","Minh",1,2);
        System.out.println(score);
    }
}
