public class DocumentoProxy implements DocumentoAccesible {
    public Documento documento;

    public DocumentoProxy(Documento documento) {
        this.documento = documento;
    }

    @Override
    public void acceder(Usuario usuario) {
        if (verificarPermiso(usuario)) {
            documento.mostrarContenido();
        } else {
            System.out.println("Acceso denegado, permisos insuficientes.");
        }
    }

    private boolean verificarPermiso(Usuario usuario) {
        switch (usuario.getRol()) {
            case "Administrador":
                return true; // Administradores tienen acceso total
            case "Gerente":
                return documento.esConfidencial() && documento.getGrupo().equals(usuario.getGrupo());
            case "Empleado":
                return !documento.esConfidencial() && documento.getGrupo().equals(usuario.getGrupo());
            default:
                return false;
        }
    }

    public String getTitulo(){
        return documento.getTitulo();
    }
}