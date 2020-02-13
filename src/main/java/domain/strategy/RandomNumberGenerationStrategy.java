package domain.strategy;

import domain.Ticket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerationStrategy implements NumberGenerationStrategy {

    public static List<Ticket> getRandomTickets(int numberOfTickets) {
        List<Ticket> tickets = new ArrayList<>();
        List<Integer> lottoNumbers = IntStream.range(1,45).boxed().collect(Collectors.toList());

        for(int index = 0; index < numberOfTickets; index++){

            Collections.shuffle(lottoNumbers);
            tickets.add(Ticket.of(lottoNumbers.subList(0,6)));
        }
        return tickets;
    }
}
