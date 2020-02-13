package domain;

import java.util.List;

public class User {

    Tickets tickets = Tickets.of();

    public void buyTicketsManual(List<Ticket> manualTickets) {
        tickets.buyTicketsManual(manualTickets);
    }

    public void buyTicketsRandom(int numberOfTickets) {
        tickets.buyTicketsRandom(numberOfTickets);
    }

    public void checkTickets(WinningNumbers winningNumbers) {
        tickets.checkTickets(winningNumbers);
    }

    public Tickets getTicketsFromUser() {
        return tickets;
    }
}
