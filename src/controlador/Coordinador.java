package controlador;

import modelo.dao.MascotaDAO;
import modelo.vo.MascotaVO;
import vista.gui.VentanaConsulta;
import vista.gui.VentanaOperaciones;

import java.util.ArrayList;

public class Coordinador {
    private MascotaDAO mascotaDAO;
    private VentanaOperaciones ventanaOperaciones;
    private VentanaConsulta ventanaConsulta;

    public Coordinador() {
        this.mascotaDAO = new MascotaDAO();
    }

    public void setVentanaOperaciones(VentanaOperaciones ventanaOperaciones) {
        this.ventanaOperaciones = ventanaOperaciones;
        ventanaOperaciones.setCoordinador(this);
    }

    public void setVentanaConsulta(VentanaConsulta ventanaConsulta) {
        this.ventanaConsulta = ventanaConsulta;
        ventanaConsulta.setCoordinador(this);
    }

    public String registrarMascota(MascotaVO mascota) {
        return mascotaDAO.registrarMascota(mascota);
    }

    public ArrayList<MascotaVO> listarMascotas() {
        return mascotaDAO.listarMascotas();
    }

    public void mostrarVentanaConsulta() {
        ventanaConsulta.actualizarLista();
        ventanaConsulta.setVisible(true);
    }
}
