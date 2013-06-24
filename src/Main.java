
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuqin
 */
public class Main {
    public static void main(String[] args)
{
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(800, 600);

    JTable table = new JTable(new Object[][]{{50, 50},{50, 50}} , new Object[]{"1", "2"});
    table.setDefaultRenderer(Object.class, new ProgressBarRender());
    frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);

    frame.setVisible(true);
}

}
