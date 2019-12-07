package game.bowling.domain;

import game.bowling.domain.status.FirstThrow;
import game.bowling.domain.status.Status;

/**
 * Created by yusik on 2019/11/20.
 */
public class NormalFrame implements Frame {

    private final FrameNumber frameNo;
    private Status status;

    private NormalFrame(FrameNumber frameNo) {
        this.frameNo = frameNo;
        status = new FirstThrow();
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

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int getFrameNo() {
        return frameNo.get();
    }

    @Override
    public Score getScore() {
        return status.getScore();
    }

    @Override
    public void bowl(int score) {
        status = status.bowl(score);
    }

    public boolean isFinish() {
        return status.isFinal();
    }
}
