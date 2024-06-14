package lotto.view;

import lotto.domain.Store;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    @DisplayName("출력 형식 확인")
    void printLottos() {
        Store store = new Store(5000);
        User user = new User(store.publishLotto());
        OutputView.printLottos(store, user);
    }
}