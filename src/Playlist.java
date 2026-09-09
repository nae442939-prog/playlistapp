import java.util.ArrayList;
import java.util.List;
//데이터 다루는 객체 
public class Playlist {
   
    //곡 목록 데이터
    private List<String> songs = new ArrayList<>(); //빈상태

    public Playlist() {
        //샘플 곡 추가
       
        addSong("Lately - Stevie Wonder");
        addSong("Ordinary People - John Legend");
        addSong("Man In The Mirror - Michael Jackson");
         
    }
    
    //모든 노래가져오기
    public List<String> getAllSongs () {
        return songs;
    }
   
    //입력받은 번호에 맞는 곡 가져오기
    public String getSongByNumber(int number) {
        //번호로 부터 인덱스를 구함
        int index = number -1; //인덱스가 0 부터 시작하기에 1을 빼줌
        if (index  < 0 || index >= songs.size()) { //인덱스 범위가 올바른지 검사  
            throw new IllegalArgumentException("곡을 찾을 수 없습니다");
        }
        return songs.get(index); //실제로 곡에 접근
        // get(인덱스) : 인덱스에 해당하는 요소를 반환

         }

         //노래 추가
         public void addSong(String song){  //song :새로 추가할 노래
            if (song.trim().length() < 3) { //노래 제목이 너무 짧음 
                //trim() : 문자열에서 앞/뒤 있는 공백 제거
                throw new IllegalArgumentException("올바른 제목을 입력하세요");
            }
                songs.add(song);  //리스트에 곡을 추 가

            }
    
            //노래 제거하기
        public void removeSong (int number) { //number: 제거할 노래의 번호
            //번호를 인덱스로 변환하는 과정
            int index = number -1;
            if (index < 0 || index >= songs.size()) { //잘못된 번호를 입력한 경우
                throw new IllegalArgumentException("곡을 찾을 수 없습니다");
            }
             songs.remove(index); //리스트에서 곡을 제거합니다
        }
   }
    

