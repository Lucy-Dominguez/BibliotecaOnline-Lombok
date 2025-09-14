package abstractfactory;

import factory.Libro;

public interface MetodoEnvio {
    //Enviar el libro al destino indicado
    void enviar(Libro libro, String destino);
}
