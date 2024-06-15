package lotto.view;

import lotto.domain.Store;
import lotto.domain.User;
import lotto.domain.WinningPolicy;

import java.util.Arrays;
import java.util.Map;

public class OutputView {

    public static void printLottos(Store store, User user) {
        System.out.printf("%n%d개를 구매했습니다.%n", store.getLottoCount());
        user.getLottos().forEach(System.out::println);
    }

    public static void printWinningResult(User user, double winningRate) {
        System.out.printf("%n당첨 통계%n");
        System.out.println("---");

        Arrays.stream(WinningPolicy.values())
                .filter(policy -> policy != WinningPolicy.EMPTY)
                .forEach(winning -> System.out.println(winningResultMessage(winning, user)));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", winningRate);
    }

    private static String winningResultMessage(WinningPolicy winning, User user) {
        Map<WinningPolicy, Integer> winningResult = user.getWinningResult();
        if (winning == WinningPolicy.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                    winning.getCorrectCount(), winning.getViewAmount(), winningResult.get(winning));
        }

        return String.format("%d개 일치 (%s원) - %d개",
                winning.getCorrectCount(), winning.getViewAmount(), winningResult.get(winning));
    }
}
