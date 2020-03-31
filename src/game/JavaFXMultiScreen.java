package game;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class JavaFXMultiScreen extends Application {



	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Javenture");

		GridPane grid = new GridPane();
		ColumnConstraints column1 = new ColumnConstraints(100);
		ColumnConstraints column2 = new ColumnConstraints(200);
		ColumnConstraints column3 = new ColumnConstraints(100);
		grid.getColumnConstraints().addAll(column1, column2, column3);
		RowConstraints row1 = new RowConstraints(100);
		RowConstraints row2 = new RowConstraints(100);
		RowConstraints row3 = new RowConstraints(100);
		grid.getRowConstraints().addAll(row1, row2, row3);

		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid);

		Button north = new Button("North");
		Button east = new Button("East");
		Button south = new Button("South");
		Button west = new Button("West");

		grid.add(north, 1, 0);
		grid.add(east, 2, 1);
		grid.add(south, 1, 2);
		grid.add(west, 0, 1);
		grid.add(new Label("Hello"), 1, 1);


		Button start = new Button("Start");
		start.setOnAction(event -> {
			primaryStage.setScene(scene);
		});
		
		GridPane firstGrid = new GridPane();
		firstGrid.add(new Label("Welcome to the Game"), 0, 0);
		firstGrid.add(start, 0, 1);
		Scene firstScene = new Scene(firstGrid);
		
		primaryStage.setScene(firstScene);
		primaryStage.show();		
	}

	public static void main(String[] args) {

		launch(args);
	}
}
