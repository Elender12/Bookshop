package business;

/**
 *
 * @author Salahdin Belghiti
 */
public class Articulo {

    private double precio;
    private int codigo;
    private int cantidad;

    public Articulo(int id, String d) {
        this(id, d, 1, 0);
    }

    public Articulo(int id, String d, int c, double p) {
        this.codigo = id;
        this.descripcion = d;
        this.cantidad = c;
        this.precio = p;
    }
    
    public Articulo(int id) {
        this(id,"no name", 0, 0);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public boolean equals(Object obj) {
        Articulo a = (Articulo)obj;
        return (codigo==a.getCodigo());
    }
}
