package domain;

public enum Prize {

    SIX_MATCHED(2000000000),
    FIVE_MATCHED_WITH_BONUS(30000000),
    FIVE_MATCHED(1500000),
    FOUR_MATCHED(50000),
    THREE_MATCHED(5000),
    NO_MATCHED(0);

    private int winningMoney;

    Prize(int winningMoney){
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney(){
        return winningMoney;
    }

    public static Prize match(int countOfWinningNumbers, boolean isBonusNumber) {
        switch (countOfWinningNumbers){
            case 6:
                return SIX_MATCHED;
            case 5:
                if(isBonusNumber)
                    return FIVE_MATCHED_WITH_BONUS;
                return FIVE_MATCHED;
            case 4:
                return FOUR_MATCHED;
            case 3:
                return THREE_MATCHED;
            default:
                return NO_MATCHED;
        }
    }
}
