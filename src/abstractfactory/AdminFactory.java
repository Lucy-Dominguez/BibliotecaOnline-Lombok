package abstractfactory;

public class AdminFactory implements AbstractFactory{
    @Override public InterfazUI crearUI(){
        return new AdminUI();
    }
    @Override public MetodoEnvio crearMetodoEnvio(){
        return new EnvioExpress();
    }
}
