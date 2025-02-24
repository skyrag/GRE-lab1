package ch.heig.gre.groupX;

import ch.heig.gre.gui.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(MainViewController.class.getResource("mainView.fxml"));
    Parent parent = fxmlLoader.load();
    Scene scene = new Scene(parent, 800, 600);
    stage.setTitle("All work and no play makes Jack a dull boy");
    stage.setScene(scene);

    MainViewController controller = fxmlLoader.getController();
    controller.init(new DfsGenerator(), new BfsSolver());

    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}