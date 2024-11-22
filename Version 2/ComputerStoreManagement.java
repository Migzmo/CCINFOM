package version1;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Arrays;

public class ComputerStoreManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/draft_computer_store";
    private static final String DB_USER = "root"; // USE 'root' as the username
    private static final String DB_PASSWORD = "6969"; // ENTER YOUR MySQL PASSWORD HERE

    public static boolean createEmployee(String firstName, String lastName, String branchId, String jobId, String departmentId, String hireDate) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    // Get the last employee_id from the employees table
                    String getEmployeeIdQuery = "SELECT MAX(employee_id) FROM employees";
                    int nextEmpId = 1;  // Default value if the table is empty
                    
                    try (Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(getEmployeeIdQuery)) {
                        if (resultSet.next()) {
                            nextEmpId = resultSet.getInt(1) + 1;  // Increment last employee_id
                        }
                    }
            
                    // Insert the new transfer record with the incremented emp_transfer_id
                    String query = "INSERT INTO Employees (employee_firstname, employee_lastname, branch_id, job_id, department_id, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
                    
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, firstName);
                        preparedStatement.setString(2, lastName);
                        preparedStatement.setInt(3, Integer.parseInt(branchId));
                        preparedStatement.setInt(4, Integer.parseInt(jobId));
                        preparedStatement.setInt(5, Integer.parseInt(departmentId));
                        preparedStatement.setDate(6, Date.valueOf(hireDate));
                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Added Successfully to the Employee Record.");
                    }
            
                    return true;
                
            } catch (Exception ex) {
                return false;
            }
        }
    
        public static void main(String[] args) {
            JFrame frame = new JFrame("Computer Retail Store Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());
    
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(2, 2));
    
            createEmployee("Zach", "Tabudlo", "1", "1", "1", "2024-01-01");

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

    public static void sellProducts() {
        String productId = JOptionPane.showInputDialog("Enter Product ID:");
        String branchId = JOptionPane.showInputDialog("Enter Branch ID:");
        String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
        String quantity = JOptionPane.showInputDialog("Enter Quantity:");
        String price = JOptionPane.showInputDialog("Enter Price per Item:");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO sales (branch_id, product_id, customer_id, quantity, price_per_item, total_cost) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Integer.parseInt(branchId));
                preparedStatement.setInt(2, Integer.parseInt(productId));
                preparedStatement.setInt(3, Integer.parseInt(customerId));
                preparedStatement.setInt(4, Integer.parseInt(quantity));
                preparedStatement.setDouble(5, Double.parseDouble(price));
                preparedStatement.setDouble(6, Integer.parseInt(quantity) * Double.parseDouble(price));
                preparedStatement.executeUpdate();

                // Update stock
                query = "UPDATE computerparts SET stock = stock - ? WHERE product_id = ?";
                try (PreparedStatement updateStock = connection.prepareStatement(query)) {
                    updateStock.setInt(1, Integer.parseInt(quantity));
                    updateStock.setInt(2, Integer.parseInt(productId));
                    updateStock.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Sale transaction recorded and stock updated!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void supplyProducts() {
        String productId = JOptionPane.showInputDialog("Enter Product ID:");
        String sourceBranchId = JOptionPane.showInputDialog("Enter Source Branch ID:");
        String destinationBranchId = JOptionPane.showInputDialog("Enter Destination Branch ID:");
        String quantity = JOptionPane.showInputDialog("Enter Quantity:");
        String transferPerson = JOptionPane.showInputDialog("Enter Name of Transfer Person:");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE computerparts SET stock = stock - ? WHERE product_id = ? AND branch_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Integer.parseInt(quantity));
                preparedStatement.setInt(2, Integer.parseInt(productId));
                preparedStatement.setInt(3, Integer.parseInt(sourceBranchId));
                preparedStatement.executeUpdate();

                query = "UPDATE computerparts SET stock = stock + ? WHERE product_id = ? AND branch_id = ?";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(query)) {
                    preparedStatement2.setInt(1, Integer.parseInt(quantity));
                    preparedStatement2.setInt(2, Integer.parseInt(productId));
                    preparedStatement2.setInt(3, Integer.parseInt(destinationBranchId));
                    preparedStatement2.executeUpdate();
                }

                query = "INSERT INTO product_transfers (product_id, source_branch_id, destination_branch_id, quantity, transfer_person, transfer_date) VALUES (?, ?, ?, ?, ?, NOW())";
                try (PreparedStatement logTransfer = connection.prepareStatement(query)) {
                    logTransfer.setInt(1, Integer.parseInt(productId));
                    logTransfer.setInt(2, Integer.parseInt(sourceBranchId));
                    logTransfer.setInt(3, Integer.parseInt(destinationBranchId));
                    logTransfer.setInt(4, Integer.parseInt(quantity));
                    logTransfer.setString(5, transferPerson);
                    logTransfer.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Product transfer recorded!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void transferEmployee() {
        JTextField employeeIdField = new JTextField();
        JTextField oldBranchIdField = new JTextField();
        JTextField newBranchIdField = new JTextField();
        JTextField newJobIdField = new JTextField();
        JTextField departmentIdField = new JTextField();
        JTextField reasonField = new JTextField();

        int option; 
        boolean validInputs; 
	    String employeeId = null;
        String oldBranchId = null;
        String newBranchId = null;
        String newJobId = null;
        String departmentId = null;
        String reason = null;  
    
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            do {
                Object[] message = {
                    "Enter Employee ID:", employeeIdField,
                    "Enter Old Branch ID:", oldBranchIdField,
                    "Enter New Branch ID:", newBranchIdField,
                    "Enter New Job ID (if applicable)\nOtherwise, enter 0:", newJobIdField,
                    "Enter New Department (if applicable)\nOtherwise, enter 0:", departmentIdField,
                    "Enter Reason for Transfer:", reasonField
                };

                option = JOptionPane.showConfirmDialog(null, message, "Transfer Employee", JOptionPane.OK_CANCEL_OPTION);
                validInputs = true;
                employeeId = employeeIdField.getText();
                oldBranchId = oldBranchIdField.getText();
                newBranchId = newBranchIdField.getText();
                newJobId = newJobIdField.getText();
                departmentId = departmentIdField.getText();
                reason = reasonField.getText();

                // For Input Checking:
                if (option == JOptionPane.OK_OPTION) {
                    String[] warning = {
                        "Invalid Input/s. Please try again."
                    };
                
                    if (!isEmployeeIdValid(connection, employeeId)) {
                        validInputs = false;
                        warning = Arrays.copyOf(warning, warning.length + 1);
                        warning[warning.length - 1] = "Error: Employee ID does not exist.";
                    }

                    if (!isBranchIdValid(connection, oldBranchId)) {
                        validInputs = false;
                        warning = Arrays.copyOf(warning, warning.length + 1);
                        warning[warning.length - 1] = "Error: Old Branch ID does not exist.";
                    }

                    if (!isBranchIdValid(connection, newBranchId)) {
                        validInputs = false;
                        warning = Arrays.copyOf(warning, warning.length + 1);
                        warning[warning.length - 1] = "Error: New Branch ID does not exist.";
                    }

                    if (!isJobIdValid(connection, newJobId) && (newJobId != null) && !newJobId.equals("0")) {
                        validInputs = false;
                        warning = Arrays.copyOf(warning, warning.length + 1);
                        warning[warning.length - 1] = "Error: Job ID does not exist.";
                    }

                    if (!isDepartmentIdValid(connection, departmentId) && (departmentId != null) && !departmentId.equals("0")) {
                        validInputs = false;
                        warning = Arrays.copyOf(warning, warning.length + 1);
                        warning[warning.length - 1] = "Error: Department ID does not exist.";
                    }
                    
                    if (!validInputs){
                        JOptionPane.showMessageDialog(null, warning);
                    }
                }

            } while (!validInputs && option == JOptionPane.OK_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                if ((departmentId == null) || departmentId.equals("0") || departmentId.trim().isEmpty()) {
                    // If department ID is blank, use the current department_id from the employee record
                    departmentId = getCurrentDepartmentId(connection, employeeId);
                }

                if ((newJobId == null) || newJobId.equals("0") || newJobId.trim().isEmpty()) {
                    // If job ID is blank, use the current job_id from the employee record
                    newJobId = getCurrentJobId(connection, employeeId);
                }

                // Get the last emp_transfer_id from the employeetransfers table
                String getLastEmpTransferIdQuery = "SELECT MAX(emp_transfer_id) FROM employeetransfers";
                int nextEmpTransferId = 1;  // Default value if the table is empty
                
                try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(getLastEmpTransferIdQuery)) {
                    if (resultSet.next()) {
                        nextEmpTransferId = resultSet.getInt(1) + 1;  // Increment last emp_transfer_id
                    }
                }
        
                // Insert the new transfer record with the incremented emp_transfer_id
                String query = "INSERT INTO employeetransfers (emp_transfer_id, employee_id, old_branch_id, new_branch_id, effective_date, new_job_id, new_department_id, reason) " +
                            "VALUES (?, ?, ?, ?, NOW(), ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, nextEmpTransferId);  // Set the incremented emp_transfer_id
                    preparedStatement.setInt(2, Integer.parseInt(employeeId));
                    preparedStatement.setInt(3, Integer.parseInt(oldBranchId));
                    preparedStatement.setInt(4, Integer.parseInt(newBranchId));
                    preparedStatement.setString(5, newJobId);
                    preparedStatement.setInt(6, Integer.parseInt(departmentId));
                    preparedStatement.setString(7, reason);
                    preparedStatement.executeUpdate();
                }
        
                // Update employee record
                query = "UPDATE employees SET branch_id = ?, job_id = ?, department_id = ? WHERE employee_id = ?";
                try (PreparedStatement updateEmployee = connection.prepareStatement(query)) {
                    updateEmployee.setInt(1, Integer.parseInt(newBranchId));
                    updateEmployee.setString(2, newJobId);
                    updateEmployee.setInt(3, Integer.parseInt(departmentId));
                    updateEmployee.setInt(4, Integer.parseInt(employeeId));
                    updateEmployee.executeUpdate();
                }
        
                JOptionPane.showMessageDialog(null, "Employee transfer recorded!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    // Method to check if employeeId exists in the database
    private static boolean isEmployeeIdValid(Connection connection, String employeeId) {
        String query = "SELECT COUNT(*) FROM employees WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(employeeId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (Exception ex) {
            // Handle exception if needed
        }
        // JOptionPane.showMessageDialog(null, "Error: Employee ID does not exist. Please try again.");
        return false;
    }
    
    // Method to check if branchId exists in the database
    private static boolean isBranchIdValid(Connection connection, String branchId) {
        String query = "SELECT COUNT(*) FROM branches WHERE branch_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(branchId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (Exception ex) {
            // Handle exception if needed
        }
        // JOptionPane.showMessageDialog(null, "Error: Branch ID does not exist. Please try again.");
        return false;
    }
    
    // Method to check if new_job_id exists in the database
    private static boolean isJobIdValid(Connection connection, String jobId) {
        String query = "SELECT COUNT(*) FROM jobs WHERE job_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, jobId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (Exception ex) {
            // Handle exception if needed
        }
        return false;
    }

    // Method to check if departmentId exists in the database
    private static boolean isDepartmentIdValid(Connection connection, String departmentId) {
        String query = "SELECT COUNT(*) FROM departments WHERE department_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(departmentId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (Exception ex) {
            // Handle exception if needed
        }
        // JOptionPane.showMessageDialog(null, "Error: Department ID does not exist. Please try again.");
        return false;
    }
    
    // Method to get the current department_id of the employee
    private static String getCurrentJobId(Connection connection, String employeeId) {
        String query = "SELECT job_id FROM employees WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(employeeId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("job_id");
                }
            }
        } catch (Exception ex) {
            // Handle exception if needed
        }
        return null; // Return null if no department is found or an error occurs
    }

    // Method to get the current department_id of the employee
    private static String getCurrentDepartmentId(Connection connection, String employeeId) {
        String query = "SELECT department_id FROM employees WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(employeeId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("department_id");
                }
            }
        } catch (Exception ex) {
            // Handle exception if needed
        }
        return null; // Return null if no department is found or an error occurs
    }
    
    public static void handleCustomerSupport() {
        String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
        String productId = JOptionPane.showInputDialog("Enter Product ID:");
        String description = JOptionPane.showInputDialog("Enter Issue Description:");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO customer_support_tickets (customer_id, product_id, issue_description, status, ticket_date) VALUES (?, ?, ?, 'In Progress', NOW())";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Integer.parseInt(customerId));
                preparedStatement.setInt(2, Integer.parseInt(productId));
                preparedStatement.setString(3, description);
                preparedStatement.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Customer support ticket created!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void generateReports() {
        String reportType = JOptionPane.showInputDialog("Enter Report Type (1 for Sales, 2 for Stock, 3 for Customer Ticket, 4 for Customer Satisfaction):");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = null;

            switch (reportType) {
                case "1":
                    query = "SELECT DATE(transaction_date) AS date, SUM(total_cost) AS total_sales, AVG(total_cost) AS average_sales FROM sales GROUP BY DATE(transaction_date)";
                    break;
                case "2":
                    query = "SELECT product_id, SUM(stock) AS total_stock FROM computerparts GROUP BY product_id";
                    break;
                case "3":
                    query = "SELECT DATE(ticket_date) AS date, COUNT(*) AS total_tickets FROM customer_support_tickets GROUP BY DATE(ticket_date)";
                    break;
                case "4":
                    query = "SELECT product_id, AVG(rating) AS average_rating FROM reviews GROUP BY product_id";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid report type!");
                    return;
            }

            try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
                StringBuilder report = new StringBuilder();
                while (resultSet.next()) {
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        report.append(resultSet.getMetaData().getColumnLabel(i)).append(": ").append(resultSet.getString(i)).append("\n");
                    }
                    report.append("\n");
                }
                JOptionPane.showMessageDialog(null, report.toString());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
