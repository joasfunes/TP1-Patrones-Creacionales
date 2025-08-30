package Builder;

import lombok.ToString;

@ToString
public class Usuario {
    private String nombre;
    private String email;
    private String domicilio;
    private String telefono;

    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.domicilio = builder.domicilio;
        this.telefono = builder.telefono;
    }

    public static void mostrar(Usuario usuario){
        System.out.println(usuario);
    }

    public static class Builder{
        private String nombre, email, domicilio, telefono;

        public Builder nombre(String n){this.nombre=n;return this;}
        public Builder email(String e){this.email=e;return this;}
        public Builder domicilio(String d){this.domicilio=d;return this;}
        public Builder telefono(String t){this.telefono=t;return this;}
        public Usuario build(){return new Usuario(this);}
    }
}
