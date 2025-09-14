package abstractfactory;

public class UsuarioUI implements InterfazUI{
    @Override public void render(){
        System.out.println("UI Usuario: busqueda, reseña y lectura de libros");
    }
}
