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
    }

    public void addSellProductsListener(ActionListener listener) {
        btnSellProducts.addActionListener(listener);
    }

    public void addSupplyProductsListener(ActionListener listener) {
        btnSupplyProducts.addActionListener(listener);
    }

    public void addTransferEmployeeListener(ActionListener listener) {
        btnTransferEmployee.addActionListener(listener);
    }

    public void addCustomerSupportListener(ActionListener listener) {
        btnCustomerSupport.addActionListener(listener);
    }

    public void addGenerateReportsListener(ActionListener listener) {
        btnGenerateReports.addActionListener(listener);
    }
}