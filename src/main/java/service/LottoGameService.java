package service;

import domain.Ticket;
import domain.Tickets;
import domain.User;
import domain.WinningNumbers;

import java.util.List;

public class LottoGameService {

    User user = new User();

    public void buyTicketsManual(List<Ticket> tickets) {

        user.buyTicketsManual(tickets);
    }

    public void buyTicketsRandom(int numberOfTickets){
        user.buyTicketsRandom(numberOfTickets);
    }

    public void checkTickets(WinningNumbers winningNumbers) {
        user.checkTickets(winningNumbers);
    }

    public Tickets getTicketsFromUser() {
        return user.getTicketsFromUser();
    }
}
