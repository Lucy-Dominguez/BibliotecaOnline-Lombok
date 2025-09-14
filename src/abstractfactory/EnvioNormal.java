package abstractfactory;

import factory.Libro;

public class EnvioNormal implements MetodoEnvio {
    @Override public void enviar(Libro libro, String destino) {//Llamado al metodo enviar en la claase al metodo envio
        System.out.println("Envio a:" + destino  + "del libro" + libro.getTitulo());
    }
}

