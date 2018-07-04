package view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.House;

public class GameScene extends Scene {

	private Button[] b;
	private Button home, exit;
	private VBox hc1,hc2,hc3,hc4,hc5,hc6,scoreHouse1,scoreHouse2, topbar1, topbar2;
	private HBox houses, players, info, navbar;
	private Label p1Label, p2Label, infoLabel, score1, score2;
	private BorderPane layout;

	/**
	 * extends Scene
	 * @param root
	 */
	public GameScene(Parent root) {
		super(root);
		b = new Button[13];
		addButtons();
		createBoard();
		setRoot(layout);
		int id = 12;
		for(int i = 1; i <=12;i++){
			b[i].setId(id+"");
			id--;
		}

	}


	/**
	 * sets message to display on infoLabel
	 *
	 * @param t takes a string
	 */
	public void setWinText(String t){
		infoLabel.setText(t);
	}


	/**
	 * sets text on Button
	 *
	 * @param index takes an integer value
	 * @param value takes an integer value
	 */
	public void setButton(int index, int value){
		b[index].setText(value+"");
	}

	/**
	 * updates buttons with new content
	 *
	 * @param index takes an integer value
	 * @param value takes an integer value
	 */
	public void updateButton(int index, int value){
		for(int i=1;i<=12;i++){

				setButton(index, value);

		}
	}



	/**
	 * adds buttons to view
	 */
	private void addButtons(){
		int id = 12;
		for(int i = 1; i <=12;i++){
			b[i] = new Button();
//			b[i].setId(id+"");
//			id--;
		}

	}

	/**
	 * returns Button object
	 * @param n takes an integer value
	 * @return Button at given position
	 */
	public Button getButton(int n){
		return b[n];
	}


	/**
	 * set the score value
	 * @param n takes an integer value
	 */
	public void setScore(int n){
		score1.setText(n+"");

	}


	/**
	 * generates a board with labels
	 */
	public void createBoard(){
		ComboBox<String> navCombo = new ComboBox<String>();
		navCombo.getItems().addAll("Home","Exit");
		navCombo.setValue("Options");
		navbar = new HBox(navCombo);


		p1Label = new Label("Player 1");
		p1Label.setPadding(new Insets(0,0,0,10));
		p1Label.setStyle("-fx-font-size: 15;");

		p2Label = new Label("Player 2");
		p2Label.setPadding(new Insets(0,0,0,618));
		p2Label.setStyle("-fx-font-size: 15;");

		players = new HBox(p1Label, p2Label);
		players.setPadding(new Insets(10,0,0,0));
		topbar1 = new VBox(navbar,players);

		b[1] = new Button("0");
		b[1].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[2] = new Button("0");
		b[2].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[3] = new Button("0");
		b[3].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[4] = new Button("0");
		b[4].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[5] = new Button("0");
		b[5].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[6] = new Button("0");
		b[6].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[7] = new Button("0");
		b[7].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[8] = new Button("0");
		b[8].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
		);

		b[9] = new Button("0");
		b[9].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
		    "-fx-border-width: 2;" +
		    "-fx-border-radius: 300;" +
		    "-fx-background-radius: 300;" +
		    "-fx-font-size: 11pt;" +
		    "-fx-text-fill: #000;"
	    );
		b[10] = new Button("0");
		b[10].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[11] = new Button("0");
		b[11].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );
		b[12] = new Button("0");
		b[12].setStyle(
			"-fx-background-color: #AD845A;" +
			"-fx-padding: 30;" +
			"-fx-border-color: #AD845A;" +
			"-fx-border-width: 2;" +
			"-fx-border-radius: 300;" +
			"-fx-background-radius: 300;" +
			"-fx-font-size: 11pt;" +
			"-fx-text-fill: #000;"
	    );

		hc1 = new VBox(b[1],b[7]);
		hc1.setSpacing(30);
		hc1.setPadding(new Insets(10));

		hc2 = new VBox(b[2],b[8]);
		hc2.setSpacing(30);
		hc2.setPadding(new Insets(10));

		hc3 = new VBox(b[3],b[9]);
		hc3.setSpacing(30);
		hc3.setPadding(new Insets(10));

		hc4 = new VBox(b[4],b[10]);
		hc4.setSpacing(30);
		hc4.setPadding(new Insets(10));

		hc5 = new VBox(b[6],b[11]);
		hc5.setSpacing(30);
		hc5.setPadding(new Insets(10));

		hc6 = new VBox(b[5],b[12]);
		hc6.setSpacing(30);
		hc6.setPadding(new Insets(10));

		houses = new HBox(hc1,hc2,hc3,hc4,hc5,hc6);

		score1 = new Label("0");
		score1.setStyle("-fx-font-size: 15");

		scoreHouse1 = new VBox(new Label("Score House:"), score1);
		scoreHouse1.setStyle("-fx-padding: 10;");

		score2 = new Label("0");
		score2.setStyle("-fx-font-size: 15");

		scoreHouse2 = new VBox(new Label("Score House:"), score2);
		scoreHouse2.setStyle("-fx-padding: 10;");

		infoLabel = new Label("Current turn: Player 1");
		infoLabel.setPadding(new Insets(0,0,0,225));
		infoLabel.setStyle("-fx-font-size: 30;");
		info = new HBox(infoLabel);


		layout = new BorderPane();
		layout.setPadding(new Insets(5));
		layout.setStyle("-fx-padding: 5;" +
	        "-fx-background-color: #DBBFA3;"
        );

		layout.setTop(topbar1);
		layout.setCenter(houses);
		layout.setLeft(scoreHouse1);
		layout.setRight(scoreHouse2);
		layout.setBottom(info);
	}

}
