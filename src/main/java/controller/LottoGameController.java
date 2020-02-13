package controller;

import domain.Ticket;
import domain.Tickets;
import domain.WinningNumbers;
import service.LottoGameService;
import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGameController {

    private InputView inputView;
    private OutputView outputView;
    private final LottoGameService lottoGameService = new LottoGameService();

    public LottoGameController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int budgetForTickets = Integer.parseInt(inputView.getBudgetForTicketsConsole());
        int numberOfManualTickets = Integer.parseInt(inputView.getMessageGetCountManualTickets());
        List<Ticket> manualTickets = new ArrayList<>();

        for(int index = 0; index < numberOfManualTickets; index ++){
            manualTickets.add(getManualNumbersTicket());
        }

        lottoGameService.buyTicketsManual(manualTickets);

        int numberOfRandomTickets = budgetForTickets / Ticket.TICKET_PRICE - numberOfManualTickets;

        lottoGameService.buyTicketsRandom(numberOfRandomTickets);

        Tickets ticketsFromUser = lottoGameService.getTicketsFromUser();
        outputView.printPurchaseList(ticketsFromUser.getTickets(),numberOfManualTickets,numberOfRandomTickets);

        String winningNumberString = inputView.getWinningNumbersConsole();
        int bonusNumber = inputView.getBonusNumberConsole();

        Set<Integer> winningNumberSet = new HashSet<>(getWinningNumbersList(winningNumberString));

        lottoGameService.checkTickets(new WinningNumbers(winningNumberSet, bonusNumber));

        outputView.printResult(ticketsFromUser);
    }

    private List<Integer> getWinningNumbersList(String winningNumberString) {
        return Arrays.stream(winningNumberString.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private Ticket getManualNumbersTicket() {
        return Ticket.of(Arrays.asList(
                Arrays.stream(inputView.getMessageGetNumberForManualTickets().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new)));
    }
}
