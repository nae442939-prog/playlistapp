import java.util.Scanner;
//명령어 처리기 - 명령어를 분석라고 컨트롤러의 로직과 연결 해줌
public class CommandHandler {
    
    //컨트롤러
    private Controller controller;
    private Scanner scanner; //입력 처리

    public CommandHandler(Controller controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void run () {

        //최초로 화면 보여주기 (앱을 처음 켰을때)
        controller.listSongs();

        //앱을 종료할 때 까지 무한히 반복
        while (true) {
            //사용자 입력란을 출력 (playlist)
            System.out.println("plist> ");
            //사용자 입력을 문자열(next Line)로 저장
            String userInput = scanner.nextLine().trim(); //trim: 문자열 앞/뒤 공백제거
            //사용자 입력을 띄어쓰기를 기준을 2 부분으로 나눕니다
            //limit:띄어쓰기를 기준으로 나누는 갯수를 저장
            //예) add foo - bar -> [add, foo-bar] 
            String[] parsedInput = userInput.split(" ",2); //parse (분석하다)
            //명령 (add, drop 등)
            String command = parsedInput[0];
            //명령어와 함께 입력된 인자 (arguments)
            String arg = parsedInput.length >1 ? parsedInput[1] : "";
            //parsedInput.length > 1 =명령어와 함께 입력된 인자가 있다
            //인자가 있으면 그 인자를 쓰고 없으면 빈 문자열을 저장해라

            //명령어와 그 명령어에 적합한 로직을 호출
            try {
                switch (command) { //command:사용자가 입력한 명령어
                    case "list":
                        controller.listSongs();
                        break;
                    case "play": //Integer.parseInt (문자열 숫자):문자열 숫자를 정수형으로 반환 
                    controller.playSong(Integer.parseInt(arg)); //arg: 재생할 곡의 번호 (문자열 상태)
                        break; //"1" (문자열 ) -> 1 (정수형)
                    case "add":
                    controller.addNewSong(arg); //arg: 노래 제목
                        break;
                    case "drop":
                    controller.dropSong(Integer.parseInt(arg)); //arg: 삭제할 곡의 번호 (문자열 상태)
                        break; //switch의 break (while 의 break가 아님) 
                    case "end":
                      System.out.println("앱을 종료합니다");
                      return; //run()을 빠져나옵니다
                      default://위에 있는 명령어가 아닌 경우 
                        System.out.println("잘못된 명령어");
                }
            }catch (Exception e) { //예외 처리 - 모든 객체가 던지는 예외를 처리한다
                System.out.println("오류: " + e.getMessage());
            }
        
        }
    }
}
