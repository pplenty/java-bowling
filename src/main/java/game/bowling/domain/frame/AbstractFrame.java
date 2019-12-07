package game.bowling.domain.frame;

import game.bowling.domain.FrameNumber;
import game.bowling.domain.Score;
import game.bowling.domain.status.Status;

/**
 * Created by yusik on 2019/12/08.
 */
public abstract class AbstractFrame implements Frame {

    protected FrameNumber frameNo;
    protected Status status;

    public AbstractFrame(FrameNumber frameNo, Status status) {
        this.frameNo = frameNo;
        this.status = status;
    }

    @Override
    public void bowl(int score) {
        status = status.bowl(score);
    }

    @Override
    public Score getScore() {
        return status.getScore();
    }

    @Override
    public boolean hasNext() {
        return !frameNo.isFinalNumber();
    }

    @Override
    public int getFrameNo() {
        return frameNo.get();
    }

    @Override
    public boolean isFinish() {
        return status.isFinal();
    }
}
