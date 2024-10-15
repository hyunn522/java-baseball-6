package baseball.Service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.Model.Game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    public Game createGame() {
        return new Game(generateRandomNum());
    }

    public static ArrayList<Integer> generateRandomNum() {
        ArrayList<Integer> randomList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randomList.add(pickNumberInRange(1, 9));
            for (int j = 0; j < i; j++) {
                if (randomList.get(j) - randomList.get(i) == 0) {
                    randomList.remove(i);
                    i--;
                }
            }
        }
        return randomList;
    }

    public ArrayList<Integer> compareNums(Game user, Game answer) {
        int strikeCount = 0;
        int ballCount = 0;

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

        return new ArrayList<>(Arrays.asList(strikeCount, ballCount));
    }
    
}
