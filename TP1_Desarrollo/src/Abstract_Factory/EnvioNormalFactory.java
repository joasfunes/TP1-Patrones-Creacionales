package Abstract_Factory;

public class EnvioNormalFactory extends AbstractFactoryEnvio{
    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioNormal();
    }
}
