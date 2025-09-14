package builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;

}
