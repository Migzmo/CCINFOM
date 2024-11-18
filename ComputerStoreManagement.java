import javax.swing.*;
//the MODEL of the gui basically where the brain works
public class ComputerStoreManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_computer_store";
    private static final String DB_USER = "root"; // USE 'root' as the username
    private static final String DB_PASSWORD = ""; // ENTER YOUR MySQL PASSWORD HERE

    
    public  void sellProducts() {
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
                    "Enter New Job ID:", newJobIdField,
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

                    if (!isJobIdValid(connection, newJobId)) {
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

    public  void handleCustomerSupport() {
        String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
        String productId = JOptionPane.showInputDialog("Enter Product ID:");
        String description = JOptionPane.showInputDialog("Enter Issue Description:");

    }

    public void generateReports() {
        String reportType = JOptionPane.showInputDialog("Enter Report Type (1 for Sales, 2 for Stock, 3 for Customer Ticket, 4 for Customer Satisfaction):");

    }
}
