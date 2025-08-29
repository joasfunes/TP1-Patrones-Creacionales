package Abstract_Factory;

public class UsuarioFactory extends AbstractFactoryUI{
    public InterfazUI crearInterfazUI(){
        return new UsuarioUI();
    }
}
