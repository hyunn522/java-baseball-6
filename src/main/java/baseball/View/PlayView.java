package baseball.View;

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
}
