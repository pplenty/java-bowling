package game.bowling.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by yusik on 2019/12/07.
 */
class FrameNumberTest {

    @Test
    void hasNextOnlyOne() {

        // given
        FrameNumber frameNumber = FrameNumber.of(9);

        // when
        boolean result = frameNumber.hasNextOnlyOne();

        // then
        assertThat(result).isTrue();

    }

    @Test
    void of() {

        // given
        FrameNumber expected = FrameNumber.of(5);

        // when
        FrameNumber result = FrameNumber.of(5);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void finalNumber() {

        // given
        FrameNumber expected = FrameNumber.of(10);

        // when
        FrameNumber result = FrameNumber.finalNumber();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void rangeOut() {
        assertThatThrownBy(() -> FrameNumber.of(11))
                .isInstanceOf(IllegalArgumentException.class);
    }
}