package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cseroad
 */

public class Webshell_Unit {
    public HBox Jsp_Unit(Stage stage) {
        // 标签
        Label jsp_label = new Label("JSP_Webshell: ");
        jsp_label.setLayoutX(240);
        jsp_label.setLayoutY(15);
        jsp_label.setFont(Font.font(20));

        // jsp_webshell
        ChoiceBox<Object> jsp_webshell = new ChoiceBox();
        jsp_webshell.getItems().addAll("cmd", new Separator(), "cmd_reflect", new Separator(), "AntSword", new Separator(), "Behinder", new Separator(), "Godzilla");
        jsp_webshell.setValue("cmd");
        jsp_webshell.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newvable) {
                String newType = (String) newvable;
                if ("Godzilla".equals(newType)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Godzilla生成");
                    alert.setContentText("开发中！！！");
                    alert.show();
                }
            }

        });

        // 标签
        Label label = new Label("密码: ");
        //label.setLayoutX(340);
        //label.setLayoutY(15);
        label.setFont(Font.font(20));

        // 文本
        TextField textField = new TextField();
        //textField.setText("输入密码：");

        // 文本 坐标
        //textField.setLayoutX(350);
        //textField.setLayoutY(10);
        textField.setFont(Font.font(16));
        textField.setPrefWidth(280);
        textField.setPromptText("请输入密码：");
        textField.setFocusTraversable(false);
        // 监听事件
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newPass) {
                if (newPass.length() > 0 && newPass.length() < 10) {
                    Pattern pattern = Pattern.compile("[^\\x{4e00}-\\x{9fa5}a-zA-Z0-9_]");
                    Matcher matcher = pattern.matcher(newPass);
                    StringBuffer buffer = new StringBuffer();
                    while (matcher.find()) {
                        matcher.appendReplacement(buffer, " ");
                    }
                    // 合法部分添加到缓冲区
                    matcher.appendTail(buffer);
                    String s = buffer.toString();
                    textField.setText(s);
                } else {
                    textField.setText(oldValue);
                }
            }
        });

        //  单选按钮
        RadioButton unicode_button = new RadioButton("unicode编码");
        //unicode_button.setSelected(true);
        unicode_button.selectedProperty().addListener(new ChangeListener<Boolean>()  {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean unicodeValue) {
                //System.out.println(unicodeValue);
            }
        });

        // 按钮
        Button button = new Button("点击生成");
        button.setPrefWidth(80);
        button.setPrefHeight(50);
        // button 坐标
        button.setLayoutX(800);
        button.setLayoutY(10);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                //System.out.println(text);
                Object selectedItem = jsp_webshell.getSelectionModel().getSelectedItem();
                //System.out.println(selectedItem);
                String jsp_type = (String) selectedItem;

                boolean unicodeValue = unicode_button.isSelected();
                //m.out.println(unicodeValue);
                // 保存文件
                FileChooser chooser = new FileChooser();
                //设置弹窗的标题
                chooser.setTitle("保存文件");
                //设置初始的文件夹
                chooser.setInitialDirectory(new File("."));
                //设置文件名，仅仅在保存时有效
                String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".jsp";
                chooser.setInitialFileName(filename);
                File file = chooser.showSaveDialog(stage);
                if (file != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
                    alert.setHeaderText("保存文件："); // 设置对话框的头部文本
                    // 设置对话框的内容文本
                    alert.setContentText("保存的文件路径是：" + file.getAbsolutePath());
                    alert.show();
                    Webshell_Generate webshell_generate = new Webshell_Generate();
                    webshell_generate.jsp_webshell(jsp_type, text, file.getAbsolutePath(),unicodeValue);
                }

            }
        });

        // 水平布局 Hbox()
        HBox hBox1 = new HBox(10);
        hBox1.setPrefWidth(1024);
        hBox1.setPrefHeight(125);
        //hBox1.setStyle("-fx-background-color: gold");
        // 内边距
        //hBox.setPadding(new Insets(20));
        // 组边距
        hBox1.setSpacing(20);
        //
        //hBox.setMargin(label,new Insets(20));
        // 居中
        hBox1.setStyle("-fx-border-style: solid inside;");
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(jsp_label, jsp_webshell, label, textField, unicode_button,button);
        return hBox1;
    }

    public HBox Jspx_Unit(Stage stage) {
        // 标签
        Label jspx_label = new Label("JSPX_Webshell: ");
        jspx_label.setLayoutX(240);
        jspx_label.setLayoutY(15);
        jspx_label.setFont(Font.font(20));

        // jsp_webshell
        ChoiceBox<Object> jspx_webshell = new ChoiceBox();
        jspx_webshell.getItems().addAll("cmd", new Separator(), "cmd_reflect", new Separator(), "AntSword", new Separator(), "Behinder", new Separator(), "Godzilla");
        jspx_webshell.setValue("cmd");
        jspx_webshell.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newvable) {
                String newType = (String) newvable;
                if ("Godzilla".equals(newType)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Godzilla生成");
                    alert.setContentText("开发中！！！");
                    alert.show();
                }
            }

        });

        // 标签
        Label label = new Label("密码: ");
        label.setFont(Font.font(20));
        TextField textField = new TextField();
        textField.setFont(Font.font(16));
        textField.setPrefWidth(280);
        textField.setPromptText("请输入密码：");
        textField.setFocusTraversable(false);
        // 监听事件
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newPass) {
                if (newPass.length() > 0 && newPass.length() < 10) {
                    Pattern pattern = Pattern.compile("[^\\x{4e00}-\\x{9fa5}a-zA-Z0-9_]");
                    Matcher matcher = pattern.matcher(newPass);
                    StringBuffer buffer = new StringBuffer();
                    while (matcher.find()) {
                        matcher.appendReplacement(buffer, " ");
                    }
                    matcher.appendTail(buffer);
                    String s = buffer.toString();
                    textField.setText(s);
                } else {
                    textField.setText(oldValue);
                }
            }
        });

        //  单选按钮
        RadioButton unicode_button = new RadioButton("unicode编码");
        unicode_button.selectedProperty().addListener(new ChangeListener<Boolean>()  {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean unicodeValue) {
                //System.out.println(unicodeValue);
            }
        });

        // 按钮
        Button button = new Button("点击生成");
        button.setPrefWidth(80);
        button.setPrefHeight(50);
        button.setLayoutX(800);
        button.setLayoutY(10);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                Object selectedItem = jspx_webshell.getSelectionModel().getSelectedItem();
                String jsp_type = (String) selectedItem;
                boolean unicodeValue = unicode_button.isSelected();
                FileChooser chooser = new FileChooser();
                chooser.setTitle("保存文件");
                chooser.setInitialDirectory(new File("."));
                String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".jspx";
                chooser.setInitialFileName(filename);
                File file = chooser.showSaveDialog(stage);
                if (file != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("保存文件：");
                    alert.setContentText("保存的文件路径是：" + file.getAbsolutePath());
                    alert.show();
                    Webshell_Generate webshell_generate = new Webshell_Generate();
                    webshell_generate.jspx_webshell(jsp_type, text, file.getAbsolutePath(),unicodeValue);
                }
            }
        });
        HBox hBox1 = new HBox(10);
        hBox1.setPrefWidth(1024);
        hBox1.setPrefHeight(125);
        hBox1.setSpacing(20);
        hBox1.setLayoutY(125);
        hBox1.setStyle("-fx-border-style: solid inside;");
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(jspx_label, jspx_webshell, label, textField, unicode_button,button);
        return hBox1;
    }

    public HBox Php_Unit(Stage stage) {
        // 标签
        Label php_label = new Label("PHP_Webshell: ");
        php_label.setLayoutX(240);
        php_label.setLayoutY(15);
        php_label.setFont(Font.font(20));

        // php_webshell
        ChoiceBox<Object> php_webshell = new ChoiceBox<>();
        php_webshell.getItems().addAll("AntSword", new Separator(), "AntSword_base64", new Separator(), "Behinder", new Separator(), "Godzilla");
        php_webshell.setValue("AntSword_base64");
        php_webshell.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newvable) {
                String newType = (String) newvable;
                //System.out.println(newType);
                if ("Godzilla".equals(newType)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Godzilla生成");
                    alert.setContentText("开发中！！！");
                    alert.show();
                }
            }

        });

        Label label = new Label("密码: ");
        label.setFont(Font.font(20));

        TextField textField = new TextField();
        textField.setFont(Font.font(16));
        textField.setPrefWidth(240);
        textField.setPromptText("请输入密码：");
        textField.setFocusTraversable(false);
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newPass) {
                if (newPass.length() > 0 && newPass.length() < 10) {
                    Pattern pattern = Pattern.compile("[^\\x{4e00}-\\x{9fa5}a-zA-Z0-9_]");
                    Matcher matcher = pattern.matcher(newPass);
                    StringBuffer buffer = new StringBuffer();
                    while (matcher.find()) {
                        matcher.appendReplacement(buffer, " ");
                    }
                    matcher.appendTail(buffer);
                    String s = buffer.toString();
                    textField.setText(s);
                } else {
                    textField.setText(oldValue);
                }

            }
        });
        Button button = new Button("点击生成");
        button.setPrefWidth(80);
        button.setPrefHeight(50);
        button.setLayoutX(800);
        button.setLayoutY(10);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                //System.out.println(text);
                Object selectedItem = php_webshell.getSelectionModel().getSelectedItem();
                //System.out.println(selectedItem);
                String php_type = (String) selectedItem;
                FileChooser chooser = new FileChooser();
                chooser.setTitle("保存文件");
                chooser.setInitialDirectory(new File("."));
                String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".php";
                chooser.setInitialFileName(filename);

                File file = chooser.showSaveDialog(stage);
                if (file != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("保存文件：");
                    alert.setContentText("保存的文件路径是：" + file.getAbsolutePath());
                    alert.show();
                    Webshell_Generate webshell_generate = new Webshell_Generate();
                    webshell_generate.php_webshell(php_type, text, file.getAbsolutePath());
                }

            }
        });

        HBox hBox1 = new HBox(10);
        hBox1.setPrefWidth(1024);
        hBox1.setPrefHeight(125);
        hBox1.setSpacing(20);
        hBox1.setLayoutY(250);
        hBox1.setStyle("-fx-border-style: solid inside;");
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(php_label, php_webshell, label, textField, button);
        return hBox1;
    }

    public HBox Asp_Unit(Stage stage) {
        Label asp_label = new Label("ASP_Webshell: ");
        asp_label.setLayoutX(240);
        asp_label.setLayoutY(15);
        asp_label.setFont(Font.font(20));

        ChoiceBox<Object> asp_webshell = new ChoiceBox<>();
        asp_webshell.getItems().addAll("AntSword", new Separator(), "Behinder", new Separator(), "Godzilla");
        asp_webshell.setValue("AntSword");
        asp_webshell.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newvable) {
                String newType = (String) newvable;
                if ("Godzilla".equals(newType)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Godzilla生成");
                    alert.setContentText("开发中！！！");
                    alert.show();
                }
            }

        });

        Label label = new Label("密码: ");
        label.setFont(Font.font(20));

        TextField textField = new TextField();
        textField.setFont(Font.font(16));
        textField.setPrefWidth(280);
        textField.setPromptText("请输入密码：");
        textField.setFocusTraversable(false);
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newPass) {
                if (newPass.length() > 0 && newPass.length() < 10) {
                    Pattern pattern = Pattern.compile("[^\\x{4e00}-\\x{9fa5}a-zA-Z0-9_]");
                    Matcher matcher = pattern.matcher(newPass);
                    StringBuffer buffer = new StringBuffer();
                    while (matcher.find()) {
                        matcher.appendReplacement(buffer, " ");
                    }
                    // 合法部分添加到缓冲区
                    matcher.appendTail(buffer);
                    String s = buffer.toString();
                    textField.setText(s);
                } else {
                    textField.setText(oldValue);
                }

            }
        });
        Button button = new Button("点击生成");
        button.setPrefWidth(80);
        button.setPrefHeight(50);
        button.setLayoutX(800);
        button.setLayoutY(10);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                Object selectedItem = asp_webshell.getSelectionModel().getSelectedItem();
                String asp_type = (String) selectedItem;
                FileChooser chooser = new FileChooser();
                chooser.setTitle("保存文件");
                chooser.setInitialDirectory(new File("."));
                String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".asp";
                chooser.setInitialFileName(filename);
                File file = chooser.showSaveDialog(stage);
                if (file != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("保存文件：");
                    alert.setContentText("保存的文件路径是：" + file.getAbsolutePath());
                    alert.show();
                    Webshell_Generate webshell_generate = new Webshell_Generate();
                    webshell_generate.asp_webshell(asp_type, text, file.getAbsolutePath());
                }

            }
        });

        HBox hBox1 = new HBox(10);
        hBox1.setPrefWidth(1024);
        hBox1.setPrefHeight(125);
        hBox1.setSpacing(20);
        hBox1.setLayoutY(375);
        hBox1.setStyle("-fx-border-style: solid inside;");
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(asp_label, asp_webshell, label, textField, button);
        return hBox1;
    }

    public HBox Aspx_Unit(Stage stage) {
        Label aspx_label = new Label("ASPX_Webshell: ");
        aspx_label.setLayoutX(240);
        aspx_label.setLayoutY(15);
        aspx_label.setFont(Font.font(20));
        ChoiceBox<Object> aspx_webshell = new ChoiceBox<>();
        aspx_webshell.getItems().addAll("AntSword", new Separator(), "Behinder", new Separator(), "Godzilla");
        aspx_webshell.setValue("AntSword");
        aspx_webshell.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newvable) {
                String newType = (String) newvable;
                if ("Godzilla".equals(newType)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Godzilla生成");
                    alert.setContentText("开发中！！！");
                    alert.show();
                }
            }

        });
        Label label = new Label("密码: ");
        label.setFont(Font.font(20));
        TextField textField = new TextField();
        textField.setFont(Font.font(16));
        textField.setPrefWidth(280);
        textField.setPromptText("请输入密码：");
        textField.setFocusTraversable(false);
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newPass) {
                if (newPass.length() > 0 && newPass.length() < 10) {
                    Pattern pattern = Pattern.compile("[^\\x{4e00}-\\x{9fa5}a-zA-Z0-9_]");
                    Matcher matcher = pattern.matcher(newPass);
                    StringBuffer buffer = new StringBuffer();
                    while (matcher.find()) {
                        matcher.appendReplacement(buffer, " ");
                    }
                    matcher.appendTail(buffer);
                    String s = buffer.toString();
                    textField.setText(s);
                } else {
                    textField.setText(oldValue);
                }

            }
        });
        Button button = new Button("点击生成");
        button.setPrefWidth(80);
        button.setPrefHeight(50);
        button.setLayoutX(800);
        button.setLayoutY(10);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                Object selectedItem = aspx_webshell.getSelectionModel().getSelectedItem();
                String aspx_type = (String) selectedItem;
                FileChooser chooser = new FileChooser();
                chooser.setTitle("保存文件");
                chooser.setInitialDirectory(new File("."));
                String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".aspx";
                chooser.setInitialFileName(filename);
                File file = chooser.showSaveDialog(stage);
                if (file != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("保存文件：");
                    alert.setContentText("保存的文件路径是：" + file.getAbsolutePath());
                    alert.show();
                    Webshell_Generate webshell_generate = new Webshell_Generate();
                    webshell_generate.aspx_webshell(aspx_type, text, file.getAbsolutePath());
                }

            }
        });

        HBox hBox1 = new HBox(10);
        hBox1.setPrefWidth(1024);
        hBox1.setPrefHeight(125);
        hBox1.setSpacing(20);
        hBox1.setLayoutY(500);
        hBox1.setStyle("-fx-border-style: solid inside;");
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(aspx_label, aspx_webshell, label, textField, button);
        return hBox1;
    }

    public HBox Other_Unit(Stage stage) {
        Label other_label = new Label("OTHER_Webshell: ");
        other_label.setLayoutX(240);
        other_label.setLayoutY(15);
        other_label.setFont(Font.font(20));

        ChoiceBox<Object> other_webshell = new ChoiceBox<>();
        other_webshell.getItems().addAll("ashx_cmd", new Separator(), "asmx_cmd");
        other_webshell.setValue("ashx_cmd");
        other_webshell.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newvable) {
                String newType = (String) newvable;
                if ("asmx_cmd".equals(newType)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("未完成");
                    alert.setContentText("开发中！！！");
                    alert.show();
                }
            }

        });

        Label label = new Label("密码: ");
        label.setFont(Font.font(20));
        TextField textField = new TextField();
        textField.setFont(Font.font(16));
        textField.setPrefWidth(280);
        textField.setPromptText("请输入密码：");
        textField.setFocusTraversable(false);
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newPass) {
                if (newPass.length() > 0 && newPass.length() < 10) {
                    Pattern pattern = Pattern.compile("[^\\x{4e00}-\\x{9fa5}a-zA-Z0-9_]");
                    Matcher matcher = pattern.matcher(newPass);
                    StringBuffer buffer = new StringBuffer();
                    while (matcher.find()) {
                        matcher.appendReplacement(buffer, " ");
                    }
                    matcher.appendTail(buffer);
                    String s = buffer.toString();
                    textField.setText(s);
                } else {
                    textField.setText(oldValue);
                }

            }
        });
        Button button = new Button("点击生成");
        button.setPrefWidth(80);
        button.setPrefHeight(50);
        button.setLayoutX(800);
        button.setLayoutY(10);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                Object selectedItem = other_webshell.getSelectionModel().getSelectedItem();
                String other_type = (String) selectedItem;
                FileChooser chooser = new FileChooser();
                chooser.setTitle("保存文件");
                chooser.setInitialDirectory(new File("."));
                if("ashx_cmd".equals(other_type)){
                    String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".ashx";
                    chooser.setInitialFileName(filename);
                }
                if("asmx_cmd".equals(other_type)){
                    String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".asmx";
                    chooser.setInitialFileName(filename);
                }
                File file = chooser.showSaveDialog(stage);
                if (file != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("保存文件：");
                    alert.setContentText("保存的文件路径是：" + file.getAbsolutePath());
                    alert.show();
                    Webshell_Generate webshell_generate = new Webshell_Generate();
                    webshell_generate.other_webshell(other_type, text, file.getAbsolutePath());
                }

            }
        });

        HBox hBox1 = new HBox(10);
        hBox1.setPrefWidth(1024);
        hBox1.setPrefHeight(125);
        hBox1.setSpacing(20);
        hBox1.setLayoutY(625);
        hBox1.setStyle("-fx-border-style: solid inside;");
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(other_label, other_webshell, label, textField, button);
        return hBox1;
    }

}
