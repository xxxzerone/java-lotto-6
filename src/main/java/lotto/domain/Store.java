package lotto.domain;

import lotto.util.Generate;

import java.util.List;
import java.util.stream.IntStream;

public class Store {

    private static final int DEFAULT_UNIT_AMOUNT = 1000;

    private final int amount;

    public Store(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (isPurchase(amount)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 천원 단위입니다.");
        }
    }

    private static boolean isPurchase(int amount) {
        return amount % DEFAULT_UNIT_AMOUNT != 0;
    }

    public List<Lotto> publishLotto() {
        return IntStream.range(0, getLottoCount())
                .mapToObj(i -> new Lotto(getSortedNumbers()))
                .toList();
    }

    private int getLottoCount() {
        return amount / DEFAULT_UNIT_AMOUNT;
    }

    private List<Integer> getSortedNumbers() {
        List<Integer> numbers = Generate.getNumbers();
        numbers.sort(null);
        return numbers;
    }
}
