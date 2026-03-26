import javax.swing.*; // Import Swing components
import java.awt.*; // Import layout managers
import java.awt.event.*; // Import event handling classes

// Main class extending JFrame to create GUI window
public class InvestmentCalculator extends JFrame implements ActionListener {

    // Declare GUI components
    JTextField principalField, rateField, yearsField, resultField;
    JButton calculateButton;

    // Constructor to create GUI
    InvestmentCalculator() {

        // Set title of window
        setTitle("Investment Calculator");

        // Set window size
        setSize(350, 250);

        // Set layout manager
        setLayout(new GridLayout(5, 2, 5, 5));

        // Principal input
        add(new JLabel("Principal Amount:"));
        principalField = new JTextField();
        add(principalField);

        // Interest rate input
        add(new JLabel("Interest Rate (%):"));
        rateField = new JTextField();
        add(rateField);

        // Years input
        add(new JLabel("Years:"));
        yearsField = new JTextField();
        add(yearsField);

        // Output field
        add(new JLabel("Final Amount:"));
        resultField = new JTextField();
        resultField.setEditable(false); // User cannot edit result
        add(resultField);

        // Button for calculation
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this); // Register event listener
        add(calculateButton);

        // Close program when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make window visible
        setVisible(true);
    }

    // Event handling method for button click
    public void actionPerformed(ActionEvent e) {

        // Get values from text fields
        double principal = Double.parseDouble(principalField.getText());
        double rate = Double.parseDouble(rateField.getText());
        int years = Integer.parseInt(yearsField.getText());

        // Calculate final investment value using compound interest formula
        double amount = principal * Math.pow((1 + rate / 100), years);

        // Display result
        resultField.setText(String.format("%.2f", amount));
    }

    // Main method to start program
    public static void main(String[] args) {

        // Create object of calculator
        new InvestmentCalculator();
    }
}