public class Main {


    public static void main(String[] args) throws Exception {
        Cuenta CuentaBancaria;
        double saldoActual;

        CuentaBancaria = new Cuenta("Eider","1234-5678-90-123456789",1000,0);
        try
        {
            CuentaBancaria.retirar(230);
        } catch (Exception e)
        {
            System.out.print("Fallo al retirar");
        }

        try
        {
            System.out.println("Ingreso en cuenta");
            CuentaBancaria.ingresar(-695);
        } catch (Exception e)
        {
            System.out.print(e.toString());
        }

        saldoActual =  CuentaBancaria.saldo();
        System.out.println("El saldo actual es"+ saldoActual );
    }
}
