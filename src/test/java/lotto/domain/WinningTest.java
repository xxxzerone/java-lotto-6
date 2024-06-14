package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    private Winning winning;

    @BeforeEach
    void setUp() {
        winning = new Winning(new Lotto(List.of(7, 17, 18, 24, 30, 33)), 42);
    }

    @ParameterizedTest(name = "[{index}] {1}")
    @MethodSource("lottoNumbers")
    @DisplayName("당첨 내역 확인")
    void winning(Lotto lotto, WinningPolicy winningPolicy) {
        //given

        //when
        WinningPolicy winning = this.winning.winning(lotto);

        //then
        assertThat(winning).isEqualTo(winningPolicy);
    }

    private static Stream<Arguments> lottoNumbers() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(7, 17, 18, 24, 30, 33)), WinningPolicy.FIRST),
                Arguments.of(new Lotto(List.of(7, 17, 18, 24, 30, 42)), WinningPolicy.SECOND),
                Arguments.of(new Lotto(List.of(7, 17, 20, 24, 30, 33)), WinningPolicy.THIRD),
                Arguments.of(new Lotto(List.of(2, 17, 18, 20, 28, 33)), WinningPolicy.FIFTH)
        );
    }
}