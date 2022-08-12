package reto5me.model.dao;
import java.sql.*;
import java.util.*;
import reto5me.model.vo.InformeLiderVo;
import reto5me.util.JDBCUtilities;

public class InformeLiderDao {
    public List<InformeLiderVo> listar() throws SQLException {
        ArrayList<InformeLiderVo> respuesta = new ArrayList<InformeLiderVo>();

        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        String consulta = "SELECT ID_Lider as id, Nombre, Primer_Apellido as apellido, Ciudad_Residencia as ciudad FROM Lider l order by Ciudad_Residencia";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                InformeLiderVo vo = new InformeLiderVo();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("nombre"));
                vo.setApellido(rs.getString("apellido"));
                vo.setCiudad(rs.getString("ciudad"));

                respuesta.add(vo);
            }
        }
        finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }
}
