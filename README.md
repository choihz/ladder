# 사다리 게임

## 기능 목록

### Direction
- 왼쪽과 오른쪽으로 움직일 수 있는지 알고 있다.
- 현재 Direction을 바탕으로 다음 Direction을 리턴할 수 있다.
- position을 받아 이동시킬 수 있다.

### Line
- 사다리의 가로 한 줄을 의미한다.
- Direction의 List를 가진다.
- position을 받아 이동시킬 수 있다.

### Ladder
- Line의 List를 가진다.
- Players와 Items를 받아 사다리 게임을 진행하고 LadderResult를 리턴할 수 있다.

### Player
- 사다리 게임에서의 참가자 한 명을 의미한다.
- 이름(1자 이상, 5자 이하)을 가진다.

### Players
- Player의 List를 가진다.

### Item
- 사다리 게임에서의 보상 하나를 의미한다.
- 이름(1자 이상, 5자 이하)을 가진다.

### Items
- Item의 List를 가진다.

### LadderResult
- 사다리 게임의 결과를 저장한다.
- Player를 key로, Item을 value로 하는 Map을 가진다.

### LineGenerator
- Player의 숫자와 BooleanGenerator를 받아 Line을 생성한다.

### LadderGenerator
- Player의 숫자, 사다리의 높이, BooleanGenerator를 받아 Ladder를 생성한다.

### RandomBooleanGenerator
- BooleanGenerator 인터페이스를 구현하여, 랜덤으로 boolean을 반환한다.

### InputView
- 사용자로부터 참여할 사람의 이름, 실행 결과, 사다리 높이, 결과를 보고 싶은 사람을 입력받는다.

### OutputView
- 사다리와 게임의 진행 결과를 출력한다.

### LadderApplication
- 게임 전체를 진행하는 컨트롤러이다.