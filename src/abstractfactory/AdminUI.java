package abstractfactory;

public class AdminUI implements InterfazUI{
    @Override public void render(){
        System.out.println("UI admin: gestion avanzada de catalogos, usuarios y reportes");
    }
}
