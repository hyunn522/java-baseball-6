package baseball.Controller;

import baseball.Model.Game;
import baseball.Service.GameService;
import baseball.View.EndView;
import baseball.View.PlayView;
import baseball.View.StartView;
import java.util.ArrayList;

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
            Game user = new Game(PlayView.printInputView());
            playGame(user, answer);
        }
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
            isGameEnd = userEndInput == 2;
            isCorrect = true;
        }
    }

}
