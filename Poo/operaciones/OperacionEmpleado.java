package operaciones;

import modelos.Empleado;
import java.util.ArrayList;
import java.util.List;

public class OperacionEmpleado implements IOperacionEmpleado {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public Empleado buscarPorDocumento(String documento) {
        return empleados.stream().filter(e -> e.getDocumento().equals(documento)).findFirst().orElse(null);
    }

    public List<Empleado> listarEmpleados() {
        return empleados;
    }

    public List<Empleado> empleadosPorEmpresa(String nit) {
        List<Empleado> result = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.getEmpresa() != null && e.getEmpresa().getNit().equals(nit)) {
                result.add(e);
            }
        }
        return result;
    }

    public double calcularSueldoEmpleado(String documento, int horas) {
        Empleado e = buscarPorDocumento(documento);
        return e != null ? e.calcularSueldo(horas) : 0;
    }
}
