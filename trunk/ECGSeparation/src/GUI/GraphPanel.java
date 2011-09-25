package GUI;

import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.traces.Trace2DSimple;
import java.util.Random;

/**
 *
 * @author Tom Pepels - 25-9-2011
 */
public class GraphPanel extends javax.swing.JPanel {

    Chart2D chart;
    
    /** Creates new form GraphPanel */
    public GraphPanel() {
        initComponents();
    }

    public void drawGraph(double[] data) {
        this.removeAll();
        // Create a chart:  
        chart = new Chart2D();
        
        // Create an ITrace: 
        ITrace2D trace = new Trace2DSimple();
        // Add the trace to the chart. This has to be done before adding points (deadlock prevention): 
        chart.addTrace(trace);
        
        for (int i = 0; i < data.length; i++) {
            trace.addPoint(i, data[i]);
        }
        
        chart.setSize(this.getWidth(), this.getHeight());
        chart.setLocation(0,0);
        add(chart);        
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (chart != null) {
            chart.setSize(this.getWidth(), this.getHeight());
        }
    }//GEN-LAST:event_formComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
