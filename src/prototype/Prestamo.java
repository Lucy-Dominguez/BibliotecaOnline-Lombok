package prototype;

import builder.Usuario;
import factory.Libro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Prestamo implements Cloneable{
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Evita duplicacion de prestamos
    @Override public Prestamo clone (){
        try {
            return (Prestamo) super.clone();
        }
        catch (CloneNotSupportedException e){
            throw new AssertionError(e);
        }
    }

}
