module Uppgift2Objektivering {
	requires javafx.controls;
	requires json.simple;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
