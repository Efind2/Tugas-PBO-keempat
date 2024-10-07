## Deskripsi
Tugas ini adalah implementasi dari proyek Pemrograman Berbasis Objek (PBO) keempat yang bertujuan untuk mengelola database menggunakan operasi CRUD (Create, Read, Update, Delete) dengan menggunakan Java dan basis data PostgreSQL.
Untuk mengimplementasikan operasi CRUD (Create, Read, Update, Delete) saya menggunakan database perhotelan dengan tabel tamu. Pada program ini kita bisa menampilkan data tamu, menambahkan data tamu, menghapus data tamu dan juga mengupdate data tamu.
Di program ini juga terdapat penugasan untuk membedakan antara  penggunaan **Exception**  `throws` dan `try-catch`, disini saya membuat class keduanya dan menggunakan kasus jumlah index array untuk menggetahui output exception keduanya. Selain itu, pada projek ini saya juga membuat costum exeption untuk mengetahui fungsi dan perbedaannya dengan `throws` & `try-catch`.

## Aplikasi
- IDE NetBeans
- JDK 16
- PostgreSql

## Cara Penggunaan Database
Buat class java yang berisi program untuk CRUD (create, read, update, delete) kemudian hubungkan Netbeans dengan database di PostgreSql dan juga tambahkan liblary Postgre JDBC driver di projeck yang digunakan untuk program CRUD.
kode program untuk menghubungkan databse dengan kode program java
    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/Your database";
    String user = "postgres";
    String password = "your password";
    
## Kode Try-Catch dan Throws
Kode program Percobaan `try-catch`

    public class TryCatch {
    
    public void untukTryCatch(int a){
        
        try{
            int[] array = {0,1,2,3};
            int index = a;
            System.out.println("index ke"+a+"adalah"+array[index]);
        }catch(Exception e){
            System.out.println("terjadi kesalahan "+ e.getMessage());
        }
    }
    }
Kode program Percobaan `throws`

    public class CobaThrows{

    public void untukThrows(int a) throws Exception {
        int[] array = {0, 1, 2, 3};
        int index = a;
        System.out.println("index ke" + a + "adalah" + array[index]);

    }
    }
Untuk mencoba kode tersebut saya memanggil di satu class kedua excetion tersebut sehingga mengetahui perbedaan secara jelas
   
    public class Utama {

    public static void main(String[] args) throws Exception {

        TryCatch array = new TryCatch();
        System.out.println("Ini try catch");
        array.untukTryCatch(5);

        CobaThrows array2 = new CobaThrows();
        System.out.println("Ini Throws");
        array2.untukThrows(5);

    }
    }
## Kode untuk Costum Exception
pada costum Exception saya menggunakan array sebagai index array tidak diketahui sebagai kasusnya.

    public class CostumEX extends ArrayIndexOutOfBoundsException {

    public CostumEX(String massage) {
        super(massage);
    }
    
    public static int cek(int index) throws CostumEX {
        int[] array = {0, 1, 2, 3};
        if(index > array.length){
            throw new CostumEX("index Array diluar batas ");
        }
        return index;
    }

    public static void main(String[] args) throws CostumEX {
        
        int[] array = {0, 1, 2, 3};
        int index = 5;

        try{
            cek(index);
            System.out.println("index ke "+index+" adalah "+array.length);
        }catch(CostumEX e){
            System.out.println(""+ e.getMessage());
        }
    }
    }

Itu penjelasan mengenai perbedaan `throws` , `try-catch` dan costum exception.
dan juga pengunaan CRUD dengan Java
semoga bermanfaat 😊
