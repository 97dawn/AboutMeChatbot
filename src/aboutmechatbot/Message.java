/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboutmechatbot;

import javafx.scene.control.Label;

/**
 *
 * @author Doeun Kim
 */
public class Message{
    
    Label label;
    public Message(String text){
        label=new Label(text);
    }
    
    public Label getPCMessage(double x, double y){
        label.setStyle("-fx-background-color :  #d1f1b5");
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setWrapText(true);
        return label;
    }
    
    public Label getUserMessage(double x, double y){
        label.setStyle("-fx-background-color :  #b3ffff");
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setWrapText(true);
        return label;
    }
}
