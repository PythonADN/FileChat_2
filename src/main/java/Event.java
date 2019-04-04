import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class Event {
    public static void eventMonitoring() {
        // событие нажатия на кнопку
        Layout.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                String str = Layout.textAreaIn.getText(); // читаем с поля ввода

                // записываем в файл
                String fileName = LocalDateTime.now().toString().replaceAll("[\\:,\\.]", "_");
                Path path = Paths.get("C:\\Users\\ADN\\IdeaProjects\\FileChat_2\\src\\main\\out_2\\"+fileName);

                if (!Files.exists(path)) {
                    try {
                        Files.createFile(path);
                        Files.write(path, str.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Layout.textAreaOut.appendText("in:   "+str+"\n"); // записываем в поле вывода наш текст
                Layout.textAreaIn.setText(""); // очищаем форму
            }
        });



    }
}
