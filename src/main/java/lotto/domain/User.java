package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private List<Lotto> lottos;
    private final Map<WinningPolicy, Integer> winningResult;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
        winningResult = init();
    }

    private Map<WinningPolicy, Integer> init() {
        Map<WinningPolicy, Integer> initWinning = new HashMap<>();
        for (WinningPolicy winning : WinningPolicy.values()) {
            if (WinningPolicy.EMPTY != winning) {
                initWinning.put(winning, 0);
            }
        }
        return initWinning;
    }

    public void findByWinning(Winning winning) {
        for (Lotto lotto : lottos) {
            WinningPolicy winningPolicy = winning.winning(lotto);
            if (winningPolicy != WinningPolicy.EMPTY) {
                winningResult.put(winningPolicy, winningResult.getOrDefault(winningPolicy, 0) + 1);
            }
        }
    }

    public double calculateRate(int money) {
        long winningAmount = winningResult.keySet().stream()
                .filter(winning -> winningResult.get(winning) != 0)
                .mapToLong(WinningPolicy::getAmount)
                .sum();
        return calculateRoundSecond((double) winningAmount / money);
    }

    private static double calculateRoundSecond(double amount) {
        return Math.round(amount * 1000) / 10.0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<WinningPolicy, Integer> getWinningResult() {
        return winningResult;
    }
}
