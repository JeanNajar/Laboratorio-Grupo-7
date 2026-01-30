
package laboratorio2_30_1_2026;
import java.time.LocalDate;

public class Empresa {
    
    public EMPLEADO[] empleados;
    private int contador;
     
    public Empresa(int capacidadMaxima){
        empleados=new EMPLEADO[capacidadMaxima];
        contador=0;
    }
    
    
    public EMPLEADO buscarEmpleadoCodigo(String codigo){
        for (int i = 0; i < contador; i++) {
            if(empleados[i].getCodigo().equals(codigo)){
                return empleados[i];
            }
        }
        return null;
    }
    
    
    public boolean registrarEmpleado(EMPLEADO empleado){
        if (contador < empleados.length && buscarEmpleadoCodigo(empleado.getCodigo()) == null) {
            empleados[contador]=empleado;
            contador++;
            return true;
        }
        return false;
    }
    public boolean registrarHorasTrabajadas(String codigo, double horas){
        for (int i = 0; i < contador; i++) {
           if(empleados[i].getCodigo().equals(codigo)){
               empleados[i].registrarHoras(horas);
             return true;
           }
        }
      return false;
    }

    
    public boolean actualizarFechaFinContratos(String codigo, LocalDate nuevaFecha){
        for(int i=0; i<contador; i++){
            if(empleados[i].getCodigo().equals(codigo)){
                if(empleados[i]instanceof EmpleadoTemporal){
                    EmpleadoTemporal temp = (EmpleadoTemporal) empleados[i];
                    temp.actualizarFechaFinContrato(nuevaFecha);
                    return true;
                } 
            }
        }
        return false;
    }
    
    public double calcularPagoMensual(){
        double total = 0.0;
        for(int i = 0; i<contador;i++){
            total+=empleados[i].calcularPago();
        }
        return total;
    }
    
    public void reporteEmpleados(){
        int estandar = 0, temporales = 0, ventas = 0;
        for(int i = 0; i<contador; i++){
            System.out.println("-------------------");
            System.out.println(empleados[i].mostrarInformacion());
            System.out.println("Pago Mensual: "+empleados[i].calcularPago());  
            
            if (empleados[i]instanceof EmpleadoTemporal) temporales++;
            else if(empleados[i]instanceof EmpleadoVentas) ventas++;
            else estandar++;
        }
        
       // System.out.println("\nReporte: ");
       // System.out.println("Empleado Estandar: "+estandar);
       // System.out.println("Empleado Temporal: "+temporales);
       // System.out.println("Empleado Ventas: "+ventas);
    }
 


public boolean registrarVenta(String codigo, double monto, int mes){
    for (int i = 0; i < contador; i++) {
        if(empleados[i].getCodigo().equals(codigo) && empleados[i] instanceof EmpleadoVentas){
            EmpleadoVentas ev = (EmpleadoVentas) empleados[i];
            ev.registrarVentas(monto, mes);
            return true;
        }
    }
    return false;
}
}