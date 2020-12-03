package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AddUserWindowController extends Controller {

    @FXML
    private Button addNewUser;

    @FXML
    private TextField textField;

    @FXML
    public void addNewUser(ActionEvent actionEvent) {
        if (textField.getText() != "") {
//            client.Client.USERS_TEST_DATA.add(textField.getText());
            getPrimaryStage().close();
        } else {
            Client.showErrorMessage("Ошибка","Заполните поле", "Поле не заполнено");
        }
    }
}
