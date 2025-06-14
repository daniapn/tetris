package tetrisoop; 
// Menyatakan bahwa file ini berada dalam package bernama 'tetrisoop'

import java.awt.Color; 
// Mengimpor class Color dari java.awt untuk menentukan warna dari bentuk

public class ShapeO extends AbstractTetromino { 
    // Kelas ShapeO mewarisi perilaku umum dari AbstractTetromino

    public ShapeO() {
        color = Color.YELLOW; 
        // Mengatur warna tetromino menjadi kuning

        blocks = new Position[] {
            new Position(4, 0), // Blok 1 berada di kolom 4, baris 0
            new Position(5, 0), // Blok 2 berada di kolom 5, baris 0
            new Position(4, 1), // Blok 3 berada di kolom 4, baris 1
            new Position(5, 1)  // Blok 4 berada di kolom 5, baris 1
        };
        // Keempat blok di atas membentuk persegi 2x2 (bentuk O)
    }

    public void rotate() {
        // Bentuk O adalah simetris dan tidak berubah saat diputar,
        // jadi metode ini dikosongkan (tidak melakukan apa-apa)
    }
}
