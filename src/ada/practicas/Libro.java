package ada.practicas;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private int idLibro;
   private String nombre;
   private String categoría;
   private String  isbn;
   private int anioodepublicación;
    @JoinTable(name = "autores_x_libro",
            joinColumns = @JoinColumn(name = "idLibro"), inverseJoinColumns = @JoinColumn(name="idAutor"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private int idAutor;
    private Autor autor;
    private String editorial;
    private List<Autor> autores = new ArrayList<>();


    public Libro() {
    }

    public Libro(String nombre, String categoría, String isbn, int anioodepublicación, String editorial) {
        this.nombre = nombre;
        this.categoría = categoría;
        this.isbn = isbn;
        this.anioodepublicación = anioodepublicación;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioodepublicación() {
        return anioodepublicación;
    }

    public void setAnioodepublicación(Integer anioodepublicación) {
        this.anioodepublicación = anioodepublicación;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public void setAnioodepublicación(int anioodepublicación) {
        this.anioodepublicación = anioodepublicación;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", categoría='" + categoría + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anioodepublicación=" + anioodepublicación +
                ", editorial='" + editorial + '\'' +
                ", idAutor=" + idAutor +
                '}';
    }

    public void agregarAutor(Autor autor){
        if(autores == null) autores = new ArrayList<>();
        autores.add(autor);
    }
}
