package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.util.Number;
import lotto.util.Separator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void buy() {
        Store store = payMoney();
        User user = new User(store.publishLotto());

        OutputView.printLottos(store, user);

        user.findByWinning(drawingLotto());
        double winningRate = user.calculateRate(store.getAmount());

        OutputView.printWinningResult(user, winningRate);
    }

    private Winning drawingLotto() {
        while (true) {
            try {
                String winningNumber = InputView.readWinningNumber();
                List<Integer> numbers = Number.toList(Separator.split(winningNumber));

                String inputBonusNumber = InputView.readBonusNumber();
                int bonusNumber = Number.parse(inputBonusNumber);

                return new Winning(new Lotto(numbers), bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Store payMoney() {
        while (true) {
            try {
                String inputMoney = InputView.readMoney();

                return new Store(Number.parse(inputMoney));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
