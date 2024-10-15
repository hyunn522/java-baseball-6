package baseball.Model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> gameNum;

    public Game(List<Integer> gameNum) {
        this.gameNum = gameNum;
    }

    public List<Integer> getGameNum() {
        return this.gameNum;
    }

    public static Game generateRandomGame() {
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

        for (int i : randomList) {
            System.out.println(i);
        }

        return new Game(randomList);
    }
}
