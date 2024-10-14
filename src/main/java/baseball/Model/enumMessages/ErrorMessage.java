package baseball.Model.enumMessages;

public enum ErrorMessage {
    INVALID_INPUT_LENGTH("사용자 입력은 3자리여야 합니다"),
    INVALID_INPUT_TYPE("사용자 입력은 숫자로만 구성되어야 합니다"),
    INPUT_DUPLICATE("사용자 입력은 서로 다른 숫자들로 구성되어야 합니다"),
    INVALID_INPUT_SIGN("사용자 입력은 0보다 큰 숫자들로 구성되어야 합니다"),
    INVALID_END_INPUT("종료 옵션은 1 또는 2이어야 합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
