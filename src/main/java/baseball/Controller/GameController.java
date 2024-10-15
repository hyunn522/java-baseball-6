package baseball.Controller;

import baseball.Model.GameNum;
import baseball.Service.GameService;
import baseball.View.StartView;

public class GameController {
    static boolean isGameEnd = false;
    static GameService gameService = new GameService();

    public static void runGame() {
        StartView.printStartView();
        while (!isGameEnd) {
            startGame();
        }
    }

    private static void startGame() {
        GameNum answerNum = gameService.createGame();
    }
}
