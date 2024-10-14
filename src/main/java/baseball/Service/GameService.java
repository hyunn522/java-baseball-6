package baseball.Service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.Model.GameNum;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    public GameNum createGame() {
        return new GameNum(generateRandomNum());
    }

    public static List<Integer> generateRandomNum() {
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
}
