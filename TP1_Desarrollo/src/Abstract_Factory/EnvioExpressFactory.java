package Abstract_Factory;

public class EnvioExpressFactory extends AbstractFactoryEnvio{
    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioExpress();
    }
}
