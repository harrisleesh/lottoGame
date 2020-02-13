package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_GET_BUDGET_FOR_TICKETS = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_GET_COUNT_MANUAL_TICKETS = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_GET_NUMBER_FOR_MANUAL_TICKETS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_GET_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_GET_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";


    public String getBudgetForTicketsConsole() {
        System.out.println(MESSAGE_GET_BUDGET_FOR_TICKETS);
        return SCANNER.nextLine();
    }

    public String getMessageGetCountManualTickets(){
        System.out.println(MESSAGE_GET_COUNT_MANUAL_TICKETS);
        return SCANNER.nextLine();
    }

    public String getMessageGetNumberForManualTickets(){
        System.out.println(MESSAGE_GET_NUMBER_FOR_MANUAL_TICKETS);
        return SCANNER.nextLine();
    }

    public String getWinningNumbersConsole() {
        System.out.println(MESSAGE_GET_WINNING_NUMBERS);
        return SCANNER.nextLine();
    }

    public int getBonusNumberConsole() {
        System.out.println(MESSAGE_GET_BONUS_NUMBER);
        return SCANNER.nextInt();
    }
}
