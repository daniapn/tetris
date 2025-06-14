package tetrisoop;
// Menyatakan bahwa interface ini berada dalam package bernama 'tetrisoop'

import java.awt.Color;
// Mengimpor class Color dari pustaka AWT untuk mewakili warna tetromino
public interface Tetromino {
// Mendeklarasikan interface Tetromino, yang berfungsi sebagai kontrak untuk semua bentuk tetromino
// Interface ini memastikan bahwa setiap tetromino harus memiliki metode-metode berikut:
    Position[] getBlocks();
    // Mengembalikan array posisi dari semua blok yang menyusun tetromino
    // Digunakan untuk mengetahui posisi tetromino di papan permainan
    Color getColor();
    // Mengembalikan warna tetromino
    // Warna ini digunakan saat menggambar tetromino di layar
    void move(int dx, int dy);
    // Memindahkan seluruh blok tetromino sebanyak dx secara horizontal dan dy secara vertikal
    // Misalnya: dx = -1 artinya geser ke kiri, dy = 1 artinya geser ke bawah
    Position[] getMovedBlocks(int dx, int dy);
    // Mengembalikan array posisi baru jika tetromino digeser sebanyak dx dan dy
    // Fungsinya untuk mengecek apakah pergerakan valid tanpa langsung mengubah posisi asli
    void rotate();
    // Memutar tetromino 90 derajat (biasanya searah jarum jam)
    // Setiap bentuk tetromino punya implementasi rotasi yang berbeda
}
