class Card {
    // 1. 필드(변수) 캡슐화: private 적용
    private String type;
    private String color;
    private int cvc;

    // 2. 생성자 1 (매개변수 3개)
    public Card(String type, String color, int cvc) {
        this.type = type;
        this.color = color;
        setCvc(cvc); // CVC 검증 로직을 거치도록 Setter 활용
    }

    // 3. 생성자 2 (매개변수 2개만 들어오면 CVC는 0으로 기본 지정) - this() 사용
    public Card(String type, String color) {
        this(type, color, 0); // 생성자 1을 재호출
    }

    // --- Getter / Setter 메서드 ---
    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getCvc() {
        return cvc;
    }

    // Setter에서 유효성 검사 진행
    public void setCvc(int cvc) {
        if (cvc >= 100 && cvc <= 999) {
            this.cvc = cvc;
        } else {
            System.out.println("경고: CVC는 3자리 정수여야 합니다.");
        }
    }

    // 카드 정보 출력용 메서드
    public void printCardInfo() {
        System.out.println("[ 카드 타입: " + type + " | 카드 색상: " + color + " | CVC: " + cvc + " ]");
    }

    // 테스트용 main 메서드
    public static void main(String[] args) {
        // 생성자 1 사용 (정상 작동)
        Card c1 = new Card("credit", "orange", 456);
        c1.printCardInfo();

        // 생성자 2 사용 (CVC 미입력 시 0으로 설정)
        Card c2 = new Card("check", "blue");
        c2.printCardInfo();

        // Setter를 통한 CVC 변경 시도 (유효하지 않은 값)
        c2.setCvc(99); // 경고문 출력

        // Setter를 통한 CVC 정상 변경
        c2.setCvc(789);
        c2.printCardInfo();
    }
}

/* 
변수를 private으로 선언하면 다른 곳에서 그 변수에 직접 접근하는 것이 완전히 금지된다 private int cvc; 라고 적는 순간 외부에서는 c.cvc처럼 직접 꺼내보거나 바꿀 수 없게 된다그래서 외부와 통신할 수 있는 문(Door)을 열어줘야 하는데 
그 문이 바로 get과 set이다

get (Getter) : 내부 값을 외부로 읽어다 전달해주는 역할	
set (Setter) : 외부에서 보낸 값을 검사해서 내부에 저장하는 역할

굳이 귀찮게 이런 방법을 쓰는 이유는 setcvc가 없다면 
Card c = new Card();
c.cvc = -99999; 
이런 말도 안되는 숫자가 저장이 된다 
자바는 이런 엉터리 데이터가 들어오는 걸 가장 싫어한다 반면 setCvc라는 통로를 만들어 두면 통로 안에서 검사를 진행할 수 있다

한마디로 set 메서드는 잘못된 입력이 들어오는 걸 막아주는 '문지기' 역할을 하기 위해 쓴다

get은 
만약 get메서드가 없다면 출력은 되지만 비교가 안된다 

get이라는 매서드가 있으면 789라는 숫자 데이터만 밖으로 꺼내서 변수에 담거나 비교문에 써먹을 수 있는 상태가 된다

만약 없다면 출력(print)만 될뿐 789라는 값은 분명히 저장되었는데 필요할 때 꺼내서 쓸 수가 없는 상태가 된다
비교, 변수에 담는 행위가 안되는 상태가 된다



한 줄 정리
set은 데이터를 상자 안에 '저장'하는 것이고 get은 저장된 데이터를 상자 밖으로 '꺼내오는' 것이다 

*/