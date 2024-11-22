import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/**
 * The ComputerStoreManagement class provides methods to manage a collection of computer stores.
 * It includes functionality for creating, reading, updating, and deleting records in the database.
 * This class interacts with a MySQL database to perform various operations related to employees,
 * products, branches, customers, and transactions.
 */
public class ComputerStoreManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_computer_store";
    private static final String DB_USER = "root"; // USE 'root' as the username
    private static final String DB_PASSWORD = ""; // ENTER YOUR MySQL PASSWORD HERE

    /* 
        *DELETE THIS WHEN ABT TO PASS*
        Temp Code Structure:
        1. Getters / Setters
        2. Checkers
        3. CRUD
        4. Transactions
        5. Reports
    */ 
    
    // ----- Getters / Setters ----- 

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

    // ----- Checkers -----

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


    // ---- CRUD -----

    // Creates a new employee record in the database. 
    public boolean createEmployee(String firstName, String lastName, String branchId, String jobId, String departmentId, String hireDate) {
        // Establish a connection to the database using the provided URL, username, and password.
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                // Query to get the maximum employee_id from the employees table
                String getEmployeeIdQuery = "SELECT MAX(employee_id) FROM employees";
                int nextEmpId = 1;  // Default value if the table is empty
                
                // Execute the query to get the maximum employee_id
                try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(getEmployeeIdQuery)) {
                    if (resultSet.next()) {
                        nextEmpId = resultSet.getInt(1) + 1;  // Increment last employee_id
                    }
                }
        
                // Insert the new transfer record with the incremented emp_transfer_id
                String query = "INSERT INTO Employees (employee_id, employee_firstname, employee_lastname, branch_id, job_id, department_id, hire_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
                
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, nextEmpId);
                    preparedStatement.setString(2, firstName);
                    preparedStatement.setString(3, lastName);
                    preparedStatement.setInt(4, Integer.parseInt(branchId));
                    preparedStatement.setInt(5, Integer.parseInt(jobId));
                    preparedStatement.setInt(6, Integer.parseInt(departmentId));
                    preparedStatement.setDate(7, Date.valueOf(hireDate));
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Added Successfully to the Employee Record.");
                }
        
                // Return true if the operation was successful.
                return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean readEmployee(String employeeId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String query = "SELECT * FROM Employees WHERE employee_id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, Integer.parseInt(employeeId));
                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        String name = rs.getString("employee_firstname") + " " + rs.getString("employee_lastname");
                        JOptionPane.showMessageDialog(null, "Employee Found: " + name);
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee Not Found!");
                    }
                }
                return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean updateEmployee(String employeeId, String firstName, String lastName, String branchId, String jobId, String departmentId, String hireDate) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String query = "UPDATE Employees SET employee_firstname = ?, employee_lastname = ?, branch_id = ?, job_id = ?, department_id = ?, hire_date = ? WHERE employee_id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setInt(3, Integer.parseInt(branchId));
                    preparedStatement.setInt(4, Integer.parseInt(jobId)); // Assuming job_id is an integer, adjust accordingly
                    preparedStatement.setInt(5, Integer.parseInt(departmentId)); // Assuming department_id is an integer
                    preparedStatement.setDate(6, Date.valueOf(hireDate));
                    preparedStatement.setInt(7, Integer.parseInt(employeeId));
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Employee Updated Successfully!");
                }
                return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean deleteEmployee(String employeeId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "DELETE FROM Employees WHERE employee_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Integer.parseInt(employeeId));
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!");
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // ----- Transactions ------
    
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

    public boolean validTransfer(String employeeId, String newBranchId, String newJobId, String departmentId, String reason, StringBuilder error) {
        boolean valid = true;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            

            if (!isEmployeeIdValid(connection, employeeId)) {
                error.append("Employee ID does not exist. Please try again.");
                valid = false;
            }
            if (!isBranchIdValid(connection, newBranchId)) {
                error.append("Error: New Branch ID does not exist. Please try again.");
                valid = false;
            }
            if (!isJobIdValid(connection, newJobId) && (newJobId != null) && !newJobId.equals("0")) {
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
    
    public boolean transferEmployee(String employeeId, String newBranchId, String newJobId, String departmentId, String reason) {
    
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            
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
                String query = "INSERT INTO employeetransfers (emp_transfer_id, employee_id, new_branch_id, effective_date, new_job_id, new_department_id, reason) " +
                            "VALUES (?, ?, ?, ?, NOW(), ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, nextEmpTransferId);  // Set the incremented emp_transfer_id
                    preparedStatement.setInt(2, Integer.parseInt(employeeId));
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
    
    public void handleCustomerSupport() {
        String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
        String productId = JOptionPane.showInputDialog("Enter Product ID:");
        String description = JOptionPane.showInputDialog("Enter Issue Description:");

    }

    // ----- Reports -----

    public boolean generateStockReport(String branchId, String month, String year) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT cp.product_id, cp.product_name, cp.classification, cp.stock - IFNULL(SUM(s.quantity), 0) AS remaining_stock " +
                           "FROM ComputerParts cp " +
                           "LEFT JOIN Sales s ON cp.product_id = s.product_id AND cp.branch_id = s.branch_id AND YEAR(s.sale_date) <= ? AND MONTH(s.sale_date) <= ? " +
                           "WHERE cp.branch_id = ? " +
                           "GROUP BY cp.product_id " +
                           "ORDER BY cp.product_name";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Integer.parseInt(year));
                preparedStatement.setInt(2, Integer.parseInt(month));
                preparedStatement.setInt(3, Integer.parseInt(branchId));
                ResultSet rs = preparedStatement.executeQuery();
                StringBuilder report = new StringBuilder("Branch Stock Report:\n");
                while (rs.next()) {
                    report.append("Product ID: ").append(rs.getString("product_id"))
                          .append("\nProduct Name: ").append(rs.getInt("product_name"))
                          .append("\nClassification: ").append(rs.getInt("classification"))
                          .append("\nRemaining Number of Stocks: ").append(rs.getInt("remaining_stock"))
                          .append("\n");
                }
                JOptionPane.showMessageDialog(null, report.toString());   
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
