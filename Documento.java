import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Documento {
    private String titulo;
    private boolean esConfidencial;
    private String grupo;
    private File archivo; // Archivo que representa el documento

    public Documento(String titulo, boolean esConfidencial, String grupo) {
        this.titulo = titulo;
        this.esConfidencial = esConfidencial;
        this.grupo = grupo;
        this.archivo = new File(titulo + ".txt"); // Crea un archivo con el título del documento

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
            e.printStackTrace();
        }
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
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo.getPath())));
            System.out.println("Contenido del documento '" + titulo + "':\n" + contenido);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }

    public void modificarContenido(String nuevoContenido) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(nuevoContenido);
            System.out.println("Contenido del documento '" + titulo + "' ha sido actualizado.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}
