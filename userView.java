
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * The UserView class acts as the view in the Model-View-Controller (MVC) pattern.
 * It is responsible for handling the Graphical User Interface and inputs needed
 * for the database application to work.
 */
public class userView {
    // Main Panel
    private JFrame frame;

    // Master Panel
    private JPanel mainUIPanel;
    private JLabel titleLabel;
    private JButton recordsManagementBtn;
    private JButton transactionsBtn;
    private JButton generateReportsBtn;

    // Transactions
    private JLabel transactionLabel;
    private JButton btnSellProducts;
    private JButton btnSupplyProducts;
    private JButton btnTransferEmployee;
    private JButton btnCustomerSupport;
    private JButton transactionsBackBtn;

    // idk yet
    private JButton btnGenerateReports;
    private JButton exitButton;
    private JButton backButton;

    // idk yet
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

        // Master Panel UI
        mainUIPanel = new JPanel();
        mainUIPanel = new JPanel(new GridLayout(4, 1, 0, 10));

        Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder, emptyBorder);
        mainUIPanel.setBorder(compoundBorder);

        titleLabel = new JLabel("Computer Retail Store Management");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(25f));

        recordsManagementBtn = new JButton("Records Management");
        recordsManagementBtn.setFocusable(false);
        recordsManagementBtn.setBounds(0, 0, 100, 100);

        transactionsBtn = new JButton("Transactions");
        transactionsBtn.setFocusable(false);
        transactionsBtn.setBounds(0, 0, 100, 100);

        generateReportsBtn = new JButton("Generate Reports");
        generateReportsBtn.setFocusable(false);
        generateReportsBtn.setBounds(0, 0, 100, 100);

        mainUIPanel.add(titleLabel);
        mainUIPanel.add(recordsManagementBtn);
        mainUIPanel.add(transactionsBtn);
        mainUIPanel.add(generateReportsBtn);

        // Transactions
        transactionLabel = new JLabel("Transactions");
        btnSellProducts = new JButton("Sell Products");
        btnSupplyProducts = new JButton("Supply Products");
        btnTransferEmployee = new JButton("Transfer Employee");
        btnCustomerSupport = new JButton("Customer Support");
        transactionsBackBtn = new JButton("Back");

        // Transfer Employee
        applyTrnsfrButton = new JButton("Apply");
        discardTrnsfrButton = new JButton("Discard");
        backButton = new JButton("Back");

        // Adds MainUIPanel to frame.
        frame.add(mainUIPanel);
        frame.setVisible(true);
    }

    // Set Action Listeners
    public void setRecordsManagementBtnListener(ActionListener actionListener) {
        recordsManagementBtn.addActionListener(actionListener);
    }

    public void setTransactionsBtnListener(ActionListener actionListener) {
        transactionsBtn.addActionListener(actionListener);
    }

    public void setGenerateReportsBtnListener(ActionListener actionListener) {
        generateReportsBtn.addActionListener(actionListener);
    }

    // ----
    public void backjButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addGenerateReportsListener(ActionListener listener) {
        btnGenerateReports.addActionListener(listener);
    }
    // ----

    public void addSellProductsListener(ActionListener listener) {
        btnSellProducts.addActionListener(listener);
    }

    public void addSupplyProductsListener(ActionListener listener) {
        btnSupplyProducts.addActionListener(listener);
    }

    public void addCustomerSupportListener(ActionListener listener) {
        btnCustomerSupport.addActionListener(listener);
    }

    public void applyTransferEmployeeListener(ActionListener listener) {
        applyTrnsfrButton.addActionListener(listener);
    }

    public void setTransactionsBackBtnListener(ActionListener actionListener) {
        transactionsBackBtn.addActionListener(actionListener);
    }

    // ---
    public void discardTransferEmployeeListener(ActionListener listener) {
        discardTrnsfrButton.addActionListener(listener);
    }

    public void addTransferEmployeeListener(ActionListener listener) {
        btnTransferEmployee.addActionListener(listener);
    }
    // ---

    // Display Methods
    public void displayMainScreen() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(mainUIPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void displayTransactions() {
        // Transaction UI
        JPanel transactionsUIPanel = new JPanel();
        transactionsUIPanel = new JPanel(new GridLayout(6, 1, 0, 10));

        Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder, emptyBorder);
        transactionsUIPanel.setBorder(compoundBorder);

        transactionLabel.setHorizontalAlignment(JLabel.CENTER);
        transactionLabel.setFont(titleLabel.getFont().deriveFont(25f));

        btnSellProducts.setFocusable(false);
        btnSellProducts.setBounds(0, 0, 100, 100);

        btnSupplyProducts.setFocusable(false);
        btnSupplyProducts.setBounds(0, 0, 100, 100);

        btnTransferEmployee.setFocusable(false);
        btnTransferEmployee.setBounds(0, 0, 100, 100);

        btnCustomerSupport.setFocusable(false);
        btnCustomerSupport.setBounds(0, 0, 100, 100);

        transactionsBackBtn.setFocusable(false);
        transactionsBackBtn.setBounds(0, 0, 100, 100);

        transactionsUIPanel.add(transactionLabel);
        transactionsUIPanel.add(btnSellProducts);
        transactionsUIPanel.add(btnSupplyProducts);
        transactionsUIPanel.add(btnTransferEmployee);
        transactionsUIPanel.add(btnCustomerSupport);
        transactionsUIPanel.add(transactionsBackBtn);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(transactionsUIPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void displaySellProducts() {
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

    // Getters and Setters
    public JTextField getEmployeeIdField() {
        return employeeIdField;
    }

    public JTextField getOldBranchIdField() {
        return oldBranchIdField;
    }

    public JTextField getNewBranchIdField() {
        return newBranchIdField;
    }

    public JTextField getNewJobIdField() {
        return newJobIdField;
    }

    public JTextField getDepartmentIdField() {
        return departmentIdField;
    }

    public JTextField getReasonField() {
        return reasonField;
    }

    public void disableAllMainBtns() {
        btnSellProducts.setVisible(false);
        btnSupplyProducts.setVisible(false);
        btnTransferEmployee.setVisible(false);
        btnCustomerSupport.setVisible(false);
        btnGenerateReports.setVisible(false);

    }

    public void enableAllMainBtns() {
        btnSellProducts.setVisible(true);
        btnSupplyProducts.setVisible(true);
        btnTransferEmployee.setVisible(true);
        btnCustomerSupport.setVisible(true);
        btnGenerateReports.setVisible(true);
    }

    // Verification / Error Prompts
    public void displayTransferSucess() {
        JOptionPane.showMessageDialog(frame, "Employee transfer successful", "Transfer Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayTransferFail(StringBuilder error) {
        JOptionPane.showMessageDialog(frame, error.toString(), "Transfer Fail", JOptionPane.ERROR_MESSAGE);
    }

}
