import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static HashSet<Integer> fiveNum = new HashSet<>();
    public static int bonusNum;
    public static final double bonusBall = 5.5;
    public static WinnerLottoDto winnerLotto = new WinnerLottoDto(fiveNum, bonusNum);
    public static HashSet<TryLottoDto> trySomeLotto = new HashSet<TryLottoDto>();
    public static HashMap<Double, Integer> nGaeIlChi = new HashMap<>();

    public static int howManyLotto;
    public static double totalReward;
    public static double yeildRate;

    public enum Reward{
        threeReward(5000),
        fourReward(50000),
        fiveReward(1500000),
        bonusReward(30000000),
        sixReward(2000000000);

        private int money;

        Reward(int money) {
            this.money = money;
        }

        public int getMoney() {
            return money;
        }
    }


    public static void main(String[] args) {
        int howManyLotto = howManyLotto();
        getSomeLotto(howManyLotto);
        getWinnerLotto();
        nGaeIlchi();
        getResult();
    }

    public static void getResult(){
        System.out.println("당첨통계");
        System.out.println("------");
        double n = 3;
        for(Reward reward : Reward.values()){
            boolean bonusIlChi = false;
            if(n == 5.5)
            {
                bonusIlChi = true;
                n=5;
                printGaeIlchi(5);
                System.out.print(", 보너스볼 일치");
            }
            else{
                printGaeIlchi(n);
            }
            System.out.print("("+reward.money+"원)-");
            if(bonusIlChi == true){
                System.out.println(nGaeIlChi.get(bonusBall) + "개");
                totalReward += reward.money * nGaeIlChi.get(bonusBall);
            }
            else{
                System.out.println(nGaeIlChi.get(n) + "개");
                totalReward += reward.money * nGaeIlChi.get(n);
            }
            n++;
            if(n == 6 && bonusIlChi == false){
                n = 5.5;
            }
        }
        yeildRate = totalReward/(howManyLotto*1000);
        System.out.println("총 수익률은 "+yeildRate+"입니다.");

    }
    public static void initnGaeIlchi(){
        for(double i = 3; i < 7; i++)
            nGaeIlChi.put(i,0);
        nGaeIlChi.put(bonusBall,0);
    }

    public static void nGaeIlchi(){

        initnGaeIlchi();
        for(TryLottoDto tryLottoDto : trySomeLotto){
            boolean bonusIlChi = false;
            int nBall = 0;
            for( int ball : tryLottoDto.sixNum){
                if(winnerLotto.sixNum.contains(ball))
                    nBall++;
                if(ball == winnerLotto.bonusNum)
                    bonusIlChi = true;
            }
            if(nBall==5 && bonusIlChi == true)
                plusValnGaeIlchi(5.5);
            else if(nBall>2)
                plusValnGaeIlchi(nBall);
        }
    }
    public static void plusValnGaeIlchi(double key){
        nGaeIlChi.put(key, nGaeIlChi.get(key) + 1);
    }

    public static void printGaeIlchi(double n){
        System.out.print((int)n+"개 일치 ");

    }

    public static int howManyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        howManyLotto =scan.nextInt()/1000;
        return howManyLotto;
    }

    public static void getSomeLotto(int howMany){
        System.out.println(howMany+"개를 구매하였습니다.");
        for(int i = 0 ; i < howMany ; i++){
            getLotto();
        }
    }
    public static void getLotto() {
        HashSet lottoSet = new HashSet();

        TryLottoDto tryLottoDto = new TryLottoDto(lottoSet);

        while(tryLottoDto.sixNum.size() < 6){
            tryLottoDto.sixNum.add((int) (Math.random()*45 + 1));
        }

        trySomeLotto.add(tryLottoDto);

        printLotto(tryLottoDto);
    }
    public static void getWinnerLotto(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        scan = new Scanner(scan.next()).useDelimiter(",");
        while(scan.hasNextInt()) {
            winnerLotto.sixNum.add(scan.nextInt());
        }
        System.out.println("보너스 볼을 입력해 주세요.");
        scan = new Scanner(System.in);
        winnerLotto.bonusNum = scan.nextInt();
    }

    public static void printLotto(TryLottoDto tryLottoDto){
        System.out.println(tryLottoDto.sixNum);
    }

}
