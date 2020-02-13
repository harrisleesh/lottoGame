package domain;

import domain.strategy.NumberGenerationStrategy;

import java.util.*;

public class Ticket {

    public static final int MAX_COUNT_OF_LOTTO_NUMBERS = 6;
    public static final int TICKET_PRICE = 1000;

    private static Prize prize;

    private Set<Integer> numbers;

    private Ticket(List<Integer> numbersList) {
        numbers = new HashSet<>(numbersList);
    }

    public static Ticket of(List<Integer> numbers){
        return new Ticket(numbers);
    }

    public static Prize getPrize() {
        return prize;
    }

    public Prize checkTicketWithWinningNumber(WinningNumbers winningNumbers) {
        int countOfWinningNumbers = getCountOfWinningNumbers(winningNumbers);
        boolean isBonusNumber = false;

        if(countOfWinningNumbers == 5)
            isBonusNumber = getCountOfBonusNumber(winningNumbers.bonusNumber);

        prize = Prize.match(countOfWinningNumbers, isBonusNumber);
        return prize;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private int getCountOfWinningNumbers(WinningNumbers winningNumbers) {
        int count = 0;

        Iterator<Integer> winningNumberIterator = winningNumbers.winningNumbers.iterator();
        while(winningNumberIterator.hasNext())
            if(numbers.contains(winningNumberIterator.next())){
                count++;
        }
        return count;
    }

    private boolean getCountOfBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
