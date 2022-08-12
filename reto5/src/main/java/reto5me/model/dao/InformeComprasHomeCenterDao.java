package reto5me.model.dao;
import java.sql.*;
import java.util.*;

import reto5me.model.vo.InformeComprasHomeCenterVo;
import reto5me.util.*;

public class InformeComprasHomeCenterDao {
    public List<InformeComprasHomeCenterVo> listar() throws SQLException {
        ArrayList<InformeComprasHomeCenterVo> respuesta = new ArrayList<InformeComprasHomeCenterVo>();


        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        String consulta = "SELECT ID_Compra as id, p.Constructora, p.Banco_Vinculado as banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                InformeComprasHomeCenterVo vo = new InformeComprasHomeCenterVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco"));

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

