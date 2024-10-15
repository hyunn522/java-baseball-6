package baseball.View;

import static baseball.Model.enumMessages.PlayResult.BALL;
import static baseball.Model.enumMessages.PlayResult.NOTHING;
import static baseball.Model.enumMessages.PlayResult.STRIKE;
import static baseball.Model.enumMessages.UserMessage.INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayView {

    public static List<Integer> printInputView() {
        System.out.print(INPUT_MESSAGE.getMessage());
        char[] userInput = Console.readLine().toCharArray();
        ArrayList<Integer> userInputList = new ArrayList<>();

        userInputList.add(Integer.parseInt(String.valueOf(userInput[0])));
        userInputList.add(Integer.parseInt(String.valueOf(userInput[1])));
        userInputList.add(Integer.parseInt(String.valueOf(userInput[2])));

        return userInputList;
    }

    public static void printBallAndStrikeView(int ballCount, int strikeCount) {
        System.out.println(
                ballCount + BALL.getResult() + " " + strikeCount + STRIKE.getResult());
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
