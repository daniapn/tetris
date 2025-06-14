package tetrisoop; // Mendeklarasikan bahwa kelas ini berada dalam package 'tetrisoop'

import java.awt.Color; // Mengimpor kelas Color untuk menentukan warna bentuk

// Kelas ShapeI merupakan bentuk tetromino I, mewarisi dari AbstractTetromino
public class ShapeI extends AbstractTetromino {
    private int rotationState = 0; 
    // Variabel untuk menyimpan status rotasi: 
    // 0 = horizontal, 1 = vertikal

    public ShapeI() {
        color = Color.CYAN; // Mengatur warna tetromino menjadi cyan (biru muda)
        blocks = new Position[] {
            new Position(3, 0), // Blok 1: posisi awal baris 0, kolom 3
            new Position(4, 0), // Blok 2: baris 0, kolom 4
            new Position(5, 0), // Blok 3: baris 0, kolom 5
            new Position(6, 0)  // Blok 4: baris 0, kolom 6
        };
        // Posisi ini membentuk garis horizontal 4 blok (I-shape)
    }

    public void rotate() {
        Position pivot = blocks[1]; // Titik pivot rotasi adalah blok ke-2

        if (rotationState == 0) {
            // Jika saat ini horizontal, ubah menjadi vertikal
            for (int i = 0; i < blocks.length; i++) {
                // Setiap blok disusun di atas pivot, membentuk garis vertikal
                blocks[i] = new Position(pivot.getX(), pivot.getY() - 1 + i);
            }
        } else {
            // Jika saat ini vertikal, ubah menjadi horizontal
            for (int i = 0; i < blocks.length; i++) {
                // Setiap blok disusun sejajar ke samping dari pivot
                blocks[i] = new Position(pivot.getX() - 1 + i, pivot.getY());
            }
        }

        // Update status rotasi agar bisa bergantian pada rotasi selanjutnya
        rotationState = (rotationState + 1) % 2;
    }
}
