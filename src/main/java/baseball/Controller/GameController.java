package baseball.Controller;

import baseball.Model.Game;
import baseball.Service.GameService;
import baseball.View.PlayView;
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
        Game answer = gameService.createGame();
        Game user = new Game(PlayView.printInputView());
    }
}
