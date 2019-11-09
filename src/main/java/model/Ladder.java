package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<LadderLine> ladderLines = new ArrayList<>();
    public Ladder(int ladderHeight, int countOfUsers) {
        for(int i=0; i<ladderHeight; i++){
            ladderLines.add(new LadderLine(countOfUsers));
        }
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
