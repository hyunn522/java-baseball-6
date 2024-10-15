package baseball.Model;

import java.util.List;

public class Game {
    private final List<Integer> gameNum;

    public Game(List<Integer> gameNum) {
        this.gameNum = gameNum;
    }

    public List<Integer> getGameNum() {
        return this.gameNum;
    }
}
