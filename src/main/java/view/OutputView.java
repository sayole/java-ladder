package view;

import model.*;

import java.util.List;

public class OutputView {
    public static final char VERTICAL_LADDER_MARK = '-';
    public static final char HORIZONTAL_LADDER_MARK = '|';
    public static final char SPACE = ' ';
    public static final int LADDER_WIDTH = 1;
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

    public static void showLadder(Ladder ladder, List<User> users, List<LadderResult> results) {
        printName(users);
        printLadder(ladder);
        printResult(results);
    }

    private static void printName(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            printStringLine(stringBuilder, user.getName());
        }
        System.out.println(stringBuilder);
    }

    private static void printStringLine(StringBuilder stringBuilder, String string) {
        int spaceSize = CONTAINER_SIZE - string.length();
        stringBuilder = showMark(stringBuilder, spaceSize, SPACE);
        stringBuilder.append(" " + string);
    }

    private static StringBuilder showMark(StringBuilder stringBuilder, int count, char mark) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append(mark);
        }
        return stringBuilder;
    }

    private static void printLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadderLines()) {
            printLaddderLine(ladderLine);
        }
    }

    private static void printLaddderLine(LadderLine ladderLine) {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean point : ladderLine.getPoints()) {
            showPointOrSpace(stringBuilder, point);
            showMark(stringBuilder, LADDER_WIDTH, HORIZONTAL_LADDER_MARK);
        }
        System.out.println(stringBuilder);
    }

    private static StringBuilder showPointOrSpace(StringBuilder stringBuilder, Boolean point) {
        if (point) {
            return showMark(stringBuilder, CONTAINER_SIZE, VERTICAL_LADDER_MARK);
        }
        return showMark(stringBuilder, CONTAINER_SIZE, SPACE);
    }

    private static void printResult(List<LadderResult> results) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderResult result : results) {
            printStringLine(stringBuilder, result.getResult());
        }
        System.out.println(stringBuilder);
    }

    public static void printSelectUserResult() {
        System.out.println("\n결과를 보고 싶은 사람은? (종료는 stop)");
    }

    public static void printSelectedResult(String selectedResult){
        System.out.println("\n실행결과");
        System.out.println(selectedResult);
    }

    public static void printAllResult(List<User> users, List<UserResult> userResults) {
        System.out.println("\n실행결과");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getName() + " : " + userResults.get(i).getResult());
        }
    }

    public static void badInputWithUserNumber() {
        System.out.println("두명 이상의 사용자 이름을 입력해 주세요.");
    }
}
