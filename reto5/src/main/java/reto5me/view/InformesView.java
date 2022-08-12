package reto5me.view;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import reto5me.controller.*;
import reto5me.model.vo.*;

public class InformesView extends JFrame implements ActionListener{
    private static InformesController controller;
    private JTable table;
    private DefaultTableModel modeloBase;
    private JMenuBar mMenuBar;
    private JMenuItem sub1, sub2, sub3;
    private JMenu menu;
    private JLabel lblBienvenida, lblPie;

    public InformesView(){
        controller = new InformesController();
        menu();
        titulo();
        tabla();
        pie();
    }


    public void titulo() {
        lblBienvenida = new JLabel("Bienvenido a las consultas del reto 5", SwingConstants.CENTER);
        lblBienvenida.setSize(500, 30);
        lblBienvenida.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblBienvenida);
    }
    public void pie() {
        lblPie = new JLabel("Proyectos de Construcción 2022");
        lblPie.setFont(new Font("Serif", Font.ITALIC, 15));
        add(lblPie);
    }

    public void tabla() {
        table = new JTable(modeloBase);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setBackground(Color.LIGHT_GRAY);
        add(table);
        JScrollPane pane = new JScrollPane(table);
        add(pane);
    }

    public void menu(){
        mMenuBar = new JMenuBar();
        setJMenuBar(mMenuBar);
        menu = new JMenu("Informes");
        
        mMenuBar.add(menu);
        mMenuBar.setOpaque(true);
        mMenuBar.setBackground(Color.ORANGE);

        sub1 = new JMenuItem("Informe n°1");
        sub2 = new JMenuItem("Informe n°2");
        sub3 = new JMenuItem("Informe n°3");

        menu.add(sub1);
        menu.addSeparator();
        menu.add(sub2);
        menu.addSeparator();
        menu.add(sub3);

        sub1.addActionListener(this);
        sub2.addActionListener(this);
        sub3.addActionListener(this);
    }

    public void informeUno() {
        try{
            List<InformeLiderVo> lideres = controller.listarInformeLideres();

            modeloBase = new DefaultTableModel();
            modeloBase.addColumn("Id");
            modeloBase.addColumn("Nombre");
            modeloBase.addColumn("Apellido");
            modeloBase.addColumn("Ciudad");

            for(InformeLiderVo lid: lideres ){
                Object[] fila = new Object[4];
                fila[0]=lid.getId();
                fila[1]=lid.getNombre();
                fila[2]=lid.getApellido();
                fila[3]=lid.getCiudad();
                modeloBase.addRow(fila);
            }
            table.setModel(modeloBase);
            modeloBase.fireTableDataChanged();
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void informeDos(){
        try {
            List<InformeCasaCampestreVo> proyectos = controller.listarProyectosCasaCampestre();
                modeloBase = new DefaultTableModel();
                modeloBase.addColumn("Id Proyecto");
                modeloBase.addColumn("Constructora");
                modeloBase.addColumn("Habitaciones");
                modeloBase.addColumn("Ciudad");
                for (InformeCasaCampestreVo pro : proyectos){
                    Object[] fila = new Object[4];
                    fila[0] = pro.getId();
                    fila[1] = pro.getConstructora();
                    fila[2] = pro.getHabitaciones();
                    fila[3] = pro.getCiudad();
                    modeloBase.addRow(fila);                    
                }
                table.setModel(modeloBase);
                modeloBase.fireTableDataChanged();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    
    public void informeTres() {
        try {
            List<InformeComprasHomeCenterVo> compras = controller.listarInformesProveedorHomecenter();

            modeloBase = new DefaultTableModel();
            modeloBase.addColumn("Id compra");
            modeloBase.addColumn("Constructora");
            modeloBase.addColumn("Banco");
            for (InformeComprasHomeCenterVo comp : compras){
                Object[] fila = new Object[3];
                fila[0] = comp.getId();
                fila[1] = comp.getConstructora();
                fila[2] = comp.getBanco();
                modeloBase.addRow(fila);
            }
            table.setModel(modeloBase);
            modeloBase.fireTableDataChanged();
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub1){
            informeUno();
        }        
        if (e.getSource() == sub2){
            informeDos();
        }
        if (e.getSource() == sub3){
            informeTres();
        }

    }
}
