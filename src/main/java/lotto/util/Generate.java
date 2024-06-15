package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Generate {

    public static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
