package buscaminas;

import buscaminas.botones;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.Timer;

public class principal extends javax.swing.JFrame implements ActionListener {

    public static int nFilas;
    public static int ncolumnas;
    public static int punteo = 0;
    public int nivel = 0;
    public static boolean perdistes;
    int nM;

    public principal() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("BUSCAMINAS");
        Cro = new Timer(1000,cr);
    }
    public static botones bn[][];

    private void iniciar() {
       
        switch (nivel) {
            case 1:
                this.tablero.removeAll();
                perdistes = false;
                nFilas = 10;
                ncolumnas = 10;
                nM = 10;
                this.tablero.setLayout(new java.awt.GridLayout(nFilas, ncolumnas));
                this.bn = new botones[nFilas][ncolumnas];
                int mix[] = Minasnum(nM, nFilas);
                int miy[] = Minasnum(nM, ncolumnas);

                for (int x = 0; x < nFilas; x++) {
                    for (int y = 0; y < ncolumnas; y++) {
                        this.bn[x][y] = new botones(x,y);
                        bn[x][y].setVisible(true);
                        bn[x][y].setMina(false);
                        bn[x][y].setTipomin(numerosbotones());
                        this.tablero.add(bn[x][y]);
                    }
                }
                for (int i = 0; i < nFilas; i++) {
                    this.bn[mix[i]][miy[i]].setMina(true);
                    this.bn[mix[i]][miy[i]].setTipomin(0);
                    this.tablero.add(bn[i][i]);
                }
                break;
            case 2:
                this.tablero.removeAll();
                perdistes = false;
                nFilas = 15;
                ncolumnas = 15;
                nM = 15;
                this.tablero.setLayout(new java.awt.GridLayout(nFilas, ncolumnas));
                this.bn = new botones[nFilas][ncolumnas];
                int mf2[] = Minasnum(nM, nFilas);
                int mc2[] = Minasnum(nM, ncolumnas);

                for (int x = 0; x < nFilas; x++) {
                    for (int y = 0; y < ncolumnas; y++) {
                        this.bn[x][y] = new botones(x,y);
                        bn[x][y].setVisible(true);
                        bn[x][y].setMina(false);
                        bn[x][y].setTipomin(numerosbotones());
                        this.tablero.add(bn[x][y]);
                    }
                }
                for (int i = 0; i < nFilas; i++) {
                    this.bn[mf2[i]][mc2[i]].setMina(true);
                    this.bn[mf2[i]][mc2[i]].setTipomin(0);
                    this.tablero.add(bn[i][i]);
                }
                break;
            case 3:
                 this.tablero.removeAll();
                perdistes = false;
                nFilas = 20;
                ncolumnas = 20;
                nM = 20;
                this.tablero.setLayout(new java.awt.GridLayout(nFilas, ncolumnas));
                this.bn = new botones[nFilas][ncolumnas];
                int mi2[] = Minasnum(nM, nFilas);
                int mj2[] = Minasnum(nM, ncolumnas);

                for (int x = 0; x < nFilas; x++) {
                    for (int y = 0; y < ncolumnas; y++) {
                        this.bn[x][y] = new botones(x,y);
                        bn[x][y].setVisible(true);
                        bn[x][y].setMina(false);
                        bn[x][y].setTipomin(numerosbotones());
                        this.tablero.add(bn[x][y]);
                    }
                }
                for (int i = 0; i < nFilas; i++) {
                    this.bn[mi2[i]][mj2[i]].setMina(true);
                    this.bn[mi2[i]][mj2[i]].setTipomin(0);
                    this.tablero.add(bn[i][i]);
                }
                break;

        }
    }

    public int numerosbotones(){
        Random numb = new Random();
        int numero = (int)(numb.nextDouble()*1);
        return numero+1;
    }
    
    //Este método crea aleatoriamente los numeros en las minas
    public int[] Minasnum(int nM, int aux) {
        Random mi = new Random();
        int n[] = new int[nM];  //guardar los numeros aleatorios
        int cnt = 0;
        boolean a; //verifica si ya se a creado un numero igual
        boolean c = false;
        while (cnt < nM) {
            int num = (int) (mi.nextDouble() * aux);
            a = true;
            for (int x = 0; x < nM; x++) {
                if (num == n[x]) {
                    a = false;
                }
            }
            if (!c && num == 1) {
                c = true;
                num = 0;
            }
            if (a) {
                n[cnt] = num;
                cnt++;
            }
        }
        return n;
    }

    // ESTE METODO SE UTILIZA PARA IMPLEMENTER EL CRONOMETRO
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public static Timer Cro;
    private int cs,s,min,h;
    private ActionListener cr = new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent a){
            cs++;
            if(cs==60){
                cs=0;
                s++;
            }
            if(s==60){
                s=0;
                min++;
            }
            if(min==60){
                min=0;
                h++;
            }
            iniciarcron();
        }
   };
    //VALORES DE TIEMPO QUE SE IMPRIMEN EN PANTALLA
    public void iniciarcron(){
    String t= (min<10?"0":" ")+min+" : "+(s<10?"0":" ")+s+" : "+(cs<10?"0":" ")+cs;
    jLabel1.setText(t);
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
        bmedio = new javax.swing.JButton();
        bfacil = new javax.swing.JButton();
        bdificil = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bmedio.setText("MEDIO");
        bmedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmedioActionPerformed(evt);
            }
        });

        bfacil.setText("FACIL");
        bfacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfacilActionPerformed(evt);
            }
        });

        bdificil.setText("DIFICIL");
        bdificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdificilActionPerformed(evt);
            }
        });

        jButton1.setText("RECORDS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("ROG Fonts", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("00 : 00 : 00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(bfacil, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bmedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdificil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bdificil)
                    .addComponent(bmedio)
                    .addComponent(bfacil)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tablero.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bmedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmedioActionPerformed
        iniciar();
        this.paintAll(this.getGraphics());
        nivel = 2;
        if (Cro.isRunning()){
            Cro.stop();
         }
         cs=0; s=0; min=0; h=0;
        String t= ("00 : 00 : 00");
        jLabel1.setText(t);        
    }//GEN-LAST:event_bmedioActionPerformed

    private void bfacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfacilActionPerformed
        iniciar();
        this.paintAll(this.getGraphics());
        nivel = 1;
        if (Cro.isRunning()){
            Cro.stop();
         }
         cs=0; s=0; min=0; h=0;
        String t= ("00 : 00 : 00");
        jLabel1.setText(t);
    }//GEN-LAST:event_bfacilActionPerformed

    private void bdificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdificilActionPerformed
         iniciar();
        this.paintAll(this.getGraphics());
        nivel = 3;
        if (Cro.isRunning()){
            Cro.stop();
         }
         cs=0; s=0; min=0; h=0;
        String t= ("00 : 00 : 00");
        jLabel1.setText(t);
    }//GEN-LAST:event_bdificilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        savedatos lee = new savedatos();
        lee.leer();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new principal().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bdificil;
    private javax.swing.JButton bfacil;
    private javax.swing.JButton bmedio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables
}
