package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author cseroad
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Webshell_Generate    by: CSeroad");
        primaryStage.setWidth(1024);
        primaryStage.setHeight(760);
        primaryStage.setResizable(false);// 不可拉伸
        primaryStage.show();
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(new Group()));

        Webshell_Unit webshell_unit = new Webshell_Unit();
        HBox jsp_hBox = webshell_unit.Jsp_Unit(primaryStage);
        HBox jspx_hBox = webshell_unit.Jspx_Unit(primaryStage);
        HBox php_hBox = webshell_unit.Php_Unit(primaryStage);
        HBox asp_hBox = webshell_unit.Asp_Unit(primaryStage);
        HBox aspx_hbox = webshell_unit.Aspx_Unit(primaryStage);
        HBox other_hbox = webshell_unit.Other_Unit(primaryStage);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(jsp_hBox,jspx_hBox,php_hBox,asp_hBox,aspx_hbox,other_hbox);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);

    }
    public static void main(String[] args) {
        launch(args);
    }


}
