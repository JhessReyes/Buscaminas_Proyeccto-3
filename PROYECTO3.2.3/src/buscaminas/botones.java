package buscaminas;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import buscaminas.principal;
import java.awt.Color;
import javax.swing.JOptionPane;

public class botones extends JButton {

    private boolean mina;
    private boolean visible;
    private int tipomin;

    public static int ptsnew;
    public static String nombre;
    public static int maximo=0;

    private final int x;
    private final int y;
    public botones(int x,int y) {
        super();
        this.x=x;
        this.y=y;
        principal.Cro.start();
        this.visible = false;
        this.setMinimumSize(new Dimension(1, 4));
        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                botonesActionPerformed(e);
            }
        });

    }

    public void botonesActionPerformed(java.awt.event.ActionEvent e) {

        System.out.println(mina);
        savedatos sv = new savedatos();
        
        int perder = 0;
        if (!visible && principal.perdistes == false) {
            this.visible = true;
            this.setBackground(new java.awt.Color(240, 240, 240));
            switch (this.tipomin) {
                case 0:
                    for (int a = 0; a < principal.nFilas; a++) {
                        for (int b = 0; b < principal.ncolumnas; b++) {
                            if (principal.bn[a][b].getTipomin() == 0) {
                                ImageIcon im = new ImageIcon(getClass().getResource("/Assets/icon.png"));
                                Icon icono = new ImageIcon(im.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
                                principal.bn[a][b].setIcon(icono);
                                perder = 1;
                                principal.Cro.stop();
                            }
                        }
                    }
                    if (perder == 1) {
                        ptsnew = principal.punteo;
                        javax.swing.JOptionPane.showMessageDialog(this, "PERDISTE");
                        nombre = JOptionPane.showInputDialog(" INGRESE JUGADOR ");
                        javax.swing.JOptionPane.showMessageDialog(null, "TU PUNTEO FUE DE:" + ptsnew);
                        maximo++;
                        sv.guardar(nombre, ptsnew);
                        principal.nFilas = 0;
                        principal.ncolumnas = 0;
                        principal.punteo = 0;
                        principal.perdistes = true;
                    }
                    break;
                case 1:
                    int cont = 0;
                    this.setBackground(new java.awt.Color(240, 240, 240));
                    for (int i = -1; i <= 1; i++) {
                        if ((x + i) >= 0 && (x + i) < principal.nFilas) {
                            for (int j = -1; j <= 1; j++) {
                                System.out.println((y + i) + " " + (y + i )+ " " + principal.ncolumnas);
                                if ((y + i) >= 0 && (y + j) < principal.ncolumnas && principal.bn[x + i][y + j].isMina()==true) {
                                    cont++;
                                }
                            }
                        }
                    }
                    this.setText("" + cont);
                    this.setForeground(Color.RED);
                    principal.punteo++;
                    principal.Cro.restart();
                    break;
            }
        }
    }

    /**
     * @return the mina
     */
    public boolean isMina() {
        return mina;
    }

    /**
     * @param mina the mina to set
     */
    public void setMina(boolean mina) {
        this.mina = mina;
    }

    /**
     * @param tipomin the mina to set
     */
    public void setTipomin(int tipomin) {
        this.tipomin = tipomin;
    }

    /**
     * @return the tipomin
     */
    public int getTipomin() {
        return tipomin;
    }

}
