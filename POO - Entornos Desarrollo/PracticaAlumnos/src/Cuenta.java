public class Cuenta {

    // Propiedades de la Clase Cuenta
    private String nombre;
    private String idcuenta;
    private double saldo;
    private double tipoInterés;

    /* Constructor sin argumentos */
    public Cuenta ()
    {
    }
    // Constructor con parámetro para iniciar todas las propiedades de la clase
    public Cuenta (String nom, String cue, double sal, double tipo)
    {
        nombre =nom;
       idcuenta=cue;
        saldo=sal;
        tipoInterés=tipo;
    }
    //Encapsular:


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoInterés() {
        return tipoInterés;
    }

    public void setTipoInterés(double tipoInterés) {
        this.tipoInterés = tipoInterés;
    }

    // Método para asignar el nombre del titular de la cuenta
    public void asignarNombre(String nom)
    {
        nombre=nom;
    }

    /* Método para ingresar cantidades en la cuenta. Modifica el saldo.
     * Este método va a ser probado con Junit
     */
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        saldo = saldo + cantidad;
    }

    /* Método para retirar cantidades en la cuenta. Modifica el saldo.
     * Este método va a ser probado con Junit
     */
    public void retirar (double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (getSaldo()< cantidad)
            throw new Exception ("No se hay suficiente saldo");
        saldo = saldo - cantidad;
    }

    // Método que me devuelve el número de cuenta
    public String obtenerCuenta ()
    {
        return idcuenta;
    }
}
