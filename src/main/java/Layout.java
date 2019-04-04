import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Layout {
    static Text textLeft;
    static Text textRght;
    static TextArea textAreaOut;
    static TextArea textAreaIn;
    static Button button;


    public static void createLayout(Stage primaryStage) {
        textLeft = new Text("История сообщений" );
        textLeft.setFill(Color.DARKBLUE);
        textLeft.setFont(Font.font(15)); // размер шрифта

        textRght = new Text("Поле ввода" );
        textRght.setFill(Color.DARKBLUE);
        textRght.setFont(Font.font(15)); // размер шрифта

        textAreaOut = new TextArea(); // поле вывода
        textAreaOut.setMaxWidth(400);
        textAreaOut.setPrefRowCount(30); // высота (в строках)
        textAreaOut.setWrapText(true); // установить перенос текста
        textAreaOut.setEditable(false); // запрет на ввод (поле вывода)

        textAreaIn = new TextArea(); // поле ввода
        textAreaIn.setMaxWidth(400);
        textAreaIn.setPrefRowCount(10); // высота (в строках)
        textAreaIn.setWrapText(true); // установить перенос текста

        button = new Button("Отправить"); // кнопка отправки

        VBox vBoxLeft = new VBox(10, textLeft, textAreaOut); // левый бокс
        VBox vBoxRight = new VBox(10, textRght, textAreaIn); // правый бокс
        VBox vBoxRight2 = new VBox(10, button); // правый бокс 2
        vBoxRight2.setAlignment(Pos.TOP_RIGHT);
        VBox vBoxRightAll = new VBox(10, vBoxRight, vBoxRight2); // правый бокс общий

        HBox hBox = new HBox(10, vBoxLeft, vBoxRightAll); // горизонтальный бокс объединяющий левый и правый
        hBox.setMargin(vBoxLeft, new Insets(10,0,5,10));
        hBox.setMargin(vBoxRightAll, new Insets(10,5,5,0));

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setResizable(false); // запрет на изменение размера окна
        root.getChildren().addAll(hBox); // Добавление на сцену Контейнер с элементами
        primaryStage.setTitle("Файловый чат 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
