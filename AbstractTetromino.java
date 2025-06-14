package tetrisoop;
// Menyatakan bahwa file ini berada di dalam package bernama 'tetrisoop'

import java.awt.Color;
// Mengimpor class Color dari pustaka AWT untuk memberikan warna pada objek tetromino

public abstract class AbstractTetromino implements Tetromino {
// Membuat kelas abstrak bernama AbstractTetromino yang mengimplementasikan interface Tetromino
// Kelas ini akan digunakan sebagai dasar (parent class) dari semua bentuk tetromino (seperti ShapeI, ShapeO, dll)

    protected Position[] blocks;
    // Array blok yang menyusun tetromino; tiap blok punya posisi (x, y)

    protected Color color;
    // Warna dari tetromino

    public Position[] getBlocks() {
        return blocks;
    }
    // Method untuk mengembalikan array posisi blok-blok tetromino saat ini

    public Color getColor() {
        return color;
    }
    // Method untuk mengembalikan warna dari tetromino

    public void move(int dx, int dy) {
        // Method untuk memindahkan semua blok dalam tetromino sebanyak dx (horizontal) dan dy (vertikal)
        for (Position p : blocks) {
            p.setX(p.getX() + dx); // Geser x sebesar dx
            p.setY(p.getY() + dy); // Geser y sebesar dy
        }
    }

    public Position[] getMovedBlocks(int dx, int dy) {
        // Method untuk mengembalikan array posisi baru dari tetromino jika digeser tanpa mengubah posisi aslinya
        Position[] moved = new Position[blocks.length];
        // Buat array baru dengan panjang yang sama dengan jumlah blok

        for (int i = 0; i < blocks.length; i++) {
            // Untuk setiap blok dalam tetromino...
            moved[i] = new Position(blocks[i].getX() + dx, blocks[i].getY() + dy);
            // Buat blok baru dengan posisi hasil penambahan dx dan dy
        }

        return moved;
        // Kembalikan array hasil posisi yang sudah digeser
    }
}
