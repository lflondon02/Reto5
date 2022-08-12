package reto5me;
import java.awt.*;
import javax.swing.*;
import reto5me.view.InformesView;

public class App 
{
    public static void main( String[] args )
    {
        var informesView = new InformesView();
        FlowLayout flowLayout = new FlowLayout();
        informesView.setLayout(flowLayout);
        informesView.setMinimumSize(new Dimension(600,400));
        informesView.setVisible(true);
        informesView.setTitle("RETO 5 - INFORMES");
        informesView.setResizable(false);
        informesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        informesView.setLocationRelativeTo(null);
    }
}
