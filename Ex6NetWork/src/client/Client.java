package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import server.Server;

import java.util.List;

public class Client extends Application {

    public static final List<String> USERS_TEST_DATA = List.of("Boris Nikolaevich", "Martin Nekotov", "Gandalf the White");

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
     //   loader.setLocation(Client.class.getResource("viewSaving.fxml"));
        loader.setLocation(Server.class.getResource("viewChatWindow.fxml"));


      //  loader.setLocation(Client.class.getResource("viewSaving.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.show();

        Network network = new Network();

        if(!network.connect()) {
            showErrorMessage("Проблемы с соединением", "", "Ошибка подключения к серверу");
        }

        Controller viewController = loader.getController();

     //   Controller viewController = new Controller();

        if(viewController != null){
            viewController.setNetwork(network);

            network.waitMessage(viewController);

            primaryStage.setOnCloseRequest(windowEvent -> network.close());
        } else {
            System.out.println("viewController == null");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }


    protected static void showErrorMessage(String title, String message, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }


}
