
package laboratorio2_30_1_2026;
import java.time.LocalDate;


public class EMPLEADO {
    
    protected String codigo;
    protected String nombre;
    protected LocalDate fechaContratacion;
    protected double salarioBase;
    protected double horasTrabajadas;
    
    public EMPLEADO(String codigo, String nombre, double salarioBase,double horasTrabajadas){
        this.codigo=codigo;
        this.nombre=nombre;
        this.fechaContratacion = LocalDate.now();
        this.salarioBase=salarioBase;
        this.horasTrabajadas=horasTrabajadas;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public double getHorasTrabajadas(){
        return horasTrabajadas;
    }
    
    public void registrarHoras(double horas){
        if(horas>0){
            horasTrabajadas+=horas;
        }
    }
    
    public double calcularPago(){
        double pagoProporcional = (salarioBase/160)*horasTrabajadas;
        double deduccion= pagoProporcional*0.035;
        return pagoProporcional-deduccion;
    }
    
    public String mostrarInformacion(){
        return "Codigo: "+codigo+"\nNombre: "+nombre+"\nFecha de contratacion:"+fechaContratacion;
    }
}
