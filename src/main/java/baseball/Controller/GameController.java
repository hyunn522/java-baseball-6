package baseball.Controller;

import static baseball.Model.Game.generateUserGame;
import static baseball.Model.enumMessages.ErrorMessage.INVALID_END_INPUT;

import baseball.Model.Game;
import baseball.Service.GameService;
import baseball.View.EndView;
import baseball.View.PlayView;
import baseball.View.StartView;
import java.util.ArrayList;
import java.util.Objects;

public class GameController {
    static boolean isGameEnd;
    static boolean isCorrect;
    static GameService gameService = new GameService();

    static char[] userInput;

    public static void runGame() {
        StartView.printStartView();
        isGameEnd = false;

        while (!isGameEnd) {
            startGame();
        }
    }

    private static void startGame() {
        Game answer = gameService.createGame();
        isCorrect = false;

        while (!isCorrect) {
            userInput = PlayView.printInputView();
            Game user = generateUserGame(userInput);
            playGame(user, answer);
        }
    }


    private static void playGame(Game user, Game answer) {
        ArrayList<Integer> compareResult = gameService.compareNums(user, answer);
        int strikeCount = gameService.generateResult(compareResult);
        if (strikeCount == 3) {
            finishGame();
        }
    }

    private static void finishGame() {
        String userEndInput = EndView.CorrectView();
        validateEndNumber(userEndInput);

        isGameEnd = Objects.equals(userEndInput, "2");
        isCorrect = true;
    }

    private static void validateEndNumber(String userEndInput) {
        if (!Objects.equals(userEndInput, "1") && !Objects.equals(userEndInput, "2")) {
            throw new IllegalArgumentException(INVALID_END_INPUT.getMessage());
        }
    }
}
