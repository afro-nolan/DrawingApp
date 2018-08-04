
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

    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
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

}

