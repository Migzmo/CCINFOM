
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

    private JButton createComputerPartsBtn;
    private JButton readComputerPartsBtn;
    private JButton updtComputerPartsBtn;
    private JButton dltComputerPartsBtn;

    private JButton createCustomerBtn;
    private JButton readCustomerBtn;
    private JButton updtCustomerBtn;
    private JButton dltCustomerBtn;

    private JButton createBranchBtn;
    private JButton readBranchBtn;
    private JButton updtBranchBtn;
    private JButton dltBranchBtn;



    private JButton backtoManagePickBtn;
    
    private JButton createEmployeeApplyBtn;
    private JButton createPartsApplyBtn;
    private JButton createEmpDscrdButton;
    private JButton readEmpDscrdBtn;
    private JButton updEmpDscrdBtn;
    private JButton dltEmpDscrdBtn;
    private JButton readEmployeeApplyBtn;
    private JPanel promptPanel;

    private JButton updateEmployeeApplybtn;
    private JButton deleteEmployeeApplybtn; 

    private JButton readPartsApplyBtn;
    private JButton updatePartsApplyBtn;
    private JButton deleteComputerPartsApplyBtn;

    private JButton createCustomerApplyBtn;
    private JButton readCustomApplyBtn;
    private JButton updateCustomerApplyBtn;
    private JButton deleteCustomerApplyBtn;

    private JButton createBranchApplyBtn;
    private JButton readBranchApplyBtn;
    private JButton updateBranchApplyBtn;
    private JButton deleteBranchApplyBtn;

    
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
    private JTextField createClassField;
    private JTextField createproductNameFld;
    private JTextField createdescriptionFld;
    private JTextField createquantityFld;
    private JTextField createpriceFld;
    private JTextField createWwarrantyField;
    private JTextField createContactNumberFld;
    private JTextField createEmailFld;
    private JTextField createShippingAddressFld;
    private JTextField createBranchNameFld;
    private JTextField createBranchLocationFld;
    private JTextField createBranchContactNumberFld;
    private JTextField createManagerIDFld;


    private JTextField readEmployeeIdFld;
    private JTextField readProductIDFld;
    private JTextField readCustomerIDFld;
    private JTextField readBranchIDFld;

    private JTextField updateEmployeeIdFld;
    private JTextField updateFirstNameFld;
    private JTextField updateLastNameFld;
    private JTextField updateBranchIdFld;
    private JTextField updateJobIDfld;
    private JTextField updateDepartmentIDFld;
    private JTextField updateHireDateFld;
    private JTextField updateClassField;
    private JTextField updateProductIDFld;
    private JTextField updateproductNameFld;
    private JTextField updatedescriptionFld;
    private JTextField updatequantityFld;
    private JTextField updatepriceFld;
    private JTextField updateWwarrantyField;
    private JTextField updateCustomerIDFld;
    private JTextField updateContactNumberFld;
    private JTextField updateEmailFld;
    private JTextField updateShippingAddressFld;
    private JTextField updateBranchLocationFld;
    private JTextField updateBranchNameFld;
    private JTextField updateBranchContactNumberFld;
    private JTextField updateManagerIDFld;
    
    

    

    private JTextField deleteEmployeeIdFld;
    private JTextField deleteProductIDFld;
    private JTextField deleteCustomerIDFld;
    private JTextField deleteBranchIDFld;

    
    // idk yet
    private JPanel BtnTrsfrPanel;
    private JButton applyTrnsfrButton;
    private JButton discardTrnsfrButton;
    private JTextField employeeIdField;
    
    private JTextField newBranchIdField;
    private JTextField newJobIdField;
    private JTextField departmentIdField;
    private JTextField reasonField;
    //Report generation
    private JButton generateSalesReportBtn;
    private JButton generateBranchStockReportBtn;
    private JButton generateCustomerTicketReportBtn;
    private JButton generateCustomerSatisifactioBtn;

    //report
    private JTextField reportMonthField;
    private JTextField reportYearField;
    private JTextField reportBranchIdField;
    
    private JButton generateSalesReportGnrtBtn;
    private JButton generateBranchStockReportGnrtBtn;
    private JButton generateCustomerTicketReportGnrtBtn;
    private JButton generateCustomerSatisifactioGnrtBtn;

    private JButton generateSalesReportDiscardBtn;
    private JButton generateBranchStockReportDiscardBtn;
    private JButton generateCustomerTicketReportDiscardBtn;
    private JButton generateCustomerSatisifactioDiscardBtn;
    


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
        //computer parts
        createComputerPartsBtn = new JButton("Create");
        readComputerPartsBtn = new JButton("Read");
        updtComputerPartsBtn = new JButton("Update");
        dltComputerPartsBtn = new JButton("Delete");

        //customer record
        createCustomerBtn = new JButton("Create");
        readCustomerBtn = new JButton("Read");  
        updtCustomerBtn = new JButton("Update");
        dltCustomerBtn = new JButton("Delete");

        createBranchBtn = new JButton("Create");
        readBranchBtn = new JButton("Read");
        updtBranchBtn = new JButton("Update");
        dltBranchBtn = new JButton("Delete");


        createCustomerApplyBtn = new JButton("Create");


        createPartsApplyBtn = new JButton("Create");


        cmpterPartsManageButton = new JButton("Computer Parts");
        customerRecordManageButton = new JButton("Customer Records");
        employeeRecordManageButton = new JButton("Employee Records");
        branchRecorManagedButton= new JButton("Branch Records");

        

        createEmployeeApplyBtn = new JButton("Create");
        readEmployeeApplyBtn = new JButton("Search");
        readPartsApplyBtn = new JButton("Search");

        createEmpDscrdButton = new JButton("Discard");
        readEmpDscrdBtn = new JButton("Discard");
        updEmpDscrdBtn = new JButton("Discard");
        dltEmpDscrdBtn = new JButton("Discard");

        backtoManagePickBtn = new JButton("Back");
        updateEmployeeApplybtn = new JButton("Apply");
        deleteEmployeeApplybtn = new JButton("Delete");
        updatePartsApplyBtn = new JButton("Apply");
        deleteComputerPartsApplyBtn = new JButton("Delete");
        createCustomerApplyBtn = new JButton("Create");
        readCustomApplyBtn = new JButton("Search");
        updateCustomerApplyBtn = new JButton("Apply");
        deleteCustomerApplyBtn = new JButton("Delete");
        createBranchApplyBtn = new JButton("Create");
        readBranchApplyBtn = new JButton("Search");
        updateBranchApplyBtn = new JButton("Apply");
        deleteBranchApplyBtn = new JButton("Delete");


        //create fields
        createFirstNameFld = new JTextField();
        createLastNameFld = new JTextField();
        createbranchIdFld = new JTextField();
        createJobIDfld = new JTextField();
        createDepartmentIDFld = new JTextField();
        createHireDateFld = new JTextField();
        createClassField = new JTextField();
        createproductNameFld = new JTextField();
        createdescriptionFld = new JTextField();
        createquantityFld = new JTextField();
        createpriceFld = new JTextField();
        createWwarrantyField = new JTextField();
        createContactNumberFld = new JTextField();
        createEmailFld = new JTextField();
        createShippingAddressFld = new JTextField();
        createBranchNameFld = new JTextField();
        createBranchLocationFld = new JTextField();
        createBranchContactNumberFld = new JTextField();
        createManagerIDFld = new JTextField();



        //read fields
        readEmployeeIdFld = new JTextField();
        readProductIDFld = new JTextField();
        readCustomerIDFld = new JTextField();
        readBranchIDFld = new JTextField();


        //update fields
        updateBranchIdFld = new JTextField();
        updateEmployeeIdFld = new JTextField();
        updateFirstNameFld = new JTextField();
        updateLastNameFld = new JTextField();
        updateJobIDfld = new JTextField();
        updateDepartmentIDFld = new JTextField();
        updateHireDateFld = new JTextField();
        updateClassField = new JTextField();
        updateproductNameFld = new JTextField();
        updatedescriptionFld = new JTextField();
        updatequantityFld = new JTextField();
        updatepriceFld = new JTextField();
        updateWwarrantyField = new JTextField();
        updateProductIDFld = new JTextField();
        updateCustomerIDFld = new JTextField();
        updateContactNumberFld = new JTextField();
        updateEmailFld = new JTextField();
        updateShippingAddressFld = new JTextField();
        updateBranchLocationFld = new JTextField();
        updateBranchNameFld = new JTextField();
        updateBranchContactNumberFld = new JTextField();
        updateManagerIDFld = new JTextField();



        //delete fields
        deleteEmployeeIdFld = new JTextField();
        deleteProductIDFld = new JTextField();
        deleteCustomerIDFld = new JTextField();
        deleteBranchIDFld = new JTextField();


        createEmployeeBtn.setPreferredSize(new Dimension(150,30));
        readEmployeeBtn.setPreferredSize(new Dimension(150,30));
        updtEmployeeBtn.setPreferredSize(new Dimension(150,30));
        dltEmployeeBtn.setPreferredSize(new Dimension(150,30));

        promptPanel = new JPanel(new FlowLayout());
        promptPanel.setBackground(Color.LIGHT_GRAY);
        promptPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Generate Reports
        generateSalesReportBtn = new JButton("Generate Sales Report");
        generateBranchStockReportBtn = new JButton("Generate Branch Stock Report");
        generateCustomerTicketReportBtn = new JButton("Generate Customer Ticket Report");
        generateCustomerSatisifactioBtn = new JButton("Generate Customer Satisfaction Report");

        reportBranchIdField = new JTextField();
        reportMonthField = new JTextField();
        reportYearField = new JTextField();

        generateSalesReportGnrtBtn = new JButton("Generate");
        generateBranchStockReportGnrtBtn = new JButton("Generate");
        generateCustomerTicketReportGnrtBtn = new JButton("Generate");
        generateCustomerSatisifactioGnrtBtn = new JButton("Generate");

        generateSalesReportDiscardBtn = new JButton("Discard");
        generateBranchStockReportDiscardBtn = new JButton("Discard");
        generateCustomerTicketReportDiscardBtn = new JButton("Discard");
        generateCustomerSatisifactioDiscardBtn = new JButton("Discard");

        
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

    // generate Reports buttons action listener
    public void setGenerateSalesReportBtnListener(ActionListener actionListener) {
        generateSalesReportBtn.addActionListener(actionListener);
    }
    public void setGenerateBranchStockReportBtnListener(ActionListener actionListener) {
        generateBranchStockReportBtn.addActionListener(actionListener);
    }
    public void setGenerateCustomerTicketReportBtnListener(ActionListener actionListener) {
        generateCustomerTicketReportBtn.addActionListener(actionListener);
    }
    public void setGenerateCustomerSatisifactioBtnListener(ActionListener actionListener) {
        generateCustomerSatisifactioBtn.addActionListener(actionListener);
    }

    public void setGenerateSalesReportGnrtBtnListener(ActionListener actionListener) {
        generateSalesReportGnrtBtn.addActionListener(actionListener);
    }
    public void setGenerateBranchStockReportGnrtBtnListener(ActionListener actionListener) {
        generateBranchStockReportGnrtBtn.addActionListener(actionListener);
    }
    public void setGenerateCustomerTicketReportGnrtBtnListener(ActionListener actionListener) {
        generateCustomerTicketReportGnrtBtn.addActionListener(actionListener);
    }
    public void setGenerateCustomerSatisifactioGnrtBtnListener(ActionListener actionListener) {
        generateCustomerSatisifactioGnrtBtn.addActionListener(actionListener);
    }

    public void setGenerateSalesReportDiscardBtnListener(ActionListener actionListener) {
        generateSalesReportDiscardBtn.addActionListener(actionListener);
    }
    public void setGenerateBranchStockReportDiscardBtnListener(ActionListener actionListener) {
        generateBranchStockReportDiscardBtn.addActionListener(actionListener);
    }
    public void setGenerateCustomerTicketReportDiscardBtnListener(ActionListener actionListener) {
        generateCustomerTicketReportDiscardBtn.addActionListener(actionListener);
    }
    public void setGenerateCustomerSatisifactioDiscardBtnListener(ActionListener actionListener) {
        generateCustomerSatisifactioDiscardBtn.addActionListener(actionListener);
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
    public void setCreatePartsApplyButtonListener(ActionListener listener){
        createPartsApplyBtn.addActionListener(listener);
    }   
    public void setReadEmployeeApplyButtonListener(ActionListener listener){
        readEmployeeApplyBtn.addActionListener(listener);
    }
    //COMPUTER PARTS
    public void setCreateEmployeeDiscardButtonListener(ActionListener listener){
        createEmpDscrdButton.addActionListener(listener);
    }
    public void setCreateComputerPartsButtonListener(ActionListener listener) {
        createComputerPartsBtn.addActionListener(listener);
    }
    public void setReadComputerPartsButtonListener(ActionListener listener) {
        readComputerPartsBtn.addActionListener(listener);
    }
    public void setUpdateComputerPartsButtonListener(ActionListener listener) {
        updtComputerPartsBtn.addActionListener(listener);
    }
    public void setDeleteComputerPartsButtonListener(ActionListener listener) {
        dltComputerPartsBtn.addActionListener(listener);
    }
    public void setReadComputerPartsApplyButtonListener(ActionListener listener) {
        readPartsApplyBtn.addActionListener(listener);
    }
    public void setUpdateComputerPartsApplyButtonListener(ActionListener listener) {
        updatePartsApplyBtn.addActionListener(listener);
    }
    public void setDeleteComputerPartsApplyButtonListener(ActionListener listener) {
        deleteComputerPartsApplyBtn.addActionListener(listener);
    }

    //CUSTOMER RECORDS
    public void setCreateCustomerButtonListener(ActionListener listener) {
        createCustomerBtn.addActionListener(listener);
    }
    public void setReadCustomerButtonListener(ActionListener listener) {
        readCustomerBtn.addActionListener(listener);
    }
    public void setUpdateCustomerButtonListener(ActionListener listener) {
        updtCustomerBtn.addActionListener(listener);
    }
    public void setDeleteCustomerButtonListener(ActionListener listener) {
        dltCustomerBtn.addActionListener(listener);
    }
    public void setCreateCustomerApplyButtonListener(ActionListener listener) {
        createCustomerApplyBtn.addActionListener(listener);
    }
    public void setReadCustomerApplyButtonListener(ActionListener listener) {
        readCustomApplyBtn.addActionListener(listener);
    }
    public void setUpdateCustomerApplyButtonListener(ActionListener listener) {
        updateCustomerApplyBtn.addActionListener(listener);
    }
    public void setDeleteCustomerApplyButtonListener(ActionListener listener) {
        deleteCustomerApplyBtn.addActionListener(listener);
    }
    // BRANCH RECORS
    public void setCreateBranchButtonListener(ActionListener listener) {
        createBranchBtn.addActionListener(listener);
    }
    public void setReadBranchButtonListener(ActionListener listener) {
        readBranchBtn.addActionListener(listener);
    }
    public void setUpdateBranchButtonListener(ActionListener listener) {
        updtBranchBtn.addActionListener(listener);
    }
    public void setDeleteBranchButtonListener(ActionListener listener) {
        dltBranchBtn.addActionListener(listener);
    }
    public void setCreateBranchApplyButtonListener(ActionListener listener) {
        createBranchApplyBtn.addActionListener(listener);
    }
    public void setReadBranchApplyButtonListener(ActionListener listener) {
        readBranchApplyBtn.addActionListener(listener);
    }
    public void setUpdateBranchApplyButtonListener(ActionListener listener) {
        updateBranchApplyBtn.addActionListener(listener);
    }
    public void setDeleteBranchApplyButtonListener(ActionListener listener) {
        deleteBranchApplyBtn.addActionListener(listener);
    }



    // ----
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
        
        JPanel sellProductMainPanel = new JPanel(new BorderLayout());
        sellProductMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("Product ID:"));
       

        inputPanel.add(productIdField);
        inputPanel.add(new JLabel("Branch ID:"));
        inputPanel.add(branchIdField);
        inputPanel.add(new JLabel("Customer ID:"));
        inputPanel.add(customerIdField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);

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
        inputPanel.add(new JLabel("description :"));
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
    promptPanel.removeAll();
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
    public void displayComputerPartsManagement(){
        JLabel managementLabel = new JLabel("Computer Parts Management");
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
        manageRecordUiPanel.add(createComputerPartsBtn);
        manageRecordUiPanel.add(readComputerPartsBtn);
        manageRecordUiPanel.add(updtComputerPartsBtn);
        manageRecordUiPanel.add(dltComputerPartsBtn);
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
        newRecordPanel.add(deleteEmployeeIdFld, gbc);


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

    public void displayCreateComputerForm() {
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

    // Add Branch ID label and field
    gbc.gridx = 0; gbc.gridy = 0;
    newRecordPanel.add(new JLabel("Branch ID:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1; // Allow text fields to expand horizontally
    newRecordPanel.add(createbranchIdFld, gbc);

    // Add Classification label and field
    gbc.gridx = 0; gbc.gridy = 1;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("Classification:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(createClassField, gbc);

    // Add Product Name label and field
    gbc.gridx = 0; gbc.gridy = 2;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("Product Name:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(createproductNameFld, gbc);

    // Add Description label and field
    gbc.gridx = 0; gbc.gridy = 3;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("Description:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(createdescriptionFld, gbc);

    // Add Stock label and field
    gbc.gridx = 0; gbc.gridy = 4;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("Stock:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(createquantityFld, gbc);

    // Add Price label and field
    gbc.gridx = 0; gbc.gridy = 5;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("Price:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    newRecordPanel.add(createpriceFld, gbc);

    // Add Warranty duration label and field
    gbc.gridx = 0; gbc.gridy = 6;
    gbc.weightx = 0;
    newRecordPanel.add(new JLabel("Warranty duration:"), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1; // Allow text fields to expand horizontally
    newRecordPanel.add(createWwarrantyField, gbc);

    // Add buttons (Create and Discard)
    gbc.gridx = 0; gbc.gridy = 7;
    gbc.gridwidth = 1;
    gbc.weightx = 0; // Buttons should not expand
    gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
    newRecordPanel.add(createPartsApplyBtn, gbc);

    gbc.gridx = 1;
    newRecordPanel.add(createEmpDscrdButton, gbc);

    // Update promptPanel
    promptPanel.setLayout(new BorderLayout());
    promptPanel.removeAll();
    promptPanel.add(newRecordPanel, BorderLayout.CENTER);

    frame.revalidate();
    frame.repaint();
}
    public void displayReadComputerPartsForm() {
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
    newRecordPanel.add(new JLabel("Product ID:"));

    gbc.gridx = 1;
    gbc.weightx = 1; // Allow text fields to expand horizontally
    newRecordPanel.add(readProductIDFld, gbc);


    // Add buttons (Create and Discard)
    gbc.gridx = 0; gbc.gridy =1;
    gbc.gridwidth = 1;
    gbc.weightx = 0; // Buttons should not expand
    gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
    newRecordPanel.add(readPartsApplyBtn, gbc);

    gbc.gridx = 1;
    newRecordPanel.add(readEmpDscrdBtn, gbc);


    // Update promptPanel
    promptPanel.setLayout(new BorderLayout());
    promptPanel.removeAll();
    promptPanel.add(newRecordPanel, BorderLayout.CENTER);
    
    frame.revalidate();
    frame.repaint();
    }
    public void displayUpdateComputerPartsForm() {
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
        //
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Product ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(updateProductIDFld, gbc);
        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 1;
        newRecordPanel.add(new JLabel("New Branch ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(updateBranchIdFld, gbc);
    
        // Add Classification label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Classification:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateClassField, gbc);
    
        // Add Product Name label and field
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Product Name:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateproductNameFld, gbc);
    
        // Add Description label and field
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Description:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updatedescriptionFld, gbc);
    
        // Add Stock label and field
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Stock:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updatequantityFld, gbc);
    
        // Add Price label and field
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Price:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updatepriceFld, gbc);
    
        // Add Warranty duration label and field
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Warranty duration:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(updateWwarrantyField, gbc);
    
        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(updatePartsApplyBtn, gbc);
    
        gbc.gridx = 1;
        newRecordPanel.add(updEmpDscrdBtn, gbc);
    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
    
        frame.revalidate();
        frame.repaint();
    }
    public void displayDeleteComputerPartsForm() {
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
        newRecordPanel.add(new JLabel("Product ID:"));

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(deleteProductIDFld, gbc);


        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy =1;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(deleteComputerPartsApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(dltEmpDscrdBtn, gbc);

    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
        
        frame.revalidate();
        frame.repaint();
    }

    public void displayCustomerRecordManagement(){
        JLabel managementLabel = new JLabel("Customer Record Management");
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
        manageRecordUiPanel.add(createCustomerBtn);
        manageRecordUiPanel.add(readCustomerBtn);
        manageRecordUiPanel.add(updtCustomerBtn);
        manageRecordUiPanel.add(dltCustomerBtn);
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
    //String customer_lastname, String customer_firstname, int contact_number, String email_address, String shipping_address
    public void displayCreateCustomerForm(){
        JPanel newRecordPanel = new JPanel(new GridBagLayout());
        newRecordPanel.setBackground(Color.LIGHT_GRAY);
        newRecordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.anchor = GridBagConstraints.WEST; // Align labels to the left
        gbc.fill = GridBagConstraints.HORIZONTAL; // Text fields expand horizontally

        gbc.weightx = 0;
        gbc.weighty = 0;

        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("First Name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(createFirstNameFld, gbc);

        // Add Classification label and field
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Last Name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createLastNameFld, gbc);

        // Add Product Name label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Contact Number:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createContactNumberFld, gbc);

        // Add Description label and field
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createEmailFld, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Shipping Address:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createShippingAddressFld, gbc);

        // Add Stock label and field
        

        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(createCustomerApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(createEmpDscrdButton, gbc);

        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
    }   

    public void displayReadCustomerForm(){
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
        newRecordPanel.add(new JLabel("Customer ID:"));

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(readCustomerIDFld, gbc);


        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy =1;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(readCustomApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(readEmpDscrdBtn, gbc);


        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
        
        frame.revalidate();
        frame.repaint();
    }

    //String customer_id, String customer_lastname, String customer_firstname, int contact_number, String email_address, String shipping_address
    public void displayUpdateCustomerForm() {
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
        //
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Customer ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(updateCustomerIDFld, gbc);
        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 1;
        newRecordPanel.add(new JLabel("New First Name:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(updateFirstNameFld, gbc);
    
        // Add Classification label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Last Name:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateLastNameFld, gbc);
    
        // Add Product Name label and field
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Contact Number:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateContactNumberFld, gbc);
    
        // Add Description label and field
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Email Address:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateEmailFld, gbc);
    
        // Add Stock label and field
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Shipping Address:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateShippingAddressFld, gbc);
    
        
        
    
        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(updateCustomerApplyBtn, gbc);
    
        gbc.gridx = 1;
        newRecordPanel.add(updEmpDscrdBtn, gbc);
    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
    
        frame.revalidate();
        frame.repaint();
    }

    public void displayDeleteCustomerForm() {
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
        newRecordPanel.add(new JLabel("Customer ID:"));

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(deleteCustomerIDFld, gbc);


        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy =1;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(deleteCustomerApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(dltEmpDscrdBtn, gbc);

    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
        
        frame.revalidate();
        frame.repaint();
    }
    
    public void displayBranchRecordManagement(){
        JLabel managementLabel = new JLabel("Branch Record Management");
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
        manageRecordUiPanel.add(createBranchBtn);
        manageRecordUiPanel.add(readBranchBtn);
        manageRecordUiPanel.add(updtBranchBtn);
        manageRecordUiPanel.add(dltBranchBtn);
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
    public void displayCreateBranchForm(){
        JPanel newRecordPanel = new JPanel(new GridBagLayout());
        newRecordPanel.setBackground(Color.LIGHT_GRAY);
        newRecordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.anchor = GridBagConstraints.WEST; // Align labels to the left
        gbc.fill = GridBagConstraints.HORIZONTAL; // Text fields expand horizontally

        gbc.weightx = 0;
        gbc.weighty = 0;

        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Branch Name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(createBranchNameFld, gbc);

        // Add Classification label and field
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Location:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createBranchLocationFld, gbc);

        // Add Product Name label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Branch Contact Number:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createBranchContactNumberFld, gbc);

        // Add Description label and field
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Manager ID:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(createManagerIDFld, gbc);

        // Add Stock label and field
        

        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(createBranchApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(createEmpDscrdButton, gbc);

        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
    }   

    public void displayReadBranchForm(){
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
        newRecordPanel.add(new JLabel("Branch ID:"));

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(readBranchIDFld, gbc);


        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy =1;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(readBranchApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(readEmpDscrdBtn, gbc);


        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
        
        frame.revalidate();
        frame.repaint();
    }

    public void displayUpdateBranchForm() {
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
        //
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Branch ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(updateBranchIdFld, gbc);
        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 1;
        newRecordPanel.add(new JLabel("New Branch Name:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(updateBranchNameFld, gbc);
    
        // Add Classification label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Location:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateBranchLocationFld, gbc);
    
        // Add Product Name label and field
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Contact Number:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateBranchContactNumberFld, gbc);
    
        // Add Description label and field
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("New Manager ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1;
        newRecordPanel.add(updateManagerIDFld, gbc);
    
     
        
        
    
        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(updateBranchApplyBtn, gbc);
    
        gbc.gridx = 1;
        newRecordPanel.add(updEmpDscrdBtn, gbc);
    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
    
        frame.revalidate();
        frame.repaint();
    }

    public void displayDeleteBranchForm() {
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
        newRecordPanel.add(new JLabel("Branch ID:"));

        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(deleteBranchIDFld, gbc);


        // Add buttons (Create and Discard)
        gbc.gridx = 0; gbc.gridy =1;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(deleteBranchApplyBtn, gbc);

        gbc.gridx = 1;
        newRecordPanel.add(dltEmpDscrdBtn, gbc);

    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
        
        frame.revalidate();
        frame.repaint();
    }


    public void displayReportGeneration(){
        JLabel managementLabel = new JLabel("Report Generation");
        managementLabel.setHorizontalAlignment(JLabel.CENTER);
        managementLabel.setFont(managementLabel.getFont().deriveFont(15f));
        

        JPanel managementPanel = new JPanel(new BorderLayout());
        managementPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel manageRecordUiPanel = new JPanel();
        manageRecordUiPanel = new JPanel(new GridLayout(6, 1, 0, 20));
        manageRecordUiPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));


        manageRecordUiPanel.add(managementLabel);
        manageRecordUiPanel.add(generateSalesReportBtn);
        manageRecordUiPanel.add(generateBranchStockReportBtn);
        manageRecordUiPanel.add(generateCustomerTicketReportBtn);
        manageRecordUiPanel.add(generateCustomerSatisifactioBtn);
        manageRecordUiPanel.add(transactionsBackBtn);

        

        JPanel promptPlaceHolder = new JPanel();
        promptPlaceHolder.setLayout(new GridLayout(2, 1, 0, 10));
        promptPlaceHolder.setPreferredSize(new Dimension(250,80));
        promptPlaceHolder.setBackground(Color.LIGHT_GRAY);

        JLabel promptLabel = new JLabel("Select a report to generate");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        promptPanel.removeAll();
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

    public void displaySalesReportForm() {
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
    
        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Branch ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportBranchIdField, gbc);
    
        // Add Enter Month label and field
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Enter Month:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportMonthField, gbc);
    
        // Add Enter Year label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Enter Year:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportYearField, gbc);
    
        // Add buttons (Generate and Discard)
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(generateSalesReportGnrtBtn, gbc);
    
        gbc.gridx = 1;
        newRecordPanel.add(generateSalesReportDiscardBtn, gbc);
    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
    
        frame.revalidate();
        frame.repaint();
    }
    public void displayStocksReportForm() {
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
    
        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Branch ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportBranchIdField, gbc);
    
        // Add Enter Month label and field
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Enter Month:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportMonthField, gbc);
    
        // Add Enter Year label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Enter Year:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportYearField, gbc);
    
        // Add buttons (Generate and Discard)
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(generateBranchStockReportGnrtBtn, gbc);
    
        gbc.gridx = 1;
        newRecordPanel.add(generateBranchStockReportDiscardBtn, gbc);
    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
    
        frame.revalidate();
        frame.repaint();
    }
    public void displayTicketsReportForm() {
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
    
        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Branch ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportBranchIdField, gbc);
    
        // Add Enter Month label and field
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Enter Month:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportMonthField, gbc);
    
        // Add Enter Year label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Enter Year:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportYearField, gbc);
    
        // Add buttons (Generate and Discard)
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(generateCustomerTicketReportGnrtBtn, gbc);
    
        gbc.gridx = 1;
        newRecordPanel.add(generateCustomerTicketReportDiscardBtn, gbc);
    
        // Update promptPanel
        promptPanel.setLayout(new BorderLayout());
        promptPanel.removeAll();
        promptPanel.add(newRecordPanel, BorderLayout.CENTER);
    
        frame.revalidate();
        frame.repaint();
    }
    public void displaySatisfactionReportForm() {
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
    
        // Add Branch ID label and field
        gbc.gridx = 0; gbc.gridy = 0;
        newRecordPanel.add(new JLabel("Branch ID:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportBranchIdField, gbc);
    
        // Add Enter Month label and field
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Enter Month:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportMonthField, gbc);
    
        // Add Enter Year label and field
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        newRecordPanel.add(new JLabel("Enter Year:"), gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 1; // Allow text fields to expand horizontally
        newRecordPanel.add(reportYearField, gbc);
    
        // Add buttons (Generate and Discard)
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0; // Buttons should not expand
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        newRecordPanel.add(generateCustomerSatisifactioGnrtBtn, gbc);
    
        gbc.gridx = 1;
        newRecordPanel.add(generateCustomerSatisifactioDiscardBtn, gbc);
    
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
    public void clearUpdateForm() {
        updateEmployeeIdFld.setText("");
        updateFirstNameFld.setText("");
        updateLastNameFld.setText("");
        updateBranchIdFld.setText("");
        updateJobIDfld.setText("");
        updateDepartmentIDFld.setText("");
        updateHireDateFld.setText("");
        updateClassField.setText("");
        updateproductNameFld.setText("");
        updatedescriptionFld.setText("");
        updatequantityFld.setText("");
        updatepriceFld.setText("");
        updateWwarrantyField.setText("");
        updateProductIDFld.setText("");
        updateCustomerIDFld.setText("");
        updateContactNumberFld.setText("");
        updateEmailFld.setText("");
        updateShippingAddressFld.setText("");
        updateBranchLocationFld.setText("");
        updateBranchNameFld.setText("");
        updateBranchContactNumberFld.setText("");
        updateManagerIDFld.setText("");


    }
    public void clearCreateForm() {
        createFirstNameFld.setText("");
        createLastNameFld.setText("");
        createbranchIdFld.setText("");
        createJobIDfld.setText("");
        createDepartmentIDFld.setText("");
        createHireDateFld.setText("");
        createClassField.setText("");   
        createproductNameFld.setText("");
        createdescriptionFld.setText("");
        createquantityFld.setText("");
        createpriceFld.setText("");
        createWwarrantyField.setText("");
        createEmailFld.setText("");
        createContactNumberFld.setText("");
        createShippingAddressFld.setText("");
        createBranchNameFld.setText("");
        createBranchLocationFld.setText("");
        createBranchContactNumberFld.setText("");
        createManagerIDFld.setText("");
        


    }
    public void clearReadForm() {
        readEmployeeIdFld.setText("");
        readProductIDFld.setText("");
        readCustomerIDFld.setText("");
        readBranchIDFld.setText("");

    }
    public void clearDeleteForm() {
        deleteEmployeeIdFld.setText("");
        deleteProductIDFld.setText("");
        deleteCustomerIDFld.setText("");
        deleteBranchIDFld.setText("");

    }
    public void clearGenerateForm() {
        reportBranchIdField.setText("");
        reportMonthField.setText("");
        reportYearField.setText("");
    }

    public void clearSellForm() {
        productIdField.setText("");
        branchIdField.setText("");
        customerIdField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }
    public void clearTicketForm() {
        cscustomerIDField.setText("");
        csproductIDField.setText("");
        csdescriptionField.setText("");
    }
    public void displaySellSuccess() {
        JOptionPane.showMessageDialog(frame, "Product sold successfully", "Sell Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displaySellFail() {
        JOptionPane.showMessageDialog(frame, "Product not sold", "Sell Fail", JOptionPane.ERROR_MESSAGE);
    }
    
    public JTextField getCreateproductNameFld() {
        return createproductNameFld;
    }

    public JTextField getCreatedescriptionFld() {
        return createdescriptionFld;
    }

    public JTextField getCreatequantityFld() {
        return createquantityFld;
    }

    public JTextField getCreatepriceFld() {
        return createpriceFld;
    }

    public JTextField getCreateWwarrantyField() {
        return createWwarrantyField;
    }

    public JTextField getCreateClassField() {
        return createClassField;
    }

    public JTextField getReadProductIDFld() {
        return readProductIDFld;
    }

    public JTextField getUpdateClassField() {
        return updateClassField;
    }

    public JTextField getUpdateproductNameFld() {
        return updateproductNameFld;
    }

    public JTextField getUpdatedescriptionFld() {
        return updatedescriptionFld;
    }

    public JTextField getUpdatequantityFld() {
        return updatequantityFld;
    }

    public JTextField getUpdatepriceFld() {
        return updatepriceFld;
    }

    public JTextField getUpdateWwarrantyField() {
        return updateWwarrantyField;
    }
    public JTextField getUpdateProductIDFld() {
        return updateProductIDFld;
    }

    public JTextField getDeleteProductIDFld() {
        return deleteProductIDFld;
    }

    public JTextField getCreateContactNumberFld() {
        return createContactNumberFld;
    }

    public JTextField getCreateEmailFld() {
        return createEmailFld;
    }

    public JTextField getCreateShippingAddressFld() {
        return createShippingAddressFld;
    }

    public JTextField getReadCustomerIDFld() {
        return readCustomerIDFld;
    }

    public JTextField getUpdateCustomerIDFld() {
        return updateCustomerIDFld;
    }

    public JTextField getUpdateContactNumberFld() {
        return updateContactNumberFld;
    }

    public JTextField getUpdateEmailFld() {
        return updateEmailFld;
    }

    public JTextField getUpdateShippingAddressFld() {
        return updateShippingAddressFld;
    }

    public JTextField getDeleteCustomerIDFld() {
        return deleteCustomerIDFld;
    }

    public JTextField getUpdateBranchLocationFld() {
        return updateBranchLocationFld;
    }

    public JTextField getUpdateBranchNameFld() {
        return updateBranchNameFld;
    }

    public JTextField getUpdateBranchContactNumberFld() {
        return updateBranchContactNumberFld;
    }

    public JTextField getUpdateManagerIDFld() {
        return updateManagerIDFld;
    }

    public JTextField getReadBranchIDFld() {
        return readBranchIDFld;
    }

    public JTextField getCreateBranchNameFld() {
        return createBranchNameFld;
    }

    public JTextField getCreateBranchLocationFld() {
        return createBranchLocationFld;
    }

    public JTextField getCreateBranchContactNumberFld() {
        return createBranchContactNumberFld;
    }

    public JTextField getCreateManagerIDFld() {
        return createManagerIDFld;
    }

    public JTextField getDeleteBranchIDFld() {
        return deleteBranchIDFld;
    }

    public JTextField getReportMonthField() {
        return reportMonthField;
    }

    public JTextField getReportYearField() {
        return reportYearField;
    }

    public JTextField getReportBranchIdField() {
        return reportBranchIdField;
    }
    public void displaySalesReportSuccess() {
        JOptionPane.showMessageDialog(frame, "Sales report generated", "Report Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displaySalesReportFail() {
        JOptionPane.showMessageDialog(frame, "Sales report not generated", "Report Fail", JOptionPane.ERROR_MESSAGE);
    }

    public void displayStockReportSuccess() {
        JOptionPane.showMessageDialog(frame, "Stock report generated", "Report Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayStockReportFail() {
        JOptionPane.showMessageDialog(frame, "Stock report not generated", "Report Fail", JOptionPane.ERROR_MESSAGE);
    }

    public void displayTicketReportSuccess() {
        JOptionPane.showMessageDialog(frame, "Ticket report generated", "Report Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayTicketReportFail() {
        JOptionPane.showMessageDialog(frame, "Ticket report not generated", "Report Fail", JOptionPane.ERROR_MESSAGE);
    }

    public void displaySatisfactionReportSuccess() {
        JOptionPane.showMessageDialog(frame, "Satisfaction report generated", "Report Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displaySatisfactionReportFail() {
        JOptionPane.showMessageDialog(frame, "Satisfaction report not generated", "Report Fail", JOptionPane.ERROR_MESSAGE);
    }

    public void displayTicketSuccess() {
        JOptionPane.showMessageDialog(frame, "Ticket created", "Ticket Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayTicketFail() {
        JOptionPane.showMessageDialog(frame, "Ticket not created", "Ticket Fail", JOptionPane.ERROR_MESSAGE);
    }


    
}