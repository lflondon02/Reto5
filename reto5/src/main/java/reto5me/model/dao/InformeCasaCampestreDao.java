package reto5me.model.dao;
import java.sql.*;
import java.util.*;
import reto5me.model.vo.InformeCasaCampestreVo;
import reto5me.util.JDBCUtilities;


public class InformeCasaCampestreDao {
    public List<InformeCasaCampestreVo> listar() throws SQLException {
        ArrayList<InformeCasaCampestreVo> respuesta = new ArrayList<InformeCasaCampestreVo>();

        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        String consulta = "select ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones,Ciudad from Proyecto p where Clasificacion = 'Casa Campestre' and Ciudad in('Santa Marta','Cartagena','Barranquilla')";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                InformeCasaCampestreVo vo = new InformeCasaCampestreVo();
                vo.setId(rs.getInt("id"));
                vo.setCiudad(rs.getString("ciudad"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setHabitaciones(rs.getInt("habitaciones"));

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
