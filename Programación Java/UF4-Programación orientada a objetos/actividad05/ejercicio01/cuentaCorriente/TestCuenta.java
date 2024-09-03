/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad05.ejercicio01.cuentaCorriente;

/**
 *
 * @author asier
 */
public class TestCuenta {

    public static void main(String[] args) {

        // Crear dos cuentas
        Cuenta cuenta1 = new Cuenta(123456789, 1000.0, "Juan Pérez");
        Cuenta cuenta2 = new Cuenta(987654321, 5000.0, "María Gómez");

        // Menú principal
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Sacar dinero");
            System.out.println("4. Realizar transferencia");
            System.out.println("5. Salir");
            opcion = Utilidades.pedirEntero("Introduce una opción: ");

            switch (opcion) {
                case 1:
                    consultarSaldo(cuenta1, cuenta2);
                    break;
                case 2:
                    ingresarDinero(cuenta1, cuenta2);
                    break;
                case 3:
                    sacarDinero(cuenta1, cuenta2);
                    break;
                case 4:
                    realizarTransferencia(cuenta1, cuenta2);
                    break;
                case 5:
                    System.out.println("Gracias por participar!");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce otra opción.");
            }
        } while (opcion != 5);
    }

    private static void consultarSaldo(Cuenta cuenta1, Cuenta cuenta2) {
        int cuenta = Utilidades.pedirEntero("¿De qué cuenta quieres consultar el saldo? (1 o 2): ");

        switch (cuenta) {
            case 1:
                System.out.println("El saldo de la cuenta " + cuenta1.getNumeroCuenta() + " es de " + cuenta1.getSaldo() + " euros.");
                break;
            case 2:
                System.out.println("El saldo de la cuenta " + cuenta2.getNumeroCuenta() + " es de " + cuenta2.getSaldo() + " euros.");
                break;
            default:
                System.out.println("Cuenta no válida. Introduce otra cuenta.");
        }
    }

    private static void ingresarDinero(Cuenta cuenta1, Cuenta cuenta2) {
        int cuenta = Utilidades.pedirEntero("¿En qué cuenta quieres ingresar dinero? (1 o 2): ");
        double cantidad = Utilidades.pedirDecimal("¿Cuánto dinero quieres ingresar?: ");

        switch (cuenta) {
            case 1:
                cuenta1.setSaldo(cuenta1.getSaldo() + cantidad);
                System.out.println("Se han ingresado " + cantidad + " euros en la cuenta " + cuenta1.getNumeroCuenta());
                System.out.println("Saldo actual de la cuenta " + cuenta1.getNumeroCuenta() + ": " + cuenta1.getSaldo() + " euros.\nSaldo actual de la cuenta " + cuenta2.getNumeroCuenta() + ": " + cuenta2.getSaldo() + " euros.");
                break;
            case 2:
                cuenta2.setSaldo(cuenta2.getSaldo() + cantidad);
                System.out.println("Se han ingresado " + cantidad + " euros en la cuenta " + cuenta2.getNumeroCuenta());
                System.out.println("Saldo actual de la cuenta " + cuenta1.getNumeroCuenta() + ": " + cuenta1.getSaldo() + " euros.\nSaldo actual de la cuenta " + cuenta2.getNumeroCuenta() + ": " + cuenta2.getSaldo() + " euros.");
                break;
            default:
                System.out.println("Cuenta no válida. Introduce otra cuenta.");
        }
    }

    private static void sacarDinero(Cuenta cuenta1, Cuenta cuenta2) {
        int cuenta = Utilidades.pedirEntero("¿De qué cuenta quieres sacar el dinero? (1 o 2): ");
        double cantidad = Utilidades.pedirDecimal("¿Cuánto dinero quieres sacar?: ");
        switch (cuenta) {
            case 1:
                if (cantidad > cuenta1.getSaldo()) {
                    System.out.println("No tienes suficiente saldo en la cuenta.");
                    break;
                } else {
                    cuenta1.setSaldo(cuenta1.getSaldo() - cantidad);
                    System.out.println("Se ha retirado " + cantidad + " euros de la cuenta " + cuenta1.getNumeroCuenta());
                    System.out.println("Saldo actual de la cuenta " + cuenta1.getNumeroCuenta() + ": " + cuenta1.getSaldo() + " euros.\nSaldo actual de la cuenta " + cuenta2.getNumeroCuenta() + ": " + cuenta2.getSaldo() + " euros.");
                    break;
                }

            case 2:
                if (cantidad > cuenta2.getSaldo()) {
                    System.out.println("No tienes suficiente saldo en la cuenta.");
                    break;
                } else {
                    cuenta2.setSaldo(cuenta2.getSaldo() - cantidad);
                    System.out.println("Se ha retirado " + cantidad + " euros de la cuenta " + cuenta2.getNumeroCuenta());
                    System.out.println("Saldo actual de la cuenta " + cuenta1.getNumeroCuenta() + ": " + cuenta1.getSaldo() + " euros.\nSaldo actual de la cuenta " + cuenta2.getNumeroCuenta() + ": " + cuenta2.getSaldo() + " euros.");
                    break;
                }
            default:
                System.out.println("Cuenta no válida. Introduce otra cuenta.");
        }
    }

    private static void realizarTransferencia(Cuenta cuenta1, Cuenta cuenta2) {
        int cuenta = Utilidades.pedirEntero("¿De qué cuenta quieres transferir el dinero? (1 o 2): ");
        double cantidad = Utilidades.pedirDecimal("¿Cuánto dinero quieres transferir?: ");
        switch (cuenta) {
            case 1:
                if (cantidad > cuenta1.getSaldo()) {
                    System.out.println("No tienes suficiente saldo en la cuenta.");
                    break;
                } else {
                    cuenta1.setSaldo(cuenta1.getSaldo() - cantidad);
                    cuenta2.setSaldo(cuenta2.getSaldo() + cantidad);
                    System.out.println("Has transferido " + cantidad + " euros de la cuenta " + cuenta1.getNumeroCuenta() + " a la cuenta " + cuenta2.getNumeroCuenta());
                    System.out.println("Saldo actual de la cuenta " + cuenta1.getNumeroCuenta() + ": " + cuenta1.getSaldo() + " euros.\nSaldo actual de la cuenta " + cuenta2.getNumeroCuenta() + ": " + cuenta2.getSaldo() + " euros.");
                    break;
                }

            case 2:
                if (cantidad > cuenta2.getSaldo()) {
                    System.out.println("No tienes suficiente saldo en la cuenta.");
                    break;
                } else {
                    cuenta2.setSaldo(cuenta2.getSaldo() - cantidad);
                    cuenta1.setSaldo(cuenta1.getSaldo() + cantidad);
                    System.out.println("Has transferido " + cantidad + " euros de la cuenta " + cuenta2.getNumeroCuenta() + " a la cuenta " + cuenta1.getNumeroCuenta());
                    System.out.println("Saldo actual de la cuenta " + cuenta1.getNumeroCuenta() + ": " + cuenta1.getSaldo() + " euros.\nSaldo actual de la cuenta " + cuenta2.getNumeroCuenta() + ": " + cuenta2.getSaldo() + " euros.");
                    break;
                }
            default:
                System.out.println("Cuenta no válida. Introduce otra cuenta.");
        }
    }

}
