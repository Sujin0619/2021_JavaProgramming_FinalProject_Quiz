# Java Programming - GUI를 이용한 Quiz Game 구현

## 1. Start Page
### Main.java를 실행하면 첫 페이지가 나온다. username을 입력하고 category를 선택한 후, 시작 버튼을 누르면 퀴즈가 시작된다. 이때 게임 유저가 입력한 정보는 Quiz.txt 파일에 입력된다. 디자인의 경우, 배경을 따로 만들어서 패널에 넣었으며 그 위에 투명 TextField와 ComboBox, Button을 넣었다. 


### 만약 username을 입력하지 않거나, category를 선택하지 않는다면 오류 메시지가 뜬다.


## 2. Game Page
### 실제 게임이 진행되는 페이지다. 각 카테고리는 10문제로 구성된다. 사각형의 보기 번호를 눌렀을 때, 정답이라면 총점은 +10이 되고 틀리면 -10이 된다. 만약 0점 미만이 된다면 바로 게임은 끝난다. 실제 정답이 어떤 것인지 표시하기 위해 게임 유저가 정답을 고르는 순간, 실제 정답 보기는 빨간색으로 표시된다. 이때 게임 유저의 게임 진행 상황은 모두 Quiz.txt 파일에 입력된다.

## 3. End Page
### 점수가 0점 미만이라면, End Page로 이동한다. 여기서 Start 버튼을 누르면 Strart Page로 이동하고, Exit 버튼을 누르면 창이 꺼진다.


## 4. Final Page
### 죽지 않고 마지막 10단계까지 왔다면, 다음 페이지는 Final Page가 된다. 'Check Your Score!' 버튼을 누르면, TextArea에는 각 단계에서의 점수가 출력되며 콘솔에는 각 단계에서의 총점이 출력된다. 또한, '3. End Page'에서와 마찬가지로 Start 버튼을 누르면 Strart Page로 이동하고, Exit 버튼을 누르면 창이 꺼진다.





