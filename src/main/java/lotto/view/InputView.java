package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String readWinningNumber() {
        System.out.printf("%n당첨 번호를 입력해 주세요.%n");
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.printf("%n보너스 번호를 입력해 주세요.%n");
        return Console.readLine();
    }
}
