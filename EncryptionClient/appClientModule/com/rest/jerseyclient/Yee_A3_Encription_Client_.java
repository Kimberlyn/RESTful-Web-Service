package com.rest.jerseyclient;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Yee_A3_Encription_Client_ extends Application {
    TextField textField,resultField;
    Label text, clicked,messageEnteredL,resultL;
    Button button, clickButton,buttonEncrypt,buttonDecrypt;
    BorderPane BPane;
    String retrievedText = null;
    HBox buttonBox;
    VBox textFieldsHolder;
    private boolean _clickMeMode = true;

    @Override
    public void start (Stage primaryStage) { 
    //Create GridPane
    BPane = new BorderPane();
    BPane.setId("grid-pane");
    //BPane.getStyleClass().add("pane-styles");
    
    //Create Scene and add Grid
    Scene scene = new Scene(BPane, 275, 275);
   // scene.getStylesheets().add(this.getClass().getResource("./restexample.css").toExternalForm());
    //Create the stage and add the scene
    primaryStage.setTitle("FileIO Application");
    primaryStage.setScene(scene);

    text = new Label("Enter String to Send to Server");
    textField = new TextField("Enter message to encrypt/decrypt");
    textField.setMaxWidth(200);
    resultField=new TextField();
    resultField.setMaxWidth(200);
    messageEnteredL=new Label("Message entered");
    resultL=new Label("Results: ");
    textFieldsHolder=new VBox(10,messageEnteredL,textField,resultL,resultField);
    textFieldsHolder.setPadding(new Insets(10));
    
    button = new Button("Click Me"); 
    buttonEncrypt=new Button("Encrypt");
    buttonDecrypt=new Button("Decrypt");
    buttonBox=new HBox(10,buttonEncrypt,buttonDecrypt);
    
    
    buttonEncrypt.setOnAction(event->
    {
    	
    	retrievedText=textField.getText();
    	String sendToServer="encrypt,";
    	sendToServer+=retrievedText;
        textField.setText("");
        Yee_Encript encriptor=new Yee_Encript();
        String result=encriptor.getTbstoCupsResponse(sendToServer);
        resultField.setText(""+result);
      
    	
    	
    	
    });
    buttonDecrypt.setOnAction(event->
    {
    	retrievedText=textField.getText();
    	String sendToServer="decrypt,";
    	sendToServer+=retrievedText;
        textField.setText("");
        Yee_Encript encriptor=new Yee_Encript();
        String result=encriptor.getTbstoCupsResponse(sendToServer);
        resultField.setText(""+result);
    	
    	
    	
    });
//    button.setOnAction(new EventHandler<ActionEvent>() {
//
//    @Override
//    public void handle(ActionEvent event) {
//      if (_clickMeMode) {        
//        retrievedText = textField.getText();                    
//        //Clear text field
//        textField.setText("");
//        //Calculate number of cups
//        Yee_Encript cupsCalc = new Yee_Encript();                
//          try {
//            String calculatedCups = cupsCalc.getTbstoCupsResponse(retrievedText);
//            
//               text.setText("" + calculatedCups);
//            
//          } catch (Exception e) {
//            text.setText("Client: Click Again and enter a number");
//          }
//          BPane.getChildren().remove(textField);
//          button.setText("Click Again");
//          _clickMeMode = false;
//      } else {
//        text.setText("Enter tbs to convert to cups:");
//        BPane.getChildren().add(textField);
//        textField.setText("");
//        button.setText("Click Me");
//        _clickMeMode = true;
//      }
//    }
//  });

  //Set positions for each control in the BorderPane
  BPane.setTop(text); 
  BPane.setCenter(textFieldsHolder);
  BPane.setBottom(buttonBox);
           
  //Show the scene
  primaryStage.show(); 
} 
    
  //main method
  public static void main(String[] args){
    launch(args);
  }
}