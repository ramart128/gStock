package com.rmzb.gstock.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public final class GUILoader extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginGui loginGui = new LoginGui(primaryStage);
		loginGui.show();
	}

}
