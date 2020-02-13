# java-lotto 게임
당첨 번호와 금액을 입력하면 해당 금액에 맞게 로또 티켓을 랜덤으로 구매한 후 당첨 정보를 출력해 준다.<br>
MVC Model Structure 
- Input : 구입금액, 당첨 번호
- Output : 당첨 통계, 수익률 
<h2>1. Domain 설계 </h2>
 - Ticket
 - Tickets
 - Prize
 - WinningNumbers

<h2>2. 전략 설계</h2>
 - Manual Lotto Number Generation
 - Random Lotto Number Generation
 
<h2>3. 게임 설계</h2>

<h2>4. 단위테스트 작성</h2>

<h2>5. 예외작성</h2>

<h2>6. 테스트작성</h2>
 - 도메인 테스트 작성 (Ticket,Tickets,Prize)
 
<h2>7. 요구사항 추가</h2>
- 수동 입력 받기 (기존에는 자동 발권)
- 보너스 볼 입력받기(기존에 기능 구현되어있음.)
- Refactoring 