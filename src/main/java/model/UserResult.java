package model;

import java.util.List;

public class UserResult {
    private String result;

    public UserResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

    public static void makeUserResults(List<UserResult> userResults, String[] results, Ladder ladder) {
        for (int lineIndex = 1; lineIndex <= results.length; lineIndex++) {
            makeUsersResults(ladder, lineIndex, userResults, results);
        }
    }

    private static void makeUsersResults(Ladder ladder, int lineIndex, List<UserResult> userResults, String[] results/*LadderResult ladderResult*/) {
        for (LadderLine currentLine : ladder.getLadderLines()) {
            lineIndex = moveCurrentPoint(lineIndex, currentLine, results.length);
        }
        UserResult userResult = new UserResult(results[lineIndex - 1]);
        userResults.add(userResult);
    }

    private static int moveCurrentPoint(int lineIndex, LadderLine currentLine, int resultsLength) {
        if (lineIndex != resultsLength && currentLine.getPoints().get(lineIndex))
            return ++lineIndex;
        if (lineIndex > 0 && currentLine.getPoints().get(lineIndex - 1))
            return --lineIndex;
        return lineIndex;
    }
}
