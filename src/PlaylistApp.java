import java.util.Scanner;

public class PlaylistApp {
    public static void main(String[] args) {
        
        //Controller
        Playlist playlist = new Playlist();
        View view = new View();
        Controller controller = new Controller(playlist, view);

        //Command Handler
        Scanner scanner = new Scanner(System.in);
         CommandHandler commandHandler = new CommandHandler(controller, scanner);

         commandHandler.run();
         scanner.close();
    }    
}   

