package reto5me.controller;
import reto5me.model.dao.*;
import reto5me.model.vo.*;
import java.sql.*;
import java.util.*;

public class InformesController {
    private InformeLiderDao informeLiderDao;
    private InformeComprasHomeCenterDao informeComprasHomeCenterDao;
    private InformeCasaCampestreDao informeCasaCampestreDao;
    
    public InformesController() {
        informeLiderDao = new InformeLiderDao();
        informeCasaCampestreDao = new InformeCasaCampestreDao();
        informeComprasHomeCenterDao = new InformeComprasHomeCenterDao();
    }


    public List<InformeLiderVo> listarInformeLideres() throws SQLException {
        return informeLiderDao.listar();
    }

    public List<InformeComprasHomeCenterVo> listarInformesProveedorHomecenter() throws SQLException {
        return informeComprasHomeCenterDao.listar();
    }

    public List<InformeCasaCampestreVo> listarProyectosCasaCampestre() throws SQLException {
        return informeCasaCampestreDao.listar();
    }
}


