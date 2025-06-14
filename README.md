# 🎮 Tetris OOP - Java Implementation

Proyek ini merupakan implementasi sederhana game **Tetris** menggunakan bahasa pemrograman **Java** dengan menerapkan konsep **Object-Oriented Programming (OOP)** secara lengkap.

## 📁 Struktur Folder

tetrisoop/

├── Main.java // Titik awal aplikasi

├── GameBoard.java // Logika inti dan tampilan permainan

├── Tetromino.java // Interface untuk semua bentuk tetromino

├── AbstractTetromino.java // Kelas abstrak untuk perilaku umum tetromino

├── ShapeI.java // Bentuk tetromino I

├── ShapeO.java // Bentuk tetromino O

├── ShapeT.java // Bentuk tetromino T

├── ShapeL.java // Bentuk tetromino L

├── Position.java // Mewakili koordinat x dan y

└── ScoreManager.java // Mengatur logika skor dan level

## 💡 Penerapan Konsep OOP

Proyek ini secara lengkap telah memenuhi 4 prinsip utama OOP berikut:

### 1. Constructor, Getter, dan Setter
- **Constructor** digunakan di:
  - `Position(int x, int y)`
  - `ScoreManager()`
- **Getter & Setter**:
  - `getX()`, `getY()`, `setX()`, `setY()` di `Position`
  - `getScore()`, `getLevel()` di `ScoreManager`
  - `getBlocks()`, `getColor()` di `AbstractTetromino`

### 2. Relasi antar Class
- **Inheritance (Pewarisan)**:
  - `ShapeI`, `ShapeO`, `ShapeT`, `ShapeL` mewarisi dari `AbstractTetromino`
  - `AbstractTetromino` mengimplementasikan interface `Tetromino`
- **Composition**:
  - `GameBoard` menyusun objek `Tetromino`, `ScoreManager`, dan `Timer` untuk menjalankan logika permainan.

### 3. Method Overloading dan Overriding
- **Overloading**:
  - `getMovedBlocks(int dx, int dy)` di `AbstractTetromino` adalah versi tambahan dari `move()` tanpa mengubah posisi asli.
- **Overriding**:
  - Method `rotate()` diimplementasikan ulang pada setiap subclass tetromino (`ShapeI`, `ShapeO`, dst).

### 4. Abstract Class dan Interface
- **Interface `Tetromino`**:
  - Mendefinisikan: `rotate()`, `getBlocks()`, `getColor()`
- **Abstract Class `AbstractTetromino`**:
  - Mengimplementasikan method dasar dan perilaku umum tetromino.

## 🚀 Cara Menjalankan

1. Pastikan semua file Java berada dalam folder `tetrisoop/`.
2. Kompilasi seluruh file:
javac tetrisoop/*.java
3. Jalankan program:
java tetrisoop.Main


## 📌 Fitur Permainan

- Grid permainan: 10 kolom × 20 baris.
- Skor naik berdasarkan jumlah baris yang dihapus:
- 1 baris = 100
- 2 baris = 300
- 3 baris = 500
- 4 baris = 800
- Level meningkat setiap 100 poin.
- Permainan berakhir ketika tidak ada ruang untuk tetromino baru.
- Tampilan menggunakan Swing (GUI Java).
