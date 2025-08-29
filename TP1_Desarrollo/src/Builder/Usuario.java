package Builder;

import lombok.Builder;

@Builder
public class Usuario {
    private String nombre;
    private String email;
    private String domicilio;
    private double telefono;
}
