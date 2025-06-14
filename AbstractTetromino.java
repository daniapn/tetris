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
    // Method getter untuk mengembalikan array posisi blok-blok tetromino saat ini

    public Color getColor() {
        return color;
    }
    // Method getter untuk mengembalikan warna dari tetromino

    public void move(int dx, int dy) {
        // Method untuk memindahkan semua blok dalam tetromino sebanyak dx (horizontal) dan dy (vertikal)
        for (Position p : blocks) {
            p.setX(p.getX() + dx); // Geser posisi x sebesar dx
            p.setY(p.getY() + dy); // Geser posisi y sebesar dy
        }
    }

    // ==== METHOD OVERLOADING ====
    public void move(Position delta) {
        // Ini adalah versi overloaded dari method move()
        // Memungkinkan pemanggilan move dengan objek Position (delta) daripada dua nilai terpisah dx dan dy
        move(delta.getX(), delta.getY()); // Memanggil method move(dx, dy) dengan nilai dari delta
    }

    public Position[] getMovedBlocks(int dx, int dy) {
        // Method untuk mengembalikan array posisi baru dari tetromino jika digeser
        // Tidak mengubah posisi aslinya, hanya simulasi pergerakan

        Position[] moved = new Position[blocks.length];
        // Buat array baru dengan panjang yang sama seperti jumlah blok

        for (int i = 0; i < blocks.length; i++) {
            // Iterasi setiap blok dalam tetromino
            moved[i] = new Position(blocks[i].getX() + dx, blocks[i].getY() + dy);
            // Buat blok baru dengan posisi yang telah digeser dx dan dy
        }

        return moved;
        // Kembalikan array berisi posisi blok-blok hasil geseran
    }
}
