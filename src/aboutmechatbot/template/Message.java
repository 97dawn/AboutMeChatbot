/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboutmechatbot.template;

import javafx.scene.control.Label;

/**
 * @version 1.0
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
        label.setMaxHeight(Double.MAX_VALUE);
        return label;
    }
    
    public Label getUserMessage(double x, double y){
        label.setStyle("-fx-background-color :  #b3ffff");
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setWrapText(true);
        label.setMaxHeight(Double.MAX_VALUE);
        return label;
    }
}
