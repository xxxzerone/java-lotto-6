package lotto.domain;

import java.util.Arrays;

public enum WinningPolicy {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NOTHING(0, false, 0L);

    private int correctCount;
    private boolean isBonus;
    private long amount;

    WinningPolicy(int correctCount, boolean isBonus, long amount) {
        this.correctCount = correctCount;
        this.isBonus = isBonus;
        this.amount = amount;
    }

    public static WinningPolicy findByCountAndBonus(int count, boolean isBonus) {
        return Arrays.stream(WinningPolicy.values())
                .filter(winning -> winning.correctCount == count && winning.isBonus == isBonus)
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }

    public long getAmount() {
        return amount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}
