
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
    //Record management Buttons

    private JButton createEmployeeBtn;
    private JButton readEmployeeBtn;
    private JButton updtEmployeeBtn;
    private JButton dltEmployeeBtn;
    private JButton backtoManagePickBtn;
    
    private JButton createEmployeeApplyBtn;
    private JButton createEmpDscrdButton;
    private JButton readEmpDscrdBtn;
    private JButton updEmpDscrdBtn;
    private JButton dltEmpDscrdBtn;
    private JButton readEmployeeApplyBtn;
    private JPanel promptPanel;
    private JButton updateEmployeeApplybtn;
    private JButton deleteEmployeeApplybtn; 
    
    private JButton cmpterPartsManageButton;
    private JButton customerRecordManageButton;
    private JButton employeeRecordManageButton;   
    private JButton branchRecorManagedButton;
    
    private JTextField createFirstNameFld;
    private JTextField createLastNameFld;
    private JTextField createbranchIdFld;
    private JTextField createJobIDfld;
    private JTextField createDepartmentIDFld;
    private JTextField createHireDateFld;

    private JTextField readEmployeeIdFld;

    private JTextField updateEmployeeIdFld;
    private JTextField updateFirstNameFld;
    private JTextField updateLastNameFld;
    private JTextField updateBranchIdFld;
    private JTextField updateJobIDfld;
    private JTextField updateDepartmentIDFld;
    private JTextField updateHireDateFld;

    private JTextField deleteEmployeeIdFld;

    
    // idk yet
    private JPanel BtnTrsfrPanel;
    private JButton applyTrnsfrButton;
    private JButton discardTrnsfrButton;
    private JTextField employeeIdField;
    
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
        // records management
        createEmployeeBtn = new JButton("Create");
        readEmployeeBtn = new JButton("Read");
        updtEmployeeBtn = new JButton("Update");
        dltEmployeeBtn = new JButton("Delete");

        cmpterPartsManageButton = new JButton("Computer Parts");
        customerRecordManageButton = new JButton("Customer Records");
        employeeRecordManageButton = new JButton("Employee Records");
        branchRecorManagedButton= new JButton("Branch Records");

        

        createEmployeeApplyBtn = new JButton("Create");
        readEmployeeApplyBtn = new JButton("Search");

        createEmpDscrdButton = new JButton("Discard");
        readEmpDscrdBtn = new JButton("Discard");
        updEmpDscrdBtn = new JButton("Discard");
        dltEmpDscrdBtn = new JButton("Discard");

        backtoManagePickBtn = new JButton("Back");
        updateEmployeeApplybtn = new JButton("Apply");
        deleteEmployeeApplybtn = new JButton("Delete");
        //create fields
        createFirstNameFld = new JTextField();
        createLastNameFld = new JTextField();
        createbranchIdFld = new JTextField();
        createJobIDfld = new JTextField();
        createDepartmentIDFld = new JTextField();
        createHireDateFld = new JTextField();
        //read fields
        readEmployeeIdFld = new JTextField();

        //update fields
        updateBranchIdFld = new JTextField();
        updateEmployeeIdFld = new JTextField();
        updateFirstNameFld = new JTextField();
        updateLastNameFld = new JTextField();
        updateJobIDfld = new JTextField();
        updateDepartmentIDFld = new JTextField();
        updateHireDateFld = new JTextField();

        //delete fields
        deleteEmployeeIdFld = new JTextField();

        createEmployeeBtn.setPreferredSize(new Dimension(150,30));
        readEmployeeBtn.setPreferredSize(new Dimension(150,30));
        updtEmployeeBtn.setPreferredSize(new Dimension(150,30));
        dltEmployeeBtn.setPreferredSize(new Dimension(150,30));

        promptPanel = new JPanel(new FlowLayout());
        promptPanel.setBackground(Color.LIGHT_GRAY);
        promptPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
    public void setcompterPartsButtonListener(ActionListener actionListener) {
        cmpterPartsManageButton.addActionListener(actionListener);
    }
    public void setcusomterRecordButtonListener(ActionListener actionListener) {
        customerRecordManageButton.addActionListener(actionListener);
    }
    public void setemployeeRecordButtonListener(ActionListener actionListener) {
        employeeRecordManageButton.addActionListener(actionListener);
    }
    public void setbranchRecordButtonListener(ActionListener actionListener) {
        branchRecorManagedButton.addActionListener(actionListener);
    }
    
    // ----
    public void setbacktoManagePickBtnListener(ActionListener actionListener) {
        backtoManagePickBtn.addActionListener(actionListener);
    }
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
    public void setCreateEmployeeButtonListener(ActionListener listener) {
        createEmployeeBtn.addActionListener(listener);
    }
    public void setReadEmployeeButtonListener(ActionListener listener) {
        readEmployeeBtn.addActionListener(listener);
    }
    public void setUpdateEmployeeButtonListener(ActionListener listener) {
        updtEmployeeBtn.addActionListener(listener);
    }
    public void setDeleteEmployeeButtonListener(ActionListener listener) {
        dltEmployeeBtn.addActionListener(listener);
    }
    public void setCreateEmployeeApplyButtonListener(ActionListener listener){
        createEmployeeApplyBtn.addActionListener(listener);
    }
    public void setReadEmployeeApplyButtonListener(ActionListener listener){
        readEmployeeApplyBtn.addActionListener(listener);
    }

    public void setCreateEmployeeDiscardButtonListener(ActionListener listener){
        createEmpDscrdButton.addActionListener(listener);
    }
    public void setReadEmployeeDiscardButtonListener(ActionListener listener){
        readEmpDscrdBtn.addActionListener(listener);
    }
    public void setUpdateEmployeeDiscardButtonListener(ActionListener listener){
        updEmpDscrdBtn.addActionListener(listener);
    }
    public void setDeleteEmployeeDiscardButtonListener(ActionListener listener){
       dltEmpDscrdBtn.addActionListener(listener);
    }

    public void setDiscardSellButton(ActionListener listener) {
        discardSellButton.addActionListener(listener);
    }
    public void setUpdateEmployeeApplyButtonListener(ActionListener listener) {
       updateEmployeeApplybtn.addActionListener(listener);
    }
    public void setDeleteEmployeeApplyButtonListener(ActionListener listener) {
        deleteEmployeeApplybtn.addActionListener(listener);
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
        
        newBranchIdField = new JTextField();
        newJobIdField = new JTextField();
        departmentIdField = new JTextField();
        reasonField = new JTextField();

        transferEmployeePanel.add(new JLabel("Employee ID:"));
        transferEmployeePanel.add(employeeIdField);
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
    public void displayPickManagement(){
    JLabel managementLabel = new JLabel("Pick What to Manage");
    managementLabel.setHorizontalAlignment(JLabel.CENTER);
    managementLabel.setFont(managementLabel.getFont().deriveFont(15f));

    JPanel managementPanel = new JPanel(new BorderLayout());
    managementPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

    // Create buttons
    

    // Create a panel for buttons and add buttons to it
    JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
    buttonPanel.add(cmpterPartsManageButton);
    buttonPanel.add(customerRecordManageButton);
    buttonPanel.add(employeeRecordManageButton);
    buttonPanel.add(branchRecorManagedButton );
    buttonPanel.add(transactionsBackBtn);

    // Add label and button panel to the management panel
    managementPanel.add(managementLabel, BorderLayout.NORTH);
    managementPanel.add(buttonPanel, BorderLayout.CENTER);

    // Add management panel to the main frame or another container
    // Assuming 'this' is a JFrame or a container

    frame.getContentPane().removeAll();
    frame.add(managementPanel, BorderLayout.CENTER);
    frame.revalidate(); 
    frame.repaint();
        
    }


    public void displayEmployeeRecordsManagement(){
        JLabel managementLabel = new JLabel("Employee Management");
        managementLabel.setHorizontalAlignment(JLabel.CENTER);
        managementLabel.setFont(managementLabel.getFont().deriveFont(15f));
        

        JPanel managementPanel = new JPanel(new BorderLayout());
        managementPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel manageRecordUiPanel = new JPanel();
        manageRecordUiPanel = new JPanel(new GridLayout(6, 1, 0, 20));
        manageRecordUiPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        createEmployeeBtn.setFocusable(false);
        readEmployeeBtn.setFocusable(false);
        updtEmployeeBtn.setFocusable(false);
        dltEmployeeBtn.setFocusable(false);

        manageRecordUiPanel.add(managementLabel);
        manageRecordUiPanel.add(createEmployeeBtn);
        manageRecordUiPanel.add(readEmployeeBtn);
        manageRecordUiPanel.add(updtEmployeeBtn);
        manageRecordUiPanel.add(dltEmployeeBtn);
        manageRecordUiPanel.add(backtoManagePickBtn);

        

        JPanel promptPlaceHolder = new JPanel();
        promptPlaceHolder.setLayout(new GridLayout(2, 1, 0, 10));
        promptPlaceHolder.setPreferredSize(new Dimension(250,80));
        promptPlaceHolder.setBackground(Color.LIGHT_GRAY);

        JLabel promptLabel = new JLabel("Select an action to perform");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        
        promptPlaceHolder.add(promptLabel);
        promptPanel.add(promptPlaceHolder);

        JSplitPane managementSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, manageRecordUiPanel, promptPanel);
        managementSplitPane.setResizeWeight(0.5);
        managementSplitPane.setDividerLocation(250);
        managementSplitPane.setEnabled(false);
        managementPanel.add(managementSplitPane);

        frame.getContentPane().removeAll();
        frame.add(managementPanel);
        frame.revalidate();
        frame.repaint();

    }
    public void displayCreateEmployeeForm() {
        // Use GridBagLayout for alignment
        JPanel newRecordPanel = new JPanel(new GridBagLayout());
        newRecordPanel.setBackground(Color.LIGHT_GRAY);
        newRecordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.anchor = GridBagConstraints.WEST; // Align labels to the left
        gbc.fill = GridBagConstraints.HORIZONTAL; // Text fields expand horizontally

        gbc.weightx = 0;
        gbc.weighty = 0;

        // Add Product ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("First name:"));

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(createFirstNameFld, gbc);

        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Last name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createLastNameFld, gbc);

        // Add Customer ID label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Branch ID:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createbranchIdFld, gbc);

        // Add Quantity label and field
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Job ID:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createJobIDfld, gbc);

        // Add Price per Item label and field
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Department ID"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createDepartmentIDFld, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Hire date:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createHireDateFld, gbc);


        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(createEmployeeApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(createEmpDscrdButton, gbc);

    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
        
        
        frame.revalidate();
        frame.repaint();
    }

    public void displayUpdateEmployeeForm() {
    // Use GridBagLayout for alignment
    JPanel newRecordPanel = new JPanel(new GridBagLayout());
    newRecordPanel.setBackground(Color.LIGHT_GRAY);
    newRecordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
    gbc.anchor = GridBagConstraints.WEST; // Align labels to the left
    gbc.fill = GridBagConstraints.HORIZONTAL; // Text fields expand horizontally

    gbc.weightx = 0;
    gbc.weighty = 0;

    // Add Employee ID label and field
    gbc.gridx = 0; gbc.gridy = 0;
    newRecordPanel.add(new JLabel("Employee ID:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1; // Allow text fields to expand horizontally
    newRecordPanel.add(updateEmployeeIdFld, gbc);

    // Add First Name label and field
    gbc.gridx = 0; gbc.gridy = 1;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("New First name:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(updateFirstNameFld, gbc);

    // Add Last Name label and field
    gbc.gridx = 0; gbc.gridy = 2;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("New Last name:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(updateLastNameFld, gbc);

    // Add Branch ID label and field
    gbc.gridx = 0; gbc.gridy = 3;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("New Branch ID:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(updateBranchIdFld, gbc);

    // Add Job ID label and field
    gbc.gridx = 0; gbc.gridy = 4;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("New Job ID:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(updateJobIDfld, gbc);

    // Add Department ID label and field
    gbc.gridx = 0; gbc.gridy = 5;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("New Department ID:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(updateDepartmentIDFld, gbc);

    // Add Hire Date label and field
    gbc.gridx = 0; gbc.gridy = 6;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("New Hire date:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(updateHireDateFld, gbc);

    // Add buttons (Create and Discard)
    gbc.gridx = 0; gbc.gridy = 7;
    gbc.gridwidth = 1;
    gbc.weightx = 0; // Buttons should not expand
    gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
    newRecordPanel.add(updateEmployeeApplybtn, gbc);

    gbc.gridx = 1;
    newRecordPanel.add(updEmpDscrdBtn, gbc);

    // Update promptPanel
    promptPanel.setLayout(new BorderLayout());
    promptPanel.removeAll();
    promptPanel.add(newRecordPanel, BorderLayout.CENTER);

    
    frame.revalidate();
    frame.repaint();
}
    public void displayReadEmployeeForm() {
        // Use GridBagLayout for alignment
        JPanel newRecordPanel = new JPanel(new GridBagLayout());
        newRecordPanel.setBackground(Color.LIGHT_GRAY);
        newRecordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.anchor = GridBagConstraints.WEST; // Align labels to the left
        gbc.fill = GridBagConstraints.HORIZONTAL; // Text fields expand horizontally

        gbc.weightx = 0;
        gbc.weighty = 0;

        // Add Product ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Employee ID:"));

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(readEmployeeIdFld, gbc);


        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy =1;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(readEmployeeApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(readEmpDscrdBtn, gbc);

    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
        
        frame.revalidate();
        frame.repaint();
    }
    public void displayDeleteEmployeeForm() {
        // Use GridBagLayout for alignment
        JPanel newRecordPanel = new JPanel(new GridBagLayout());
        newRecordPanel.setBackground(Color.LIGHT_GRAY);
        newRecordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.anchor = GridBagConstraints.WEST; // Align labels to the left
        gbc.fill = GridBagConstraints.HORIZONTAL; // Text fields expand horizontally

        gbc.weightx = 0;
        gbc.weighty = 0;

        // Add Product ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Employee ID:"));

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(createFirstNameFld, gbc);


        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy =1;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(deleteEmployeeApplybtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(dltEmpDscrdBtn, gbc);

    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
        
        frame.revalidate();
        frame.repaint();
    }


    // Getters and Setters
    public JTextField getEmployeeIdField() {
        return employeeIdField;
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

    

    public JTextField getCreateFirstNameFld() {
        return createFirstNameFld;
    }

    public JTextField getCreateLastNameFld() {
        return createLastNameFld;
    }

    public JTextField getCreatebranchIdFld() {
        return createbranchIdFld;
    }

    public JTextField getCreateJobIDfld() {
        return createJobIDfld;
    }

    public JTextField getCreateDepartmentIDFld() {
        return createDepartmentIDFld;
    }

    public JTextField getCreateHireDateFld() {
        return createHireDateFld;
    }
    public void displayCreateSuccess() {
        JOptionPane.showMessageDialog(frame, "Record created successfully", "Create Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayCreateFail() {
        JOptionPane.showMessageDialog(frame, "Record not created", "Create Fail", JOptionPane.ERROR_MESSAGE);
    }

    public JTextField getReadEmployeeIdFld() {
        return readEmployeeIdFld;
    }

    public void displayReadSuccess() {
        JOptionPane.showMessageDialog(frame, "Record found", "Read Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayReadFail() {
        JOptionPane.showMessageDialog(frame, "Record not found", "Read Fail", JOptionPane.ERROR_MESSAGE);
    }

    public JTextField getUpdateEmployeeIdFld() {
        return updateEmployeeIdFld;
    }

    public JTextField getUpdateFirstNameFld() {
        return updateFirstNameFld;
    }

    public JTextField getUpdateLastNameFld() {
        return updateLastNameFld;
    }

    public JTextField getUpdateBranchIdFld() {
        return updateBranchIdFld;
    }

    public JTextField getUpdateJobIDfld() {
        return updateJobIDfld;
    }

    public JTextField getUpdateDepartmentIDFld() {
        return updateDepartmentIDFld;
    }

    public JTextField getUpdateHireDateFld() {
        return updateHireDateFld;
    }
    public void displayUpdateSuccess() {
        JOptionPane.showMessageDialog(frame, "Record updated successfully", "Update Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayUpdateFail() {
        JOptionPane.showMessageDialog(frame, "Record not updated", "Update Fail", JOptionPane.ERROR_MESSAGE);
    }

    public JTextField getDeleteEmployeeIdFld() {
        return deleteEmployeeIdFld;
    }
    public void displayDeleteSuccess() {
        JOptionPane.showMessageDialog(frame, "Record deleted successfully", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayDeleteFail() {
        JOptionPane.showMessageDialog(frame, "Record not deleted", "Delete Fail", JOptionPane.ERROR_MESSAGE);
    }
    public void clearUpdateEmployeeForm() {
        updateEmployeeIdFld.setText("");
        updateFirstNameFld.setText("");
        updateLastNameFld.setText("");
        updateBranchIdFld.setText("");
        updateJobIDfld.setText("");
        updateDepartmentIDFld.setText("");
        updateHireDateFld.setText("");
    }
    public void clearCreateEmployeeForm() {
        createFirstNameFld.setText("");
        createLastNameFld.setText("");
        createbranchIdFld.setText("");
        createJobIDfld.setText("");
        createDepartmentIDFld.setText("");
        createHireDateFld.setText("");
    }
    public void clearReadEmployeeForm() {
        readEmployeeIdFld.setText("");
    }
    public void clearDeleteEmployeeForm() {
        deleteEmployeeIdFld.setText("");
    }



    

    

}
