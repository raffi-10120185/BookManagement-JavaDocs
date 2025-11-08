package model;

/**
 * Kelas Book merepresentasikan entitas buku di sistem.
 * Setiap buku memiliki judul, penulis, dan tahun terbit.
 * 
 * @author Raffi
 * @version 1.0
 */
public class Book {
    private final String title;
    private final String author;
    private final int year;

    /**
     * Membuat objek Book baru.
     * 
     * @param title judul buku
     * @param author penulis buku
     * @param year tahun terbit buku
     */
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    /** @return judul buku */
    public String getTitle() {
        return title;
    }

    /** @return nama penulis buku */
    public String getAuthor() {
        return author;
    }

    /** @return tahun terbit buku */
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " oleh " + author + " (" + year + ")";
    }
}
