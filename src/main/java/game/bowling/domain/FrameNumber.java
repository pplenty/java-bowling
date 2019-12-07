package game.bowling.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by yusik on 2019/12/07.
 */
public class FrameNumber {

    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final String MESSAGE = String.format("프레임 번호의 범위는 [%d, %d] 입니다.", MIN, MAX);
    private static final Map<Integer, FrameNumber> CACHE = new HashMap<>();

    private final int number;

    static {
        for (int i = MIN; i <= MAX; i++) {
            CACHE.put(i, new FrameNumber(i));
        }
    }

    private FrameNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(MESSAGE);
        }
        this.number = number;
    }

    public boolean hasNextOnlyOne() {
        return this.number == MAX - 1;
    }

    public static FrameNumber of(int number) {
        return Optional.ofNullable(CACHE.get(number))
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE));
    }

    public static FrameNumber firstNumber() {
        return CACHE.get(MIN);
    }

    public static FrameNumber finalNumber() {
        return CACHE.get(MAX);
    }

    public FrameNumber next() {
        return CACHE.get(number + 1);
    }

    public int get() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FrameNumber)) return false;

        FrameNumber that = (FrameNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
