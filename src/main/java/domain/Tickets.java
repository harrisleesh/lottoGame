package domain;

import domain.strategy.RandomNumberGenerationStrategy;

import java.util.*;

public class Tickets {

    private List<Ticket> tickets;
    private double profitRatio;
    Map<Prize, Integer> prizeResult = new HashMap<>();

    private Tickets() {
        this.tickets = new ArrayList<>();
        initializePrizeResult();
    }

    private void initializePrizeResult() {
        for(Prize prize : Prize.values()){
            prizeResult.put(prize, 0);
        }
    }

    public static Tickets of(){
        return new Tickets();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void checkTickets(WinningNumbers winningNumbers) {
        Iterator<Ticket> ticketIterator = tickets.iterator();
        Prize prize;
        double profit = 0;

        while(ticketIterator.hasNext()){
            prize = ticketIterator.next().checkTicketWithWinningNumber(winningNumbers);
            int prizeNum = 1;
            if(prizeResult.containsKey(prize)){
                prizeNum = prizeResult.get(prize) + 1;
            }
            prizeResult.put(prize, prizeNum);
            profit += prize.getWinningMoney();
        }

        profitRatio = calculateProfitRatio(profit);
    }

    private double calculateProfitRatio(double profit) {
        return profit / (tickets.size() * Ticket.TICKET_PRICE);
    }

    public Map<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }

    public double calculateProfitRatio() {
        return profitRatio;
    }

    public void buyTicketsManual(List<Ticket> manualTickets) {
        tickets.addAll(manualTickets);
    }

    public void buyTicketsRandom(int numberOfTickets) {
        tickets.addAll(RandomNumberGenerationStrategy.getRandomTickets(numberOfTickets));
    }
}
