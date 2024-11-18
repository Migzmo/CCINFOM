
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

    //  Sell products
    private JTextField productIdField;
    private JTextField branchIdField;
    private JTextField customerIdField;
    private JTextField quantityField;
    private JTextField priceField;
    private JButton applySellButton;
    private JButton discardSellButton;

    // supply products
    private JTextField supplyIdField;
    private JTextField supplySourceBranchIdField;
    private JTextField supplyDestinationBranchIdField;
    private JTextField supplyQuantityField;
    private JTextField supplyTransferPerson;
    private JButton applySupplyButton;
    private JButton discardSupplyButton;
    
    //customer support
    private JTextField cscustomerIDField;
    private JTextField csproductIDField;
    private JTextArea csdescriptionField;
    private JButton applyCustomerSupportButton;
    private JButton discardCustomerSupportButton;

    // idk yet
    private JButton exitButton;
    private JButton backButtonToTrsnc;

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
        backButtonToTrsnc = new JButton("Back");

        // sell products 
        
        applySellButton = new JButton("Apply");
        discardSellButton = new JButton("Discard");

        //supply products
        applySupplyButton = new JButton("Apply");
        discardSupplyButton = new JButton("Discard");

        //customer support
        applyCustomerSupportButton = new JButton("Apply");
        discardCustomerSupportButton = new JButton("Discard");

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
    public void setApplyCustomerSupportButton(ActionListener listener) {
        applyCustomerSupportButton.addActionListener(listener);
    }
    public void setDiscardCustomerSupportButton(ActionListener listener) {
        discardCustomerSupportButton.addActionListener(listener);
    }
    public void backButtonTrnscListener(ActionListener listener) {
        backButtonToTrsnc.addActionListener(listener);
    }

    public void setApplySellButton(ActionListener listener) {
        applySellButton.addActionListener(listener);
    }

    public void setDiscardSellButton(ActionListener listener) {
        discardSellButton.addActionListener(listener);
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
    public void setApplySupplyButtonListener(ActionListener actionListener) {
        applySupplyButton.addActionListener(actionListener);
    }
    public void setDiscardSupplyButtonListener(ActionListener actionListener) {
        discardSupplyButton.addActionListener(actionListener);
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

    public void displaySupplyProducts() {
        JLabel productIdLabel = new JLabel("Supply Products");
        productIdLabel.setHorizontalAlignment(JLabel.CENTER);
        productIdLabel.setFont(productIdLabel.getFont().deriveFont(30f));

        supplyIdField = new JTextField();
        supplySourceBranchIdField = new JTextField();
        supplyDestinationBranchIdField = new JTextField();
        supplyQuantityField = new JTextField();
        supplyTransferPerson = new JTextField();

        JPanel sellProductMainPanel = new JPanel(new BorderLayout());
        sellProductMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        inputPanel.add(new JLabel("Product ID:"));
        inputPanel.add(supplyIdField);
        inputPanel.add(new JLabel("Source Branch ID:"));
        inputPanel.add(supplySourceBranchIdField);
        inputPanel.add(new JLabel("Destination Branch ID:"));
        inputPanel.add( supplyDestinationBranchIdField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(supplyQuantityField);
        inputPanel.add(new JLabel("Name of Transfer Person:"));
        inputPanel.add(supplyTransferPerson);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      
        buttonPanel.add(applySupplyButton);
        buttonPanel.add(discardSupplyButton);
        buttonPanel.add(backButtonToTrsnc);
        sellProductMainPanel.add(productIdLabel, BorderLayout.NORTH);
        sellProductMainPanel.add(inputPanel, BorderLayout.CENTER);
        sellProductMainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(sellProductMainPanel);
        frame.revalidate();
        frame.repaint();
    }

    public void displaySellProducts() {
        JLabel productIdLabel = new JLabel("Sell Products");
        productIdLabel.setHorizontalAlignment(JLabel.CENTER);
        productIdLabel.setFont(productIdLabel.getFont().deriveFont(30f));

        productIdField = new JTextField();
        branchIdField = new JTextField();
        customerIdField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        
        JPanel sellProductMainPanel = new JPanel(new BorderLayout());
        sellProductMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        inputPanel.add(new JLabel("Product ID:"));
       

        inputPanel.add(productIdField);
        inputPanel.add(new JLabel("Branch ID:"));
        inputPanel.add(branchIdField);
        inputPanel.add(new JLabel("Customer ID:"));
        inputPanel.add(customerIdField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Price per Item:"));
        inputPanel.add(priceField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      
        buttonPanel.add(applySellButton);
        buttonPanel.add(discardSellButton);
        buttonPanel.add(backButtonToTrsnc);
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
        BtnTrsfrPanel.add(backButtonToTrsnc);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(transferEmployeePanel, BorderLayout.CENTER);
        frame.getContentPane().add(BtnTrsfrPanel, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }
    public void displayCustomerSupport() {
        JLabel productIdLabel = new JLabel("Customer Support");
        productIdLabel.setHorizontalAlignment(JLabel.CENTER);
        productIdLabel.setFont(productIdLabel.getFont().deriveFont(30f));

        cscustomerIDField = new JTextField();
        csproductIDField = new JTextField();
        csdescriptionField = new JTextArea();
        
        

        JPanel sellProductMainPanel = new JPanel(new BorderLayout());
        sellProductMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        inputPanel.add(new JLabel("Customer ID:"));
        inputPanel.add(cscustomerIDField);
        inputPanel.add(new JLabel("Product ID:"));
        inputPanel.add(csproductIDField);
        inputPanel.add(new JLabel("description ID:"));
        inputPanel.add(csdescriptionField);
       
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      
        buttonPanel.add(applyCustomerSupportButton);
        buttonPanel.add(discardCustomerSupportButton);
        buttonPanel.add(backButtonToTrsnc);
        sellProductMainPanel.add(productIdLabel, BorderLayout.NORTH);
        sellProductMainPanel.add(inputPanel, BorderLayout.CENTER);
        sellProductMainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(sellProductMainPanel);
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
        recordsManagementBtn.setEnabled(false);
        transactionsBtn.setEnabled(false);
        generateReportsBtn.setEnabled(false);
        

    }

    public void enableAllMainBtns() {
        recordsManagementBtn.setEnabled(true);
        transactionsBtn.setEnabled(true);
        generateReportsBtn.setEnabled(true);
    }

    // Verification / Error Prompts
    public void displayTransferSucess() {
        JOptionPane.showMessageDialog(frame, "Employee transfer successful", "Transfer Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayTransferFail(StringBuilder error) {
        JOptionPane.showMessageDialog(frame, error.toString(), "Transfer Fail", JOptionPane.ERROR_MESSAGE);
    }

    public JTextField getProductIdField() {
        return productIdField;
    }

    public JTextField getBranchIdField() {
        return branchIdField;
    }

    public JTextField getCustomerIdField() {
        return customerIdField;
    }

    public JTextField getQuantityField() {
        return quantityField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JTextField getSupplyIdField() {
        return supplyIdField;
    }

    public JTextField getSupplySourceBranchIdField() {
        return supplySourceBranchIdField;
    }

    public JTextField getSupplyDestinationBranchIdField() {
        return supplyDestinationBranchIdField;
    }

    public JTextField getSupplyQuantityField() {
        return supplyQuantityField;
    }

    public JTextField getSupplyPriceField() {
        return supplyTransferPerson;
    }

    public JTextField getCscustomerIDField() {
        return cscustomerIDField;
    }

    public JTextField getCsproductIDField() {
        return csproductIDField;
    }

    public JTextArea getCsdescriptionField() {
        return csdescriptionField;
    }

    

}
