import view.LibraryView;

/**
 * Kelas Main berfungsi sebagai entry point program.
 * Memulai aplikasi manajemen buku berbasis konsol.
 * 
 * @author Raffi
 * @version 1.0
 */
public class Main {
    /**
     * Metode utama untuk menjalankan program.
     * @param args argumen baris perintah (tidak digunakan di sini)
     */
    public static void main(String[] args) {
        LibraryView view = new LibraryView();
        view.displayMenu();
    }
}
