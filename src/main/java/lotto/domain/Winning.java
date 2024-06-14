package lotto.domain;

public class Winning {

    private final Lotto winning;
    private final int bonusNumber;

    public Winning(Lotto winning, int bonusNumber) {
        this.winning = winning;
        this.bonusNumber = bonusNumber;
    }

    public WinningPolicy winning(Lotto lotto) {
        return WinningPolicy.findByCountAndBonus(getCorrectCount(lotto), isBonus(lotto));
    }

    private int getCorrectCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winning.getNumbers().contains(number))
                .count();
    }

    private boolean isBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
