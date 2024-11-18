import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
//the VIEW of the gui basically where the user interacts
public class userView {
    private JFrame frame;
    private JPanel buttonPanel;
    private JButton btnSellProducts;
    private JButton btnSupplyProducts;
    private JButton btnTransferEmployee;
    private JButton btnCustomerSupport;
    private JButton btnGenerateReports;
    private JButton exitButton;
    private JButton backButton;
    
    private JPanel BtnTrsfrPanel;
    private JButton applyTrnsfrButton;
    private JButton discardTrnsfrButton; 
    private JTextField employeeIdField;
    private JTextField oldBranchIdField;
    private JTextField newBranchIdField;
    private JTextField newJobIdField;
    private JTextField departmentIdField;
    private JTextField reasonField;



    public userView() {
        frame = new JFrame("Computer Retail Store Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));

        btnSellProducts = new JButton("Sell Products");
        buttonPanel.add(btnSellProducts);

        btnSupplyProducts = new JButton("Supply Products");
        buttonPanel.add(btnSupplyProducts);

        btnTransferEmployee = new JButton("Transfer Employee");
        buttonPanel.add(btnTransferEmployee);

        btnCustomerSupport = new JButton("Customer Support");
        buttonPanel.add(btnCustomerSupport);

        btnGenerateReports = new JButton("Generate Reports");
        buttonPanel.add(btnGenerateReports);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        applyTrnsfrButton = new JButton("Apply");
        discardTrnsfrButton = new JButton("Discard");
        backButton = new JButton("Back");
        
    }
    //listeners
    public void addSellProductsListener(ActionListener listener) {
        btnSellProducts.addActionListener(listener);
    }
    public void backjButtonListener(ActionListener listener){
        backButton.addActionListener(listener);
    }

    public void addSupplyProductsListener(ActionListener listener) {
        btnSupplyProducts.addActionListener(listener);
    }

   

    public void addCustomerSupportListener(ActionListener listener) {
        btnCustomerSupport.addActionListener(listener);
    }

    public void addGenerateReportsListener(ActionListener listener) {
        btnGenerateReports.addActionListener(listener);
    }
    public void applyTransferEmployeeListener(ActionListener listener){
        applyTrnsfrButton.addActionListener(listener);
    }
    public void discardTransferEmployeeListener(ActionListener listener){
        discardTrnsfrButton.addActionListener(listener);
    }
    public void displayMainScreen() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
    public void displaySellProducts(){
        JLabel productIdLabel = new JLabel("Sell Products");
    productIdLabel.setHorizontalAlignment(JLabel.CENTER);
    productIdLabel.setFont(productIdLabel.getFont().deriveFont(30f));

    JPanel sellProductMainPanel = new JPanel(new BorderLayout());
    sellProductMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

    JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

    inputPanel.add(new JLabel("Product ID:"));
    JTextField productIdField = new JTextField();
    inputPanel.add(productIdField);

    inputPanel.add(new JLabel("Branch ID:"));
    JTextField branchIdField = new JTextField();
    inputPanel.add(branchIdField);

    inputPanel.add(new JLabel("Customer ID:"));
    JTextField customerIdField = new JTextField();
    inputPanel.add(customerIdField);

    inputPanel.add(new JLabel("Quantity:"));
    JTextField quantityField = new JTextField();
    inputPanel.add(quantityField);

    inputPanel.add(new JLabel("Price per Item:"));
    JTextField priceField = new JTextField();
    inputPanel.add(priceField);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    JButton applyButton = new JButton("Apply");
    JButton discardButton = new JButton("Discard");
    buttonPanel.add(applyButton);
    buttonPanel.add(discardButton);

    sellProductMainPanel.add(productIdLabel, BorderLayout.NORTH);
    sellProductMainPanel.add(inputPanel, BorderLayout.CENTER);
    sellProductMainPanel.add(buttonPanel, BorderLayout.SOUTH);

    frame.getContentPane().removeAll();
    frame.getContentPane().add(sellProductMainPanel);
    frame.revalidate();
    frame.repaint();




    }

    public void addTransferEmployeeListener(ActionListener listener) {
        btnTransferEmployee.addActionListener(listener);
    }
    public JTextField getEmployeeIdField(){
        return employeeIdField;
    }
    public JTextField getOldBranchIdField(){
        return oldBranchIdField;
    }
    public JTextField getNewBranchIdField(){
        return newBranchIdField;
    }
    public JTextField getNewJobIdField(){
        return newJobIdField;
    }
    public JTextField getDepartmentIdField(){
        return departmentIdField;
    }
    public JTextField getReasonField(){
        return reasonField;
    }
    public void disableAllMainBtns(){
        btnSellProducts.setVisible(false);
        btnSupplyProducts.setVisible(false);
        btnTransferEmployee.setVisible(false);
        btnCustomerSupport.setVisible(false);
        btnGenerateReports.setVisible(false);

        
    }
    public void enableAllMainBtns(){
        btnSellProducts.setVisible(true);
        btnSupplyProducts.setVisible(true);
        btnTransferEmployee.setVisible(true);
        btnCustomerSupport.setVisible(true);
        btnGenerateReports.setVisible(true);
        
    }
    public void displayTransferEmployeeForm() {
        JPanel transferEmployeePanel = new JPanel(new GridLayout(7, 2, 10, 10));

        employeeIdField = new JTextField();
        oldBranchIdField = new JTextField();
        newBranchIdField = new JTextField();
        newJobIdField = new JTextField();
        departmentIdField = new JTextField();
        reasonField = new JTextField();

        transferEmployeePanel.add(new JLabel("Employee ID:"));
        transferEmployeePanel.add(employeeIdField);
        transferEmployeePanel.add(new JLabel("Old Branch ID:"));
        transferEmployeePanel.add(oldBranchIdField);
        transferEmployeePanel.add(new JLabel("New Branch ID:"));
        transferEmployeePanel.add(newBranchIdField);
        transferEmployeePanel.add(new JLabel("New Job ID:"));
        transferEmployeePanel.add(newJobIdField);
        transferEmployeePanel.add(new JLabel("New Department ID (if applicable):"));
        transferEmployeePanel.add(departmentIdField);
        transferEmployeePanel.add(new JLabel("Reason for Transfer:"));
        transferEmployeePanel.add(reasonField);

        BtnTrsfrPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
       
        BtnTrsfrPanel.add(applyTrnsfrButton);
        BtnTrsfrPanel.add(discardTrnsfrButton);
        BtnTrsfrPanel.add(backButton);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(transferEmployeePanel, BorderLayout.CENTER);
        frame.getContentPane().add(BtnTrsfrPanel, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();

        

        
    }

    public void displayTransferSucess(){
        JOptionPane.showMessageDialog(frame, "Employee transfer successful", "Transfer Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayTransferFail(StringBuilder error){
        JOptionPane.showMessageDialog(frame, error.toString(), "Transfer Fail", JOptionPane.ERROR_MESSAGE);
    }
    
}