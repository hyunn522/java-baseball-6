package baseball.Controller;

import static baseball.Model.enumMessages.ErrorMessage.INPUT_DUPLICATE;
import static baseball.Model.enumMessages.ErrorMessage.INVALID_END_INPUT;
import static baseball.Model.enumMessages.ErrorMessage.INVALID_INPUT_SIGN;
import static baseball.Model.enumMessages.ErrorMessage.INVALID_INPUT_TYPE;

import baseball.Model.Game;
import baseball.Service.GameService;
import baseball.View.EndView;
import baseball.View.PlayView;
import baseball.View.StartView;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    static boolean isGameEnd = false;
    static boolean isCorrect = false;
    static GameService gameService = new GameService();

    public static void runGame() {
        StartView.printStartView();
        while (!isGameEnd) {
            startGame();
        }
    }

    private static void startGame() {
        Game answer = gameService.createGame();
        isCorrect = false;

        while (!isCorrect) {
            char[] userInput = PlayView.printInputView();
            Game user = new Game(generateUserNum(userInput));
            playGame(user, answer);
        }
    }

    private static List<Integer> generateUserNum(char[] userInput) {
        ArrayList<Integer> userInputList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            validateZero(userInput[i]);

            if (validateNumber(userInput[i], userInputList)) {
                continue;
            }

            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }

        return userInputList;
    }

    private static void playGame(Game user, Game answer) {
        ArrayList<Integer> compareResult = gameService.compareNums(user, answer);
        generateResult(compareResult);
    }

    private static void generateResult(ArrayList<Integer> compareResult) {
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

        finishGame(strikeCount);
    }

    private static void finishGame(int strikeCount) {
        if (strikeCount == 3) {
            int userEndInput = EndView.CorrectView();
            validateEndNumber(userEndInput);
            
            isGameEnd = userEndInput == 2;
            isCorrect = true;
        }
    }

    private static void validateEndNumber(int userEndInput) {
        if (userEndInput != '1' && userEndInput != '2') {
            throw new IllegalArgumentException(INVALID_END_INPUT.getMessage());
        }
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
