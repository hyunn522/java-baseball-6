package baseball.Service;

import baseball.Model.Game;
import baseball.View.PlayView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    public Game createGame() {
        return Game.generateRandomGame();
    }

    public ArrayList<Integer> compareNums(Game user, Game answer) {
        int ballCount = 0;
        int strikeCount = 0;

        List<Integer> userNum = user.getGameNum();
        List<Integer> answerNum = answer.getGameNum();

        for (int i = 0; i < 3; i++) {
            if (userNum.get(i) - answerNum.get(i) == 0) {
                strikeCount++;
            } else {
                if (answerNum.contains(userNum.get(i))) {
                    ballCount++;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(ballCount, strikeCount));
    }

    public int generateResult(ArrayList<Integer> compareResult) {
        int ballCount = compareResult.get(0);
        int strikeCount = compareResult.get(1);

        if (strikeCount == 0 && ballCount == 0) {
            PlayView.printNothingView();
        } else if (strikeCount == 3) {
            PlayView.printStrikeView(strikeCount);
        } else if (strikeCount == 0) {
            PlayView.printBallView(ballCount);
        } else if (ballCount == 0) {
            PlayView.printStrikeView(strikeCount);
        } else {
            PlayView.printBallAndStrikeView(ballCount, strikeCount);
        }

        return strikeCount;
    }

}
