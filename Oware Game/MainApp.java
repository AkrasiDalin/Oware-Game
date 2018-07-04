import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import model.Board;
import model.Player;
import model.ScoreHouse;
import view.GameScene;


public class MainApp extends Application{
	static GameScene gs;

	public MainApp(){}

	@Override
	public void start(Stage primaryStage) throws Exception {
		gs = new GameScene(new Group());
		primaryStage.setScene(gs);
		primaryStage.setTitle("Oware");

		ScoreHouse sc1 = new ScoreHouse();
		ScoreHouse sc2 = new ScoreHouse();

		Board b = new Board(12, sc1, sc2);

		Player p = new Player("Luigi", b.getScoreHouse1());
		Player p2 = new Player("Li", b.getScoreHouse2());

		Controller co = new Controller(b, p,p2, gs);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}




}
