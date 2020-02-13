package domain;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class TicketsTest {

    @Test
    void ofTest() {

        Tickets tickets = Tickets.of();

        List<Integer> manualNumbers = IntStream.range(1,6).boxed().collect(Collectors.toList());
        Ticket manualTicket = Ticket.of(manualNumbers);

        List<Ticket> manualTickets = new ArrayList<>();
        manualTickets.add(manualTicket);

        tickets.buyTicketsManual(manualTickets);

        List<Ticket> ticketList = tickets.getTickets();
        assertThat(ticketList.size())
                .isEqualTo(1);
        assertThat(ticketList.get(0).getNumbers().containsAll(manualNumbers))
            .isTrue();
    }

}