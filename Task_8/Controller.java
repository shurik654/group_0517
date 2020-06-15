
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField textField;
    @FXML
    TextArea textArea;

    public void send() {
        String str = textField.getText();
        textArea.appendText(str+"\n");
        textField.setText("");
    }
}
