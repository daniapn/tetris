package tetrisoop;
// Menyatakan bahwa kelas ini berada dalam package bernama 'tetrisoop'

public class Position {
// Mendefinisikan kelas publik bernama Position, yang mewakili titik koordinat (x, y)

    private int x, y;
    // Dua variabel private bertipe integer untuk menyimpan nilai koordinat x dan y

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // Konstruktor kelas Position yang menerima dua parameter (x dan y), 
    // kemudian menginisialisasi variabel instance x dan y dengan nilai tersebut

    public int getX() { return x; }
    // Method getter untuk mengambil nilai x saat ini

    public int getY() { return y; }
    // Method getter untuk mengambil nilai y saat ini

    public void setX(int x) { this.x = x; }
    // Method setter untuk mengubah nilai x

    public void setY(int y) { this.y = y; }
    // Method setter untuk mengubah nilai y
}
