import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Главный класс, который запускает окно
 * */

public class Main extends Application {
    public static void main(String[] args) {
        new Thread(new FilesWatcher()).start();
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Layout.createLayout(primaryStage); // создание формы
        Event.eventMonitoring(); // мониторинг событий
    }
}
