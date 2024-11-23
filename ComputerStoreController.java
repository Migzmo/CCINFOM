import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// the controller or the middleman of both the model and the view
public class ComputerStoreController {
    private ComputerStoreManagement model;
    private userView view;

    public ComputerStoreController(ComputerStoreManagement model, userView view) {
        this.model = model;
        this.view = view;

        this.view.setRecordsManagementBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayPickManagement();
            }
        });

        this.view.setTransactionsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayTransactions();
            }
        });

        this.view.setGenerateReportsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayReportGeneration();
            }
        });

        this.view.addSellProductsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySellProducts();
            }
        });
        
        this.view.addTransferEmployeeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayTransferEmployeeForm();
                view.disableAllMainBtns();
            }
        });
        this.view.addSupplyProductsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.supplyProducts();
            }
        });

        this.view.applyTransferEmployeeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeId = view.getEmployeeIdField().getText();
                String newBranchId = view.getNewBranchIdField().getText();
                String newJobId = view.getNewJobIdField().getText();
                String departmentId = view.getDepartmentIdField().getText();
                String reason = view.getReasonField().getText();
                StringBuilder error = new StringBuilder();
                if(model.validTransfer(employeeId, newBranchId, newJobId, departmentId, reason, error)) {
                    if (model.transferEmployee(employeeId, newBranchId, newJobId, departmentId, reason)) {
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
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = view.getCscustomerIDField().getText();
                String productId = view.getCsproductIDField().getText();
                String description = view.getCsdescriptionField().getText();
                if(model.createTicket(customerId, productId, description )){
                    view.displayTicketSuccess();
                } else {
                    view.displayTicketFail();
                }
                view.clearTicketForm();
            }
        });
        this.view.setApplySellButton(new ActionListener() {
            //need to replace this with actualy getting of values and integrating to model and stuff
            @Override
            public void actionPerformed(ActionEvent e){
                String productId = view.getProductIdField().getText();
                String customerId = view.getCustomerIdField().getText();
                String branchId = view.getBranchIdField().getText();
                String quantity = view.getQuantityField().getText();
                if(model.sellProducts(productId, branchId, customerId, quantity)){
                    view.displaySellSuccess();
                } else {
                    view.displaySellFail();
                }
                view.clearSellForm();
            }
        });

        this.view.setApplySupplyButtonListener(new ActionListener() {
            //need to replace this with actualy getting of values and integrating to model and stuff
            @Override
            public void actionPerformed(ActionEvent e) {
                model.supplyProducts();
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
                //model.generateReports();
            }
        });
        this.view.setDiscardSellButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySellProducts();
            }
        });

        this.view.setCreateEmployeeButtonListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                view.displayCreateEmployeeForm();
            }
        });

        this.view.setReadEmployeeButtonListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                view.displayReadEmployeeForm();
            }
        });

        this.view.setemployeeRecordButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayEmployeeRecordsManagement();

            }
        });
        this.view.setbacktoManagePickBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayPickManagement();
            }
        });
        this.view.setUpdateEmployeeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayUpdateEmployeeForm();
            }
        });
        // This is for creating a new employee
        this.view.setCreateEmployeeApplyButtonListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String firstName = view.getCreateFirstNameFld().getText();
                String lastName = view.getCreateLastNameFld().getText();
                String branchID = view.getCreatebranchIdFld().getText();
                String JobId = view.getCreateJobIDfld().getText();
                String depID = view.getCreateDepartmentIDFld().getText();
                String hireDate = view.getCreateHireDateFld().getText();
                
                if(model.createEmployee(firstName, lastName, branchID, JobId, depID, hireDate) ){
                    //view.displayCreateSuccess();
                } else {
                    view.displayCreateFail();
                }
                view.clearCreateForm();

            }
        });

        this.view.setReadEmployeeApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeId = view.getReadEmployeeIdFld().getText();
                if(model.readEmployee(employeeId)){
                    // view.displayReadSuccess();
                } else {
                    // view.displayReadFail();
                }
                view.clearReadForm();
            }
        });
        this.view.setUpdateEmployeeApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeId = view.getUpdateEmployeeIdFld().getText();
                String firstName = view.getUpdateFirstNameFld().getText();
                String lastName = view.getUpdateLastNameFld().getText();
                String branchID = view.getUpdateBranchIdFld().getText();
                String JobId = view.getUpdateJobIDfld().getText();
                String depID = view.getUpdateDepartmentIDFld().getText();
                String hireDate = view.getUpdateHireDateFld().getText();
                if(model.updateEmployee(employeeId, firstName, lastName, branchID, JobId, depID, hireDate)){
                    // view.displayUpdateSuccess();
                } else {
                    view.displayUpdateFail();
                }
                view.clearUpdateForm();
            }
        });
        this.view.setDeleteEmployeeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayDeleteEmployeeForm();
            }
        });
        this.view.setDeleteEmployeeApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this employee?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );
        
                if (response == JOptionPane.YES_OPTION) {
                    // Call the method to delete the employee
                    String employeeId = view.getDeleteEmployeeIdFld().getText();
                    if(model.deleteEmployee(employeeId)){
                        // view.displayDeleteSuccess();
                    } else {
                        // view.displayDeleteFail();
                    }
                    
                }
            }
        });
        this.view.setDeleteEmployeeDiscardButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearDeleteForm();
             
            }
        });
        this.view.setCreateEmployeeDiscardButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearCreateForm();
                
            }
        });
        this.view.setReadEmployeeDiscardButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearReadForm();
               
            }
        });
        this.view.setUpdateEmployeeDiscardButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearUpdateForm();
               
            }
        });
        this.view.setcompterPartsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayComputerPartsManagement();
            }
        });

        this.view.setCreateComputerPartsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayCreateComputerForm();
            }
        });
        this.view.setCreatePartsApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String branchID = view.getCreatebranchIdFld().getText();
                String productName = view.getCreateproductNameFld().getText();
                String partType = view.getCreateClassField().getText();
                int partPrice = Integer.parseInt(view.getCreatepriceFld().getText());
                String partDescription= view.getCreatedescriptionFld().getText();
                int partStock =  Integer.parseInt(view.getCreatequantityFld().getText());
                int partWarranty = Integer.parseInt(view.getCreateWwarrantyField().getText());
                if(model.createComputerPartRecord(branchID, partType, productName, partDescription, partStock, partPrice, partWarranty)){
                    view.displayCreateSuccess();
                } else {
                    view.displayCreateFail();
                }
                view.clearCreateForm();
            }
        });
        this.view.setReadComputerPartsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayReadComputerPartsForm();
            }
        });
        this.view.setReadComputerPartsApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String partId = view.getReadProductIDFld().getText();
                if(model.readComputerPartRecord(partId)){
                    // view.displayReadSuccess();
                } else {
                    view.displayReadFail();
                }
                view.clearReadForm();
            }
        });
        this.view.setUpdateComputerPartsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayUpdateComputerPartsForm();
            }
        });
        this.view.setUpdateComputerPartsApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String partId = view.getUpdateProductIDFld().getText();
                String branchID = view.getBranchIdField().getText();
                String productName = view.getUpdateproductNameFld().getText();
                String partType = view.getUpdateClassField().getText();
                int partPrice = Integer.parseInt(view.getUpdatepriceFld().getText());
                String partDescription= view.getUpdatedescriptionFld().getText();
                int partStock =  Integer.parseInt(view.getUpdatequantityFld().getText());
                int partWarranty = Integer.parseInt(view.getUpdateWwarrantyField().getText());
                if(model.updateComputerPartRecord(partId, branchID, partDescription, productName, partDescription, partStock, partPrice, partWarranty)){
                    view.displayUpdateSuccess();
                } else {
                    view.displayUpdateFail();
                }
                view.clearUpdateForm();
            }
        });
       
        this.view.setDeleteComputerPartsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayDeleteComputerPartsForm();
            }
        });
        this.view.setDeleteComputerPartsApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this computer part?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );
        
                if (response == JOptionPane.YES_OPTION) {
                    // Call the method to delete the employee
                    String partId = view.getDeleteProductIDFld().getText();
                    if (model.deleteComputerPartRecord(partId)){
                        // view.displayDeleteSuccess();
                    } else {
                        // view.displayDeleteFail();
                    }
                    
                }
            }
        });
        
        this.view.setcusomterRecordButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayCustomerRecordManagement();
                
            }
        });

        this.view.setCreateCustomerButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayCreateCustomerForm();
            }
        });

        this.view.setCreateCustomerApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = view.getCreateFirstNameFld().getText();
                String lastName = view.getCreateLastNameFld().getText();
                int contactNumber = Integer.parseInt(view.getCreateContactNumberFld().getText());
                String emailAddress = view.getCreateEmailFld().getText();
                String shippingAddresss = view.getCreateShippingAddressFld().getText();
                
                
                if(model.createCustomerRecord(lastName, firstName, contactNumber,emailAddress,shippingAddresss) ){
                    // view.displayCreateSuccess();
                } else {
                    // view.displayCreateFail();
                }
                view.clearCreateForm();
            }
        });

        this.view.setReadCustomerButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayReadCustomerForm();
            }
        });
        this.view.setReadCustomerApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = view.getReadCustomerIDFld().getText();
                if(model.readCustomerRecord(customerId)){
                    // view.displayReadSuccess();
                } else {
                    //view.displayReadFail();
                }
                view.clearReadForm();
            }
        });
        this.view.setUpdateCustomerButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayUpdateCustomerForm();
            }
        });
        this.view.setUpdateCustomerApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = view.getUpdateCustomerIDFld().getText();
                String firstName = view.getUpdateFirstNameFld().getText();
                String lastName = view.getUpdateLastNameFld().getText();
                Long contactNumber = Long.parseLong(view.getUpdateContactNumberFld().getText());
                String emailAddress = view.getUpdateEmailFld().getText();
                String shippingAddresss = view.getUpdateShippingAddressFld().getText();
                if(model.updateCustomerRecord(customerId, lastName, firstName, contactNumber,emailAddress,shippingAddresss)){
                    //view.displayUpdateSuccess();
                } else {
                    //view.displayUpdateFail();
                }
                view.clearUpdateForm();
            }
        });

        this.view.setDeleteCustomerButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayDeleteCustomerForm();
            }
        });
        this.view.setDeleteCustomerApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this customer?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );
        
                if (response == JOptionPane.YES_OPTION) {
                    // Call the method to delete the employee
                    String customerId = view.getDeleteCustomerIDFld().getText();
                    if(model.deleteCustomerRecord(customerId)){
                        //view.displayDeleteSuccess();
                    } else {
                        //view.displayDeleteFail();
                    }
                    
                }
            }
        });
        this.view.setbranchRecordButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayBranchRecordManagement();
                
            }
        });
        this.view.setCreateBranchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayCreateBranchForm();
            }
        });
        this.view.setCreateBranchApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String branchName = view.getCreateBranchNameFld().getText();
                String branchLocation = view.getCreateBranchLocationFld().getText();
                Long branchContactNumber = Long.parseLong(view.getCreateBranchContactNumberFld().getText());
                int branchManager = Integer.parseInt(view.getCreateManagerIDFld().getText());
                if(model.createBranchRecord(branchName, branchLocation, branchContactNumber, branchManager)){
                    //view.displayCreateSuccess();
                } else {
                    //view.displayCreateFail();
                }
                view.clearCreateForm();
            }
        });

        this.view.setReadBranchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayReadBranchForm();
            }
        });
        this.view.setReadBranchApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String branchId = view.getReadBranchIDFld().getText();
                if(model.readBranchRecord(branchId)){
                    //view.displayReadSuccess();
                } else {
                    //view.displayReadFail();
                }
                view.clearReadForm();
            }
        });
        this.view.setUpdateBranchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayUpdateBranchForm();
            }
        });
        this.view.setUpdateBranchApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String branchId = view.getUpdateBranchIdFld().getText();
                String branchName = view.getUpdateBranchNameFld().getText();
                String branchLocation = view.getUpdateBranchLocationFld().getText();
                Long branchContactNumber = Long.parseLong(view.getUpdateBranchContactNumberFld().getText());
                int branchManager = Integer.parseInt(view.getUpdateManagerIDFld().getText());
                if(model.updateBranchRecord(branchId, branchName, branchLocation, branchContactNumber, branchManager)){
                    //view.displayUpdateSuccess();
                } else {
                    //view.displayUpdateFail();
                }
                view.clearUpdateForm();
            }
        });
        this.view.setDeleteBranchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayDeleteBranchForm();
            }
        });
        this.view.setDeleteBranchApplyButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this branch?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );
        
                if (response == JOptionPane.YES_OPTION) {
                    // Call the method to delete the employee
                    String branchId = view.getDeleteBranchIDFld().getText();
                    if(model.deleteBranchRecord(branchId)){
                        //view.displayDeleteSuccess();
                    } else {
                        //view.displayDeleteFail();
                    }
                    
                }
            }
        });
        this.view.setGenerateSalesReportBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySalesReportForm();
            }
        });
        this.view.setGenerateSalesReportGnrtBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String month = view.getReportMonthField().getText();
                String year = view.getReportYearField().getText();
                String branchId  = view.getReportBranchIdField().getText();
                
                  if(model.generateSalesReport(branchId, month,year)){
                    view.displaySalesReportSuccess();
                }    else {
                    view.displaySalesReportFail();
                }
                view.clearGenerateForm();
                 
                 
               
            }
        });

        this.view.setGenerateBranchStockReportBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayStocksReportForm();
            }
        });
        this.view.setGenerateBranchStockReportGnrtBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String branchId = view.getReportBranchIdField().getText();
                String month = view.getReportMonthField().getText();
                String year = view.getReportYearField().getText();

                if(model.generateStockReport(branchId, month, year)){
                    view.displayStockReportSuccess();
                } else {
                    view.displayStockReportFail();
                }
                view.clearGenerateForm();
            }
        });
        this.view.setGenerateCustomerSatisifactioBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySatisfactionReportForm();
            }
        });
        this.view.setGenerateCustomerSatisifactioGnrtBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String month = view.getReportMonthField().getText();
                String year = view.getReportYearField().getText();
                String branchId = view.getReportBranchIdField().getText();
                if(model.generateSatisfactionReport(branchId, month, year)){
                    view.displayTicketReportSuccess();
                } else {
                    view.displayTicketReportFail();
                }
                view.clearGenerateForm();
            }
        });
        this.view.setGenerateCustomerTicketReportBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayTicketsReportForm();
            }
        });
        this.view.setGenerateCustomerTicketReportGnrtBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String month = view.getReportMonthField().getText();
                String year = view.getReportYearField().getText();
                String branchId = view.getReportBranchIdField().getText();
                if(model.generateTicketReport(branchId, month, year)){
                    view.displayTicketReportSuccess();
                } else {
                    view.displayTicketReportFail();
                }
                view.clearGenerateForm();
            }
        });
        this.view.setGenerateSalesReportDiscardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearGenerateForm();
            }
        });
        this.view.setGenerateBranchStockReportDiscardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearGenerateForm();
            }
        });
        this.view.setGenerateCustomerSatisifactioDiscardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearGenerateForm();
            }
        });
        this.view.setGenerateCustomerTicketReportDiscardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearGenerateForm();
            }
        });
        




    }
}
