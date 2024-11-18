import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                model.sellProducts();
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
                model.transferEmployee();
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
