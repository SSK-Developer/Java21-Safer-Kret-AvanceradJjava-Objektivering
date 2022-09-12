package application;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class Main extends Application {
	public static ParserHelper p = new ParserHelper();
	public static TableView<RowReaderBean> tbv = new TableView();

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		p.CSVmode();
		p.JSONmode();

		TableColumn<RowReaderBean, String> r1 = new TableColumn<>("OrderDate");
		r1.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

		TableColumn<RowReaderBean, String> r2 = new TableColumn<>("Region");
		r2.setCellValueFactory(new PropertyValueFactory<>("Region"));

		TableColumn<RowReaderBean, String> r3 = new TableColumn<>("Rep1");
		r3.setCellValueFactory(new PropertyValueFactory<>("Rep1"));

		TableColumn<RowReaderBean, String> r4 = new TableColumn<>("Rep2");
		r4.setCellValueFactory(new PropertyValueFactory<>("Rep2"));

		TableColumn<RowReaderBean, String> r5 = new TableColumn<>("Item");
		r5.setCellValueFactory(new PropertyValueFactory<>("Item"));

		TableColumn<RowReaderBean, String> r6 = new TableColumn<>("Units");
		r6.setCellValueFactory(new PropertyValueFactory<>("Units"));

		TableColumn<RowReaderBean, String> r7 = new TableColumn<>("UnitCost");
		r7.setCellValueFactory(new PropertyValueFactory<>("UnitCost"));

		TableColumn<RowReaderBean, String> r8 = new TableColumn<>("Total");
		r8.setCellValueFactory(new PropertyValueFactory<>("Total"));
		tbv.getColumns().addAll(r1, r2, r3, r4, r5, r6, r7, r8);

		Button jsonBtn = new Button("Display JSON");
		Button csvBtn = new Button("Display CSV");
		Button resetBtn = new Button("RESET");

		jsonBtn.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				@SuppressWarnings("static-access")
				ObservableList<RowReaderBean> data = FXCollections.observableArrayList(p.JSONrows);
				tbv.setItems(data);

			}
		});

		csvBtn.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				@SuppressWarnings("static-access")
				ObservableList<RowReaderBean> data = FXCollections.observableArrayList(p.CSVrows);
				tbv.setItems(data);

			}
		});

		resetBtn.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				@SuppressWarnings("static-access")
				ObservableList<RowReaderBean> data = FXCollections.observableArrayList();
				tbv.setItems(data);

			}
		});

		VBox vbox = new VBox();
		vbox.getChildren().add(tbv);
		vbox.getChildren().addAll(jsonBtn, csvBtn, resetBtn);
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
