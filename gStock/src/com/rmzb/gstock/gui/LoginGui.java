package com.rmzb.gstock.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public final class LoginGui {

	/**
	 * 
	 */
	private Stage stage;

	/**
	 * 
	 */
	private Scene scene;

	/**
	 * 
	 * @param primaryStage
	 */
	public LoginGui(Stage primaryStage) {
		this.stage = primaryStage;
		initScene();
		initStage();
	}

	/**
	 * 
	 */
	public void show() {
		this.stage.show();
	}
	
	/**
	 * 
	 */
	private void initScene() {
		AnchorPane aPane = new AnchorPane();
		aPane.setPrefWidth(500);
		aPane.setPrefHeight(280);
		
		TitledPane titledPane = new TitledPane();
		titledPane.setText("Folders");
		titledPane.setAnimated(false);
		titledPane.setCollapsible(false);
		titledPane.setPrefWidth(362);
		titledPane.setPrefHeight(270);
		titledPane.setLayoutX(10);
		titledPane.setLayoutY(10);
		
		Label usernameLabel = new Label("Nom d'utilisateur");
		usernameLabel.setLayoutX(380);
		usernameLabel.setLayoutY(14);
		
		TextField usernameTextField = new TextField();
		usernameTextField.setPrefHeight(25);
		usernameTextField.setPrefWidth(124);
		usernameTextField.setLayoutX(380);
		usernameTextField.setLayoutY(33);

		aPane.getChildren().add(usernameLabel);
		aPane.getChildren().add(usernameTextField);
		
		Label passwordLabel = new Label("Mot de passe");
		passwordLabel.setLayoutX(382);
		passwordLabel.setLayoutY(60);

		PasswordField passwordField = new PasswordField();
		passwordField.setPrefHeight(25);
		passwordField.setPrefWidth(124);
		passwordField.setLayoutX(380);
		passwordField.setLayoutY(80);

		aPane.getChildren().add(passwordLabel);
		aPane.getChildren().add(passwordField);
		
		Button loginButton = new Button("Login");
		loginButton.setPrefHeight(25);
		loginButton.setPrefWidth(124);
		loginButton.setLayoutX(380);
		loginButton.setLayoutY(112);
		
		aPane.getChildren().add(loginButton);
		
		Button newDossierButton = new Button("New Folder ");
		newDossierButton.setPrefHeight(25);
		newDossierButton.setPrefWidth(124);
		newDossierButton.setLayoutX(380);
		newDossierButton.setLayoutY(194);
		
		Button openFolderButton = new Button("Open Folder ");
		openFolderButton.setPrefHeight(25);
		openFolderButton.setPrefWidth(124);
		openFolderButton.setLayoutX(380);
		openFolderButton.setLayoutY(224);
		
		Button exitApplicationButton = new Button("Exit");
		exitApplicationButton.setPrefHeight(25);
		exitApplicationButton.setPrefWidth(124);
		exitApplicationButton.setLayoutX(380);
		exitApplicationButton.setLayoutY(254);
		
		aPane.getChildren().add(newDossierButton);
		aPane.getChildren().add(openFolderButton);
		aPane.getChildren().add(exitApplicationButton);
		
		aPane.getChildren().add(titledPane);
		scene = new Scene(aPane);
	}

	/**
	 * 
	 */
	private void initStage() {
		stage.setTitle("Login : gStock");
		stage.centerOnScreen();
		stage.setScene(scene);
		stage.setResizable(false);
	}

}
