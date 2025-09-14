import abstractfactory.*;
import builder.Usuario;
import factory.Libro;
import factory.LogisticaLibro;
import prototype.Prestamo;
import singleton.Database;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Parte 1 -Creo las bases de datos
        Database DB1 = Database.getInstance(); //Llamo a la coneccion con la base de datos
        Database DB2 = Database.getInstance();

        System.out.println(DB1 == DB2); //Probar que múltiples llamadas devuelvan la misma instancia.

        // Parte 2 - Creo los librros
        Libro L1 = LogisticaLibro.crear("Fisico", "Antonio Russell", "La edad dorada", 563);
        Libro L2 = LogisticaLibro.crear("Digital", "Perdo Alfonso", "La vaca lola", 33);
        Libro L3 = LogisticaLibro.crear("Fisico", "Sancho Panza", "La vida loca", 700);
        Libro L4 = LogisticaLibro.crear("Digital", "Juan Perez", "El ratón Perez", 210);

        // Cargo los libros en la BD de manera ordenada
        DB1.agregarLibro(L1);
        DB1.agregarLibro(L2);
        DB1.agregarLibro(L3);
        DB1.agregarLibro(L4);

        System.out.println("Total de libros en la Base de Datos:" + DB1.getLibros().size());
        DB1.getLibros().forEach( libro -> System.out.println("Tipo:" + libro.getTipo() + "Autor:" + libro.getAutor() + "Título:" + libro.getTitulo() + "Cantidad de páginas:" + libro.getPaginas()));

        // Parte 3 Creo los usuarios y administrador
        String tipoUsuario1 = (args.length > 0) ? args[0] : "Admin";
        String tipoUsuario2 = (args.length > 0) ? args[0] : "Usuario";

        System.out.println("Tipo de usuario:" + tipoUsuario1);
        System.out.println("Tipo de usuario:" + tipoUsuario2);

        // Relaciono el usuario con la interfaz correspondiente (elgir la fabrica adecuada)
        AbstractFactory fabrica = "Admin".equalsIgnoreCase(tipoUsuario1)
                ? new AdminFactory()
                : new UsuarioFactory();

        InterfazUI ui = fabrica.crearUI();  // Renderizar la UI específica
        MetodoEnvio envio = fabrica.crearMetodoEnvio(); // Ejecutar el envio coherente

        ui.render(); //Renderizar la interfaz de usuario

        // Seleccionando un libro para asignarle un envio
        Libro seleccionado = DB1.getLibros().get(0);
        System.out.println("El libro seleccionado es: " + seleccionado.getTitulo() + " del tipo " + seleccionado.getTipo() + " del autor " + seleccionado.getAutor());

        // Crear envio
        envio.enviar(seleccionado, " Calle Paraguay 122");

        // Parte 4 Creo los usuarios
        Usuario U1 = Usuario.builder()
                .nombre("Antonio")
                .email("anton@gmail.com")
                .direccion("Los andes 123")
                .fechaNacimiento(java.time.LocalDate.of(1998, 12, 24))
                .build();
        Usuario U2 = Usuario.builder()
                .nombre("Patroclo")
                .email("patroclito@gmail.com")
                .direccion("San Andres 456")
                .fechaNacimiento(java.time.LocalDate.of(2000, 8, 6))
                .build();
        Usuario U3 = Usuario.builder()
                .nombre("Lucia")
                .email("lucy@gmail.com")
                .direccion("Los alpes 123")
                .fechaNacimiento(java.time.LocalDate.of(2004, 4, 14))
                .build();

        System.out.println("Usuario1: " + U1);
        System.out.println("Usuario2: " + U2);
        System.out.println("Usuario3: " + U3);

        // Parte 5 y final
        if (DB1.getLibros().isEmpty()){
            Libro demostracion = LogisticaLibro.crear("Fisico", "Pedro Alfonso", "La vaca lola", 33);
            DB1.agregarLibro(demostracion);
        }
        Libro prestar = DB1.getLibros().get(2);

        Prestamo prototipo = new Prestamo(prestar, U1, LocalDate.now(), LocalDate.now().plusDays(7));

        Prestamo copia1 = prototipo.clone();
        copia1.setUsuario(U2);
        Prestamo copia2 = prototipo.clone();
        copia2.setFechaFin(LocalDate.now().plusDays(14));

        System.out.println(prototipo);
        System.out.println(copia1);
        System.out.println(copia2);

    }
}