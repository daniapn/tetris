package tetrisoop;
// Menyatakan bahwa kelas ini berada di dalam package 'tetrisoop'

import java.awt.Color;
// Mengimpor class Color dari pustaka AWT untuk memberikan warna pada tetromino

public class ShapeT extends AbstractTetromino {
// Kelas ShapeT mewarisi dari AbstractTetromino dan merepresentasikan bentuk T

    private int rotationState = 0; 
    // Menyimpan status rotasi tetromino (0 sampai 3 — total 4 arah rotasi)

    public ShapeT() {
        color = Color.MAGENTA; 
        // Memberi warna ungu (magenta) pada bentuk T

        blocks = new Position[] {
            new Position(4, 0), // Blok bagian atas (di atas pivot)
            new Position(3, 1), // Blok kiri bawah
            new Position(4, 1), // Blok tengah bawah — ini digunakan sebagai pivot rotasi
            new Position(5, 1)  // Blok kanan bawah
        };
        // Dengan susunan ini, bentuk menyerupai huruf "T"
    }

    public void rotate() {
        Position center = blocks[2]; 
        // Menyimpan posisi blok pivot (tengah) ke variabel 'center'

        switch (rotationState) {
            case 0:
                // Rotasi dari posisi awal ke posisi rotasi ke-1
                blocks[0] = new Position(center.getX(), center.getY() - 1); // Atas
                blocks[1] = new Position(center.getX() - 1, center.getY()); // Kiri
                blocks[3] = new Position(center.getX() + 1, center.getY()); // Kanan
                break;

            case 1:
                // Rotasi ke posisi rotasi ke-2
                blocks[0] = new Position(center.getX() + 1, center.getY()); // Kanan
                blocks[1] = new Position(center.getX(), center.getY() - 1); // Atas
                blocks[3] = new Position(center.getX(), center.getY() + 1); // Bawah
                break;

            case 2:
                // Rotasi ke posisi rotasi ke-3
                blocks[0] = new Position(center.getX(), center.getY() + 1); // Bawah
                blocks[1] = new Position(center.getX() + 1, center.getY()); // Kanan
                blocks[3] = new Position(center.getX() - 1, center.getY()); // Kiri
                break;

            case 3:
                // Rotasi kembali ke posisi awal (rotasi ke-0)
                blocks[0] = new Position(center.getX() - 1, center.getY()); // Kiri
                blocks[1] = new Position(center.getX(), center.getY() + 1); // Bawah
                blocks[3] = new Position(center.getX(), center.getY() - 1); // Atas
                break;
        }

        rotationState = (rotationState + 1) % 4; 
        // Mengupdate status rotasi agar berputar terus antara 0-3
    }
}
