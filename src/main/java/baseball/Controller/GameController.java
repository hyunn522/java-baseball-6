package baseball.Controller;

import baseball.Model.GameNum;
import baseball.Service.GameService;
import baseball.View.StartView;

public class GameController {
    static boolean isGameEnd = false;

    public static void runGame() {
        StartView.printStartView();
        while (!isGameEnd) {
            startGame();
        }
    }

    private static void startGame() {
        GameService gameService = new GameService();
        GameNum answerNum = gameService.createGame();
    }
}
