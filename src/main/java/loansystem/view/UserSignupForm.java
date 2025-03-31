package loansystem.view;

import loansystem.controller.UserController;
import loansystem.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSignupForm extends JFrame {
    private JTextField firstNameField, lastNameField, usernameField, emailField, phoneField, addressField;
    private JPasswordField passwordField;
    private JButton signupButton;
    private JCheckBox rememberMeCheckBox;

    public UserSignupForm() {
        setTitle("User Signup");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2));

        // Left panel (Image)
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        // Load the image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/signup.jpg")); // Path to your image
        Image image = imageIcon.getImage().getScaledInstance(640, 720, Image.SCALE_SMOOTH); // Resize the image
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        leftPanel.add(imageLabel, BorderLayout.CENTER);

        add(leftPanel);

        // Right panel (Signup Form)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(new Color(245, 245, 245)); // Light gray background
        add(rightPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Title Label
        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28)); // Larger font size
        titleLabel.setForeground(new Color(0, 153, 255)); // Blue color
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        rightPanel.add(titleLabel, gbc);

        // Subtitle Label
        JLabel subtitleLabel = new JLabel("Sign up to continue");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // Modern font
        subtitleLabel.setForeground(new Color(102, 102, 102)); // Gray color
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        rightPanel.add(subtitleLabel, gbc);

        // First Name Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        rightPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        firstNameField = new JTextField(20);
        firstNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        firstNameField.setPreferredSize(new Dimension(250, 30)); // Larger text field
        rightPanel.add(firstNameField, gbc);

        // Last Name Field
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        rightPanel.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        lastNameField = new JTextField(20);
        lastNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        lastNameField.setPreferredSize(new Dimension(250, 30)); // Larger text field
        rightPanel.add(lastNameField, gbc);

        // Username Field
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        rightPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        usernameField.setPreferredSize(new Dimension(250, 30)); // Larger text field
        rightPanel.add(usernameField, gbc);

        // Email Field
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        rightPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        emailField.setPreferredSize(new Dimension(250, 30)); // Larger text field
        rightPanel.add(emailField, gbc);

        // Password Field
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        rightPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        passwordField.setPreferredSize(new Dimension(250, 30)); // Larger text field
        rightPanel.add(passwordField, gbc);

        // Phone Number Field
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        rightPanel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        phoneField = new JTextField(20);
        phoneField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        phoneField.setPreferredSize(new Dimension(250, 30)); // Larger text field
        rightPanel.add(phoneField, gbc);

        // Address Field
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        rightPanel.add(addressLabel, gbc);

        gbc.gridx = 1;
        addressField = new JTextField(20);
        addressField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        addressField.setPreferredSize(new Dimension(250, 30)); // Larger text field
        rightPanel.add(addressField, gbc);

        // Remember Me Checkbox
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        rememberMeCheckBox = new JCheckBox("Remember me");
        rememberMeCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        rememberMeCheckBox.setBackground(new Color(245, 245, 245)); // Light gray background
        rightPanel.add(rememberMeCheckBox, gbc);

        // Signup Button
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        signupButton = new JButton("Sign Up");
        signupButton.setBackground(new Color(0, 153, 255)); // Blue color
        signupButton.setForeground(Color.WHITE);
        signupButton.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Modern font
        signupButton.setPreferredSize(new Dimension(250, 40)); // Larger button
        signupButton.setFocusPainted(false); // Remove focus border
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String username = usernameField.getText(); // Get username
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String phoneNumber = phoneField.getText();
                String address = addressField.getText();

                if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(UserSignupForm.this, "All fields are required.");
                    return;
                }

                User user = new User();
                user.setUsername(username); // Set username
                user.setPassword(password);
                user.setRole("user");
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setAddress(address);
                user.setCreditScore(600);

                UserController userController = new UserController();
                if (userController.registerUser(user)) {
                    JOptionPane.showMessageDialog(UserSignupForm.this, "Signup Successful!");
                    new LoginFrame().setVisible(true); // Redirect to login page
                    dispose(); // Close the signup window
                } else {
                    JOptionPane.showMessageDialog(UserSignupForm.this, "Signup Failed. Username or Email may already exist.");
                }
            }
        });
        rightPanel.add(signupButton, gbc);

        // Back to Login Link
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        JLabel backToLoginLabel = new JLabel("Already have an account? Login here");
        backToLoginLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font
        backToLoginLabel.setForeground(new Color(0, 153, 255)); // Blue color
        backToLoginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
        backToLoginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new LoginFrame().setVisible(true); // Redirect to login page
                dispose(); // Close the signup window
            }
        });
        rightPanel.add(backToLoginLabel, gbc);

        setVisible(true);
    }
}