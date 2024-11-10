public class Documento {
    private String titulo;
    private boolean esConfidencial;
    private String grupo;

    public Documento(String titulo, boolean esConfidencial, String grupo) {
        this.titulo = titulo;
        this.esConfidencial = esConfidencial;
        this.grupo = grupo;
    }

    public boolean esConfidencial() {
        return esConfidencial;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void mostrarContenido() {
        System.out.println("Mostrando contenido del documento: " + titulo);
    }
}