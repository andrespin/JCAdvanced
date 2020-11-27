package main;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller extends Parent {


    @FXML
    private TextField textFieldAdd;

    @FXML
    private ListView<String> getFromTextField;

    @FXML
    private TableColumn<String, Integer> usersTableColumn;


    @FXML
    private Button btnAdd;




    public void textFieldAdd(ActionEvent actionEvent) {

    }

    /*
    public void btnAdd(ActionEvent actionEvent) {

    }
    */


    @FXML
    public void initialize(){


    }


    @FXML
    public void btnAdd() {
        String word = textFieldAdd.getText();

        if (word.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Ошибка ввода сообщения");
            alert.setContentText("Нельзя вводить пустое сообщение");
            alert.showAndWait();
            return;

        } else {
            addWordToList(word);

        }

        textFieldAdd.clear();
    }


    private void addWordToTable(String word) {
        /*
        for (RowWord rowWord : frequencyByWord) {
            if (word.equals(rowWord.getWord())) {
                rowWord.incCount();
                return;
            }
        }

        frequencyByWord.add(new RowWord(word, 1));
        */
    }


    private void addWordToList(String word) {
        getFromTextField.getItems().add(word);
    }

    @FXML
    public void exit() {
        System.exit(1);
    }

    @FXML
    public void sendText(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            String word = textFieldAdd.getText();
            System.out.println("Word " + word);
            addWordToList(word);
        }
    }

    @FXML
    public void delete(ActionEvent actionEvent) {
        getFromTextField.getItems().clear();
    }
}
