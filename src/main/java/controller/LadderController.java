package controller;

import model.Ladder;
import model.LadderResult;
import model.User;
import model.UserResult;
import view.*;

import java.util.ArrayList;
import java.util.List;

public class LadderController {
    public static final int MINIMUM_USERS = 2;
    private static final List<User> users = new ArrayList<>();
    private static final List<LadderResult> ladderResults = new ArrayList<>();
    private static final List<UserResult> userResults = new ArrayList<>();
    private static int LADDER_HEIGHT;
    private static Ladder ladder;

    public void runLadder() {
        setUsers();
        String stringResults = getCorrectResults();
        setLadderResults(stringResults);
        setLadder();
        setUserResults(stringResults);
        showLadder();
        runLadderResult();
    }

    private void setUsers() {
        OutputView.printGetUserNames();
        String userNames = InputView.getUsers();
        for (String userName : userNames.split(",")) {
            User.addIfGoodInput(userName, users);
        }
        restartIfBadSize();
    }

    private void restartIfBadSize() {
        if (users.size() < MINIMUM_USERS) {
            ErrorOutputView.badInputWithUserNumber();
            users.removeAll(users);
            setUsers();
        }
    }

    private String getCorrectResults() {
        OutputView.printGetResults();
        String stringResults = InputView.getResults();
        int resultNumber = stringResults.split(",").length;
        if (resultNumber != users.size()) {
            ErrorOutputView.badInputWithResultNumber();
            return getCorrectResults();
        }
        return stringResults;
    }

    private void setLadderResults(String stringResults) {
        for (String result : stringResults.split(",")) {
            LadderResult ladderResult = new LadderResult(result);
            ladderResults.add(ladderResult);
        }
    }

    private void setLadder() {
        setLadderHeight();
        ladder = new Ladder(LADDER_HEIGHT, users.size());
    }

    private void setLadderHeight() {
        try {
            OutputView.printGetLadderHeight();
            LADDER_HEIGHT = InputView.getLadderHeight();
            checkLadderHeightRange();
        } catch (NumberFormatException e) {
            ErrorOutputView.badInputWithLadderHeight();
            setLadderHeight();
        }
    }

    private void checkLadderHeightRange() {
        if (LADDER_HEIGHT < 1)
            throw new NumberFormatException();
    }

    private void setUserResults(String stringResults) {
        String[] results = stringResults.split(",");
        UserResult.makeUserResults(userResults, results, ladder);
    }

    private void showLadder() {
        UserOutputView.printName(users);
        LadderOutputView.printLadder(ladder);
        ResultOutputView.printResult(ladderResults);
    }

    private void runLadderResult() {
        String selectedResult = "";
        while (!(selectedResult.equals("stop"))) {
            OutputView.printSelectUserResult();
            selectedResult = InputView.getSelectedResult();
            showResult(selectedResult);
        }
    }

    private void showResult(String selectedResult) {
        if (selectedResult.equals("all")) {
            ResultOutputView.printAllResult(users, userResults);
            return;
        }
        showUserResult(selectedResult);
    }

    private void showUserResult(String selectedUser) {
        boolean selected = false;
        int index;
        for (index = 0; index < users.size() && selected != true; index++) {
            selected = users.get(index).isSelected(selectedUser);
        }
        if (selected != true) {
            ErrorOutputView.badInputWithUserName();
            return;
        }
        ResultOutputView.printSelectedResult(userResults.get(index - 1).getResult());
    }
}
