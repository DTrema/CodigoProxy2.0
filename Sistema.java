import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sistema {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<DocumentoProxy> documentos = new ArrayList<>();

    public void registrarUsuario(String nombre, String rol, String grupo) {
        Usuario usuario = new Usuario(nombre, rol, grupo);
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + nombre + " - Rol: " + rol + " - Grupo: " + grupo);
    }

    public void agregarDocumento(String titulo, boolean esConfidencial, String grupo, Usuario usuario) {
        if (usuario.getRol().equals("Administrador")) {
            Documento doc = new Documento(titulo, esConfidencial, grupo);
            DocumentoProxy proxy = new DocumentoProxy(doc);
            documentos.add(proxy);
            System.out.println("Documento agregado: " + titulo + " - Confidencial: " + esConfidencial + " - Grupo: " + grupo);
        } else {
            System.out.println("Acceso denegado: solo los administradores pueden agregar documentos.");
        }
    }

    public void eliminarDocumento(String titulo, Usuario usuario) {
        if (usuario.getRol().equals("Administrador")) {
            documentos.removeIf(doc -> doc.documento.getTitulo().equals(titulo));
            System.out.println("Documento eliminado: " + titulo);
        } else {
            System.out.println("Acceso denegado: solo los administradores pueden eliminar documentos.");
        }
    }

    public void accederADocumento(String titulo, Usuario usuario) {
        for (DocumentoProxy docProxy : documentos) {
            if (docProxy.documento.getTitulo().equals(titulo)) {
                docProxy.acceder(usuario);
                return;
            }
        }
        System.out.println("Documento no encontrado: " + titulo);
    }

    // Método para encontrar un usuario por nombre
    public Optional<Usuario> buscarUsuario(String nombre) {
        return usuarios.stream().filter(u -> u.getNombre().equals(nombre)).findFirst();
    }

    // Cambiar el rol de un usuario
    public void cambiarRol(String nombre, String nuevoRol) {
        buscarUsuario(nombre).ifPresentOrElse(
            usuario -> {
                usuario.setRol(nuevoRol);
                System.out.println("Rol de " + nombre + " actualizado a " + nuevoRol);
            },
            () -> System.out.println("Usuario no encontrado.")
        );
    }

    // Cambiar el grupo de un usuario
    public void cambiarGrupo(String nombre, String nuevoGrupo) {
        buscarUsuario(nombre).ifPresentOrElse(
            usuario -> {
                usuario.setGrupo(nuevoGrupo);
                System.out.println("Grupo de " + nombre + " actualizado a " + nuevoGrupo);
            },
            () -> System.out.println("Usuario no encontrado.")
        );
    }

    public void listaUsuarios(){
        System.out.println("\nUsuarios:");
        for(Usuario usuario : usuarios){
            System.out.println("- " + usuario.getNombre());
        }
    }

    public void listaDocumentos(){
        System.out.println("\nDocumentos:");
        for(DocumentoProxy documento : documentos){
            System.out.println("- " + documento.getTitulo());
        }
    }
}
