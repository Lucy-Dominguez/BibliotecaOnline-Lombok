package factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LibroDigital implements Libro{
    private String titulo;
    private String autor;
    private int paginas;

    @Override public String getTitulo() { return titulo; }
    @Override public String getAutor() {return autor;}
    @Override public String getTipo (){
        return "Digital";
    }
    public int getPaginas() { return paginas;}
}
