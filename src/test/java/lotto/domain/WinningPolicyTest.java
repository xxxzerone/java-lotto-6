package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningPolicyTest {

    @ParameterizedTest
    @MethodSource("resultWinning")
    @DisplayName("당첨 내역 확인")
    void findByCountAndBonus(int count, boolean isBonus, WinningPolicy winningPolicy) {
        //given

        //when
        WinningPolicy winning = WinningPolicy.findByCountAndBonus(count, isBonus);

        //then
        assertThat(winning).isEqualTo(winningPolicy);
    }

    private static Stream<Arguments> resultWinning() {
        return Stream.of(
                Arguments.of(6, false, WinningPolicy.FIRST),
                Arguments.of(5, true, WinningPolicy.SECOND),
                Arguments.of(5, false, WinningPolicy.THIRD),
                Arguments.of(3, false, WinningPolicy.FIFTH)
        );
    }
}