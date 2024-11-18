import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    public static boolean validTransfer (String employeeId, String oldBranchId, String newBranchId, String newJobId, String departmentId, String reason, StringBuilder error) {
        boolean valid = true;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            

            if (!isEmployeeIdValid(connection, employeeId)) {
                error.append("Employee ID does not exist. Please try again.");
                valid = false;
            }
            if (!isBranchIdValid(connection, oldBranchId)) {
                error.append("Error: Old Branch ID does not exist. Please try again.");
                valid = false;
            }
            if (!isBranchIdValid(connection, newBranchId)) {
                error.append("Error: New Branch ID does not exist. Please try again.");
                valid = false;
            }
            if (!isJobIdValid(connection, newJobId)) {
                error.append("Error: Job ID does not exist. Please try again.");
                valid = false;
            }
            if (!isDepartmentIdValid(connection, departmentId) && (departmentId != null) && !departmentId.equals("0")) {
                error.append( "Error: Department ID does not exist. Please try again.");
                valid = false;
            }
            if(!valid){
                return false;
            }
        
        } catch (Exception ex) {
            error.append("Error: ").append(ex.getMessage());
            return false;

        }
                return valid;
    }
    public static boolean transferEmployee(String employeeId, String oldBranchId, String newBranchId, String newJobId, String departmentId, String reason) {

        int option; 
        boolean validInputs; 
	     
    
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            

            
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
        
                return true;
            
        } catch (Exception ex) {
            return false;
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
