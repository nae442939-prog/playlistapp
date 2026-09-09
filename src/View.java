import java.util.List;

public class View {

    public View() {}

    public void showList(List<String> songs) {

        System.out.println();
        System.out.println("나의 플레이리스트");
        System.out.println("-------------------------");
        if (songs.size() < 1) {
            System.out.println("새 곡을 추가해보세요");
        } else {
            for (int i = 0; i < songs.size(); i++) {
                System.out.println((i + 1) + ". " + songs.get(i));
            }
        }

        System.out.println("--------------------------");
        System.out.println("|추가: add 노래|삭제: drop 번호|재생: play 번호|종료: end|");
    }

    public void showMusic(String song) {

        System.out.println();
        System.out.println("나의 플레이리스트");
        System.out.println("--------------------------");
        System.out.println(song);
        System.out.println("--------------------------");
        System.out.println("|돌아가기: list|종료: end|");
    }
}
