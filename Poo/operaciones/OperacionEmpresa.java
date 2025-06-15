package operaciones;

import modelos.Empresa;
import java.util.ArrayList;
import java.util.List;

public class OperacionEmpresa implements IOperacionEmpresa {
    private List<Empresa> empresas = new ArrayList<>();

    public void agregarEmpresa(Empresa e) {
        empresas.add(e);
    }

    public List<Empresa> listarEmpresas() {
        return empresas;
    }

    public Empresa buscarPorNit(String nit) {
        return empresas.stream().filter(e -> e.getNit().equals(nit)).findFirst().orElse(null);
    }
}

