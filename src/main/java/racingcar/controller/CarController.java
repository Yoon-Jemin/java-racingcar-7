package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    private final OutputView outputView;
    private final InputView inputView;
    private final CarService carService;

    public CarController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.carService = new CarService();
    }

    public void run() {
        outputView.printStartMessage();
        ArrayList<String> carNames = inputView.readCarNames();

        for (String carName : carNames) {
            carService.addParticipant(carName);
        }

        outputView.printAttemptMessage();
        int attempts = inputView.readAttempts();

        startGame(attempts);
        List<String> winners = carService.getWinners();
    }

    private void startGame(int attempts) {
        for (int i = 0; i < attempts; i++) {
            carService.advanceCars();
        }
        carService.updateWinners();
    }
}
