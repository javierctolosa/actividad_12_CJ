import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class actividad_12_CJ {
    public static void main(String[] args) {

        System.out.println("""
                Bienvenido(a) a tu agenda virtual
                """);

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion;

        HashMap<String, Long> agenda = new HashMap<>();

        Leer teclado = new Leer();

        String nombre;
        long telefono;

        while (!salir) {

            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Salir");
            System.out.println();

            try {
                System.out.println("Selecciona una de las opciones:");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println();
                        nombre = teclado.pedirString("Introduce el nombre:");
                        System.out.println();
                        telefono = teclado.pedirLong("Introduce el teléfono:");
                        System.out.println();

                        if(!agenda.containsKey(nombre)){
                            agenda.put(nombre, telefono);
                            System.out.println("Se ha añadido el contacto.");
                        }else{
                            System.out.println("Ya existe el contacto.");
                        }
                        System.out.println();

                        break;

                    case 2:
                        System.out.println();
                        if(agenda.entrySet().isEmpty()){
                            System.out.println("No hay contactos.");
                            System.out.println();
                        }else{

                            for(Map.Entry<String, Long> entry: agenda.entrySet()){
                                System.out.println("Nombre: "+entry.getKey()+" - Teléfono: "+entry.getValue());
                                System.out.println();
                            }
                        }

                        break;

                    case 3:
                        System.out.println();
                        nombre = teclado.pedirString("Introduce el nombre:");

                        if(agenda.containsKey(nombre)){
                            System.out.println("Su teléfono es: "+agenda.get(nombre));
                        }else{
                            System.out.println("El contacto no existe.");
                        }
                        System.out.println();
                        break;

                    case 4:
                        System.out.println();
                        nombre = teclado.pedirString("Introduce el nombre:");

                        if(agenda.containsKey(nombre)){
                            System.out.println("El contacto existe.");
                        }else{
                            System.out.println("El contacto no existe.");
                        }
                        System.out.println();
                        break;

                    case 5:
                        System.out.println();
                        nombre = teclado.pedirString("Introduce el nombre:");

                        if(agenda.containsKey(nombre)){
                            agenda.remove(nombre);
                            System.out.println("El contacto se ha borrado.");
                        }else{
                            System.out.println("El contacto no existe.");
                        }
                        System.out.println();
                        break;

                    case 6:
                        salir = true;
                        break;

                    default:
                        System.out.println("Solo números entre 1 y 6.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número.");
                sn.next();
            }

        }

    }

}
