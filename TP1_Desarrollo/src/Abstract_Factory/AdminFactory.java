package Abstract_Factory;

public class AdminFactory extends AbstractFactoryUI {
    public InterfazUI crearInterfazUI(){
        return new AdminUI();
    }

}
