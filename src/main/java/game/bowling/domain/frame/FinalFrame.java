package game.bowling.domain.frame;

import game.bowling.domain.FrameNumber;
import game.bowling.domain.status.FinalFirstThrow;

/**
 * Created by yusik on 2019/11/20.
 */
public class FinalFrame extends AbstractFrame {

    public FinalFrame() {
        super(FrameNumber.finalNumber(), new FinalFirstThrow());
    }

    @Override
    public Frame next() {
        return null;
    }

}
