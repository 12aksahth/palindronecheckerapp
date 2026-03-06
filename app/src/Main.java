import javax.swing.*;
import java.awt.*;

// Class name must match the filename exactly!
public class Main extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public Main() {
        // Window Configuration
        setTitle("Palindrome Checker App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // UI Components
        JLabel titleLabel = new JLabel("Palindrome Checker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        inputField = new JTextField(15);
        JButton checkButton = new JButton("Check Text");
        resultLabel = new JLabel("Enter a word to start");

        // Layout Assembly
        gbc.gridx = 0; gbc.gridy = 0;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        add(new JLabel("Type here:"), gbc);

        gbc.gridy = 2;
        add(inputField, gbc);

        gbc.gridy = 3;
        add(checkButton, gbc);

        gbc.gridy = 4;
        add(resultLabel, gbc);

        // Logic Implementation
        checkButton.addActionListener(e -> {
            String original = inputField.getText().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            if (original.isEmpty()) {
                resultLabel.setText("⚠️ Please enter some text.");
                resultLabel.setForeground(Color.GRAY);
                return;
            }

            String reversed = new StringBuilder(original).reverse().toString();

            if (original.equals(reversed)) {
                resultLabel.setText("✅ Yes! It is a Palindrome.");
                resultLabel.setForeground(new Color(34, 139, 34)); // Dark Green
            } else {
                resultLabel.setText("❌ No, not a palindrome.");
                resultLabel.setForeground(Color.RED);
            }
        });

        setLocationRelativeTo(null); // Centers the window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}