package tetrisoop;
// Menyatakan bahwa file ini berada dalam package bernama 'tetrisoop'
public class ScoreManager {
// Membuat class publik bernama ScoreManager
// Class ini bertanggung jawab untuk mengatur skor dan level dalam permainan
    private int score;
    // Variabel untuk menyimpan jumlah skor pemain

    private int level;
    // Variabel untuk menyimpan level pemain saat ini
    public ScoreManager() {
        score = 0;
        // Inisialisasi skor awal ke 0

        level = 1;
        // Inisialisasi level awal ke 1
    }
    public void addLines(int lines) {
        // Method untuk menambahkan skor berdasarkan jumlah baris yang dihapus sekaligus

        switch (lines) {
            case 1: score += 100; break; // 1 baris = tambah 100 poin
            case 2: score += 300; break; // 2 baris = tambah 300 poin
            case 3: score += 500; break; // 3 baris = tambah 500 poin
            case 4: score += 800; break; // 4 baris (Tetris) = tambah 800 poin
        }

        level = (score / 100) + 1;
        // Naik level setiap skor kelipatan 100, misalnya skor 200 = level 3
    }
    public int getScore() {
        return score;
        // Mengembalikan skor saat ini
    }

    public int getLevel() {
        return level;
        // Mengembalikan level saat ini
    }
}
