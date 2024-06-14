package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Number {

    public static int parse(String value) throws IllegalArgumentException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수로 입력해야 합니다.");
        }
    }

    public static List<Integer> toList(String[] values) throws IllegalArgumentException {
        return Arrays.stream(values)
                .mapToInt(Number::parse)
                .boxed()
                .toList();
    }
}
