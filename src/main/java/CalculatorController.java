
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML private TextField number1Field;
    @FXML private TextField number2Field;
    @FXML private Label resultLabel;

    @FXML
    private void onCalculateClick() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());

            double sum = num1 + num2;
            double product = num1 * num2;
            double subtract = num1 - num2;
            Double quotient= null;
            if (num2 != 0) {
                quotient = num1 / num2;
            }

            resultLabel.setText("Sum: " + sum + ", Product: " + product + ", Sutract" + subtract + ", Quotient: " + (quotient != null ? quotient : "undefined"));

            // Save to DB
            ResultService.saveResult(num1, num2, sum, product, subtract, quotient);

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }
}