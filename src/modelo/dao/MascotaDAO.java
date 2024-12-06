package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.MascotaVO;

import java.sql.*;
import java.util.ArrayList;

public class MascotaDAO {
    private Conexion conexion;

    public MascotaDAO() {
        this.conexion = new Conexion();
    }

    public String registrarMascota(MascotaVO mascota) {
        String resultado = conexion.conectar();
        if (!resultado.equals("conectado")) {
            return "Error en la conexión: " + resultado;
        }

        String sql = "INSERT INTO mascotas (nombre, especie, raza, edad) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mascota.getNombre());
            ps.setString(2, mascota.getEspecie());
            ps.setString(3, mascota.getRaza());
            ps.setInt(4, mascota.getEdad());
            ps.executeUpdate();
            return "Registro exitoso";
        } catch (SQLException e) {
            return "Error al registrar: " + e.getMessage();
        } finally {
            conexion.desconectar();
        }
    }

    public ArrayList<MascotaVO> listarMascotas() {
        ArrayList<MascotaVO> lista = new ArrayList<>();
        String resultado = conexion.conectar();
        if (!resultado.equals("conectado")) {
            System.out.println("Error en la conexión: " + resultado);
            return lista;
        }

        String sql = "SELECT * FROM mascotas";
        try (Connection conn = conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                MascotaVO mascota = new MascotaVO();
                mascota.setId(rs.getInt("id"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setEdad(rs.getInt("edad"));
                lista.add(mascota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
        return lista;
    }
}
