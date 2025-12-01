/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoPOO3.Vista;
import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author paula
 */
public class PanelDibujo extends JPanel{
    private List<Integer> valores = new ArrayList<>();
    
    public void setValores(List<Integer> valores) {
        this.valores = valores;
        repaint(); 
    }
    
    public PanelDibujo() {
        this.setBackground(Color.WHITE);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (valores == null || valores.isEmpty()) {
            g.drawString("Sin datos para mostrar", 20, 20);
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        int padding=40;
        int barWidth=(width-2*padding) / valores.size();

        int max = valores.stream().max(Integer::compare).orElse(1);

        // Eje X
        g2.drawLine(padding, height - padding, width - padding, height - padding);

        // Eje Y
        g2.drawLine(padding, padding, padding, height - padding);

        // Dibujar barras
        for (int i = 0; i < valores.size(); i++) {
            int val = valores.get(i);

            int barHeight = (int) ((double) val / max * (height - 2 * padding));
            int x = padding + i * barWidth;
            int y = height - padding - barHeight;

            //Barra
            g2.setColor(new Color(100, 150, 255));
            g2.fillRect(x, y, barWidth - 10, barHeight);

            //Valor encima
            g2.setColor(Color.BLACK);
            g2.drawString(val + "", x + barWidth / 4, y - 5);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(450, 250);
    }
}
