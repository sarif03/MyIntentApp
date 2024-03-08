# latihan Intent Aplikasi

### Projek ini dibuat agar dapat memahami penggunaan dari Intent.


### Project Aplikasi ini akan menjawab beberapa pertanyaan umum :
  - Bagaimana berpindah dari satu Activity ke Activity lain?
  - Bagaimana berpindah dari satu Activity ke Activity lain dengan membawa data?
    - Single value dari suatu variabel.
    - Objek model dengan menggunakan Parcelable.
  - Menjalankan komponen di aplikasi lain untuk keperluan membuka browser atau melakukan pemanggilan melalui aplikasi telepon bawaan?
  - Mengirimkan hasil nilai balik melalui Intent.
<br>

## 🔖 Berikut alur yang akan kita pelajari dalam latihan ini 🔖:  

  - Berpindah antar Activity menggunakan Explicit Intent.✅
  - Mengirim data pada Intent menggunakan putExtra.✅
  - Mengirim banyak data pada Intent menggunakan Parcelable.✅
  - Berpindah antar aplikasi menggunakan Implicit Intent.✅
  - Mendapatkan hasil dari Activity tujuan menggunakan registerForActivityResult.✅

ScreenShoot:<br>
<img src="https://github.com/sarif03/MyIntentApp/blob/main/Screenshot_Home_after.png?raw=true" width="300">
<img src="https://github.com/sarif03/MyIntentApp/blob/main/Screenshot_intent%20dial%20Number.png?raw=true" width="300">


## 📚 Penjelasan Singkat 📚
Intent adalah mekanisme untuk melakukan sebuah action dan komunikasi antar komponen aplikasi misal Activity, Service, dan Broadcast Receiver.

### 3 Penggunaan umum Intent:
- Pindah antar Activity dgn atau tidak membawa data✅( telah diterapkan )
- menjalankan Backgroud Service, misal melakukan sinkronisasi ke server dan menjalankan proses berulang.❔
- mengirimkan objek broadcast ke aplikasi yg membutuhkan.❔

### Intent memiliki 2 Bentuk yaitu:
- <b>Explicit Intent<b> : yaitu tipe intent yg digunakan untuk menjalankan komponen lain dengan tujuan yang sudah jelas(eksplisit). umumnya digunakan untuk berpindah antar Activity

  contoh :<br>
<img src="https://github.com/sarif03/MyIntentApp/blob/main/screenshoot_Intent%20Implicit.png?raw=true" width="600">

- Implicit Intent : digunakan untuk menjalankan komponen lain dengan tujuan yang belum jelas. biasana digunakan untuk aksi berpindah ke aplikasi lain. misal membuka maps,camera, atau foto. dan jika ada leebih dari satu aplikasi yg dapat menangani hal tersebut, opsi aplikasi akan muncul.<br>

  contoh : <br>
<img src="https://github.com/sarif03/MyIntentApp/blob/main/Screenshot_%20intetn_%20eksplicit.png?raw=true" width="200"> <br>




Fungsi putExtra(key, value) digunakan untuk menambahkan data di dalam Intent dengan bentuk key-value.<br>

Fungsi intent.getFooExtra(key) digunakan untuk mengambil data berdasarkan key. Dengan “Foo” adalah tipe data dari dari data yang dikirim.<br>

Parcelable adalah suatu interface yang memungkinkan kita melakukan pengiriman satu objek sekaligus di dalam Intent.<br>

Parcelize adalah plugin yang dapat digunakan untuk membuat implementasi Parcelable secara otomatis.<br>
tambahkan ini terlebih dahulu pada gradle.kts(module:app) jika ingin memakai Parcelize :
```
plugin {
    id("kotlin-parcelize")
}
```
<br>
Fungsi registerForActivityResult digunakan untuk menerima data yang dikirimkan oleh setResult dari Activity lain. Fungsi ini mengembalikan objek ActivityResultLauncher yang digunakan untuk menjalankan Activity lain.

