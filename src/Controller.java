import java.util.List;

public class Controller {
    
    //playlist , View 호출
    private Playlist playlist;
    private View view;

    //의존성 주입
    public Controller (Playlist playlist, View view) {
        this.playlist = playlist;
        this.view = view;
    }
     //곡 목록 처리
    public void listSongs () {
        //playlist 로부터 곡 목록을 가져온다
        List<String> songs = playlist.getAllSongs();
        //뷰에게 곡 목록 전달
        view.showList(songs);
    }

    public void playSong(int number) { //number : 전달 받은 곡의 번호
        //번호로부터 곡을 가져옵니다
        String song = playlist.getSongByNumber(number);
        //가져온 곡을 뷰에게 전달
        view.showMusic(song);
    }
//곡 추가 처리
    public void addNewSong (String song) { //song: 추가할 노래
        //곡을 리스트에 추가
        playlist.addSong(song);
        //리스트를 가져옵니다 (새곡이 저장된 상태)
        List<String> songs = playlist.getAllSongs();
        view.showList(songs);
    }
//곡 상제 담당
    public void dropSong(int number) { //삭제할 곡의 번호
        //곡 리스트에서 벊호에 해당하는 곡 삭제
        playlist.removeSong(number);
        //갱신된 리스트
        List<String> songs = playlist.getAllSongs();
        //갱신된 리스트를 뷰에게 전달
        view.showList(songs);
    }
}


