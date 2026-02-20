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
    private JLabel labelTitulo, labelNombre, labelEspecie, labelRaza, labelEdad, labelId;
    private JTextField txtNombre, txtEspecie, txtRaza, txtEdad, txtId;
    private JButton btnRegistrar, btnConsultar, btnCancelar, btnActualizar, btnEliminar;
    private JPanel panel;
    
 

    public VentanaOperaciones() {
        // Configuración principal de la ventana
        setTitle("Gestión de Mascotas");
        setSize(680, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // Inicializar componentes
        initComponents();
    }

    private void initComponents() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(236, 240, 241)); // Fondo suave en azul claro

        // Título
        labelTitulo = new JLabel("Gestión de Mascotas", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 22));
        labelTitulo.setForeground(new Color(33, 80, 162)); // Azul oscuro
        labelTitulo.setBounds(180, 20, 350, 30);
        
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
        Color azulPrincipal = new Color(52, 152, 219);
        Color rojoElegante = new Color(231, 76, 60);
        Color grisSuave = new Color(189, 195, 199);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(btnFont);
        btnRegistrar.setBounds(450, 80, 180, 42); 
        btnRegistrar.setBackground(azulPrincipal);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBorder(null);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(this);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(btnFont);
        btnActualizar.setBounds(450, 145, 180, 42);
        btnActualizar.setBackground(azulPrincipal);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setBorder(null);
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(this);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(btnFont);
        btnConsultar.setBounds(450, 200, 180, 42);
        btnConsultar.setBackground(azulPrincipal);
        btnConsultar.setForeground(Color.WHITE);
        btnConsultar.setBorder(null);
        btnConsultar.setFocusPainted(false);
        btnConsultar.addActionListener(this);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(btnFont);
        btnEliminar.setBounds(450, 255, 180, 42);
        btnEliminar.setBackground(rojoElegante);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setBorder(null);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(this);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(btnFont);
        btnCancelar.setBounds(450, 310, 180, 42);
        btnCancelar.setBackground(grisSuave);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBorder(null);
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
        panel.add(btnActualizar);
        panel.add(btnEliminar);
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
    	    } else if (e.getSource() == btnActualizar) {
    	        actualizarMascota();
    	    } else if (e.getSource() == btnEliminar) {
    	        eliminarMascota();
    	    }
    }

    private void registrarMascota() {
        try {
            String nombre = txtNombre.getText();
            String especie = txtEspecie.getText();
            String raza = txtRaza.getText();
            String edadTexto = txtEdad.getText().trim();
            
            if (nombre.isEmpty() || especie.isEmpty() || raza.isEmpty() || edadTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }

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
    private void eliminarMascota() {

        String nombre = txtNombre.getText().trim();

        // Validar campo vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de la mascota.");
            return;
        }

        MascotaVO mascota = coordinador.buscarPorNombre(nombre);

        if (mascota != null) {

            // Confirmación antes de eliminar
            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de eliminar la mascota \"" + nombre + "\"?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {

                String mensaje = coordinador.eliminarMascota(mascota.getId());
                JOptionPane.showMessageDialog(this, mensaje);
                limpiarCampos();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Mascota no encontrada.");
        }
    }
    private void actualizarMascota() {
        try {
            String nombreBusqueda = txtNombre.getText();

            MascotaVO mascotaExistente = coordinador.buscarPorNombre(nombreBusqueda);

            if (mascotaExistente != null) {

                mascotaExistente.setNombre(txtNombre.getText());
                mascotaExistente.setEspecie(txtEspecie.getText());
                mascotaExistente.setRaza(txtRaza.getText());
                mascotaExistente.setEdad(Integer.parseInt(txtEdad.getText()));

                String mensaje = coordinador.actualizarMascota(mascotaExistente);
                JOptionPane.showMessageDialog(this, mensaje);
                limpiarCampos();

            } else {
                JOptionPane.showMessageDialog(this, "Mascota no encontrada.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad debe ser un número válido.");
        }
    }
}
