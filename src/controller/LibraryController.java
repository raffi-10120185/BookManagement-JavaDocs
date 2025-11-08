package controller;

import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 * Kelas LibraryController mengimplementasikan pola Singleton.
 * Bertanggung jawab mengelola data buku: tambah, hapus, dan tampilkan.
 * 
 * @author Raffi
 * @version 1.0
 */
public class LibraryController {

    private static LibraryController instance;
    private final List<Book> books;

    /**
     * Konstruktor privat agar hanya bisa diakses melalui getInstance().
     */
    private LibraryController() {
        books = new ArrayList<>();
    }

    /**
     * Mengembalikan satu-satunya instance LibraryController.
     * @return instance LibraryController
     */
    public static LibraryController getInstance() {
        if (instance == null) {
            instance = new LibraryController();
        }
        return instance;
    }

    /**
     * Menambahkan buku ke koleksi perpustakaan.
     * @param book objek Book yang ingin ditambahkan
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Menghapus buku dari koleksi berdasarkan judulnya.
     * 
     * @param title judul buku yang ingin dihapus
     * @return true jika buku berhasil dihapus, false jika tidak ditemukan
     */
    public boolean removeBook(String title) {
        return books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
    }

    /**
     * Mengembalikan daftar semua buku yang ada di perpustakaan.
     * 
     * @return daftar buku (List<Book>)
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // return copy untuk keamanan
    }

    /**
     * Mengecek apakah perpustakaan kosong.
     * @return true jika tidak ada buku
     */
    public boolean isEmpty() {
        return books.isEmpty();
    }
}
