package controlador;

import vista.gui.VentanaConsulta;
import vista.gui.VentanaOperaciones;

public class Relaciones {
    public void iniciar() {
        // Crear instancias de clases
        Coordinador coordinador = new Coordinador();
        VentanaOperaciones ventanaOperaciones = new VentanaOperaciones();
        VentanaConsulta ventanaConsulta = new VentanaConsulta();

        // Establecer relaciones entre ventanas y el coordinador
        coordinador.setVentanaOperaciones(ventanaOperaciones);
        coordinador.setVentanaConsulta(ventanaConsulta);

        // Mostrar la ventana principal
        ventanaOperaciones.setVisible(true);
    }
}
