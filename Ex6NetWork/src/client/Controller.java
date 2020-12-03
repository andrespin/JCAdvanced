package client;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import server.Server;

import java.io.IOException;

public class Controller {


    @FXML
    public ListView<String> usersList;

    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;

    @FXML
    private MenuItem fileClose;


    private Network network;

    public void setNetwork(Network network) {
        this.network = network;
    }

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(client.Client.USERS_TEST_DATA));
        System.out.println("initialize");
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controller.this.sendMessage();
            }
        });
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controller.this.sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = textField.getText();
        appendMessage(message);
        textField.clear();

        try {
            network.getOut().writeUTF(message);

        } catch (IOException e) {
            e.printStackTrace();
            Client.showErrorMessage("Ошибка подключения", "Ошибка при отправке сообщения", e.getMessage());
        }

    }

    public void appendMessage(String message) {
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
    }

    @FXML
    public void fileClose(ActionEvent actionEvent) {
        System.exit(1);
    }

    @FXML
    public void fileAddUser(ActionEvent actionEvent) throws IOException {
        showAddingWindow();
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private final Stage primaryStage = new Stage();

    private void showAddingWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Client.class.getResource("addUserWindow.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.show();
    }



    @FXML
    public void fileConnectToServer(ActionEvent actionEvent) {

    }
}
