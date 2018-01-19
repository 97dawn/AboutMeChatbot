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
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author Doeun Kim
 */
public class FXMLDocumentController implements Initializable {

    private HashMap<String, String[]> celebrities;
    private ArrayList<Label> labels;
    private ArrayList<String> history;
    private String[] info;
    @FXML
    private ScrollPane scroll;
    @FXML
    private JFXTextArea message;
    @FXML
    private JFXButton send;
    private Pane pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane = new Pane();
        history = new ArrayList<>();
        // SET CELEBRITIES' DATA
        Data data = new Data();
        celebrities = data.getCelebritiesData();
        // ADD MESSAGE HISTORY
        labels = new ArrayList<>();
        scroll.setContent(pane);
        Message m = new Message("Welcome. Which Korean celebrity \ndo you want to know? \n( format: FirstName LastName )");
        Label greet = m.getPCMessage(0, 0);
        pane.getChildren().add(greet);
        labels.add(greet);
        history.add("GREET");
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
        Label prevLabel = (Label) labels.get(labels.size() - 1);
        if (history.get(history.size() - 1).equals("GREET") || history.get(history.size() - 1).equals("REWRITE")) {
            String name = message.getText();
            // UPLOAD USER'S MESSAGE
            Message m = new Message(name+"  ");
            Label currentLabel = m.getUserMessage(0, prevLabel.getLayoutY() + prevLabel.getHeight() +10);
            pane.getChildren().add(currentLabel);
            labels.add(currentLabel);
            history.add("CELEB_NAME");
            handleName(name);
        } else if (history.get(history.size() - 1).equals("ASK_SNS")) {
            String yn = message.getText();
            // UPLOAD USER'S MESSAGE
            Message m = new Message(yn );
            Label currentLabel = m.getUserMessage(0, prevLabel.getLayoutY() +20);
            pane.getChildren().add(currentLabel);
            labels.add(currentLabel);
            history.add("ANSWER_YN");
            handleAnswerYNForSNS(yn);
        }
    }

    private void handleName(String name) {
        Label prevLabel = (Label) labels.get(labels.size() - 1);
        message.setText("");
        if (name.equals("")) {
            Message m = new Message("Please write a message");
            Label pc = m.getPCMessage(0, prevLabel.getLayoutY() +20);
            pane.getChildren().add(pc);
            labels.add(pc);
            history.add("REWRITE");
        } else {
            if (name.contains("Jihyun Jeon") || name.contains("Jihyun Jun") || name.contains("Jihyeon Jeon") || name.contains("jihyun jeon") || name.contains("jihyun jun") || name.contains("jihyeon jeon")) {
                info = celebrities.get("Jihyun Jeon");
            } else if (name.contains("Minho Lee") || name.contains("minho lee")) {
                info = celebrities.get("Minho Lee");
            } else if (name.contains("Jisung") || name.contains("jisung")) {
                info = celebrities.get("Taegeun Kwak");
            } else if (name.contains("Boyoung") || name.contains("boyoung")) {
                info = celebrities.get("Boyoung Lee");
            } else if (name.contains("jico") || name.contains("Zico") || name.contains("Jico") || name.contains("jiko") || name.contains("Ziko") || name.contains("Jiko") || name.contains("zico") || name.contains("ziko")) {
                info = celebrities.get("Jiho Woo");
            } else if (name.contains("dragon") || name.contains("gd") || name.contains("GD") || name.contains("Dragon")) {
                info = celebrities.get("Jiyong Kwon");
            } else if (name.contains("sunmi") || name.contains("Sunmi") || name.contains("Seonmi") || name.contains("seonmi")) {
                info = celebrities.get("Sunmi Lee");
            } else if (name.contains("taeyeon") || name.contains("Taeyeon")) {
                info = celebrities.get("Taeyeon Kim");
            } else if (name.contains("yonghwa") || name.contains("Yonghwa")) {
                info = celebrities.get("Yonghwa Jung");
            } else if (name.contains("Dujun") || name.contains("Doojoon") || name.contains("Dujoon") || name.contains("Doojun") || name.contains("dujun") || name.contains("doojoon") || name.contains("dujoon") || name.contains("doojun")) {
                info = celebrities.get("Dujun Yoon");
            } else if (!name.equals("")) {
                Message m = new Message("I don't know who this person is. Please write a name again");
                Label pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
                pane.getChildren().add(pc);
                labels.add(pc);
                history.add("REWRITE");
            }
        }
        // THERE IS A CELEBRITY IN DATA
        if (info != null) {
            PCShowInfo(info);
        }
    }

    private void PCShowInfo(String[] info) {
        try {
            Label prevLabel = (Label) labels.get(labels.size() - 1);
            String text = info[0] + "  \n\n" + info[2] + "  \n\n" + info[3] + "  \n\n" + info[4] + "  \n\n" + info[5];
            Image img = new Image(info[1]);
            ImageView image = new ImageView(img);

            // SHOW CELEBRITY BIO
            Label pc = new Label(text, image);
            pc.setStyle("-fx-background-color :  #d1f1b5");
            pc.setLayoutX(0);
            pc.setLayoutY(prevLabel.getLayoutY() + 20);
            pc.setWrapText(true);
            history.add("CELEB_INFO");
            pane.getChildren().add(pc);
            labels.add(pc);

            // ASK FOR KNOWING HIS/HER SNS
            prevLabel = (Label) labels.get(labels.size() - 1);
            Message m = new Message("Do you want to know the celebrity's SNS? (yes/no)");
            Label pc2 = m.getPCMessage(0, prevLabel.getLayoutY() + 160);
            history.add("ASK_SNS");
            pane.getChildren().add(pc2);
            labels.add(pc2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleAnswerYNForSNS(String ans) {
        Label prevLabel = (Label) labels.get(labels.size() - 1);
        if (ans.contains("yes") || ans.equals("y") || ans.contains("Yes") || ans.equals("Y")) {
            Message m = new Message("Please type the corresponding number\n\n1. Youtube\n2. Instagram\n3. Twitter");
            Label pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(pc);
            labels.add(pc);
            history.add("ASK_SELECT_SNS");
        } else if (ans.contains("no") || ans.equals("n") || ans.contains("No") || ans.equals("N")) {
            Message m = new Message("Do you want to search another Korean celebrity? (Yes/No)");
            Label pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(pc);
            labels.add(pc);
            history.add("ASK_ANOTHER");
        } else {
            Message m = new Message("I can't understand. Please write again");
            Label pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20 );
            pane.getChildren().add(pc);
            labels.add(pc);
            history.add("REWRITE");
        }
    }
}
