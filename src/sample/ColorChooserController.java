package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.text.NumberFormat;

public class ColorChooserController {

    @FXML private Label redLabel;
    @FXML private Label greenLabel;
    @FXML private Label blueLabel;
    @FXML private Label alphaLabel;
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;



    public void initialize () {

        redSlider.setValue(red);
        redTextField.setText(new Integer(red).toString());

        greenSlider.setValue(green);
        greenTextField.setText(new Integer(green).toString());

        blueSlider.setValue(blue);
        blueTextField.setText(new Integer(blue).toString());

        alphaSlider.setValue(alpha);
        alphaTextField.setText(new Double(alpha).toString());

        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), NumberFormat.getNumberInstance());
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), NumberFormat.getNumberInstance());
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), NumberFormat.getNumberInstance());
        alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), NumberFormat.getNumberInstance());




        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {

                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        try {
                            red = newValue.intValue();
                            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );

        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        green = newValue.intValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }

                }

        );

        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        blue = newValue.intValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));


                    }
                }
        );
        alphaSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        alpha = newValue.doubleValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );

    }
}