
package laboratorio2_30_1_2026;


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
 
}
