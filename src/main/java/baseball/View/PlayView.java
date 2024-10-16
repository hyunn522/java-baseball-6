package baseball.View;

import static baseball.Model.enumMessages.ErrorMessage.INVALID_INPUT_LENGTH;
import static baseball.Model.enumMessages.PlayResult.BALL;
import static baseball.Model.enumMessages.PlayResult.NOTHING;
import static baseball.Model.enumMessages.PlayResult.SEPERATOR;
import static baseball.Model.enumMessages.PlayResult.STRIKE;
import static baseball.Model.enumMessages.UserMessage.INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class PlayView {

    public static char[] printInputView() {
        System.out.print(INPUT_MESSAGE.getMessage());
        char[] input = Console.readLine().toCharArray();

        if (input.length != 3) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH.getMessage());
        }
        
        return input;
    }

    public static void printBallAndStrikeView(int ballCount, int strikeCount) {
        System.out.println(
                ballCount + BALL.getResult() + SEPERATOR.getResult() + strikeCount + STRIKE.getResult());
    }

    public static void printNothingView() {
        System.out.println(NOTHING.getResult());
    }

    public static void printStrikeView(int strikeCount) {
        System.out.println(strikeCount + STRIKE.getResult());
    }

    public static void printBallView(int ballCount) {
        System.out.println(ballCount + BALL.getResult());
    }
}
