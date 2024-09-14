## Deskripsi
Tugas ini adalah implementasi dari proyek Pemrograman Berbasis Objek (PBO) keempat yang bertujuan untuk mengelola database menggunakan operasi CRUD (Create, Read, Update, Delete) dengan menggunakan Java dan basis data PostgreSQL.
Untuk mengimplementasikan operasi CRUD (Create, Read, Update, Delete) saya menggunakan database perhotelan dengan tabel tamu. Pada program ini kita bisa menampilkan data tamu, menambahkan data tamu, menghapus data tamu dan juga mengupdate data tamu.
Di program ini juga terdapat penugasan untuk membedakan antara  penggunaan **Exception** Throws dan Try Catch, disini saya membuat class keduanya dan menggunakan kasus jumlah index array untuk menggetahui output exception keduanya.

## Perbedaan Antara `throws` dan `try-catch`

Dalam pemrograman Java, penanganan pengecualian adalah mekanisme penting untuk mengelola kesalahan yang terjadi selama eksekusi program. Dua konsep utama dalam penanganan pengecualian adalah `throws` dan `try-catch`. Berikut adalah perbedaan signifikan antara keduanya:

- **`throws`**: 
  - **Deklarasi Metode**: `throws` digunakan dalam deklarasi metode untuk menginformasikan bahwa metode tersebut mungkin melemparkan pengecualian. Ini memberi tahu pemanggil metode bahwa mereka perlu menangani atau meneruskan pengecualian tersebut.
  - **Contoh**:
    ```java
    public void readFile(String fileName) throws IOException {
        // Metode ini dapat melempar IOException
    }
    ```

- **`try-catch`**:
  - **Penanganan Pengecualian**: `try-catch` digunakan untuk menangani pengecualian secara langsung di dalam blok kode. Kode di dalam blok `try` adalah yang mungkin melemparkan pengecualian, dan blok `catch` menangani pengecualian yang terjadi.
  - **Contoh**:
    ```java
    try {
        // Kode yang mungkin melemparkan pengecualian
        readFile("example.txt");
    } catch (IOException e) {
        // Penanganan pengecualian
        System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
    }
    ```
Dengan memahami perbedaan ini, Anda dapat memutuskan kapan harus menggunakan `throws` untuk mendeklarasikan pengecualian dan kapan harus menggunakan `try-catch` untuk menangani pengecualian di dalam kode Anda.

Semoga Hal tersebut dapat membantu anda 
