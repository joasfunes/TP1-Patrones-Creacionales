package Prototype;

import Builder.Usuario;
import Factory_Method.Libro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prestamo implements Cloneable{
    private Libro libro;
    private Usuario usuario;
    private String fechaInicio;
    private String fechaFin;


    public Prestamo clone(){
        try{
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }


}
