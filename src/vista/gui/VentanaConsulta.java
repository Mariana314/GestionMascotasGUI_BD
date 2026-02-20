package vista.gui;

import controlador.Coordinador;
import modelo.vo.MascotaVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaConsulta extends JFrame {

    private Coordinador coordinador;
    private JTable tablaMascotas;
    private DefaultTableModel modelo;

    public VentanaConsulta() {

        setTitle("Consulta de Mascotas");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ===== HEADER =====
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(33, 150, 243));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel labelHeader = new JLabel("Mascotas Registradas");
        labelHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
        labelHeader.setForeground(Color.WHITE);

        headerPanel.add(labelHeader);
        add(headerPanel, BorderLayout.NORTH);

        // ===== TABLA =====
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");

        tablaMascotas = new JTable(modelo);
        tablaMascotas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tablaMascotas.setRowHeight(25);
        tablaMascotas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(tablaMascotas);
        add(scrollPane, BorderLayout.CENTER);

        // ===== FOOTER =====
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.WHITE);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnActualizar.setBackground(new Color(33, 150, 243));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusPainted(false);
        btnActualizar.setPreferredSize(new Dimension(150, 35));

        btnActualizar.addActionListener(e -> actualizarLista());

        footerPanel.add(btnActualizar);
        add(footerPanel, BorderLayout.SOUTH);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void actualizarLista() {

        modelo.setRowCount(0); // limpiar tabla

        ArrayList<MascotaVO> listaMascotas = coordinador.listarMascotas();

        for (MascotaVO mascota : listaMascotas) {
            modelo.addRow(new Object[]{
                    mascota.getId(),
                    mascota.getNombre(),
                    mascota.getEspecie(),
                    mascota.getRaza(),
                    mascota.getEdad()
            });
        }
    }
}