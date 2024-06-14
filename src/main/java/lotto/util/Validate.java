package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class Validate {

    public static void numberOutOfRange(List<Integer> numbers) {
        boolean hasNumberOutOfRange = numbers.stream()
                .anyMatch(Validate::isOutOfRange);
        if (hasNumberOutOfRange) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 벗어난 숫자가 있습니다.");
        }
    }

    public static void numberOfDuplicate(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 있습니다.");
        }
    }

    public static void bonusNumberOutOfRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 벗어난 숫자가 있습니다.");
        }
    }

    public static void bonusNumberInLotto(Lotto lotto, int bonusNumber) {
        if (isBonusNumberInLotto(lotto, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자가 로또 번호 숫자와 겹칩니다.");
        }
    }

    private static boolean isBonusNumberInLotto(Lotto lotto, Integer bonusNumber) {
        return lotto.getNumbers().stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    private static boolean isOutOfRange(int number) {
        return !(1 <= number && number <= 45);
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != 6;
    }
}
