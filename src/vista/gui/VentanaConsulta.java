package vista.gui;

import controlador.Coordinador;
import modelo.vo.MascotaVO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaConsulta extends JFrame {
    private Coordinador coordinador;
    private JTextArea areaMascotas;

    public VentanaConsulta() {
        // Configuración de la ventana
        setTitle("Consulta de Mascotas");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel de encabezado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 123, 255)); // Azul fuerte
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel labelHeader = new JLabel("Mascotas Registradas");
        labelHeader.setFont(new Font("Verdana", Font.BOLD, 16));
        labelHeader.setForeground(Color.WHITE);
        headerPanel.add(labelHeader);
        add(headerPanel, BorderLayout.NORTH);

        // Área de texto para mostrar las mascotas
        areaMascotas = new JTextArea();
        areaMascotas.setEditable(false);
        areaMascotas.setFont(new Font("Arial", Font.PLAIN, 14));
        areaMascotas.setForeground(new Color(50, 50, 50)); // Texto oscuro
        areaMascotas.setBackground(new Color(248, 248, 248)); // Fondo claro
        JScrollPane scrollPane = new JScrollPane(areaMascotas);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 255), 1)); // Borde suave
        add(scrollPane, BorderLayout.CENTER);

        // Botón de actualizar lista
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(248, 248, 248)); // Fondo claro
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 14));
        btnActualizar.setBackground(new Color(0, 123, 255)); // Azul fuerte
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 200), 2));
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(e -> actualizarLista());
        footerPanel.add(btnActualizar);
        add(footerPanel, BorderLayout.SOUTH);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void actualizarLista() {
        ArrayList<MascotaVO> listaMascotas = coordinador.listarMascotas();
        areaMascotas.setText(""); // Limpiar área de texto
        if (listaMascotas.isEmpty()) {
            areaMascotas.append("No hay mascotas registradas.\n");
        } else {
            for (MascotaVO mascota : listaMascotas) {
                areaMascotas.append("ID: " + mascota.getId() + "\n");
                areaMascotas.append("Nombre: " + mascota.getNombre() + "\n");
                areaMascotas.append("Especie: " + mascota.getEspecie() + "\n");
                areaMascotas.append("Raza: " + mascota.getRaza() + "\n");
                areaMascotas.append("Edad: " + mascota.getEdad() + " años\n");
                areaMascotas.append("----------------------------------------\n\n");
            }
        }
    }
}
