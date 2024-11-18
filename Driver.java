public class Driver {
    public static void main(String[] args) {
        ComputerStoreManagement model = new ComputerStoreManagement();
        userView view = new userView();
        ComputerStoreController controller = new ComputerStoreController(model, view);
    }
}