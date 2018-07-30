
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {
		
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
	    private RadioButton blackRadioButton;

	    @FXML
	    private ToggleGroup colorToggleGroup;

	    @FXML
	    private RadioButton redRadioButton;

	    @FXML
	    private RadioButton greenRadioButton;

	    @FXML
	    private RadioButton blueRadioButton;
	    
	    @FXML
	    private RadioButton yellowRadioButton;
	    
	    @FXML
	    private RadioButton orangeRadioButton;
	    
	    @FXML
	    private RadioButton pinkRadioButton;

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
	    private Button undoButton;

	    @FXML
	    private Button clearButton;

	    @FXML
	    private Pane drawingAreaPane;
	    
	    //radius of the circle
	    private PenSize radius = PenSize.MEDIUM; 
	    //drawing color
	    private Paint brushColor = Color.BLACK;
	    
	    //set user data for Radio Buttons
	    public void initialize() {
	    		blackRadioButton.setUserData(Color.BLACK);
		    redRadioButton.setUserData(Color.RED);
		    greenRadioButton.setUserData(Color.GREEN);
		    blueRadioButton.setUserData(Color.BLUE);
		    yellowRadioButton.setUserData(Color.YELLOW);
		    orangeRadioButton.setUserData(Color.ORANGE);
		    pinkRadioButton.setUserData(Color.PINK);
		    smallRadioButton.setUserData(PenSize.SMALL);
		    mediumRadioButton.setUserData(PenSize.MEDIUM);
		    largeRadioButton.setUserData(PenSize.LARGE);
		    veryLargeRadioButton.setUserData(PenSize.VERYLARGE);
	    }
	   
	    
	    @FXML
	    private void clearButtonPressed(ActionEvent event) {
	    		//clears the canvas
	    		drawingAreaPane.getChildren().clear();
	    }

	    @FXML
	    private void colorRadioButtonSelected(ActionEvent event) {
	    		brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();

	    }

	    @FXML
	    private void drawingAreaMouseDragged(MouseEvent e) {
	    		Circle newCircle = new Circle(e.getX(), e.getY(), radius.getRadius(), brushColor);
	    		drawingAreaPane.getChildren().add(newCircle);					

	    }

	    @FXML
	    private void sizeRadioButtonSelected(ActionEvent event) {
	    		radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
	    }

	    @FXML
	    private void undoButtonPressed(ActionEvent event) {
	    		int count = drawingAreaPane.getChildren().size();
	    		
	    		//if there are shapes, remove last one added
	    		if (count > 0) {
	    			drawingAreaPane.getChildren().remove(count - 1);
	    		}
	    }

	


}
