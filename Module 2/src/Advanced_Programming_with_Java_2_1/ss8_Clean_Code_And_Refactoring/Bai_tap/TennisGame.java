package Advanced_Programming_with_Java_2_1.ss8_Clean_Code_And_Refactoring.Bai_tap;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int playerScore1, int playerScore2) {
        String score = "";
        int tempScore = 0;
        if (playerScore1==playerScore2)
        {
            score = compareScore(playerScore1);
        }
        else if (playerScore1>=4 || playerScore2>=4)
        {
            score = score(playerScore1, playerScore2);
        }
        else
        {
            score = compareTempScore(playerScore1, playerScore2, score);
        }
        return score;
    }

    private static String compareScore(int playerScore1) {
        String score;
        switch (playerScore1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static String compareTempScore(int playerScore1, int playerScore2, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = playerScore1;
            else { score +="-"; tempScore = playerScore2;}
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private static String score(int playerScore1, int playerScore2) {
        String score;
        int minusResult = playerScore1 - playerScore2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }



}
