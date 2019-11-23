package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private List<Boolean> points = new ArrayList<>();

    public LadderLine(int countOfUsers) {
        setLadderLine(countOfUsers);
    }

    private void setLadderLine(int countOfUsers) {
        boolean lastPoint = false;
        points.add(lastPoint);
        for (int i = 0; i < countOfUsers - 1; i++) {
            lastPoint = setPoint(lastPoint);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private boolean setPoint(boolean lastPoint) {
        if (!lastPoint && hasPoint()) {
            points.add(true);
            return true;
        }
        points.add(false);
        return false;
    }

    private boolean hasPoint() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
