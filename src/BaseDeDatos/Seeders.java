/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import TarjetaDeCredito.TarjetaDeCredito;
import TarjetaDeCredito.TransaccionTarjeta;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Clase abstracta Seeders para sembrar datos de prueba en la base de datos.
 * Contiene métodos para la creación de usuarios y cuentas. Implementa métodos
 * abstractos en clases derivadas.
 *
 * @author David Gomez
 */
public class Seeders {

    /**
     * Método principal para sembrar datos en la base de datos.
     *
     * @param base Base de datos en la que se sembrarán los datos.
     * @author David Gomez
     */
    public static void seed(BaseDeDatos base) {
        try {
            insertUsuarios(base);
            insertCuentas(base);
            insertTarjetas(base);
            insertServicios(base);
            insertarTransaccionTC(base);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para la creación de usuarios de prueba en la base de datos.
     *
     * @param base Base de datos en la que se crearán los usuarios.
     * @author David Gomez
     */
    private static void insertUsuarios(BaseDeDatos base) {
        // Creación de usuarios de prueba
        Usuario user1 = base.createUsuario("6660354", "123456", "654321", "davegomez426@gmail.com", "Paraguaya",
                "David Emmanuel", "Gomez Arca", new Date(1, 23, 1983), "0772411806");

        Usuario user2 = base.createUsuario("5173040", "123456", "654321", "davegomez426@gmail.com", "Paraguaya",
                "Jaime", "Nuñez", new Date(1, 23, 1983), "0772411806");

        Usuario user3 = base.createUsuario("1234567", "123456", "654321", "user3@example.com", "Nationality",
                "Alice", "Smith", new Date(3, 15, 1992), "123456789");

        Usuario user4 = base.createUsuario("7654321", "123456", "654321", "user4@example.com", "Nationality",
                "Bob", "Johnson", new Date(5, 8, 1985), "987654321");

        Usuario user5 = base.createUsuario("9876543", "123456", "654321", "user5@example.com", "Nationality",
                "Charlie", "Williams", new Date(7, 20, 1980), "543216789");

        Usuario user6 = base.createUsuario("2345678", "123456", "654321", "user6@example.com", "Nationality",
                "David", "Jones", new Date(9, 10, 1995), "987123654");

        Usuario user7 = base.createUsuario("8765432", "123456", "654321", "user7@example.com", "Nationality",
                "Eva", "Brown", new Date(11, 3, 1988), "654321987");

        Usuario user8 = base.createUsuario("3456789", "123456", "654321", "user8@example.com", "Nationality",
                "Frank", "Miller", new Date(12, 5, 1990), "147258369");

        Usuario user9 = base.createUsuario("6789123", "123456", "654321", "user9@example.com", "Nationality",
                "Grace", "Davis", new Date(4, 18, 1982), "159753468");

        Usuario user10 = base.createUsuario("8912345", "123456", "654321", "user10@example.com", "Nationality",
                "Henry", "Garcia", new Date(8, 1, 1987), "369852147");

        Usuario user11 = base.createUsuario("4567891", "123456", "654321", "user11@example.com", "Nationality",
                "Ivy", "Rodriguez", new Date(2, 25, 1993), "753159852");

        Usuario user12 = base.createUsuario("1122334", "123456", "654321", "user12@example.com", "Nationality",
                "Jack", "Martinez", new Date(6, 12, 1984), "852963741");

    }

    /**
     * Método para la creación de cuentas de prueba en la base de datos.
     *
     * @param base Base de datos en la que se crearán las cuentas.
     * @throws Exception Si no hay usuarios en la base de datos.
     * @author David Gomez
     */
    private static void insertCuentas(BaseDeDatos base) throws Exception {
        // Obtención de la lista de usuarios en la base de datos
        ArrayList<Usuario> usuarios = base.getUsuarios();

        // Verificación de existencia de usuarios
        if (!usuarios.isEmpty()) {
            // Creación de cuentas con valores aleatorios
            for (Usuario usuario : usuarios) {
                double saldoInicial =usuario.getCi().compareTo("6660354") == 0 ? 20000000 : Math.random() * 1000000;  // Valor Double aleatorio
                String tipoCuenta = Math.random() < 0.5 ? "Cuenta corriente" : "Caja de ahorro"; // Aleatoriamente elige
                // el tipo de cuenta

                base.createCuenta(usuario.getCi(), saldoInicial, tipoCuenta);
            }

        } else {
            throw new Exception("No hay usuarios en la base");
        }
    }

    /**
     * Inserta tarjetas de crédito en la base de datos para cada usuario
     * existente.
     *
     * @param base La base de datos en la que se insertarán las tarjetas de
     * crédito.
     * @throws Exception Si no hay usuarios en la base.
     *
     * @author David Gomez
     */
    private static void insertTarjetas(BaseDeDatos base) throws Exception {
        ArrayList<Usuario> usuarios = base.getUsuarios();

        // Verificación de existencia de usuarios
        if (!usuarios.isEmpty()) {
            // Creación de cuentas con valores aleatorios
            for (Usuario usuario : usuarios) {
                double saldoInicial = usuario.getCi().compareTo("6660354") == 0 ? 20000000 : Math.random() * 1000000; // Valor Double aleatorio
                String tipoTarjeta = Math.random() < 0.5 ? "Cuenta corriente" : "Caja de ahorro"; // Aleatoriamente
                // elige el tipo de
                // cuenta
                String afinidad = Math.random() < 0.5 ? "Master Card" : "Visa"; // Aleatoriamente elige el tipo de
                // cuenta

                base.createTarjetaDeCredito(usuario.getCi(), tipoTarjeta, "1234", afinidad, saldoInicial);
            }
        } else {
            throw new Exception("No hay usuarios en la base");
        }
    }

    /**
     * Inserta servicios en la base de datos.
     *
     * @param base La base de datos en la que se insertarán los servicios.
     *
     * @author David Gomez
     */
    private static void insertServicios(BaseDeDatos base) {
        base.addServicio("Electricidad", "ANDE");
        base.addServicio("Agua", "Municipalidad");
        base.addServicio("Internet", "ProveedorXYZ");
        base.addServicio("Gas", "GasNaturalSA");
        base.addServicio("Telefonía", "TelecomunicacionesSA");
        base.addServicio("Cable", "CablevisionSA");
        base.addServicio("Seguro de Vehículo", "AseguradoraABC");
        base.addServicio("Seguro de Salud", "AseguradoraXYZ");
        base.addServicio("Limpieza", "ServiciosLimpieza");
        base.addServicio("Mantenimiento de Jardín", "JardinesVerdes");
        base.addServicio("Seguridad Residencial", "SeguridadTotal");
        base.addServicio("Educación Online", "EdTechCompany");
        base.addServicio("Gimnasio", "FitClub");
        base.addServicio("Reparación de Electrodomésticos", "FixIt");
        base.addServicio("Asesoría Legal", "BufeteJurídicoXYZ");
    }

    private static void insertarTransaccionTC(BaseDeDatos base) {
        ArrayList<TarjetaDeCredito> misTC = base.getTarjetas();
        Random miRand = new Random();

        for (TarjetaDeCredito tarjetaDeCredito : misTC) {
            for (int i = 0; i < 5; i++) {
                try {
                    tarjetaDeCredito.pagar(Math.random() * 10000000, "Transaccion generada automaticamente");
                } catch (Exception e) {
                    System.out.println(e.getMessage() + tarjetaDeCredito.getTitular().getNombre());
                }
            }
        }

    }

}
