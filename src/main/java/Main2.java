import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Main2 extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane rootNode = new BorderPane();
        rootNode.setMinSize(300, 300);
        rootNode.setStyle("-fx-background-color: RED;");
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: BLUE;");
        rootNode.setCenter(gridPane);

        int counter = 1;
        for (int row = 3; row > 0; row--)
            for (int col = 0; col < 3; col++) {
                Button button = new Button("" + counter++);
                gridPane.add(button, col, row);
                GridPane.setHgrow(button, Priority.ALWAYS);
            }
        Button r = new Button("R");
        gridPane.add(r, 0, 4);
        GridPane.setHgrow(r, Priority.ALWAYS);
        Button r0 = new Button("0");
        gridPane.add(r0, 1, 4);
        GridPane.setHgrow(r0, Priority.ALWAYS);
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}