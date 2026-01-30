
package laboratorio2_30_1_2026;

import java.time.LocalDate;
        
public class EmpleadoTemporal extends EMPLEADO {
    private LocalDate fechaFinContrato;
    
    public EmpleadoTemporal(String codigo, String nombre, double salarioBase, double horasTrabajadas, LocalDate fechaFinContrato){
        super(codigo, nombre, salarioBase, horasTrabajadas);
        this.fechaFinContrato = fechaFinContrato;
    }
    
    public void actualizarFechaFinContrato(LocalDate nuevaFecha) {
        this.fechaFinContrato = nuevaFecha;
    }
    
    @Override
    public String mostrarInformacion(){
        return super.mostrarInformacion()+"\nFin de contrato: "+fechaFinContrato;
    } 
    
    @Override
    public double calcularPago(){
        LocalDate hoy = LocalDate.now();
        if (!hoy.isAfter(fechaFinContrato)){
            return super.calcularPago();
        } else {
            return 0.0;
        }
    }
}
