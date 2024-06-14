package lotto.domain;

import lotto.util.Validate;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 정수여야 합니다.");
        }
        if (Validate.numberOutOfRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 벗어난 숫자가 있습니다.");
        }
        if (Validate.numberOfDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
