// GameBoard.java
package tetrisoop;

import javax.swing.*;               // Import library Swing untuk komponen GUI
import java.awt.*;                 // Import untuk fungsi grafis seperti Color dan Graphics
import java.awt.event.*;           // Import untuk menangani event seperti tombol keyboard
import java.util.Random;           // Import untuk menghasilkan angka acak

// Kelas utama papan permainan, turunan dari JPanel dan implementasi ActionListener dan KeyListener
public class GameBoard extends JPanel implements ActionListener, KeyListener {
    private final int WIDTH = 10, HEIGHT = 20, TILE_SIZE = 30; // Ukuran papan dan ukuran satu blok
    private Timer timer;             // Timer untuk mengatur kecepatan jatuh
    private Tetromino current;      // Tetromino yang sedang aktif
    private Color[][] grid;         // Grid 2D menyimpan posisi blok tetap
    private ScoreManager scoreManager; // Pengatur skor dan level
    private Random random = new Random(); // Untuk memilih bentuk secara acak

    // Konstruktor
    public GameBoard() {
        setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE)); // Ukuran panel
        setBackground(Color.BLACK); // Latar belakang hitam
        setFocusable(true);         // Supaya panel bisa menangkap input keyboard
        addKeyListener(this);       // Tambahkan pendengar input keyboard

        grid = new Color[HEIGHT][WIDTH]; // Inisialisasi grid kosong
        scoreManager = new ScoreManager(); // Buat objek manajer skor

        spawnNewPiece();            // Panggil tetromino baru pertama kali

        timer = new Timer(500, this); // Timer berjalan tiap 500ms
        timer.start();              // Mulai timer
    }

    // Fungsi untuk menghasilkan tetromino baru
    private void spawnNewPiece() {
        int shapeType = random.nextInt(4); // Pilih bentuk acak (0-3)
        switch (shapeType) {
            case 0: current = new ShapeI(); break; // Bentuk I
            case 1: current = new ShapeO(); break; // Bentuk O
            case 2: current = new ShapeT(); break; // Bentuk T
            case 3: current = new ShapeL(); break; // Bentuk L
        }

        // Jika tidak bisa muncul karena posisi awal sudah tertutup, game over
        if (!isValidMove(current.getBlocks())) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over!");
            System.exit(0);
        }
    }

    // Dipanggil oleh timer secara otomatis
    public void actionPerformed(ActionEvent e) {
        Position[] moved = current.getMovedBlocks(0, 1); // Cek apakah bisa turun
        if (isValidMove(moved)) {
            current.move(0, 1); // Turunkan tetromino
        } else {
            fixToGrid(); // Tetap di tempat, tambahkan ke grid
        }
        repaint(); // Gambar ulang
    }

    // Cek apakah posisi baru valid (tidak keluar batas dan tidak menabrak blok lain)
    private boolean isValidMove(Position[] newBlocks) {
        for (Position p : newBlocks) {
            int x = p.getX();
            int y = p.getY();
            if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) return false; // Cek batas papan
            if (grid[y][x] != null) return false; // Cek apakah sudah terisi
        }
        return true;
    }

    // Tetromino berhenti, simpan ke grid dan cek garis penuh
    private void fixToGrid() {
        for (Position p : current.getBlocks()) {
            grid[p.getY()][p.getX()] = current.getColor(); // Tetapkan warna ke grid
        }
        clearLines(); // Cek dan bersihkan garis penuh
        spawnNewPiece(); // Munculkan tetromino baru
    }

    // Fungsi untuk membersihkan garis penuh
    private void clearLines() {
        int cleared = 0;
        for (int y = HEIGHT - 1; y >= 0; y--) {
            boolean full = true;
            for (int x = 0; x < WIDTH; x++) {
                if (grid[y][x] == null) {
                    full = false;
                    break;
                }
            }

            if (full) {
                cleared++;
                for (int row = y; row > 0; row--) {
                    grid[row] = grid[row - 1].clone(); // Geser baris ke bawah
                }
                grid[0] = new Color[WIDTH]; // Baris atas jadi kosong
                y++; // Cek lagi baris ini setelah digeser
            }
        }
        if (cleared > 0) {
            scoreManager.addLines(cleared); // Tambah skor dan level
            int newDelay = Math.max(100, 500 - (scoreManager.getLevel() - 1) * 50); // Percepat timer
            timer.setDelay(newDelay);
        }
    }

    // Menggambar ulang panel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Gambar tetromino aktif
        g.setColor(current.getColor());
        for (Position p : current.getBlocks()) {
            g.fillRect(p.getX() * TILE_SIZE, p.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(p.getX() * TILE_SIZE, p.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            g.setColor(current.getColor());
        }

        // Gambar semua blok yang sudah tetap
        for (int r = 0; r < HEIGHT; r++) {
            for (int c = 0; c < WIDTH; c++) {
                if (grid[r][c] != null) {
                    g.setColor(grid[r][c]);
                    g.fillRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }

        // Gambar skor dan level
        g.setColor(Color.WHITE);
        g.drawString("Score: " + scoreManager.getScore(), 10, 20);
        g.drawString("Level: " + scoreManager.getLevel(), 10, 40);
    }

    // Menangani input keyboard
    public void keyPressed(KeyEvent e) {
        Position[] moved;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                moved = current.getMovedBlocks(-1, 0);
                if (isValidMove(moved)) current.move(-1, 0); // Gerak kiri
                break;
            case KeyEvent.VK_RIGHT:
                moved = current.getMovedBlocks(1, 0);
                if (isValidMove(moved)) current.move(1, 0); // Gerak kanan
                break;
            case KeyEvent.VK_DOWN:
                moved = current.getMovedBlocks(0, 1);
                if (isValidMove(moved)) current.move(0, 1); // Gerak bawah
                break;
            case KeyEvent.VK_UP:
                current.rotate(); // Coba putar
                if (!isValidMove(current.getBlocks())) {
                    current.rotate(); current.rotate(); current.rotate(); // Batalkan rotasi jika tidak valid
                }
                break;
        }
        repaint(); // Gambar ulang
    }

    public void keyReleased(KeyEvent e) {} // Tidak digunakan
    public void keyTyped(KeyEvent e) {}    // Tidak digunakan
}
