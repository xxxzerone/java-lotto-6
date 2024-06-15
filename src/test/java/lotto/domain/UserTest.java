package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    Winning winning;
    User user;

    @BeforeEach
    void setUp() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        user = new User(lottos);
        winning = new Winning(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    @DisplayName("3등 당첨 확인")
    void findByWinning() {
        //given
        user.findByWinning(winning);
        //when
        //then
        assertThat(user.getWinningResult().keySet()).contains(WinningPolicy.FIFTH);
    }

    @Test
    @DisplayName("수익률 계산 3등")
    void calculateRate() {
        //given
        user.findByWinning(winning);
        //when
        double winningRate = user.calculateRate(8000);
        //then
        assertThat(winningRate).isEqualTo(62.5);
    }

    @Test
    @DisplayName("수익률 계산 소수점 둘째 자리 반올림")
    void calculateRate_round() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)),
                new Lotto(List.of(6, 12, 17, 20, 22, 45)),
                new Lotto(List.of(5, 8, 10, 14, 22, 45)),
                new Lotto(List.of(10, 13, 15, 24, 32, 45)),
                new Lotto(List.of(11, 23, 25, 28, 33, 44))
        );
        user = new User(lottos);
        winning = new Winning(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        user.findByWinning(winning);
        //when
        double winningRate = user.calculateRate(12000);
        //then
        assertThat(winningRate).isEqualTo(41.7);
    }
}