import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ComputerStoreManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_computer_store";
    private static final String DB_USER = "root"; // USE 'root' as the username
    private static final String DB_PASSWORD = ""; // ENTER YOUR MySQL PASSWORD HERE

    public static void main(String[] args) {
        JFrame frame = new JFrame("Computer Retail Store Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));

        JButton btnSellProducts = new JButton("Sell Products");
        btnSellProducts.addActionListener(e -> sellProducts());
        buttonPanel.add(btnSellProducts);

        JButton btnSupplyProducts = new JButton("Supply Products");
        btnSupplyProducts.addActionListener(e -> supplyProducts());
        buttonPanel.add(btnSupplyProducts);

        JButton btnTransferEmployee = new JButton("Transfer Employee");
        btnTransferEmployee.addActionListener(e -> transferEmployee());
        buttonPanel.add(btnTransferEmployee);

        JButton btnCustomerSupport = new JButton("Customer Support");
        btnCustomerSupport.addActionListener(e -> handleCustomerSupport());
        buttonPanel.add(btnCustomerSupport);

        JButton btnGenerateReports = new JButton("Generate Reports");
        btnGenerateReports.addActionListener(e -> generateReports());
        buttonPanel.add(btnGenerateReports);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void sellProducts() {
        String productId = JOptionPane.showInputDialog("Enter Product ID:");
        String branchId = JOptionPane.showInputDialog("Enter Branch ID:");
        String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
        String quantity = JOptionPane.showInputDialog("Enter Quantity:");
        String price = JOptionPane.showInputDialog("Enter Price per Item:");

    }

    public void supplyProducts() {
        String productId = JOptionPane.showInputDialog("Enter Product ID:");
        String sourceBranchId = JOptionPane.showInputDialog("Enter Source Branch ID:");
        String destinationBranchId = JOptionPane.showInputDialog("Enter Destination Branch ID:");
        String quantity = JOptionPane.showInputDialog("Enter Quantity:");
        String transferPerson = JOptionPane.showInputDialog("Enter Name of Transfer Person:");

    }

    public void transferEmployee() {
        String employeeId = JOptionPane.showInputDialog("Enter Employee ID:");
        String oldBranchId = JOptionPane.showInputDialog("Enter Old Branch ID:");
        String newBranchId = JOptionPane.showInputDialog("Enter New Branch ID:");
        String department = JOptionPane.showInputDialog("Enter New Department (if applicable):");
        String reason = JOptionPane.showInputDialog("Enter Reason for Transfer:");

    }

    public void handleCustomerSupport() {
        String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
        String productId = JOptionPane.showInputDialog("Enter Product ID:");
        String description = JOptionPane.showInputDialog("Enter Issue Description:");

    }

    public void generateReports() {
        String reportType = JOptionPane.showInputDialog("Enter Report Type (1 for Sales, 2 for Stock, 3 for Customer Ticket, 4 for Customer Satisfaction):");

    }
}
