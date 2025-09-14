package abstractfactory;

import factory.Libro;

public class EnvioExpress implements MetodoEnvio {
    @Override public void enviar(Libro libro, String destino) {//Llamado al metodo enviar en la claase al metodo envio
        System.out.println("Envio express a:" + destino + "del libro" + libro.getTitulo());
    }
}
