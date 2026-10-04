import java.util.Scanner;

public class Code71 {

    public static void printDan(int dan){
        for(int num = 1; num <= 9; num++){
            System.out.println(dan + "*" + num + "=" + dan*num);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int scdan = 0;

        while(true){
            System.out.println("출력하고 싶은 단의 숫자를 입력해주시오 (0~9)");

            if(sc.hasNextInt()){ // 확인만 하는 코드이기에 정수를 입력받는 sc.nextInt는 안에다가 둬야 된다
                scdan = sc.nextInt();
                if(scdan > 0 && scdan < 10){
                    printDan(scdan);
                    break;   
                }else{
                    System.out.println("1부터 9사이의 정수를 입력해주세요");
                }  
            }else{
                System.out.println("숫자만 입력 가능합니다");
                sc.nextLine();
            }
        }
    }
}


/*
Getter (get으로 시작하는 메서드): 숨겨둔 변수 값을 읽어올 때 사용
Setter (set으로 시작하는 메서드): 숨겨둔 변수 값을 안전하게 변경할 때 사용

언제 / 왜 써야 하는가? (사용 공식)
private + Getter / Setter

언제 쓰나요?
클래스에 변수(필드)를 만들 때 99% 무조건 사용한다

왜 쓰나요?
실수로 이상한 값이 들어가는 걸 막는 "안전장치"이다

어떻게 써야 하나요? (공식)
변수는 일단 무조건 앞에 private을 붙인다
그 변수 값을 가져다 쓰고 싶으면 get변수명()을 만든다
그 변수 값을 바꾸고 싶으면 set변수명(값)을 만든다

*/
