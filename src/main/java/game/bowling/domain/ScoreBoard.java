package game.bowling.domain;

import game.bowling.domain.frame.Frame;
import game.bowling.domain.frame.NormalFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Created by yusik on 2019/11/23.
 */
public class ScoreBoard {

    private final String playerName;
    private final List<Frame> frames;
    private int currentFrameIndex = 0;

    public ScoreBoard(String playerName) {

        this.playerName = playerName;
        frames = new ArrayList<>();

        Frame frame = NormalFrame.first();
        frames.add(frame);
        while (frame.hasNext()) {
            frame = frame.next();
            frames.add(frame);
        }
    }

    public List<Integer> getFrameNos() {
        return frames.stream()
                .map(Frame::getFrameNo)
                .collect(toList());
    }

    public List<Score> getScores() {
        return frames.stream()
                .map(Frame::getScore)
                .collect(toList());
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean hasNextFrame() {
        if (currentFrameIndex == frames.size() - 1) {
            return !frames.get(currentFrameIndex).isFinish();
        }
        return currentFrameIndex < frames.size();
    }

    public int nextFrameNo() {
        if (frames.get(currentFrameIndex).isFinish()) {
            currentFrameIndex++;
        }

        return Optional.ofNullable(frames.get(currentFrameIndex))
                .map(Frame::getFrameNo)
                .orElse(0);
    }

    public void bowl(int score) {
        Frame currentFrame = frames.get(currentFrameIndex);
        currentFrame.bowl(score);
    }
}
