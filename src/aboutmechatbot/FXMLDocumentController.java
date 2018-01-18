/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboutmechatbot;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {

    private HashMap<String, String[]> celebrities;
    private HashMap<String, Label> history;
    private String[] info ;
    @FXML
    private ScrollPane scroll;
    @FXML
    private JFXTextArea message;
    private Pane pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane=new Pane();
        // SET CELEBRITIES' DATA
        Data data = new Data();
        celebrities = data.getCelebritiesData();
        // ADD MESSAGE HISTORY
        history = new HashMap<>();
        scroll.setContent(pane);
        Message m = new Message("Welcome. Which Korean celebrity \ndo you want to know? \n(format: FirstName LastName )");
        Label greet = m.getPCMessage(0, 0);
        pane.getChildren().add(greet);
        history.put("PC:GREET", greet);
    }
    
    @FXML
    public void handleButtonAction(ActionEvent event) {
        FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
        if(history.keySet().toArray()[history.size()-1].equals("PC:GREET")){
            String name = message.getText();
            // UPLOAD USER'S MESSAGE
            Message m = new Message(name);
            Label prevLabel = history.get("PC:GREET");
            Label currentLabel = m.getUserMessage(scroll.getPrefWidth() -fontLoader.computeStringWidth(name, prevLabel.getFont())-10 , prevLabel.getHeight()+10);
            pane.getChildren().add(currentLabel);
            handleName(name);
        }
    }
    
    private void handleName(String name){
        Label pc = new Label();
        if (name.equals("")) {
            System.out.println("Please write a message");
        } 
        else {
            if (name.contains("Jihyun Jeon") || name.contains("Jihyun Jun") || name.contains("Jihyeon Jeon") || name.contains("jihyun jeon") || name.contains("jihyun jun") || name.contains("jihyeon jeon")) {
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Jihyun Jeon");
            } 
            else if(name.contains("Minho Lee") || name.contains("minho lee")){
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Minho Lee");
            }
            else if(name.contains("Jisung") || name.contains("jisung")){
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Taegeun Kwak");
            }
            else if(name.contains("Boyoung") || name.contains("boyoung")){
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Boyoung Lee");
            }
            else if(name.contains("jico") || name.contains("Zico") || name.contains("Jico") || name.contains("jiko") || name.contains("Ziko") || name.contains("Jiko")||name.contains("zico") || name.contains("ziko")){
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Jiho Woo");
            }
            else if(name.contains("dragon") || name.contains("gd") || name.contains("GD")||name.contains("Dragon")){
               history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Jiyong Kwon");
            }
            else if(name.contains("sunmi") || name.contains("Sunmi") || name.contains("Seonmi")||name.contains("seonmi")){
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Sunmi Lee");
            }
            else if(name.contains("taeyeon") || name.contains("Taeyeon")){
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Taeyeon Kim");
            }
            else if(name.contains("yonghwa") || name.contains("Yonghwa")){
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Yonghwa Jung");
            }
            else if(name.contains("Dujun") || name.contains("Doojoon") || name.contains("Dujoon")||name.contains("Doojun") || name.contains("dujun") || name.contains("doojoon")||name.contains("dujoon") || name.contains("doojun")){
                history.put("USER:CELEBRITY_NAME", pc);
                info = celebrities.get("Dujun Yoon");
            }            
            else {
                System.out.println("I don't know. Please write a name again");
            }
        }
        // THERE IS A CELEBRITY IN DATA
        if(info != null){
            message.setText("");
            PCShowInfo(info);
        }
    }
    private void PCShowInfo(String[] info){
        Label pc = new Label();
        for(int i = 0 ; i < info.length; i++){
            
        }
    }
    
}
