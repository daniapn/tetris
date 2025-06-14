package tetrisoop;
// Menyatakan bahwa kelas ini berada di dalam package 'tetrisoop'

import java.awt.Color;
// Mengimpor class Color dari pustaka AWT untuk memberikan warna pada tetromino

public class ShapeL extends AbstractTetromino {
// Kelas ShapeL mewarisi dari AbstractTetromino dan merepresentasikan bentuk L

    private int rotationState = 0; 
    // Variabel untuk menyimpan status rotasi saat ini (0 hingga 3)

    public ShapeL() {
        color = Color.ORANGE; 
        // Memberikan warna oranye pada bentuk L

        blocks = new Position[] {
            new Position(3, 1), // Blok kiri bawah
            new Position(4, 1), // Blok tengah bawah (digunakan sebagai pivot rotasi)
            new Position(5, 1), // Blok kanan bawah
            new Position(5, 0)  // Blok kanan atas
        };
        // Keempat blok di atas membentuk huruf "L"
    }

    public void rotate() {
        Position center = blocks[1]; 
        // Mendapatkan posisi pivot (blok tengah) untuk rotasi

        switch (rotationState) {
            case 0:
                // Rotasi dari posisi awal ke rotasi ke-1 (berdiri menghadap kanan)
                blocks[0] = new Position(center.getX(), center.getY() - 1); // Atas tengah
                blocks[2] = new Position(center.getX(), center.getY() + 1); // Bawah tengah
                blocks[3] = new Position(center.getX() + 1, center.getY() - 1); // Atas kanan
                break;

            case 1:
                // Rotasi ke posisi ke-2 (terlentang ke atas)
                blocks[0] = new Position(center.getX() + 1, center.getY()); // Kanan tengah
                blocks[2] = new Position(center.getX() - 1, center.getY()); // Kiri tengah
                blocks[3] = new Position(center.getX() + 1, center.getY() + 1); // Bawah kanan
                break;

            case 2:
                // Rotasi ke posisi ke-3 (berdiri menghadap kiri)
                blocks[0] = new Position(center.getX(), center.getY() + 1); // Bawah tengah
                blocks[2] = new Position(center.getX(), center.getY() - 1); // Atas tengah
                blocks[3] = new Position(center.getX() - 1, center.getY() + 1); // Bawah kiri
                break;

            case 3:
                // Rotasi ke posisi ke-4 (terlentang ke bawah / kembali ke posisi awal)
                blocks[0] = new Position(center.getX() - 1, center.getY()); // Kiri tengah
                blocks[2] = new Position(center.getX() + 1, center.getY()); // Kanan tengah
                blocks[3] = new Position(center.getX() - 1, center.getY() - 1); // Atas kiri
                break;
        }

        rotationState = (rotationState + 1) % 4; 
        // Memperbarui status rotasi agar berputar ke posisi berikutnya (0–1–2–3–0)
    }
}
