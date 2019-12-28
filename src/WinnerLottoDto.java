import java.util.HashSet;

public class WinnerLottoDto {
    public HashSet<Integer> sixNum;
    public int bonusNum;

    public WinnerLottoDto(HashSet<Integer> fiveNum, int bonusNum) {
        this.sixNum = fiveNum;
        this.bonusNum = bonusNum;
    }
}
