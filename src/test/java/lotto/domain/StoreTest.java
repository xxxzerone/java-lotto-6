package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StoreTest {

    @Test
    @DisplayName("금액 1500원, 천원 단위가 아니라 예외")
    void notPurchase() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Store(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 천원 단위입니다.");
    }

    @Test
    @DisplayName("금액 5000원, 구매 가능")
    void purchase() {
        //given
        //when
        //then
        assertThatCode(() -> new Store(5000)).doesNotThrowAnyException();
    }
}