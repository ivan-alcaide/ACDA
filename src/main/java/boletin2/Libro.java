package boletin2;

public class Libro {

    private int id_libro;
    private String titulo;
    private String ISBN;
    private int anio_publicacion;
    private int id_editorial;
    private int ejemplares_totales;
    private int ejemplares_disponibles;

    public Libro(int id_libro, String titulo, String ISBN, int anio_publicacion, int id_editorial, int ejemplares_totales, int ejemplares_disponibles) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.anio_publicacion = anio_publicacion;
        this.id_editorial = id_editorial;
        this.ejemplares_totales = ejemplares_totales;
        this.ejemplares_disponibles = ejemplares_disponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public int getEjemplares_totales() {
        return ejemplares_totales;
    }

    public void setEjemplares_totales(int ejemplares_totales) {
        this.ejemplares_totales = ejemplares_totales;
    }

    public int getEjemplares_disponibles() {
        return ejemplares_disponibles;
    }

    public void setEjemplares_disponibles(int ejemplares_disponibles) {
        this.ejemplares_disponibles = ejemplares_disponibles;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id_libro=" + id_libro +
                ", titulo='" + titulo + '\'' +
                ", ISBN=" + ISBN +
                ", anio_publicacion=" + anio_publicacion +
                ", id_editorial=" + id_editorial +
                ", ejemplares_totales=" + ejemplares_totales +
                ", ejemplares_disponibles=" + ejemplares_disponibles +
                '}';
    }


    public String toStringRed() {
        return id_libro + " | " + this.titulo + " | Disponibles: " + this.ejemplares_disponibles;
    }
}
