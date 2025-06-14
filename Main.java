package tetrisoop; // Mendeklarasikan bahwa file ini berada di package 'tetrisoop'

import javax.swing.*; // Mengimpor library Swing untuk membuat GUI di Java

public class Main { // Kelas utama yang menjadi titik awal program
    public static void main(String[] args) {
        // Membuat jendela baru dengan judul "Tetris Game"
        JFrame frame = new JFrame("Tetris Game");

        // Membuat objek GameBoard (papan permainan Tetris)
        GameBoard board = new GameBoard();

        // Menambahkan papan permainan ke dalam jendela
        frame.add(board);

        // Mengatur ukuran jendela agar pas dengan komponen yang ditambahkan
        frame.pack();

        // Mengatur agar aplikasi keluar ketika jendela ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Meletakkan jendela di tengah layar
        frame.setLocationRelativeTo(null);

        // Menampilkan jendela ke layar
        frame.setVisible(true);
    }
}
