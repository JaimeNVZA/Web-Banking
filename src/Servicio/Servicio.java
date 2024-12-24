package Servicio;

import java.util.Random;

import Cuenta.Cuenta;

/**
 * La clase Servicio representa un servicio que puede ser consultado o pagado.
 * Contiene información sobre el nombre del servicio, la entidad emisora y el
 * monto.
 * Además, proporciona métodos para consultar el monto del servicio y realizar
 * un pago.
 * Los pagos realizados se registran en la base de datos asociada a la cuenta.
 *
 * @author David Gomez
 */
public class Servicio {

    private final String nombre;
    private final String entidadEmisora;
    private Double monto;

    /**
     * Constructor de la clase Servicio.
     *
     * @param nombreServicio El nombre del servicio.
     * @param entidadEmisora La entidad emisora del servicio.
     * 
     * @author David Gomez
     */
    public Servicio(String nombreServicio, String entidadEmisora) {
        this.nombre = nombreServicio;
        this.entidadEmisora = entidadEmisora;
    }

    /**
     * Consulta el monto del servicio. Si el monto aún no ha sido asignado, se
     * genera un valor aleatorio.
     *
     * @return El monto del servicio.
     * 
     * @author David Gomez
     */
    public Double consultar() {
        if (monto == null) 
            this.monto = new Random().nextDouble() * (300000.00-10000.00) + 10000.00;
        return (double)Math.round(this.monto * 100) / 100;
    }

    /**
     * Realiza el pago del servicio utilizando la cuenta proporcionada.
     *
     * @param miCuenta La cuenta desde la cual se realizará el pago.
     * @throws Exception Si la cuenta no tiene saldo suficiente para realizar el
     *                   pago.
     * 
     * @author David Gomez
     */
    public void pagar(Cuenta miCuenta) throws Exception {
        if (miCuenta.getSaldo() >= this.monto) {
            // Actualiza el saldo de la cuenta después de realizar el pago.
            miCuenta.setSaldo(miCuenta.getSaldo() - this.monto);

            // Crea una instancia de la clase PagoServicio para registrar el pago.
            PagoServicio miPago = new PagoServicio(this.nombre, this.monto, miCuenta.getNroCuenta());

            // Registra el pago en la base de datos asociada a la cuenta.
            miCuenta.base.addPagoServicios(miPago);
        } else {
            throw new Exception("Cuenta no posee el saldo suficiente para realizar el pago");
        }
    }

    /**
     * Obtiene el nombre del servicio.
     *
     * @return El nombre del servicio.
     * 
     * @author David Gomez
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la entidad emisora del servicio.
     *
     * @return La entidad emisora del servicio.
     * 
     * @author David Gomez
     */
    public String getEntidadEmisora() {
        return entidadEmisora;
    }

    /**
     * Obtiene el monto del servicio.
     *
     * @return El monto del servicio.
     * 
     * @author David Gomez
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Establece el monto del servicio.
     *
     * @param monto El nuevo monto del servicio.
     * 
     * @author David Gomez
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
