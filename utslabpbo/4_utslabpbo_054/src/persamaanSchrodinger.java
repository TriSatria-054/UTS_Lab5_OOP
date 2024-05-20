import java.util.function.DoubleUnaryOperator;

public class persamaanSchrodinger {
    private double posisiAwal; 
    private double deltaX; 
    private double fungsiGelombangAwal; 
    private DoubleUnaryOperator fungsiPotensial; 

    
    public persamaanSchrodinger(double posisiAwal, double deltaX, double fungsiGelombangAwal, DoubleUnaryOperator fungsiPotensial) {
        this.posisiAwal = posisiAwal;
        this.deltaX = deltaX;
        this.fungsiGelombangAwal = fungsiGelombangAwal;
        this.fungsiPotensial = fungsiPotensial;
    }

    //method utk menghitung Persamaan Schrödinger dengan jumlah langkah spasial tertentu
    public void hitungPersamaanSchrodinger(int jumlahLangkah) {
        double posisiSekarang = posisiAwal;
        double fungsiGelombangSekarang = fungsiGelombangAwal;

        //iterasi pake langkah-langkah spasial
        for (int i = 0; i < jumlahLangkah; i++) {
            //hitung nilai fungsi gelombang pada posisi berikutnya
            double fungsiGelombangSelanjutnya = fungsiGelombangSekarang + (fungsiPotensial.applyAsDouble(posisiSekarang) * fungsiGelombangSekarang * deltaX);

            //update posisi dan fungsi gelombang
            posisiSekarang += deltaX;
            fungsiGelombangSekarang = fungsiGelombangSelanjutnya;
        }

        
        System.out.println("Nilai fungsi gelombang pada posisi akhir: " + fungsiGelombangSekarang);
    }

    //method overloading utk menghitung Persamaan Schrödinger dgn jumlah langkah spasial dan posisi awal tertentu
    public void hitungPersamaanSchrodinger(double posisiAwal, int jumlahLangkah) {
        this.posisiAwal = posisiAwal;
        hitungPersamaanSchrodinger(jumlahLangkah);
    }

    //method overloading utk menghitung Persamaan Schrödinger dengan jumlah langkah spasial, posisi awal, dan fungsi gelombang awal tertentu
    public void hitungPersamaanSchrodinger(double posisiAwal, double fungsiGelombangAwal, int jumlahLangkah) {
        this.posisiAwal = posisiAwal;
        this.fungsiGelombangAwal = fungsiGelombangAwal;
        hitungPersamaanSchrodinger(jumlahLangkah);
    }

    //getter
    public double getPosisiAwal() {
        return posisiAwal;
    }

    //getter
    public double getDeltaX() {
        return deltaX;
    }

    //getter
    public double getFungsiGelombangAwal() {
        return fungsiGelombangAwal;
    }

    //getter
    public DoubleUnaryOperator getFungsiPotensial() {
        return fungsiPotensial;
    }

    public static void main(String[] args) {
        //inisialisasi dulu potensial
        DoubleUnaryOperator fungsiPotensial = x -> Math.sin(x);

        //inisialisasi solver
        persamaanSchrodinger solver = new persamaanSchrodinger(-5, 0.1, 1, fungsiPotensial);

        //hitung Persamaan Schrödinger
        solver.hitungPersamaanSchrodinger(100);

        //hitung Persamaan Schrödinger dengan posisi awal yg berbeda
        solver.hitungPersamaanSchrodinger(-10, 100);

        //hitung Persamaan Schrödinger dengan posisi awal dan fungsi gelombang awal yg berbeda
        solver.hitungPersamaanSchrodinger(-5, 2, 100);
    }
}

// Persamaan Schrödinger dalam mekanika kuantum digunakan untuk menggambarkan evolusi waktu fungsi gelombang sistem kuantum, terdiri atas persamaan diferensial parsial non-linier utk memahami perilaku partikel subatom dan sistem kuantum secara umum.
// dengan Persamaan Schrodinger kita dapat memprediksi bagaimana fungsi gelombang sebuah sistem kuantum akan berevolusi dari waktu ke waktu yang dapat menghitung sifat-sifat kuantum seperti energi, momentum, posisi, dan banyak lagi dari partikel atau sistem kuantum.
// Persamaan Schrödinger sangat penting dalam berbagai bidang, termasuk fisika, kimia, teknologi semikonduktor, dan komputasi kuantum. Misalnya, dalam kimia, Persamaan Schrödinger digunakan untuk memahami struktur molekul dan reaksi kimia. Dalam fisika, Persamaan Schrödinger membantu kita memahami sifat-sifat partikel subatom dan fenomena seperti tunel kuantum. Sedangkan dalam teknologi semikonduktor, Persamaan Schrödinger digunakan untuk merancang dan memahami perilaku perangkat semikonduktor seperti transistor.
// Cara kerjanya yaitu: 
// Method hitungPersamaanSchrodinger digunakan untuk menyelesaikan Persamaan Schrödinger dengan menggunakan metode numerik. Metode ini melakukan iterasi sejumlah langkah yang ditentukan, dan pada setiap langkah, ia menghitung nilai fungsi gelombang pada posisi selanjutnya menggunakan formula iteratif yang sesuai dengan Persamaan Schrödinger.