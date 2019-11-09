package controller;

import model.Ladder;
import model.LadderLine;
import model.LadderResult;
import model.User;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {
    public static int LADDER_HEIGHT;
    private static List<User> users = new ArrayList<>();
    private static List<LadderResult> results = new ArrayList<>();
    private static Ladder ladder;

    public void setUsers() {
        OutputView.printGetUserNames();
        String usernames = InputView.getUsers();
        for (String username : usernames.split(",")) {
            users.add(new User(username));
        }
    }

    public void setLadder() {
        OutputView.printGetLadderHeight();
        LADDER_HEIGHT = InputView.getLadderHeight();
        ladder = new Ladder(LADDER_HEIGHT, users.size());
    }

    public void showLadder() {
        OutputView.drawLadder(ladder, users, results);
        setCorrectResult();
    }

    public void setResults() {
        for (int i = 0; i < users.size(); i++) {
            results.add(new LadderResult());
        }
    }

    public void showResult(String selectedUser) {
        if (selectedUser.equals("all")) {
            OutputView.printAllResult(users, results);
            return;
        }
        showUserResult(selectedUser);
    }

    public void showUserResult(String selectedUser) {
        boolean selected = false;
        int index;
        for (index = 0; index < users.size() && selected != true; index++) {
            selected = users.get(index).isSelected(selectedUser);
        }
        if (selected == true)
            OutputView.printSelectedResult(results.get(index - 1).getValue());
    }

    public void setCorrectResult() {
        List<LadderResult> correctedResults = new ArrayList<>();
        for (int lineIndex = 1; lineIndex <= users.size(); lineIndex++)
            setUsersResults(lineIndex, correctedResults);
        results = correctedResults;
    }

    private void setUsersResults(int lineIndex, List<LadderResult> correctedResults) {
        for (LadderLine currentLine : ladder.getLadderLines()) {
            lineIndex = moveCurrentPoint(lineIndex, currentLine);
        }
        correctedResults.add(results.get(lineIndex-1));
    }

    public int moveCurrentPoint(int lineIndex, LadderLine currentLine) {
        if (lineIndex != users.size() && currentLine.getPoints().get(lineIndex))
            return ++lineIndex;
        if (lineIndex > 0 && currentLine.getPoints().get(lineIndex - 1))
            return --lineIndex;
        return lineIndex;
    }
}
