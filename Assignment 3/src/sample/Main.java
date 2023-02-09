package sample;

//part 1
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import java.util.Random;

//part 2
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

//part 3
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;

public class Main extends Application{

    private Button draw;
    private TextField objCount;
    private TextField maxSize;
    private TextField newSpeed;
    ObservableList<String> shapeTypes =
            FXCollections.observableArrayList("Circle", "Rectangle");
    final ComboBox combobox = new ComboBox(shapeTypes);
    private BorderPane bdrPane = new BorderPane();
    private HBox drawingBarPane;
    int size = 100;
    int obj = 50;
    int speed = 800;
    Pane artworkPane = new Pane();

    private Pane AddHBox(){

        drawingBarPane = new HBox();
        drawingBarPane.setSpacing(8);
        drawingBarPane.setPadding(new Insets(4,4,4,4));

        Label label1 = new Label("Object Count");
        Label label2 = new Label("Size");
        Label label3 = new Label("Speed");

        objCount = new TextField();
        maxSize = new TextField();
        newSpeed = new TextField();

        draw = new Button("Draw");
        combobox.setValue("Circle");
        drawingBarPane.getChildren().addAll(combobox, label1, objCount, label2, maxSize, label3, newSpeed, draw);

        draw.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                artworkPane.getChildren().clear();
                size = Integer.parseInt(maxSize.getText());
                obj = Integer.parseInt(objCount.getText());
                speed = Integer.parseInt(newSpeed.getText());
                drawShape();

                TranslateTransition translate = new TranslateTransition(Duration.millis(speed));
                translate.setToX(20);
                translate.setToY(-20);

                ParallelTransition transition = new ParallelTransition(artworkPane, translate);
                transition.setCycleCount(Timeline.INDEFINITE);
                transition.setAutoReverse(true);
                transition.play();
            }
        });

        objCount.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                artworkPane.getChildren().clear();
                obj = Integer.parseInt(objCount.getText());
                drawShape();
            }
        });

        maxSize.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                artworkPane .getChildren().clear();
                size = Integer.parseInt(maxSize.getText());
                drawShape();
            }
        });
        return drawingBarPane;
    }

    @Override
    public void start(Stage primaryStage) {
        drawCircle();
        combobox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                artworkPane.getChildren().clear();
                drawShape();
            }
        });

        bdrPane.setBottom(AddHBox());
        bdrPane.setCenter(artworkPane);

        Scene scene = new Scene(bdrPane, 600, 300);
        primaryStage.setTitle("Modern Art");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawCircle() {
        for(int i =0;i < obj;i++) {
            Circle cir = new Circle (getCenterX(), getCenterY(), getRadius());
            cir.setFill(Color.color(Math.random(), Math.random(),Math.random()));
            artworkPane.getChildren().add(cir);
        }
    }

    private void drawShape(){
        if (combobox.getValue() == "Circle"){
            for (int i =0;i < obj;i++) {
                Circle cir = new Circle (getCenterX(), getCenterY(), getRadius());
                cir.setFill(Color.color(Math.random(), Math.random(),Math.random()));
                cir.setOpacity(0.25);
                artworkPane.getChildren().add(cir);

                TranslateTransition translate = new TranslateTransition(Duration.millis(800));
                translate.setToX(30);
                translate.setToY(-30);

                ParallelTransition transition = new ParallelTransition(artworkPane, translate);
                transition.setCycleCount(Timeline.INDEFINITE);
                transition.setAutoReverse(true);
                transition.play();
            }
        }

        if (combobox.getValue()=="Rectangle") {
            for (int i =0;i < obj;i++) {

                double height = (int)(Math.random()*size);
                double width = (int)(Math.random()*size);
                double xCord = (int)(Math.random()*500 + 50);
                double yCord = (int)(Math.random()*150 + 50);
                Rectangle rec = new Rectangle(xCord,yCord,width,height);
                rec.setFill(Color.color(Math.random(), Math.random(),Math.random()));
                rec.setOpacity(0.25);
                artworkPane.getChildren().add(rec);

                TranslateTransition translate = new TranslateTransition(Duration.millis(600));
                translate.setToX(30);
                translate.setToY(-30);

                ParallelTransition transition = new ParallelTransition(artworkPane, translate);
                transition.setCycleCount(Timeline.INDEFINITE);
                transition.setAutoReverse(true);
                transition.play();
            }
        }
    }

    private double getRadius() {
        return (int) (Math.random() * size);
    }

    private double getCenterX() {
        return (int)(Math.random() * 500 + 50);
    }

    private double getCenterY() {
        return (int)(Math.random() * 150 + 50);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
