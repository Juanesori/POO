package operaciones;

import modelos.Empresa;
import java.util.List;

public interface IOperacionEmpresa {
    void agregarEmpresa(Empresa e);
    List<Empresa> listarEmpresas();
    Empresa buscarPorNit(String nit);
}

