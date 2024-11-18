import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.multi.MultiViewportUI;
import javax.swing.text.View;
// the controller or the middleman of both the model and the view
public class ComputerStoreController {
    private ComputerStoreManagement model;
    private userView view;

    public ComputerStoreController(ComputerStoreManagement model, userView view) {
        this.model = model;
        this.view = view;

        this.view.addSellProductsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displaySellProducts();
            }
        });
        this.view.addSupplyProductsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.supplyProducts();
            }
        });
        this.view.addTransferEmployeeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayTransferEmployeeForm();
                view.disableAllMainBtns();
            }
        });

        this.view.applyTransferEmployeeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeId = view.getEmployeeIdField().getText();
                String oldBranchId = view.getOldBranchIdField().getText();
                String newBranchId = view.getNewBranchIdField().getText();
                String newJobId = view.getNewJobIdField().getText();
                String departmentId = view.getDepartmentIdField().getText();
                String reason = view.getReasonField().getText();
                StringBuilder error = new StringBuilder();
                if(model.validTransfer(employeeId, oldBranchId, newBranchId, newJobId, departmentId, reason, error)) {
                    if(model.transferEmployee(employeeId, oldBranchId, newBranchId, newJobId, departmentId, reason)) {
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

        this.view.discardTransferEmployeeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.displayTransferEmployeeForm();
            }
        });

        this.view.backjButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.enableAllMainBtns();
                view.displayMainScreen();
            }
        });
        this.view.addCustomerSupportListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.handleCustomerSupport();
            }   
        });
        this.view.addGenerateReportsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.generateReports();
            }
        });
    }

   
}
