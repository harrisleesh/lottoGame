import controller.LottoGameController;
import view.InputView;
import view.OutputView;

public class Game {

    public void play() {
        LottoGameController lottoGameController = new LottoGameController(new InputView(), new OutputView());
        lottoGameController.run();
    }
}
