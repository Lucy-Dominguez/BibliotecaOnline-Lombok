package factory;

public interface Libro {
    String getTitulo(); // Me aseguro con el get que sin importar si es digital o Fisico va a tener estos atributos
    String getAutor();
    String getTipo();
    int getPaginas();
}
