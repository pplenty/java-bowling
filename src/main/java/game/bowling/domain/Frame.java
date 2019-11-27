package game.bowling.domain;

/**
 * Created by yusik on 2019/11/20.
 */
public interface Frame {

    int NUMBER_OF_FRAME = 10;

    int getFrameNo();

    void bowl(int score);

    Frame next();

    boolean hasNext();

    boolean isFinish();

    Score getScore();

}
