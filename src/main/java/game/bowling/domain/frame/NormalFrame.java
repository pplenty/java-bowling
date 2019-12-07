package game.bowling.domain.frame;

import game.bowling.domain.FrameNumber;
import game.bowling.domain.status.FirstThrow;

/**
 * Created by yusik on 2019/11/20.
 */
public class NormalFrame extends AbstractFrame {

    private NormalFrame(FrameNumber frameNo) {
        super(frameNo, new FirstThrow());
    }

    public static NormalFrame first() {
        return new NormalFrame(FrameNumber.firstNumber());
    }

    @Override
    public Frame next() {
        if (frameNo.hasNextOnlyOne()) {
            return new FinalFrame();
        }
        return new NormalFrame(frameNo.next());
    }
}
