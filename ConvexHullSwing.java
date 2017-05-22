/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import datastructuredemo.home_not_updated.ConvexHullPoint;
import datastructuredemo.home_not_updated.GenericLinkListStack;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author omi
 */
public class ConvexHullSwing extends javax.swing.JFrame {

    /**
     * Creates new form ConvexHullSwing
     */
    public ConvexHullSwing() {
        this.points = new ArrayList<>();
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g; 
        int x = 100; 
        int y = 150; 
        g2.setColor(new Color(255, 0, 0)); //set color to red (r, g, b) 
        g2.draw(new Line2D.Double(x, y, 120, 130)); 
        
    }
    
    
    
    
    
    
    private ArrayList<ConvexHullPoint> points;
    
    
    private int getOrientation(ConvexHullPoint p, ConvexHullPoint q, ConvexHullPoint r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;  // colinear
        return (val > 0)? 1: 2; // clock or counterclock wise
        // 2 holei left turn hobe
    }
    
    private void addPoint(ConvexHullPoint point)
    {
        this.points.add(point);
    }
    
    public void getHull()
    {
        ConvexHullPoint minimumY = this.points.get(0);
        
        for(int i=1;i<this.points.size();i++)
        {
            if(points.get(i).y < minimumY.y)
            {
                minimumY = points.get(i);
                
            }
        }
        points.remove(minimumY);
        
        for(int i=0;i<points.size();i++)
        {
            points.get(i).angle = this.getAngle(minimumY, points.get(i));
        }
        
        Collections.sort(points);
        System.out.println("minimum: "+minimumY.x+":"+minimumY.y+":"+minimumY.angle);
        
        for(int i=0;i<points.size();i++)
        {
            System.out.println(points.get(i).x+":"+points.get(i).y+":"+points.get(i).angle);
        }
        
        GenericLinkListStack<ConvexHullPoint> stack = new GenericLinkListStack<>();
        
        stack.push(minimumY);
        stack.push(points.get(0));
        stack.push(points.get(1));
        
        points.remove(points.get(0));
        points.remove(points.get(1));
        
        for(int i=0;i<points.size();i++)
        {
            //ConvexHullPoint next_to_top = stack.next_to_top();
            //ConvexHullPoint top = stack.top();
            while(this.getOrientation(stack.next_to_top(), stack.top(), points.get(i)) != 2)
            {
                stack.pop();  
            }
            stack.push(points.get(i));
            
        }
        
        System.out.println("all hull points: ");
        
        while (!stack.isEmpty())
        {
            ConvexHullPoint point = stack.pop();
            System.out.println(point.x+":"+point.y);    
        }
            
    }
    
    
    
    private double getAngle(ConvexHullPoint source,ConvexHullPoint dest)
    {
        double dy = dest.y-source.y;
        double dx = dest.x-source.x;
        return Math.atan2(dy, dx);  
    }
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jToggleButton1.setText("jToggleButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jToggleButton1)
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jToggleButton1)
                .addGap(62, 62, 62)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        int x = evt.getX();
        int y = evt.getY();
        ConvexHullPoint point = new ConvexHullPoint(x, y);
        this.addPoint(point);
        System.out.println(x+":"+y);
        
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(ConvexHullSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvexHullSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvexHullSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvexHullSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvexHullSwing().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}