
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
    
    public boolean registrarHorasTrabajadas(String codigo, double horas){
        for (int i = 0; i < contador; i++) {
           if(empleados[i].getCodigo().equals(codigo)){
               empleados[i].registrasHoras(horas);
             return true;
           }
        }
      return false;
    }
public double calcularPagoMensual(){
    double total = 0.0;
    for(int i = 0; i < contador; i++){
        total += empleados[i].calcularPagoMensual();
    }
    return total;
}

public void reporteEmpleados(){
    for(int i = 0; i < contador; i++){
        System.out.println("-------------------");
        System.out.println(empleados[i].mostrarInformacion());
        System.out.println("Pago Mensual: " + empleados[i].calcularPagoMensual());       
    }
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