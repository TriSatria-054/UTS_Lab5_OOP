import java.util.ArrayList;
import java.util.Scanner;

//class utama
public class OnlineStore {
    public static void main(String[] args) {
        //membuat objek toko online
        Store store = new Store("BeliBeli");

        //menambahkan produk ke toko online
        store.addProduct(new Product("P001", "Baju", 50000));
        store.addProduct(new Product("P002", "Celana", 30000));
        store.addProduct(new Product("P003", "Topi", 20000));
        store.addProduct(new ElectronicProduct("P004", "Headphones", 2000000, "1 tahun"));
        store.addProduct(new GroceryProduct("P005", "Susu", 25000, "2024-12-31"));
        

        // menampilkan produk yang ada di toko online
        store.displayProducts();

        // Scanner untuk input user
        Scanner scanner = new Scanner(System.in);
        String choice;
        int quantity;
        double total;
        boolean run;

        // loop untuk pilihan beli
        do {
            run = true; // Set run ke true pada setiap iterasi

            // mengambil masukan dari user
            System.out.print("Masukkan ID produk yang ingin dibeli: ");
            String productId = scanner.nextLine();

            // mencari produk berdasarkan ID
            Product foundProduct = store.findProduct(productId);
            if (foundProduct != null) {
                System.out.println("Produk ditemukan: " + foundProduct.getName() + " seharga " + foundProduct.getPrice());

                // meminta konfirmasi untuk membeli produk
                System.out.print("Apakah Anda ingin membeli produk ini? (y/n): ");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    System.out.println("Quantity: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer
                    total = quantity * foundProduct.getPrice();
                    System.out.println("======================================================");
                    System.out.println("Nama Produk       Harga       Qty       Total");
                    System.out.println("======================================================");
                    System.out.println( foundProduct.getName() + "   " + foundProduct.getPrice() + "   " + quantity + "   " + total );
                    System.out.println("======================================================");
                }
            } else {
                System.out.println("Produk tidak ditemukan.");
            }

           
            System.out.print("Apakah Anda ingin mencari produk lain? (y/n): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("n")) {
                run = false; 
            }
        } while (run);

        scanner.close();
    
    }
}

//class untuk produk
class Product {
    private String id;
    private String name;
    private double price;

    //constructor untuk inisialisasi objek product
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //setter dan getter untuk atribut id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // setter dan getter untuk atribut name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // setter dan getter untuk atribut price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //method untuk menampilkan detail produk
    public void displayInfo() {
        System.out.println("ID: " + id + ", Nama: " + name + ", Harga: " + price);
    }

    //method overloading
    public void displayInfo(boolean detailed) {
        if (detailed) {
            System.out.println("Informasi detail produk:");
        }
        displayInfo();
    }
}

//class untuk Toko
class Store {
    private String name;
    private ArrayList<Product> products;

    //constructor untuk inisialisasi objek store
    public Store(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    // method untuk menambahkan produk ke toko
    public void addProduct(Product product) {
        products.add(product);
    }

    //method untuk menampilkan semua produk di toko
    public void displayProducts() {
        System.out.println("Produk yang tersedia di " + name + ":");
        for (Product product : products) {
            product.displayInfo(true); 
        }
    }

    // method untuk mencari produk berdasarkan ID, jika sama dengan id yg dicari, return product yg berisi id, nama, harga
    public Product findProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    // setter dan getter untuk atribut name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// class turunan untuk Produk elektronik
class ElectronicProduct extends Product {
    private String warranty;

    // constructor untuk inisialisasi objek electronicProduct
    public ElectronicProduct(String id, String name, double price, String warranty) {
        super(id, name, price);
        this.warranty = warranty;
    }

    // setter dan getter untuk atribut warranty
    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    // method overriding untuk menampilkan detail produk elektronik spt garansi
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Garansi: " + warranty);
    }
}

// class turunan untuk produk kebutuhan sehari hari
class GroceryProduct extends Product {
    private String expiryDate;

    // constructor untuk inisialisasi objek GroceryProduct
    public GroceryProduct(String id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    // setter dan getter untuk atribut expiryDate
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    // method overriding untuk menampilkan detail produk kebutuhan seharihari seperti expiryDate
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tanggal Kedaluwarsa: " + expiryDate);
    }
}

//Penjelasan naratif
// 1. Class dan Object:
// Program ini memiliki beberapa class: OnlineStore, Product, Store, ElectronicProduct, dan GroceryProduct.
// OnlineStore adalah class utama yang menjalankan program.
// Product adalah class dasar yang merepresentasikan produk di toko online.
// Store adalah class yang merepresentasikan toko online yang berisi kumpulan produk. 
// ElectronicProduct, dan GroceryProduct adalah class turunan dari Product yang memiliki fitur tambahan spesifik.
// 2. Constructor:
// Constructor digunakan untuk menginisialisasi objek dengan nilai awal. Misalnya, constructor pada class Product digunakan untuk menginisialisasi ID, name, dan price. Constructor pada class turunan menginisialisasi atribut tambahan.
// 3. Method Overloading:
// Method overloading terjadi pada method displayInfo di class Product. Terdapat dua method displayInfo, satu dengan parameter boolean dan satu tanpa parameter. Ini memungkinkan method dipanggil dengan cara yang berbeda berdasarkan parameter yang diberikan.
// 4. Method Overriding:
// Method overriding terjadi pada class ElectronicProduct, GroceryProduct yang mengoverride method displayInfo dari class Product. Ini memungkinkan class turunan menyediakan implementasi spesifik yang berbeda dari class induknya.
// 5. Setter dan Getter:
// Setter dan getter digunakan untuk mengakses dan memodifikasi atribut private dari class Product dan class turunannya. Ini adalah cara yang baik untuk mengontrol akses ke properti objek dan menjaga enkapsulasi.

// Cara Kerja Program Toko Online
// Membuat Objek Store:

// Program memulai dengan membuat objek Store bernama BeliBeli.
// Store adalah sebuah kelas yang menyimpan nama toko dan daftar produk yang tersedia di toko tersebut.
// Menambahkan Produk ke Toko:

// Program menambahkan beberapa objek Product ke dalam daftar produk di objek Store. Produk-produk tersebut mencakup produk umum (Product), produk elektronik (ElectronicProduct), dan produk kebutuhan sehari-hari (GroceryProduct).
// Menampilkan Produk yang Tersedia:

// Program menampilkan semua produk yang tersedia di toko dengan menggunakan metode displayProducts dari kelas Store. Metode ini memanggil metode displayInfo dari setiap objek Product untuk menampilkan detail produk.
// Meminta Input dari Pengguna:

// Program menggunakan Scanner untuk meminta input dari pengguna, yaitu ID produk yang ingin dibeli.
// Mencari Produk Berdasarkan ID:

// Program mencari produk di daftar produk toko berdasarkan ID yang dimasukkan oleh pengguna menggunakan metode findProduct dari kelas Store.
// Memverifikasi Produk yang Ditemukan:

// Jika produk ditemukan, program menampilkan detail produk tersebut dan meminta konfirmasi dari pengguna apakah ingin membeli produk tersebut.
// Memproses Pembelian:

// Jika pengguna mengonfirmasi pembelian, program meminta pengguna untuk memasukkan jumlah produk yang ingin dibeli.
// Program menghitung total harga berdasarkan jumlah produk yang dibeli dan menampilkan detail pembelian.
// Mengulangi Proses atau Mengakhiri Program:

// Program menanyakan pengguna apakah ingin mencari produk lain. Jika pengguna memilih y, proses pencarian dan pembelian diulangi. Jika pengguna memilih n, program berhenti.
// singkatnya 
// 1. menampilkan daftar produk yg terdapat di store
// 2. meminta user menginput kode produk yg dicari, setelah ketemu konfirmasi apakah dibeli atau tidak, jika ya tanyakan quantity produk yg dibeli, 
// setelahnya tampilkan struk belanja berisi detail dan total belanjaan. lalu konfirmasi apakah user ingin mencari produk atau tidak, jika user menginputkan karakter n exit program, 
// jika yg diinputkan karakter y ulangi sampai user menginputkan karakter n  
