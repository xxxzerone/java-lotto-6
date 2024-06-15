package lotto.domain;

import java.util.Arrays;

public enum WinningPolicy {
    EMPTY(0, false, "0", 0L),
    FIFTH(3, false, "5,000", 5_000L),
    FOURTH(4, false, "50,000", 50_000L),
    THIRD(5, false, "1,500,000", 1_500_000L),
    SECOND(5, true, "30,000,000", 30_000_000L),
    FIRST(6, false, "2,000,000,000", 2_000_000_000);

    private final int correctCount;
    private final boolean isBonus;
    private final String viewAmount;
    private final long amount;

    WinningPolicy(int correctCount, boolean isBonus, String viewAmount, long amount) {
        this.correctCount = correctCount;
        this.isBonus = isBonus;
        this.viewAmount = viewAmount;
        this.amount = amount;
    }

    public static WinningPolicy findByCountAndBonus(int count, boolean isBonus) {
        return Arrays.stream(WinningPolicy.values())
                .filter(winning -> isSameAll(count, isBonus, winning))
                .findAny()
                .orElse(EMPTY);
    }

    private static boolean isSameAll(int count, boolean isBonus, WinningPolicy winning) {
        return winning.correctCount == count && winning.isBonus == isBonus;
    }

    public String getViewAmount() {
        return viewAmount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getAmount() {
        return amount;
    }
}
