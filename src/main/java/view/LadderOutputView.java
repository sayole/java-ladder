package view;

import model.Ladder;
import model.LadderLine;

public class LadderOutputView {
    public static final char VERTICAL_LADDER_MARK = '-';
    public static final char HORIZONTAL_LADDER_MARK = '|';
    public static final char SPACE = ' ';
    public static final int LADDER_WIDTH = 1;
    public static final int CONTAINER_SIZE = 5;

    public static void printLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadderLines()) {
            printLaddderLine(ladderLine);
        }
    }

    private static void printLaddderLine(LadderLine ladderLine) {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean point : ladderLine.getPoints()) {
            showPointOrSpace(stringBuilder, point);
            OutputView.appendMark(stringBuilder, LADDER_WIDTH, HORIZONTAL_LADDER_MARK);
        }
        System.out.println(stringBuilder);
    }

    private static StringBuilder showPointOrSpace(StringBuilder stringBuilder, Boolean point) {
        if (point) {
            return OutputView.appendMark(stringBuilder, CONTAINER_SIZE, VERTICAL_LADDER_MARK);
        }
        return OutputView.appendMark(stringBuilder, CONTAINER_SIZE, SPACE);
    }
}
