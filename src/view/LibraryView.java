package view;

import controller.LibraryController;
import model.Book;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas LibraryView menyediakan antarmuka konsol untuk berinteraksi
 * dengan sistem perpustakaan.
 * 
 * Menggunakan prinsip pemisahan tampilan (View) dari logika kontrol (Controller).
 * 
 * @author Raffi
 * @version 1.0
 */
public class LibraryView {
    private final LibraryController controller;
    private final Scanner scanner;

    /**
     * Membuat objek LibraryView baru.
     */
    public LibraryView() {
        controller = LibraryController.getInstance();
        scanner = new Scanner(System.in);
    }

    /**
     * Menampilkan menu utama dan menangani input pengguna.
     */
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n=== Sistem Manajemen Buku ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Lihat Semua Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = getIntInput();

            switch (choice) {
                case 1 -> addBookMenu();
                case 2 -> removeBookMenu();
                case 3 -> showAllBooks();
                case 0 -> System.out.println("Keluar dari program...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }

    /** Menangani input pengguna dengan validasi angka */
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Masukkan angka yang valid: ");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    /** Menampilkan form tambah buku */
    private void addBookMenu() {
        System.out.print("Judul Buku: ");
        String title = scanner.nextLine().trim();
        System.out.print("Penulis: ");
        String author = scanner.nextLine().trim();
        System.out.print("Tahun Terbit: ");
        int year = getIntInput();

        controller.addBook(new Book(title, author, year));
        System.out.println("✅ Buku berhasil ditambahkan!");
    }

    /** Menampilkan form hapus buku */
    private void removeBookMenu() {
        System.out.print("Judul Buku yang ingin dihapus: ");
        String title = scanner.nextLine().trim();

        if (controller.removeBook(title)) {
            System.out.println("🗑️ Buku berhasil dihapus.");
        } else {
            System.out.println("❌ Buku tidak ditemukan.");
        }
    }

    /** Menampilkan semua buku di perpustakaan */
    private void showAllBooks() {
        List<Book> books = controller.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku di perpustakaan.");
        } else {
            System.out.println("Daftar Buku di Perpustakaan:");
            books.forEach(book -> System.out.println("- " + book));
        }
    }
}
