
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import java.security.SecureRandom;
import javafx.scene.transform.Transform;

public class DrawController {

    //enum representing pen sizes
        private enum PenSize {
            SMALL(2),
            MEDIUM(4),
            LARGE(6),
            VERYLARGE(16);
            
            private final int radius;
            
            PenSize(int radius) {
                this.radius = radius;
            }
            
            public int getRadius() {
                return radius;
            }
            
        };


    @FXML
    private RadioButton smallRadioButton;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton largeRadioButton;

    @FXML
    private RadioButton veryLargeRadioButton;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button clearButton;

    @FXML
    private Button undoButton;

    @FXML
    private Pane drawingAreaPane;

    @FXML 
    private RadioButton starShape;

    @FXML
    private ToggleGroup shapeToggleGroup;



    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    private static final SecureRandom random = new SecureRandom();
    //final ColorPicker colorPicker = new ColorPicker();
    //colorPicker.setValue(Color.RED);

    public void initialize() {
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
        largeRadioButton.setUserData(PenSize.VERYLARGE);
        colorPicker.setValue(Color.BLACK);
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent e) {
        //Circle newCircle = new Circle(e.getX(), e.getY(), radius.getRadius(), brushColor);
        Circle newCircle = new Circle(e.getX(), e.getY(), radius.getRadius());
        newCircle.setFill(colorPicker.getValue());
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent e) {
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();

        if (count > 0) {
            drawingAreaPane.getChildren().remove(count - 1);
        }

    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private void colorSelected(ActionEvent event) {
        brushColor = colorPicker.getValue();
    }

    @FXML
    private void starButtonSelected(ActionEvent event) {

        //System.out.println(type(shapeToggleGroup.getSelectedToggle().getUserData()));

        //Object button = shapeToggleGroup.getSelectedToggle().getUserData();
        //System.out.println(button);
        //if (button == "Star") {

        Double[] starPoints = {205.0, 150.0, 217.0, 186.0, 259.0, 186.0, 223.0, 204.0, 233.0,
            246.0, 205.0, 222.0, 177.0, 246.0, 187.0, 204.0, 151.0, 186.0, 193.0, 186.0};

        Polygon star = new Polygon();
        star.getPoints().addAll(starPoints);

        star.setStroke(Color.GREY);
        star.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255), random.nextDouble()));
        drawingAreaPane.getChildren().add(star);

    }

}

