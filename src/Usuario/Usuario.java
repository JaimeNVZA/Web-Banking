package Usuario;

import java.text.SimpleDateFormat;
import java.util.Date;

import BaseDeDatos.BaseDeDatos;
import Cuenta.Cuenta;
import TarjetaDeCredito.TarjetaDeCredito;
import java.util.ArrayList;

/**
 * La clase Usuario representa un usuario del sistema bancario.
 * Contiene información personal, como nombre, apellido, cédula de identidad,
 * etc.
 * Además, proporciona métodos para obtener y establecer cada uno de los
 * atributos.
 * 
 * @author David Gomez
 */
public class Usuario {
    private String ci; // Cédula de identidad
    private String pin; // PIN de acceso
    private String pinTransaccional; // PIN para transacciones
    private String email; // Correo electrónico
    private String nacionalidad; // Nacionalidad
    private String nombre; // Nombre
    private String apellido; // Apellido
    private String telefono; // Número de teléfono
    private Date fechaNacimiento; // Fecha de nacimiento
    public BaseDeDatos base;

    /**
     * Constructor de la clase Usuario.
     *
     * @param ci               Cédula de identidad.
     * @param pin              PIN de acceso.
     * @param pinTransaccional PIN para transacciones.
     * @param email            Correo electrónico.
     * @param nacionalidad     Nacionalidad.
     * @param nombre           Nombre.
     * @param apellido         Apellido.
     * @param fechaNacimiento  Fecha de nacimiento.
     * @param telefono         Número de teléfono.
     * @param miBase           direccion de memoria de la base en la que esta
     *                         almacenado el usuario
     * 
     * @author David Gomez
     * @throws java.lang.Exception excepción
     */
    public Usuario(String ci, String pin, String pinTransaccional, String email, String nacionalidad, String nombre,
            String apellido, Date fechaNacimiento, String telefono, BaseDeDatos miBase) throws Exception {
        this.ci = ci;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.pin = pin;
        this.nombre = nombre;
        this.pinTransaccional = pinTransaccional;
        this.base = miBase;
        miBase.addUsuario(this);
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     * 
     * @author David Gomez
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene la cédula de identidad del usuario.
     *
     * @return La cédula de identidad del usuario.
     * 
     * @author David Gomez
     */
    public String getCi() {
        return ci;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     * 
     * @author David Gomez
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return La fecha de nacimiento del usuario.
     * 
     * @author David Gomez
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene la nacionalidad del usuario.
     *
     * @return La nacionalidad del usuario.
     * 
     * @author David Gomez
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     * 
     * @author David Gomez
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el PIN de acceso del usuario.
     *
     * @return El PIN de acceso del usuario.
     * 
     * @author David Gomez
     */
    public String getPin() {
        return pin;
    }

    /**
     * Obtiene el PIN transaccional del usuario.
     *
     * @return El PIN transaccional del usuario.
     * 
     * @author David Gomez
     */
    public String getPinTransaccional() {
        return pinTransaccional;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return El número de teléfono del usuario.
     * 
     * @author David Gomez
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido El nuevo apellido del usuario.
     * 
     * @author David Gomez
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece la cédula de identidad del usuario.
     *
     * @param ci La nueva cédula de identidad del usuario.
     * 
     * @author David Gomez
     */
    public void setCi(String ci) {
        this.ci = ci;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico del usuario.
     * 
     * @author David Gomez
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento La nueva fecha de nacimiento del usuario.
     * 
     * @author David Gomez
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Establece la nacionalidad del usuario.
     *
     * @param nacionalidad La nueva nacionalidad del usuario.
     * 
     * @author David Gomez
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     * 
     * @author David Gomez
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el PIN de acceso del usuario.
     *
     * @param pin El nuevo PIN de acceso del usuario.
     * 
     * @author David Gomez
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * Establece el PIN transaccional del usuario.
     *
     * @param pinTransaccional El nuevo PIN transaccional del usuario.
     * 
     * @author David Gomez
     */
    public void setPinTransaccional(String pinTransaccional) {
        this.pinTransaccional = pinTransaccional;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono El nuevo número de teléfono del usuario.
     * 
     * @author David Gomez
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Imprime los atributos del usuario en formato JSON con la fecha formateada.
     *
     * @return Una cadena JSON que representa los atributos del usuario.
     * 
     * @author David Gomez
     */
    public String toJsonString() {
        // Formatea la fecha como dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNacimientoFormatted = dateFormat.format(fechaNacimiento);

        // Construye la representación JSON manualmente
        String jsonString = "{"
                + "\"ci\":\"" + ci + "\","
                + "\"pin\":\"" + pin + "\","
                + "\"pinTransaccional\":\"" + pinTransaccional + "\","
                + "\"email\":\"" + email + "\","
                + "\"nacionalidad\":\"" + nacionalidad + "\","
                + "\"nombre\":\"" + nombre + "\","
                + "\"apellido\":\"" + apellido + "\","
                + "\"telefono\":\"" + telefono + "\","
                + "\"fechaNacimiento\":\"" + fechaNacimientoFormatted + "\""
                + "}";

        return jsonString;
    }
    
    
    public ArrayList<TarjetaDeCredito> getTarjetas(){
        return base.getTarjetasByUserCI(this.ci);
    }
    
    public ArrayList<Cuenta> getCuentas(){
        return base.getCuentasByUserCi(ci);
    }

}
