package lotto.domain;

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

    private int getLottoCount() {
        return amount / DEFAULT_UNIT_AMOUNT;
    }
}
