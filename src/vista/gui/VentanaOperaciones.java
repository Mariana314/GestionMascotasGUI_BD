package vista.gui;

import controlador.Coordinador;
import modelo.vo.MascotaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOperaciones extends JFrame implements ActionListener {

    private Coordinador coordinador;

    // Componentes
    private JLabel labelTitulo, labelNombre, labelEspecie, labelRaza, labelEdad;
    private JTextField txtNombre, txtEspecie, txtRaza, txtEdad;
    private JButton btnRegistrar, btnConsultar, btnCancelar;
    private JPanel panel;

    public VentanaOperaciones() {
        // Configuración principal de la ventana
        setTitle("Gestión de Mascotas");
        setSize(700, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar componentes
        initComponents();
    }

    private void initComponents() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 247, 255)); // Fondo suave en azul claro

        // Título
        labelTitulo = new JLabel("Gestión de Mascotas", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 22));
        labelTitulo.setForeground(new Color(33, 80, 162)); // Azul oscuro
        labelTitulo.setBounds(200, 20, 300, 30);

        // Etiquetas y campos de texto
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);

        labelNombre = new JLabel("Nombre:");
        labelNombre.setFont(labelFont);
        labelNombre.setForeground(new Color(33, 33, 33)); // Gris oscuro
        labelNombre.setBounds(50, 80, 120, 30);

        txtNombre = new JTextField();
        txtNombre.setFont(textFieldFont);
        txtNombre.setBounds(180, 80, 250, 30);
        txtNombre.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230))); // Azul claro

        labelEspecie = new JLabel("Especie:");
        labelEspecie.setFont(labelFont);
        labelEspecie.setForeground(new Color(33, 33, 33)); // Gris oscuro
        labelEspecie.setBounds(50, 130, 120, 30);

        txtEspecie = new JTextField();
        txtEspecie.setFont(textFieldFont);
        txtEspecie.setBounds(180, 130, 250, 30);
        txtEspecie.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230))); // Azul claro

        labelRaza = new JLabel("Raza:");
        labelRaza.setFont(labelFont);
        labelRaza.setForeground(new Color(33, 33, 33)); // Gris oscuro
        labelRaza.setBounds(50, 180, 120, 30);

        txtRaza = new JTextField();
        txtRaza.setFont(textFieldFont);
        txtRaza.setBounds(180, 180, 250, 30);
        txtRaza.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230))); // Azul claro

        labelEdad = new JLabel("Edad:");
        labelEdad.setFont(labelFont);
        labelEdad.setForeground(new Color(33, 33, 33)); // Gris oscuro
        labelEdad.setBounds(50, 230, 120, 30);

        txtEdad = new JTextField();
        txtEdad.setFont(textFieldFont);
        txtEdad.setBounds(180, 230, 250, 30);
        txtEdad.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230))); // Azul claro

        // Botones
        Font btnFont = new Font("Verdana", Font.BOLD, 14);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(btnFont);
        btnRegistrar.setBounds(470, 80, 150, 40);
        btnRegistrar.setBackground(new Color(34, 139, 34)); // Verde
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(this);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(btnFont);
        btnConsultar.setBounds(470, 140, 150, 40);
        btnConsultar.setBackground(new Color(30, 144, 255)); // Azul
        btnConsultar.setForeground(Color.WHITE);
        btnConsultar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 205), 2));
        btnConsultar.setFocusPainted(false);
        btnConsultar.addActionListener(this);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(btnFont);
        btnCancelar.setBounds(470, 200, 150, 40);
        btnCancelar.setBackground(new Color(220, 20, 60)); // Rojo
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBorder(BorderFactory.createLineBorder(new Color(139, 0, 0), 2));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(this);

        // Agregar componentes al panel
        panel.add(labelTitulo);
        panel.add(labelNombre);
        panel.add(txtNombre);
        panel.add(labelEspecie);
        panel.add(txtEspecie);
        panel.add(labelRaza);
        panel.add(txtRaza);
        panel.add(labelEdad);
        panel.add(txtEdad);
        panel.add(btnRegistrar);
        panel.add(btnConsultar);
        panel.add(btnCancelar);

        // Agregar panel al JFrame
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            registrarMascota();
        } else if (e.getSource() == btnConsultar) {
            coordinador.mostrarVentanaConsulta();
        } else if (e.getSource() == btnCancelar) {
            limpiarCampos();
        }
    }

    private void registrarMascota() {
        try {
            String nombre = txtNombre.getText();
            String especie = txtEspecie.getText();
            String raza = txtRaza.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            MascotaVO mascota = new MascotaVO();
            mascota.setNombre(nombre);
            mascota.setEspecie(especie);
            mascota.setRaza(raza);
            mascota.setEdad(edad);

            coordinador.registrarMascota(mascota);
            JOptionPane.showMessageDialog(this, "Mascota registrada correctamente.");
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEspecie.setText("");
        txtRaza.setText("");
        txtEdad.setText("");
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}
