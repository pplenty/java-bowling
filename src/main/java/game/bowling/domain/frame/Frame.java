package game.bowling.domain.frame;

import game.bowling.domain.Score;

/**
 * Created by yusik on 2019/11/20.
 */
public interface Frame {

    int getFrameNo();

    void bowl(int score);

    Frame next();

    boolean hasNext();

    boolean isFinish();

    Score getScore();

}
