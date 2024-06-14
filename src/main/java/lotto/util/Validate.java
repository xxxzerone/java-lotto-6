package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class Validate {

    public static boolean numberOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(Validate::isOutOfRange);
    }

    public static boolean numberOfDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != 6;
    }

    public static boolean bonusNumberOutOfRange(int number) {
        return isOutOfRange(number);
    }

    public static boolean bonusNumberInLotto(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    private static boolean isOutOfRange(int number) {
        return !(1 <= number && number <= 45);
    }
}
