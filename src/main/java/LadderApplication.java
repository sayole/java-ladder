import controller.LadderController;
import view.InputView;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.runLadder();
    }
}
