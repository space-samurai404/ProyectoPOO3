/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProyectoPOO3.Vista;
import java.awt.*;
import javax.swing.*;
import ProyectoPOO3.Controlador.Control_Gestores.Control;
import ProyectoPOO3.Modelo.Wearables.TipoWearable;
import ProyectoPOO3.Controlador.Control_Gestores.Control;
import ProyectoPOO3.Controlador.Archivos_Excepciones.*;
import ProyectoPOO3.Controlador.Control_Gestores.*;
import ProyectoPOO3.Modelo.Wearables.*;
import ProyectoPOO3.Modelo.Metricas.*;
import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author paula
 */
public class Pantalla_Principal extends javax.swing.JFrame {
    private Control controlador;
    private PanelDibujo graficoPasos;
    private PanelDibujo graficoSuenno;
    private List valoresCardio;
    private List valoresSuenno;
    private List valoresPasos;
    private Timer timer;
    private Metrica MetricaRitmo;
    private Metrica MetricaHorasSuenno;
    private Metrica MetricaCantPasos;
    private GestorUsuarios gu;
    private int cont=0;
   
    /**
     * Creates new form Registro_Login
     */
    public Pantalla_Principal(Control controlador) {
        initComponents();
        this.controlador=controlador;
        
        this.gu=controlador.getGestorUsuarios();
        
        valoresCardio = new ArrayList<>();
        valoresSuenno = new ArrayList<>();
        valoresPasos = new ArrayList<>();
        
        MetricaRitmo= new RitmoCardiaco();
        MetricaHorasSuenno= new HorasSuenno();
        MetricaCantPasos= new CantKilometros();
        
        graficoPasos = new PanelDibujo();
        graficoSuenno = new PanelDibujo();
        
        
        //Pasos
        pnl_graphicsCantPasos.setLayout(new BorderLayout());
        pnl_graphicsCantPasos.add(graficoPasos, BorderLayout.CENTER);
        
        //Horas de suenno
        pnl_graphicsCanthoras.setLayout(new BorderLayout());
        pnl_graphicsCanthoras.add(graficoSuenno, BorderLayout.CENTER);
        
        revalidate();
        repaint();
        
        ArrayList<Meta> metas = controlador.obtenerMetasPredeterminadas();
        cbo_metas.setModel(new DefaultComboBoxModel<>(metas.toArray(new Meta[0])));
        
        timer = new Timer(10000, e-> {
            cont = 0; 
            int simul=controlador.Simulacion(1);
            int simul2=controlador.Simulacion(2);
            int simul3=controlador.Simulacion(3);
            valoresCardio.add(simul);
            lbl_bpm.setText(Double.toString(simul));
            valoresSuenno.add(simul2);
            valoresPasos.add(simul3);
        if (simul > 100) {
        JOptionPane.showMessageDialog(this, 
            "⚠️ Ritmo cardiaco muy alto: " + simul + " BPM",
            "Alerta salud",
            JOptionPane.WARNING_MESSAGE);
        }
            
        if (simul < 60) {
        JOptionPane.showMessageDialog(this, 
            "⚠️ Ritmo cardiaco muy bajo: " + simul + " BPM",
            "Alerta salud",
            JOptionPane.WARNING_MESSAGE);
        }

        if (simul2 < 6) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Dormiste menos de 6 horas",
                "Alerta sueño",
                JOptionPane.WARNING_MESSAGE);
        }
        
        if (simul2 > 9) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Dormiste demasiado",
                "Alerta sueño",
                JOptionPane.WARNING_MESSAGE);
        }

        if (simul3 < 4000) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Pasos muy bajos hoy",
                "Alerta actividad",
                JOptionPane.WARNING_MESSAGE);
        }
                
            
            
            
            
            System.out.println(gu.getUsuarioActual());
            for (Metrica m : gu.getUsuarioActual().getMetricasDiarias()){
                cont++;
                
                if (cont==1){
                    m.setValorActual(simul);
                }else if(cont==2){
                    m.setValorActual(simul3);
                }else if (cont==3){
                    m.setValorActual(simul2);
                }               
            }
            try{
                controlador.procesarMetricas();
            }catch(MiExcepcion ex){

                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            try{
                txt_reporte.setText(controlador.generarReporteConsolidado());
            }catch(MiExcepcion ej){

                JOptionPane.showMessageDialog(this, ej.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            graficoSuenno.setValores(valoresSuenno);
            graficoPasos.setValores(valoresPasos);

            graficoPasos.repaint();
            graficoSuenno.repaint();
        

    });

        
    }
    
    public Pantalla_Principal() {
        initComponents();
        this.controlador=controlador;
        
        this.gu=controlador.getGestorUsuarios();
        
        valoresCardio = new ArrayList<>();
        valoresSuenno = new ArrayList<>();
        valoresPasos = new ArrayList<>();
        
        MetricaRitmo= new RitmoCardiaco();
        MetricaHorasSuenno= new HorasSuenno();
        MetricaCantPasos= new CantKilometros();
        
        graficoPasos = new PanelDibujo();
        graficoSuenno = new PanelDibujo();
        
        
        //Pasos
        pnl_graphicsCantPasos.setLayout(new BorderLayout());
        pnl_graphicsCantPasos.add(graficoPasos, BorderLayout.CENTER);
        
        //Horas de suenno
        pnl_graphicsCanthoras.setLayout(new BorderLayout());
        pnl_graphicsCanthoras.add(graficoSuenno, BorderLayout.CENTER);
        
        revalidate();
        repaint();
        
        ArrayList<Meta> metas = controlador.obtenerMetasPredeterminadas();
        cbo_metas.setModel(new DefaultComboBoxModel<>(metas.toArray(new Meta[0])));
        
        timer = new Timer(10000, e-> {
            int simul=controlador.Simulacion(1);
            int simul2=controlador.Simulacion(2);
            int simul3=controlador.Simulacion(3);
            
            
            valoresCardio.add(simul);
            lbl_bpm.setText(Double.toString(simul));
            valoresSuenno.add(simul2);
            valoresPasos.add(simul3);
            
            if (simul > 100) {
        JOptionPane.showMessageDialog(this, 
            "⚠️ Ritmo cardiaco muy alto: " + simul + " BPM",
            "Alerta salud",
            JOptionPane.WARNING_MESSAGE);
        }
            
        if (simul < 60) {
        JOptionPane.showMessageDialog(this, 
            "⚠️ Ritmo cardiaco muy bajo: " + simul + " BPM",
            "Alerta salud",
            JOptionPane.WARNING_MESSAGE);
        }

        if (simul2 < 6) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Dormiste menos de 6 horas",
                "Alerta sueño",
                JOptionPane.WARNING_MESSAGE);
        }
        
        if (simul2 > 9) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Dormiste demasiado",
                "Alerta sueño",
                JOptionPane.WARNING_MESSAGE);
        }

        if (simul3 < 4000) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Pasos muy bajos hoy",
                "Alerta actividad",
                JOptionPane.WARNING_MESSAGE);
        }

            for (Metrica m : gu.getUsuarioActual().getMetricasDiarias()){
                cont++;

                if (cont==1){
                    m.setValorActual(simul);
                }else if(cont==2){
                    m.setValorActual(controlador.Simulacion(3));
                }else if (cont==3){
                    m.setValorActual(controlador.Simulacion(2));

                }
                System.out.println(Double.toString(m.getValorActual()));

            }
            try{
                controlador.procesarMetricas();
            }catch(MiExcepcion ex){

                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            try{
                txt_reporte.setText(controlador.generarReporteConsolidado());
            }catch(MiExcepcion ej){

                JOptionPane.showMessageDialog(this, ej.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            graficoSuenno.setValores(valoresSuenno);
            graficoPasos.setValores(valoresPasos);

            graficoPasos.repaint();
            graficoSuenno.repaint();
        

    });
 
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        lbl_bpm = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_consultarHistorial = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        pnl_graphicsCantPasos = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        pnl_graphicsCanthoras = new javax.swing.JPanel();
        btn_guardarUser = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btn_compartirInfo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_reporte = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbo_metas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tab_Referencias = new javax.swing.JTable();
        btn_guardarConfig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(341, 627));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(349, 627));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Ritmo Cárdiaco");

        lbl_bpm.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_bpm.setForeground(new java.awt.Color(153, 153, 153));
        lbl_bpm.setText("000");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("bpm");

        jLabel11.setText("  ");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-corazón-undertale-30.png"))); // NOI18N
        jLabel12.setText("    ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Cantidad de pasos dados");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Horas de sueño");

        btn_consultarHistorial.setBackground(new java.awt.Color(0, 0, 0));
        btn_consultarHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btn_consultarHistorial.setText("Consultar historial de metricas");
        btn_consultarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarHistorialActionPerformed(evt);
            }
        });

        pnl_graphicsCantPasos.setMinimumSize(new java.awt.Dimension(300, 150));
        pnl_graphicsCantPasos.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pnl_graphicsCantPasosLayout = new javax.swing.GroupLayout(pnl_graphicsCantPasos);
        pnl_graphicsCantPasos.setLayout(pnl_graphicsCantPasosLayout);
        pnl_graphicsCantPasosLayout.setHorizontalGroup(
            pnl_graphicsCantPasosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        pnl_graphicsCantPasosLayout.setVerticalGroup(
            pnl_graphicsCantPasosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(pnl_graphicsCantPasos);

        pnl_graphicsCanthoras.setMinimumSize(new java.awt.Dimension(300, 150));
        pnl_graphicsCanthoras.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pnl_graphicsCanthorasLayout = new javax.swing.GroupLayout(pnl_graphicsCanthoras);
        pnl_graphicsCanthoras.setLayout(pnl_graphicsCanthorasLayout);
        pnl_graphicsCanthorasLayout.setHorizontalGroup(
            pnl_graphicsCanthorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        pnl_graphicsCanthorasLayout.setVerticalGroup(
            pnl_graphicsCanthorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jScrollPane7.setViewportView(pnl_graphicsCanthoras);

        btn_guardarUser.setBackground(new java.awt.Color(0, 0, 0));
        btn_guardarUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardarUser.setText("Guardar y cerrar");
        btn_guardarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_consultarHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_bpm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(btn_guardarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_bpm)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btn_guardarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_consultarHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jScrollPane1.setViewportView(jPanel3);

        jTabbedPane1.addTab("Métricas", jScrollPane1);

        btn_compartirInfo.setBackground(new java.awt.Color(0, 0, 0));
        btn_compartirInfo.setForeground(new java.awt.Color(255, 255, 255));
        btn_compartirInfo.setText("Compartir información con profesional");
        btn_compartirInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compartirInfoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Reporte consolidado");

        txt_reporte.setColumns(20);
        txt_reporte.setRows(5);
        jScrollPane5.setViewportView(txt_reporte);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btn_compartirInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(42, 42, 42))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btn_compartirInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel2);

        jTabbedPane1.addTab("Recomendaciones", jScrollPane3);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Agregar meta");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Rangos de Referencia");

        tab_Referencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ritmo cárdiaco", "100", "50"},
                {"Horas de sueño", "9", "6"},
                {"Cantidad de pasos", "---", "4000"}
            },
            new String [] {
                "Métrica", "Valor máx", "Valor min"
            }
        ));
        jScrollPane4.setViewportView(tab_Referencias);

        btn_guardarConfig.setBackground(new java.awt.Color(0, 0, 0));
        btn_guardarConfig.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardarConfig.setText("Guardar");
        btn_guardarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_guardarConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(cbo_metas, 0, 264, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_metas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_guardarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jTabbedPane1.addTab("Configuración Perfil", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btn_guardarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarConfigActionPerformed
        if (cbo_metas.getSelectedIndex()== 0){
            controlador.asignarMeta(0);
        }else if (cbo_metas.getSelectedIndex()== 1){
            controlador.asignarMeta(1);
        }else if (cbo_metas.getSelectedIndex()== 2){
            controlador.asignarMeta(2);
        }
        
        //
    }//GEN-LAST:event_btn_guardarConfigActionPerformed

    private void btn_compartirInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compartirInfoActionPerformed
        controlador.exportarReporteParaProfesional();
    }//GEN-LAST:event_btn_compartirInfoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.out.print("pasa por aqui");
        try{
            controlador.guardarUsuarios();
        }catch(MiExcepcion e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosed

    private void btn_consultarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarHistorialActionPerformed

        new Historial(controlador).setVisible(true);
    }//GEN-LAST:event_btn_consultarHistorialActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void btn_guardarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarUserActionPerformed
        
        try{
            controlador.guardarUsuarios();
            System.exit(0);
            
        }catch(MiExcepcion e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_guardarUserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_compartirInfo;
    private javax.swing.JButton btn_consultarHistorial;
    private javax.swing.JButton btn_guardarConfig;
    private javax.swing.JButton btn_guardarUser;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<Meta> cbo_metas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_bpm;
    private javax.swing.JPanel pnl_graphicsCantPasos;
    private javax.swing.JPanel pnl_graphicsCanthoras;
    private javax.swing.JTable tab_Referencias;
    private javax.swing.JTextArea txt_reporte;
    // End of variables declaration//GEN-END:variables
}
