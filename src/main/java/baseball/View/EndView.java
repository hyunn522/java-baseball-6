package baseball.View;

import static baseball.Model.enumMessages.UserMessage.END_MESSAGE;
import static baseball.Model.enumMessages.UserMessage.RESTART_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class EndView {

    public static String CorrectView() {
        System.out.println(END_MESSAGE.getMessage());
        System.out.println(RESTART_MESSAGE.getMessage());
        return Console.readLine();
    }
}
