package lotto.domain;

import lotto.util.Validate;

public class Winning {

    private final Lotto winning;
    private final int bonusNumber;

    public Winning(Lotto winning, int bonusNumber) {
        validate(winning, bonusNumber);
        this.winning = winning;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winning, int bonusNumber) {
        if (Validate.bonusNumberOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 벗어난 숫자가 있습니다.");
        }

        if (Validate.bonusNumberInLotto(winning, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자가 로또 번호 숫자와 겹칩니다.");
        }
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
