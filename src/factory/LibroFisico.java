package factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //No genero constructores
@NoArgsConstructor //Crea constructor vacio
@AllArgsConstructor //Crea constructor con todos los atributos

public class LibroFisico implements Libro{
    private String titulo;
    private String autor;
    private int paginas;

    @Override public String getTitulo() { return titulo;}
    @Override public String getAutor() {return autor;}
    @Override public String getTipo(){
        return "Fisico";
    }
    public int getPaginas() { return paginas;}
}
