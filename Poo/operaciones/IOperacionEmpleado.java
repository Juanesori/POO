package operaciones;

import modelos.Empleado;
import java.util.List;

public interface IOperacionEmpleado {
    void agregarEmpleado(Empleado e);
    Empleado buscarPorDocumento(String documento);
    List<Empleado> listarEmpleados();
    List<Empleado> empleadosPorEmpresa(String nit);
    double calcularSueldoEmpleado(String documento, int horas);
}
