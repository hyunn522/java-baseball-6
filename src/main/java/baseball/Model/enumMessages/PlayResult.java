package baseball.Model.enumMessages;

public enum PlayResult {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private String result;

    PlayResult(String result) {
        this.result = result;
    }
}
