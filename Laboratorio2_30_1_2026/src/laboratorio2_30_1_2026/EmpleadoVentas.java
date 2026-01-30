package laboratorio2_30_1_2026;

import java.time.LocalDate;

public class EmpleadoVentas extends EMPLEADO{
    
private double[] ventasMensuales;
private double tasaComision;

    public EmpleadoVentas(String codigo, String nombre, double salarioBase,double horasTrabajadas) {
        super(codigo, nombre, salarioBase, horasTrabajadas);
        this.tasaComision= tasaComision;
        this.ventasMensuales= new double[12]; 
    }
 
    public void registrarVentas(double monto){
        if (monto > 0) {
            int mesActual = LocalDate.now().getMonthValue() - 1;
            ventasMensuales[mesActual] += monto;
        }
    }
     public double calcularComision() {
        int mesActual = LocalDate.now().getMonthValue() - 1;
        return ventasMensuales[mesActual] * tasaComision;
    }
     @Override
    public double calcularPago() {
        double salarioProporcional = (salarioBase / 160) * horasTrabajadas;
        return salarioProporcional + calcularComision();
    }
    
    public double calcularVentasAnuales() {
        double total = 0;
        for (double venta : ventasMensuales) {
            total += venta;
        }
        return total;
    }
     @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
               "\nVentas anuales: " + calcularVentasAnuales();
    
    }
    
    
    
}
