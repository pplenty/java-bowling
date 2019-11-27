package game.bowling.domain;

import game.bowling.domain.status.FirstThrow;
import game.bowling.domain.status.Status;

/**
 * Created by yusik on 2019/11/20.
 */
public class NormalFrame implements Frame {

    private final int frameNo;
    private Status status;

    private NormalFrame(int frameNo) {
        this.frameNo = frameNo;
        status = new FirstThrow();
    }

    public static NormalFrame first() {
        return new NormalFrame(1);
    }

    @Override
    public Frame next() {
        if (this.frameNo == NUMBER_OF_FRAME - 1) {
            return new FinalFrame();
        }
        return new NormalFrame(this.frameNo + 1);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int getFrameNo() {
        return frameNo;
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
