package buscaminas;

import buscaminas.Jugador;
import buscaminas.botones;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class savedatos {

    static ArrayList<Jugador> record = new ArrayList<Jugador>();

    File archivo = null;
    FileWriter fw = null;
    BufferedWriter bw = null;
    PrintWriter wr = null;
    FileReader fr;
    BufferedReader br;

    public void guardar(String nb, int pt) {
        int  pts,cnt;
        String player;
        try {
            archivo = new File(DirectorioActual() + "/punteos.txt");
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);
            wr = new PrintWriter(bw);

            player = nb;
            pts = pt;  
            cnt=botones.maximo;
            for (int x=1; x<=cnt;x++){
                Njugadores(x,player,pts); 
                wr.write(x+" , "+player+" , "+pts);
            }
            wr.close();
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
    }

    public void leer() {
        try {
            archivo = new File(DirectorioActual() + "/punteos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
            JOptionPane.showMessageDialog(null, linea);
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
    }

    public static void Njugadores(int cod, String nom, int pt) {
        Jugador nuevo = new Jugador();
        nuevo.setCodigo(cod);
        nuevo.setNombre(nom);
        nuevo.setPunteo(pt);
        record.add(nuevo);

    }

    public static String DirectorioActual() {
        String directorio = System.getProperty("java.class.path");
        File dir = new File(directorio);
        String directorioPadre = dir.getParent();
        return directorioPadre;
    }

}
