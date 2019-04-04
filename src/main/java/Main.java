import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Главный класс, который запускает окно
 * */

public class Main extends Application {
    public static void main(String[] args) {
        Thread t = new Thread(new FilesWatcher(args[1]));
        t.setDaemon(true);
        t.start();
        Event.absolutePathOut = args[0];
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Layout.createLayout(primaryStage); // создание формы
        Event.eventMonitoring(primaryStage); // мониторинг событий
    }
}
