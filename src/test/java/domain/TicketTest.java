package domain;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void ofTest() {
        List<Integer> ticketList = IntStream.range(1,6).boxed().collect(Collectors.toList());
        Ticket ticket = Ticket.of(ticketList);
        Set<Integer> manualNumbers =ticket.getNumbers();
        Set<Integer> numbers = new HashSet<>(Arrays.asList(0,1,2,3,4,5));
        assertThat(manualNumbers.containsAll(numbers))
                .isTrue();
    }

    @Test
    void checkTicketWithWinningNumberTest() {
        List<Integer> ticketList = IntStream.range(1,6).boxed().collect(Collectors.toList());
        Ticket ticket = Ticket.of(ticketList);

        Set<Integer> numbers = new HashSet<>(Arrays.asList(0,1,2,3,4,5));
        WinningNumbers winningNumbers = new WinningNumbers(numbers,6);

        assertThat(ticket.checkTicketWithWinningNumber(winningNumbers))
                .isEqualTo(Prize.SIX_MATCHED);
    }

    @Test
    void test(){
        List<Integer> ticketList = new ArrayList<>();
        List<Integer> lottoNumbers = IntStream.range(0,45).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        lottoNumbers.subList(0,6);
    }
}