package laboratorio2_30_1_2026;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FrmEmpresa {

    private ArrayList<EMPLEADO> empleados = new ArrayList<>();
    private JFrame menuFrame;

    public FrmEmpresa() {
        // Ventana principal
        menuFrame = new JFrame("Menú Principal - Empresa");
        menuFrame.setSize(400, 400);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);

        // Botones menú principal
        JButton btnRegistrarEmp = new JButton("Registrar Empleado");
        btnRegistrarEmp.setBounds(100, 30, 200, 40);
        menuFrame.add(btnRegistrarEmp);

        JButton btnRegistrarHoras = new JButton("Registrar Horas");
        btnRegistrarHoras.setBounds(100, 90, 200, 40);
        menuFrame.add(btnRegistrarHoras);

        JButton btnRegistrarVentas = new JButton("Registrar Ventas");
        btnRegistrarVentas.setBounds(100, 150, 200, 40);
        menuFrame.add(btnRegistrarVentas);

        JButton btnActualizarContrato = new JButton("Actualizar Contrato");
        btnActualizarContrato.setBounds(100, 210, 200, 40);
        menuFrame.add(btnActualizarContrato);

        JButton btnReporte = new JButton("Reporte Empleados");
        btnReporte.setBounds(100, 270, 200, 40);
        menuFrame.add(btnReporte);

        // ====================== ACCIONES BOTONES ======================

        // Registra empleado
        btnRegistrarEmp.addActionListener(e -> abrirRegistroEmpleado());

        // Registrar horas
        btnRegistrarHoras.addActionListener(e -> abrirRegistroHoras());

        // Registrar ventas
        btnRegistrarVentas.addActionListener(e -> abrirRegistroVentas());

        // Actualiz contrato
        btnActualizarContrato.addActionListener(e -> abrirActualizarContrato());

        // Reporte
        btnReporte.addActionListener(e -> abrirReporte());

        menuFrame.setVisible(true);
    }

    // ====================== VENTANAS SECUNDARIAS ======================

    private void abrirRegistroEmpleado() {
        JFrame frame = new JFrame("Registrar Empleado");
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        frame.add(lblCodigo);
        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 150, 25);
        frame.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        frame.add(lblNombre);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 150, 25);
        frame.add(txtNombre);

        JLabel lblSalario = new JLabel("Salario Base:");
        lblSalario.setBounds(20, 100, 100, 25);
        frame.add(lblSalario);
        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(120, 100, 150, 25);
        frame.add(txtSalario);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 140, 100, 25);
        frame.add(lblTipo);
        JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Estándar", "Temporal", "Ventas"});
        cmbTipo.setBounds(120, 140, 150, 25);
        frame.add(cmbTipo);

        JLabel lblFechaFin = new JLabel("Fin Contrato (AAAA-MM-DD):");
        lblFechaFin.setBounds(20, 180, 200, 25);
        frame.add(lblFechaFin);
        JTextField txtFechaFin = new JTextField();
        txtFechaFin.setBounds(200, 180, 100, 25);
        frame.add(txtFechaFin);

        JLabel lblComision = new JLabel("Tasa Comisión (0.05 = 5%):");
        lblComision.setBounds(20, 220, 200, 25);
        frame.add(lblComision);
        JTextField txtComision = new JTextField();
        txtComision.setBounds(200, 220, 100, 25);
        frame.add(txtComision);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(120, 260, 120, 30);
        frame.add(btnRegistrar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(250, 260, 100, 30);
        frame.add(btnVolver);

        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText();
                String nombre = txtNombre.getText();
                double salario = Double.parseDouble(txtSalario.getText());
                String tipo = (String) cmbTipo.getSelectedItem();

                if (tipo.equals("Estándar")) {
                    empleados.add(new EMPLEADO(codigo, nombre, salario, 0));
                } else if (tipo.equals("Temporal")) {
                    LocalDate fechaFin = LocalDate.parse(txtFechaFin.getText());
                    empleados.add(new EmpleadoTemporal(codigo, nombre, salario, fechaFin));
                } else if (tipo.equals("Ventas")) {
                    double comision = Double.parseDouble(txtComision.getText());
                    empleados.add(new EmpleadoVentas(codigo, nombre, salario, comision));
                }

                JOptionPane.showMessageDialog(frame, "Empleado registrado correctamente");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        btnVolver.addActionListener(e -> frame.dispose()); // cierra ventana y no guarda

        frame.setVisible(true);
    }

    private void abrirRegistroHoras() {
        JFrame frame = new JFrame("Registrar Horas");
        frame.setSize(400, 200);
        frame.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        frame.add(lblCodigo);
        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 150, 25);
        frame.add(txtCodigo);

        JLabel lblHoras = new JLabel("Horas:");
        lblHoras.setBounds(20, 60, 100, 25);
        frame.add(lblHoras);
        JTextField txtHoras = new JTextField();
        txtHoras.setBounds(120, 60, 150, 25);
        frame.add(txtHoras);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(120, 100, 120, 30);
        frame.add(btnRegistrar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(250, 100, 100, 30);
        frame.add(btnVolver);

        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText();
                double horas = Double.parseDouble(txtHoras.getText());
                for (EMPLEADO emp : empleados) {
                    if (emp.getCodigo().equals(codigo)) {
                        emp.registrarHoras(horas);
                        JOptionPane.showMessageDialog(frame, "Horas registradas");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Empleado no encontrado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        btnVolver.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    // ====================== Las demás ventanas seguirían la misma lógica ======================

    private void abrirRegistroVentas() {
        JFrame frame = new JFrame("Registrar Ventas");
        frame.setSize(400, 200);
        frame.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        frame.add(lblCodigo);
        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 150, 25);
        frame.add(txtCodigo);

        JLabel lblMonto = new JLabel("Monto:");
        lblMonto.setBounds(20, 60, 100, 25);
        frame.add(lblMonto);
        JTextField txtMonto = new JTextField();
        txtMonto.setBounds(120, 60, 150, 25);
        frame.add(txtMonto);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(120, 100, 120, 30);
        frame.add(btnRegistrar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(250, 100, 100, 30);
        frame.add(btnVolver);

        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText();
                double monto = Double.parseDouble(txtMonto.getText());
                for (EMPLEADO emp : empleados) {
                    if (emp instanceof EmpleadoVentas ev && emp.getCodigo().equals(codigo)) {
                        ev.registrarVentas(monto);
                        JOptionPane.showMessageDialog(frame, "Venta registrada");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Empleado de ventas no encontrado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        btnVolver.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    private void abrirActualizarContrato() {
        JFrame frame = new JFrame("Actualizar Contrato");
        frame.setSize(400, 200);
        frame.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        frame.add(lblCodigo);
        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 150, 25);
        frame.add(txtCodigo);

        JLabel lblFecha = new JLabel("Nueva Fecha (AAAA-MM-DD):");
        lblFecha.setBounds(20, 60, 200, 25);
        frame.add(lblFecha);
        JTextField txtFecha = new JTextField();
        txtFecha.setBounds(220, 60, 100, 25);
        frame.add(txtFecha);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(120, 100, 120, 30);
        frame.add(btnActualizar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(250, 100, 100, 30);
        frame.add(btnVolver);

        btnActualizar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText();
                LocalDate nuevaFecha = LocalDate.parse(txtFecha.getText());
                for (EMPLEADO emp : empleados) {
                    if (emp instanceof EmpleadoTemporal et && emp.getCodigo().equals(codigo)) {
                        et.actualizarFechaFin(nuevaFecha);
                        JOptionPane.showMessageDialog(frame, "Contrato actualizado");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Empleado temporal no encontrado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        btnVolver.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    private void abrirReporte() {
        JFrame frame = new JFrame("Reporte Empleados");
        frame.setSize(500, 400);
        frame.setLayout(null);

        JTextArea txtReporte = new JTextArea();
        txtReporte.setBounds(20, 20, 450, 300);
        txtReporte.setEditable(false);
        frame.add(txtReporte);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(350, 330, 100, 30);
        frame.add(btnVolver);

        StringBuilder sb = new StringBuilder();
        for (EMPLEADO emp : empleados) {
            sb.append(emp.mostrarInformacion())
              .append("\nPago mensual: L. ").append(emp.calcularPago())
              .append("\n---------------------\n");
        }
        txtReporte.setText(sb.toString());

        btnVolver.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    // Método público para mostrar el menú desde otra clase
    public void mostrar() {
        menuFrame.setVisible(true);
    }
}