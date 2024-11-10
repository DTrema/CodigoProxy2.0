import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        
        // Usuario administrador para realizar operaciones administrativas
        Usuario admin = new Usuario("Admin", "Administrador", "Grupo_A");
        
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Cambiar rol de usuario");
            System.out.println("3. Cambiar grupo de usuario");
            System.out.println("4. Agregar documento (Solo admin)");
            System.out.println("5. Eliminar documento (Solo admin)");
            System.out.println("6. Acceder a documento");
            System.out.println("7. Modificar contenido de documento (Solo admin)");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Rol del usuario (Empleado, Gerente, Administrador): ");
                    String rol = scanner.nextLine();
                    System.out.print("Grupo del usuario (Grupo_A, Grupo_B, Grupo_C, Grupo_D): ");
                    String grupo = scanner.nextLine();
                    sistema.registrarUsuario(nombre, rol, grupo);
                    break;

                case 2:
                    System.out.print("Nombre del usuario: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nuevo rol (Empleado, Gerente, Administrador): ");
                    rol = scanner.nextLine();
                    sistema.cambiarRol(nombre, rol);
                    break;

                case 3:
                    System.out.print("Nombre del usuario: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nuevo grupo (Grupo_A, Grupo_B, Grupo_C, Grupo_D): ");
                    grupo = scanner.nextLine();
                    sistema.cambiarGrupo(nombre, grupo);
                    break;

                case 4:
                    System.out.print("Título del documento: ");
                    String titulo = scanner.nextLine();
                    System.out.print("¿Es confidencial? (true/false): ");
                    boolean esConfidencial = scanner.nextBoolean();
                    scanner.nextLine(); // Consume la nueva línea
                    System.out.print("Grupo del documento (Grupo_A, Grupo_B, Grupo_C, Grupo_D): ");
                    grupo = scanner.nextLine();
                    sistema.agregarDocumento(titulo, esConfidencial, grupo, admin);
                    break;

                case 5:
                    System.out.print("Título del documento a eliminar: ");
                    titulo = scanner.nextLine();
                    sistema.eliminarDocumento(titulo, admin);
                    break;

                case 6:
                    System.out.print("Nombre del usuario que accede: ");
                    nombre = scanner.nextLine();
                    System.out.print("Título del documento: ");
                    titulo = scanner.nextLine();
                    sistema.buscarUsuario(nombre).ifPresentOrElse(
                        usuario -> sistema.accederADocumento(titulo, usuario),
                        () -> System.out.println("Usuario no encontrado.")
                    );
                    break;

                case 7:
                    System.out.print("Título del documento a modificar: ");
                    titulo = scanner.nextLine();
                    System.out.print("Nuevo contenido del documento: ");
                    String nuevoContenido = scanner.nextLine();
                    sistema.modificarDocumento(titulo, nuevoContenido, admin);
                    break;

                case 8:
                    running = false;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}

