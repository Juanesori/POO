import modelos.*;
import operaciones.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            IOperacionEmpleado opEmpleado = new OperacionEmpleado();
            IOperacionEmpresa opEmpresa = new OperacionEmpresa();

            while (true) {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Crear empresa");
                System.out.println("2. Crear empleado");
                System.out.println("3. Ver empresas");
                System.out.println("4. Ver empleados");
                System.out.println("5. Buscar empleado por documento");
                System.out.println("6. Calcular sueldo empleado");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("NIT: ");
                        String nit = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Dirección: ");
                        String direccion = sc.nextLine();
                        System.out.print("Ciudad: ");
                        String ciudad = sc.nextLine();
                        Empresa empresa = new EmpresaDesarrollo(nit, nombre, direccion, ciudad);
                        opEmpresa.agregarEmpresa(empresa);
                        System.out.println("Empresa registrada.");
                        break;

                    case 2:
                        System.out.print("Documento: ");
                        String doc = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nomEmp = sc.nextLine();
                        System.out.print("Sueldo por hora: ");
                        double sueldo = sc.nextDouble(); sc.nextLine();
                        System.out.print("NIT Empresa: ");
                        String nitEmp = sc.nextLine();
                        Empresa emp = opEmpresa.buscarPorNit(nitEmp);
                        if (emp == null) {
                            System.out.println("Empresa no encontrada.");
                            break;
                        }
                        Empleado nuevo = new Desarrollador(doc, nomEmp, sueldo, emp);
                        opEmpleado.agregarEmpleado(nuevo);
                        System.out.println("Empleado registrado.");
                        break;

                    case 3:
                        for (Empresa e : opEmpresa.listarEmpresas())
                            System.out.println(e);
                        break;

                    case 4:
                        for (Empleado e : opEmpleado.listarEmpleados())
                            System.out.println(e);
                        break;

                    case 5:
                        System.out.print("Documento: ");
                        String docBuscar = sc.nextLine();
                        Empleado e = opEmpleado.buscarPorDocumento(docBuscar);
                        System.out.println(e != null ? e : "No encontrado.");
                        break;

                    case 6:
                        System.out.print("Documento: ");
                        String docSueld = sc.nextLine();
                        System.out.print("Horas trabajadas: ");
                        int horas = sc.nextInt(); sc.nextLine();
                        double total = opEmpleado.calcularSueldoEmpleado(docSueld, horas);
                        System.out.println("Sueldo total: $" + total);
                        break;

                    case 0:
                        System.exit(0);
                }
            }
        }
    }
}

