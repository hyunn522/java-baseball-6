package baseball.Model;

import static baseball.Model.enumMessages.ErrorMessage.INPUT_DUPLICATE;
import static baseball.Model.enumMessages.ErrorMessage.INVALID_INPUT_SIGN;
import static baseball.Model.enumMessages.ErrorMessage.INVALID_INPUT_TYPE;
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

    public static Game generateUserGame(char[] userInput) {
        ArrayList<Integer> userInputList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            validateZero(userInput[i]);

            if (validateNumber(userInput[i], userInputList)) {
                continue;
            }

            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }

        return new Game(userInputList);
    }

    private static void validateZero(char c) {
        if (c == '0') {
            throw new IllegalArgumentException(INVALID_INPUT_SIGN.getMessage());
        }
    }

    private static boolean validateNumber(char c, ArrayList<Integer> userInputList) {
        if (c >= '0' && c <= '9') {
            validateDuplicate(c, userInputList);
            userInputList.add(Integer.parseInt(String.valueOf(c)));
            return true;
        }
        return false;
    }

    private static void validateDuplicate(char c, ArrayList<Integer> userInputList) {
        if (userInputList.contains(c - '0')) {
            throw new IllegalArgumentException(INPUT_DUPLICATE.getMessage());
        }
    }
}
