// Clase Usuario
public class Usuario {
    private String nombre;
    private String rol; // "Empleado", "Gerente" o "Administrador"
    private String grupo; // Grupo de trabajo del usuario (Grupo_A, Grupo_B, etc.)

    public Usuario(String nombre, String rol, String grupo) {
        this.nombre = nombre;
        this.rol = rol;
        this.grupo = grupo;
    }

    public String getRol() {
        return rol;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getNombre() {
        return nombre;
    }

    // Métodos para actualizar rol y grupo
    public void setRol(String nuevoRol) {
        this.rol = nuevoRol;
    }

    public void setGrupo(String nuevoGrupo) {
        this.grupo = nuevoGrupo;
    }
}
