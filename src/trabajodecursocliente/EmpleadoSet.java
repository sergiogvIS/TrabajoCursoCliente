package trabajodecursocliente;

import org.simpleframework.xml.Element;


public class EmpleadoSet {
    @Element
    private Empleado tablaEmp;

    public void setTablaEmp(Empleado tablaEmp) {
        this.tablaEmp = tablaEmp;
    }
    public Empleado getTabla(){
        return tablaEmp;
    }
    
    
}
