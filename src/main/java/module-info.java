module ch.heig.gre {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.graphics;

  opens ch.heig.gre.gui to javafx.fxml;
  opens ch.heig.gre.groupF to javafx.graphics;
}
