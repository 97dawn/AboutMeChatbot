package aboutmechatbot.gui;

import aboutmechatbot.AboutMeChatbot;
import aboutmechatbot.template.Message;
import aboutmechatbot.data.Data;
import com.jfoenix.controls.JFXTextArea;
import java.awt.Desktop;
import java.net.URI;
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

/**
 * @version 1.0
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
        scroll.vvalueProperty().bind(pane.heightProperty());
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
        Label prevLabel = (Label) labels.get(labels.size() - 1);
        if (history.get(history.size() - 1).equals("GREET") || history.get(history.size() - 1).equals("REWRITE")) {
            String name = message.getText();
            // UPLOAD USER'S MESSAGE
            Message m = new Message(name + "  ");
            Label currentLabel = m.getUserMessage(0, prevLabel.getLayoutY() + prevLabel.getHeight() + 10);
            pane.getChildren().add(currentLabel);
            labels.add(currentLabel);
            history.add("CELEB_NAME");
            handleName(name);
        } else if (history.get(history.size() - 1).equals("ASK_SNS") || history.get(history.size() - 1).equals("ASK_ANOTHER_SNS")) {
            String yn = message.getText();
            // UPLOAD USER'S MESSAGE
            Message m = new Message(yn);
            Label currentLabel = m.getUserMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(currentLabel);
            labels.add(currentLabel);
            history.add("ANSWER_YN");
            handleAnswerYNForSNS(yn);
        } else if (history.get(history.size() - 1).equals("ASK_SELECT_SNS") || history.get(history.size() - 1).equals("REWRITE_FOR_SNS")) {
            String number = message.getText();
            // UPLOAD USER'S MESSAGE
            Message m = new Message(number);
            Label currentLabel = m.getUserMessage(0, prevLabel.getLayoutY() + 80);
            pane.getChildren().add(currentLabel);
            labels.add(currentLabel);
            history.add("SELECT_SNS");
            handleSNS(number);
        } else if (history.get(history.size() - 1).equals("ASK_ANOTHER_CELEB")) {
            String yn = message.getText();
            // UPLOAD USER'S MESSAGE
            Message m = new Message(yn);
            Label currentLabel = m.getUserMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(currentLabel);
            labels.add(currentLabel);
            history.add("ANSWER_YN");
            handleYNForAnotherCeleb(yn);
        } 
    }

    private void handleName(String name) {
        Label prevLabel = (Label) labels.get(labels.size() - 1);
        message.setText("");
        if (name.equals("")) {
            Message m = new Message("Please write a message");
            Label pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
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
            Message m = new Message("Do you want to know the celebrity's SNS? (Yes/No)");
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
            history.add("ASK_ANOTHER_CELEB");
        } else {
            Message m = new Message("I can't understand. Please write again.");
            Label pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(pc);
            labels.add(pc);
            history.add("REWRITE_FOR_SNS");
        }
        message.setText("");
    }

    private void handleSNS(String input) {
        Desktop desktop = Desktop.getDesktop();
        Label prevLabel = (Label) labels.get(labels.size() - 1);
        message.setText("");
        Message m = null;
        Label pc = null;
        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            if (input.equals("1")) {
                try {
                    desktop.browse(new URI(info[6]));
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            } else if (input.equals("2")) {
                if (info[7] != null) {
                    try {
                        desktop.browse(new URI(info[7]));
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                } else {
                    m = new Message("This celebrity doesn't have instagram.");
                    pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
                    pane.getChildren().add(pc);
                    labels.add(pc);
                }
            } else if (input.equals("3")) {
                if (info[8] != null) {
                    try {
                        desktop.browse(new URI(info[8]));
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                } else {
                    m = new Message("This celebrity doesn't have twitter.");
                    pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
                    pane.getChildren().add(pc);
                    labels.add(pc);
                }
            }
            prevLabel = (Label) labels.get(labels.size() - 1);
            m = new Message("Do you want to check other SNS? (Yes/No)");
            pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(pc);
            labels.add(pc);
            history.add("ASK_ANOTHER_SNS");
        } else { // WRONG INPUT
            m = new Message("I can't understand. Please write again.");
            pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(pc);
            labels.add(pc);
            history.add("REWRITE_FOR_SNS_TYPE");
        }
    }
    
    private void handleYNForAnotherCeleb(String ans){
        Label prevLabel = (Label) labels.get(labels.size() - 1);
        if (ans.contains("yes") || ans.equals("y") || ans.contains("Yes") || ans.equals("Y")) {
            prevLabel = (Label) labels.get(labels.size() - 1);
             Message m = new Message("Which Korean celebrity \ndo you want to know? \n( format: FirstName LastName )");
             Label currentLabel = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(currentLabel);
            labels.add(currentLabel);
            history.add("GREET");
        } else if (ans.contains("no") || ans.equals("n") || ans.contains("No") || ans.equals("N")) {
            AboutMeChatbot.getPrimaryStage().close();
        } else {
            Message m = new Message("I can't understand. Please write again.");
            Label pc = m.getPCMessage(0, prevLabel.getLayoutY() + 20);
            pane.getChildren().add(pc);
            labels.add(pc);
            history.add("REWRITE_FOR_CELEB");
        }
        message.setText("");
    }
}
