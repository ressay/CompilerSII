import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button run;

    @FXML
    private TextArea edit;


    @FXML
    private CheckBox tree;

    @FXML
    private CheckBox oCode;

    @FXML
    private CheckBox symb;

    @FXML
    private CheckBox quad;

    @FXML
    private CheckBox tok;

    @FXML
    private Button imp;

    @FXML
    private TextFlow flow;

    private int xQuad = 100,yQuad = 100,xSymb = 100,ySymb = 500,xOCode = 700,yOCode = 100;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        if(event.getSource() == run)
        {
            flow.getChildren().clear();
            String[] params = new String[3+(tree.isSelected()?1:0)+(tok.isSelected()?1:0)];
            int endOff = 1;
            if(tree.isSelected())
                params[params.length-(endOff++)] = "-gui";
            if(tok.isSelected())
                params[params.length-endOff] = "-tokens";
            try {
                params[0] = "TinyLangageSII";
                params[1] = "prog";
                BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.txt"));
                writer.write(edit.getText());
                writer.close();
                params[2] = "myFile.txt";
                myMain.main(params);
                LinkedList<String> errors1 = myMain.semanticErrorCheck.getErrors();
                LinkedList<String> errors2 = myMain.lexerErrors;
                LinkedList<String> errors3 = myMain.parserErrors;
                if(errors1.size() == 0 && errors2.size() == 0 && errors3.size() == 0)
                {
                        addInfoText("Program compiled without errors\n","-fx-fill: #4F8A10;-fx-font-weight:bold;");
                }
                else
                {
                    addInfoText("Program compiled with the following errors:\n","-fx-fill: #000000;-fx-font-weight:bold;");
                    for (int i=0;i<errors1.size();i++)
                        addInfoText(errors1.get(i)+"\n","-fx-fill: #CD1010;-fx-font-weight:normal;");
                    for (int i=0;i<errors2.size();i++)
                        addInfoText(errors2.get(i)+"\n","-fx-fill: #CD1010;-fx-font-weight:normal;");
                    for (int i=0;i<errors3.size();i++)
                        addInfoText(errors3.get(i)+"\n","-fx-fill: #CD1010;-fx-font-weight:normal;");
                }

                if(quad.isSelected()) {
                    showTextNewWindow(getQuadText(),"Quadruplet",xQuad,yQuad);
                }
                if(symb.isSelected())
                {
                    showTextNewWindow(getSymbText(),"Symbols Table",xSymb,ySymb);
                }
                if(oCode.isSelected())
                {
                    showTextNewWindow(getOCodeText(),"Object Code",xOCode,yOCode);
                }
                if(tok.isSelected())
                {
                    showTextNewWindow(getTokensText(),"Lexar Tokens",xOCode,yOCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(event.getSource() == imp)
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(new Stage());
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while((line = reader.readLine()) != null) {
                    System.out.println(line);
                    edit.appendText(line+"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
//        informations.setEditable(false);
//        informations.setVisible(false);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            while((line = reader.readLine()) != null) {
                edit.appendText(line+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showTextNewWindow(String text,String title,int x,int y)
    {
        Parent root = null;
        UIpart.moreInfo = text;
        try {
            root = FXMLLoader.load(getClass().getResource("moreInfo.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root));
        primaryStage.setX(x);
        primaryStage.setY(y);
        primaryStage.show();
    }

    private String getQuadText()
    {
        String text = "";
        for(int i=0;i<myMain.quadGenerator.getQuads().quads.size();i++)
            text += ""+myMain.quadGenerator.getQuads().quads.get(i) +"\n";
        return text;
    }

    private String getSymbText()
    {
        String text = "";
        for(int i=0;i<myMain.semanticErrorCheck.getTable().getSize();i++)
            text += ""+myMain.semanticErrorCheck.getTable().getElement(i) +"\n";
        return text;
    }

    private String getOCodeText()
    {
        String text = "";
        for(int i=0;i<myMain.quadGenerator.getInstructions().size();i++)
            text += ""+myMain.quadGenerator.getInstructions().get(i) +"\n";
        return text;
    }

    private String getTokensText()
    {
        return myMain.tokenstext;
    }

    private void addInfoText(String text, String style)
    {
        Text t1 = new Text();
        t1.setStyle(style);
        t1.setText(text);
        flow.getChildren().addAll(t1);
    }

}