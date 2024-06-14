package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidateTest {

    @Test
    @DisplayName("1 ~ 45 범위의 숫자 6개 성공")
    void numberOutOfRange_success() {
        //given
        List<Integer> numbers = List.of(1, 10, 20, 26, 32, 40);

        //when

        //then
        assertThatCode(() -> Validate.numberOutOfRange(numbers)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("1 ~ 45 범위의 벗어난 숫자 6개 예외")
    void numberOutOfRange_fail() {
        //given
        List<Integer> numbers1 = List.of(1, 10, 20, 26, 32, 48);
        List<Integer> numbers2 = List.of(0, 10, 20, 26, 32, 48);

        //when

        //then
        assertThatThrownBy(() -> Validate.numberOutOfRange(numbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 범위의 벗어난 숫자가 있습니다.");
        assertThatThrownBy(() -> Validate.numberOutOfRange(numbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 범위의 벗어난 숫자가 있습니다.");
    }

    @Test
    @DisplayName("중복된 수 없을 때 성공")
    void numberOfDuplicate_success() {
        //given
        List<Integer> numbers = List.of(1, 10, 20, 26, 32, 45);

        //when

        //then
        assertThatCode(() -> Validate.numberOfDuplicate(numbers)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("중복된 수가 있을 때 예외")
    void numberOfDuplicate_fail() {
        //given
        List<Integer> numbers1 = List.of(1, 20, 20, 26, 32, 45);
        List<Integer> numbers2 = List.of(6, 6, 20, 32, 32, 45);

        //when

        //then
        assertThatThrownBy(() -> Validate.numberOfDuplicate(numbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 수가 있습니다.");
        assertThatThrownBy(() -> Validate.numberOfDuplicate(numbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 수가 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 40, 20, 34, 27})
    @DisplayName("보너스 번호가 1~45 범위면 성공")
    void bonusNumberOutOfRange_success(int number) {
        //given
        //when
        //then
        assertThatCode(() -> Validate.bonusNumberOutOfRange(number)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스 번호가 1~45 범위 벗어나면 실패")
    void bonusNumberOutOfRange_fail(int number) {
        //given
        //when
        //then
        assertThatThrownBy(() -> Validate.bonusNumberOutOfRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 범위의 벗어난 숫자가 있습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호랑 겹치지 않으면 성공")
    void bonusNumberInLotto_success() {
        //given
        Lotto winning = new Lotto(List.of(1, 5, 8, 16, 22, 30));
        int bonusNumber = 10;
        //when

        //then
        assertThatCode(() -> Validate.bonusNumberInLotto(winning, bonusNumber)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호랑 겹치면 에러")
    void bonusNumberInLotto_fail() {
        //given
        Lotto winning = new Lotto(List.of(1, 5, 10, 16, 22, 30));
        int bonusNumber = 10;
        //when

        //then
        assertThatThrownBy(() -> Validate.bonusNumberInLotto(winning, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호의 숫자가 로또 번호 숫자와 겹칩니다.");
    }
}