import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ComputerStoreController class acts as the controller in the Model-View-Controller (MVC) pattern.
 * It is responsible for handling user interactions from the userView and updating the model accordingly.
 */
public class ComputerStoreController {
    private ComputerStoreManagement model;
    private userView view;

    public ComputerStoreController(ComputerStoreManagement model, userView view) {
        this.model = model;
        this.view = view;

        this.view.setRecordsManagementBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayRecordsManagement();
            }
        });

        this.view.setTransactionsBtnListener(new ActionListener() {
            /**
             * Handles the action event when the "Transactions" button in the master UI panel is pressed.
             * 
             * It displays the UI for transactions, where the user can sell products, supply products, 
             * transfer employees, and perform customer support.
             */ 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayTransactions();
            }
        });

        this.view.setGenerateReportsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //view.displayGenerateReports();
            }
        });

        this.view.addSellProductsListener(new ActionListener() {
            /**
             * Handles the action event when the "Sell Products" button is pressed.
             * 
             * It displays the UI for selling products.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySellProducts();
            }
        });
        
        this.view.addTransferEmployeeListener(new ActionListener() {
            /**
             * Handles the action event when the "Transfer Employee" button is pressed.
             * 
             * It displays the UI for transferring employees and disables all main buttons.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayTransferEmployeeForm();
                view.disableAllMainBtns();
            }
        });
        this.view.addSupplyProductsListener(new ActionListener() {
            /**
             * Handles the action event when the "Supply Products" button is pressed.
             * 
             * It displays the UI for supplying products.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySupplyProducts();;
            }
        });

        this.view.applyTransferEmployeeListener(new ActionListener() {
            /**
             * Handles the action event when the "Apply Transfer Employee" button is pressed.
             * 
             * It validates and applies the employee transfer, displaying success or failure messages.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeId = view.getEmployeeIdField().getText();
                String newBranchId = view.getNewBranchIdField().getText();
                String newJobId = view.getNewJobIdField().getText();
                String departmentId = view.getDepartmentIdField().getText();
                String reason = view.getReasonField().getText();
                StringBuilder error = new StringBuilder();
                if(model.validTransfer(employeeId, newBranchId, newJobId, departmentId, reason, error)) {
                    if(model.transferEmployee(employeeId, newBranchId, newJobId, departmentId, reason)) {
                        view.displayTransferSucess();
                    } else {
                        view.displayTransferFail(error);
                    }
                    
                } else {
                        view.displayTransferFail(error);
                        view.displayTransferEmployeeForm();
                    }
                    
                    view.disableAllMainBtns();
                    view.displayTransferEmployeeForm();
                
            }
        });

        this.view.setApplyCustomerSupportButton(new ActionListener() {
            // need to replace this with actualy getting of values and integrating to model and stuff
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayCustomerSupport();
            }
        });
        
        this.view.setApplySellButton(new ActionListener() {
            // need to replace this with actualy getting of values and integrating to model and stuff
            @Override
            public void actionPerformed(ActionEvent e){
                view.displaySellProducts();
            }
        });

        this.view.setApplySupplyButtonListener(new ActionListener() {
            // need to replace this with actualy getting of values and integrating to model and stuff
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySupplyProducts();
            }
        });

        this.view.setDiscardSupplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySupplyProducts();
            }
        });

        this.view.discardTransferEmployeeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayTransferEmployeeForm();
            }
        });

        this.view.backButtonTrnscListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.enableAllMainBtns();
                view.displayTransactions();
            }
        });

        this.view.addCustomerSupportListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayCustomerSupport();
            }   
        });

        this.view.setDiscardCustomerSupportButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayCustomerSupport();
            }
        });

        this.view.setTransactionsBackBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayMainScreen();
            }
        });

        this.view.setGenerateReportsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // model.generateStockReport();
            }
        });

        this.view.setDiscardSellButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySellProducts();
            }
        });

        this.view.setCreateButtonListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                view.displayCreateRecordForm();
            }
        });

        // This is for creating a new employee
        this.view.setCreateApplyButtonListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String firstName = view.getCreateFirstNameFld().getText();
                String lastName = view.getCreateLastNameFld().getText();
                String branchID = view.getCreatebranchIdFld().getText();
                String JobId = view.getCreateJobIDfld().getText();
                String depID = view.getCreateDepartmentIDFld().getText();
                String hireDate = view.getCreateHireDateFld().getText();
                
                if(model.createEmployee(firstName, lastName, branchID, JobId, depID, hireDate) ){
                    view.displayCreateSuccess();
                } else {
                    view.displayCreateFail();
                }

            }
        });
    }
}
