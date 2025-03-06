import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Vehiculo {
    private String placa;
    private String tipo; // Puede ser "Carro", "Moto", etc.
    private int puertas;

    public Vehiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Tipo: " + tipo;
    }
}

class Parqueadero {
    private int capacidadMaxima;
    private Map<String, Vehiculo> espacios;

    public Parqueadero(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.espacios = new HashMap<>();
    }

    public boolean agregarVehiculo(Vehiculo vehiculo) {
        if (espacios.size() < capacidadMaxima) {
            espacios.put(vehiculo.getPlaca(), vehiculo);
            System.out.println("Vehículo agregado: " + vehiculo);
            return true;
        } else {
            System.out.println("Parqueadero lleno. No se puede agregar el vehículo.");
            return false;
        }
    }

    public boolean removerVehiculo(String placa) {
        if (espacios.containsKey(placa)) {
            Vehiculo vehiculo = espacios.remove(placa);
            System.out.println("Vehículo retirado: " + vehiculo);
            return true;
        } else {
            System.out.println("No se encontró un vehículo con la placa: " + placa);
            return false;
        }
    }

    public void mostrarEstado() {
        System.out.println("\nEstado actual del parqueadero:");
        if (espacios.isEmpty()) {
            System.out.println("El parqueadero está vacío.");
        } else {
            for (Vehiculo v : espacios.values()) {
                System.out.println(v);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(5); // Capacidad máxima de 5 vehículos

        while (true) {
            System.out.println("\n1. Agregar vehículo");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Mostrar estado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese el tipo de vehículo: ");
                    String tipo = scanner.nextLine();
                    parqueadero.agregarVehiculo(new Vehiculo(placa, tipo));
                    break;
                case 2:
                    System.out.print("Ingrese la placa del vehículo a retirar: ");
                    String placaRetirar = scanner.nextLine();
                    parqueadero.removerVehiculo(placaRetirar);
                    break;
                case 3:
                    parqueadero.mostrarEstado();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
