package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @Test
    void getWinningMoneyTest() {
        Prize prize = Prize.SIX_MATCHED;
        assertThat(prize.getWinningMoney()).isEqualTo(Prize.SIX_MATCHED.getWinningMoney());
    }

    @Test
    void matchTest() {
        assertThat(Prize.match(6, false))
                .isEqualTo(Prize.SIX_MATCHED);
        assertThat(Prize.match(5,true))
                .isEqualTo(Prize.FIVE_MATCHED_WITH_BONUS);
        assertThat(Prize.match(5,false))
                .isEqualTo(Prize.FIVE_MATCHED);
        assertThat(Prize.match(4,false))
                .isEqualTo(Prize.FOUR_MATCHED);
        assertThat(Prize.match(3,false))
                .isEqualTo(Prize.THREE_MATCHED);
        assertThat(Prize.match(2,false))
                .isEqualTo(Prize.NO_MATCHED);



    }
}