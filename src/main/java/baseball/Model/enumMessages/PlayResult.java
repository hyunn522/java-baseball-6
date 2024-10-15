package baseball.Model.enumMessages;

public enum PlayResult {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    SEPERATOR(" ");

    private final String result;

    PlayResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
