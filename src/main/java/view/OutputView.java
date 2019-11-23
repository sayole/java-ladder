package view;

import model.*;

import java.util.List;

public class OutputView {
    public static final char SPACE = ' ';
    public static final int CONTAINER_SIZE = 5;

    public static void printGetUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printGetResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static void printGetLadderHeight() {
        System.out.println("사다리의 높이는 몇개인가요?");
    }

    public static StringBuilder appendMark(StringBuilder stringBuilder, int count, char mark) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append(mark);
        }
        return stringBuilder;
    }

    public static StringBuilder printStringLine(StringBuilder stringBuilder, String string) {
        int spaceSize = CONTAINER_SIZE - string.length();
        stringBuilder = OutputView.appendMark(stringBuilder, spaceSize, SPACE);
        return stringBuilder.append(" " + string);
    }

    public static void printSelectUserResult() {
        System.out.println("\n결과를 보고 싶은 사람은? (종료는 stop)");
    }


}
