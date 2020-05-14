package buscaminas;

public class Jugador {

    private int codigo;
    private String nombre;
    private int punteo;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the punteo
     */
    public int getPunteo() {
        return punteo;
    }

    /**
     * @param punteo the punteo to set
     */
    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

}
