# 로또 서비스
## 요구 사항
- 입력
  - [x] 구입 금액
  - [x] 당첨 번호
    - 쉼표 기준 6개 숫자
  - [x] 보너스 번호


- 출력
  - [x] 발행한 로또 수량
  - [x] 발행한 로또 번호
  - [x] 당첨 내역
  - [x] 수익률


- Error 문구는 "[ERROR]"로 시작
- [x] 구매 금액 1,000원 단위 검증
  - 1,000원으로 나누어 떨어지지 않으면 IllegalArgumentException
- [x] 구매 수량만큼 로또 발행
  - asc 정렬
- [x] 1~45의 랜덤 숫자 생성
- [x] 당첨 번호 split
  - 각각의 번호가 1~45가 아니면 IllegalArgumentException
- [x] 당첨 번호가 6개인지 검증
  - 6개가 아니면 IllegalArgumentException
- [x] 당첨 번호 중복 숫자 검증
  - 중복 시 IllegalArgumentException
- [x] 보너스 번호 1개, 1~45 범위인지 검증
  - 해당 하지 않으면 IllegalArgumentException
- [x] 보너스 번호가 당첨 번호와 중복인지 검증
  - 중복 시 IllegalArgumentException
- [x] 당첨 번호와 발행한 로또 번호 비교
- [x] 수익률 계산
  - 당첨 금액 / 구입 금액 * 100
   
## 도메인
- 사용자
  - 여러 개의 로또
- 당첨 정책
  - 일치 수
  - 보너스 일치 여부
  - 금액
- 로또 가게
  - 금액
- 결과
  - 일치하는 숫자의 수
- 입력
- 출력