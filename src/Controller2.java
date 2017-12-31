/**
 * Created by ressay on 31/12/17.
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

    @FXML
    private TextArea info;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        info.appendText(UIpart.moreInfo);
        info.setEditable(false);
    }
}