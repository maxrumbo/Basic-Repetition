# Soal Basic Repetition (Loop) untuk Flowgorithm

Dokumen ini berisi rangkaian soal latihan tentang pengulangan (repetition/loop) untuk diimplementasikan menggunakan Flowgorithm.

Tujuan: melatih pembuatan flowchart dengan struktur loop (For, While, Do-While), penggunaan variabel penentu loop, agregasi (sum, count), dan operasi sederhana pada setiap iterasi.

Petunjuk umum:
- Gunakan bentuk loop yang paling sesuai (For, While, atau Do-While) di Flowgorithm.
- Tuliskan juga pseudocode singkat sebelum membuat flowchart.
- Sediakan beberapa kasus uji untuk memverifikasi program.

Format soal:
- Judul soal
- Deskripsi singkat
- Input
- Output
- Contoh
- Hint (petunjuk untuk Flowgorithm)
- Solusi singkat (pseudocode) — untuk pembelajaran

---

## Soal 1 — Jumlah Bilangan 1..N (Mudah)
Deskripsi: Hitung jumlah semua bilangan bulat dari 1 sampai N.

Input: satu bilangan bulat positif N
Output: satu bilangan (jumlah dari 1 sampai N)

Contoh:
- Input: N = 5
- Output: 15

Hint:
- Gunakan loop For dari i = 1 sampai N.
- Gunakan variabel `sum` inisialisasi 0.

Solusi (pseudocode):
1. Baca N
2. sum = 0
3. For i = 1 to N: sum = sum + i
4. Tampilkan sum

---

## Soal 2 — Faktorial (Sedang)
Deskripsi: Hitung faktorial N (N!).

Input: satu bilangan bulat N (N >= 0)
Output: hasil faktorial (jika N besar, gunakan tipe data yang cukup)

Contoh:
- Input: N = 5
- Output: 120

Hint:
- Gunakan loop For dari i = 1 sampai N (atau While).
- Inisialisasi result = 1.
- Jika N = 0, hasil = 1.

Solusi (pseudocode):
1. Baca N
2. result = 1
3. For i = 1 to N: result = result * i
4. Tampilkan result

---

## Soal 3 — Deret Ganjil sampai N (Mudah)
Deskripsi: Tampilkan semua bilangan ganjil dari 1 sampai N.

Input: satu bilangan bulat N
Output: deretan bilangan ganjil (dipisah spasi atau baris baru)

Contoh:
- Input: N = 10
- Output: 1 3 5 7 9

Hint:
- Loop For dengan langkah 2 (i = 1; i <= N; i = i + 2) atau gunakan if i%2==1.

Solusi (pseudocode):
1. Baca N
2. For i = 1 to N step 2: Tampilkan i

---

## Soal 4 — Jumlah Bilangan Genap dan Ganjil (Sedang)
Deskripsi: Dari N bilangan yang dimasukkan pengguna, hitung dan tampilkan jumlah total bilangan genap dan jumlah total bilangan ganjil.

Input: N (jumlah bilangan), lalu N bilangan bulat (satu per baris)
Output: dua angka: sum_genap dan sum_ganjil

Contoh:
- Input: N=5, bilangan: 2 7 4 1 6
- Output: sum_genap=12 (2+4+6), sum_ganjil=8 (7+1)

Hint:
- Gunakan loop For atau While untuk membaca N bilangan.
- Gunakan modul (%) untuk cek genap/ganjil.

Solusi (pseudocode):
1. Baca N
2. sum_genap = 0; sum_ganjil = 0
3. For i = 1 to N: Baca x; if x % 2 == 0 then sum_genap += x else sum_ganjil += x
4. Tampilkan sum_genap, sum_ganjil

---

## Soal 5 — Rata-Rata Nilai (Sedang)
Deskripsi: Hitung rata-rata dari N nilai (float/double diterima) yang dimasukkan.

Input: N (jumlah nilai), lalu N nilai (angka)
Output: rata-rata dengan 2 desimal

Contoh:
- Input: N=4, nilai: 7.5 8.0 6.0 9.5
- Output: 7.75

Hint:
- Gunakan `sum` dan `count` lalu rata = sum / N.
- Pastikan pembagian menggunakan tipe desimal.

Solusi (pseudocode):
1. Baca N
2. sum = 0
3. For i = 1 to N: Baca v; sum += v
4. avg = sum / N
5. Tampilkan avg

---

## Soal 6 — Cari Maksimum dan Minimum (Sedang)
Deskripsi: Dari N bilangan input, temukan nilai maksimum dan minimum.

Input: N, lalu N bilangan
Output: nilai maksimum dan minimum

Contoh:
- Input: N=6, bilangan: 4 9 1 3 7 2
- Output: max=9, min=1

Hint:
- Inisialisasi max dengan nilai sangat kecil atau pakai angka pertama sebagai awal.

Solusi (pseudocode):
1. Baca N
2. Baca x pertama; max = x; min = x
3. For i = 2 to N: Baca x; if x > max then max = x; if x < min then min = x
4. Tampilkan max, min

---

## Soal 7 — Deret Fibonacci (Sedang)
Deskripsi: Tampilkan deret Fibonacci sampai N elemen.

Input: N (jumlah elemen deret, N >= 1)
Output: N bilangan Fibonacci (misal: 0 1 1 2 3 ...)

Contoh:
- Input: N=7
- Output: 0 1 1 2 3 5 8

Hint:
- Gunakan dua variabel prev dan curr, lalu update dalam loop.

Solusi (pseudocode):
1. Baca N
2. Jika N >= 1 tampilkan 0
3. Jika N >= 2 tampilkan 1
4. prev=0; curr=1
5. For i = 3 to N: next = prev + curr; tampilkan next; prev = curr; curr = next

---

## Soal 8 — Jumlah Digit (Mudah-Sedang)
Deskripsi: Hitung jumlah digit dari sebuah bilangan bulat positif (misal 1234 -> 4).

Input: satu bilangan bulat positif X
Output: satu bilangan (jumlah digit)

Contoh:
- Input: X = 2025
- Output: 4

Hint:
- Bisa gunakan loop While: while X > 0: X = X // 10; count++
- Pastikan menangani X = 0 (jumlah digit = 1).

Solusi (pseudocode):
1. Baca X
2. Jika X == 0 maka tampilkan 1
3. count = 0
4. While X > 0: X = X / 10 (integer); count++
5. Tampilkan count

---

## Soal 9 — Bilangan Prima dari 1 sampai N (Sukar)
Deskripsi: Tampilkan semua bilangan prima dari 1 sampai N.

Input: N
Output: daftar bilangan prima <= N

Contoh:
- Input: N = 10
- Output: 2 3 5 7

Hint:
- Gunakan loop luar untuk k dari 2 sampai N dan loop dalam untuk cek pembagi dari 2 sampai sqrt(k) (atau sampai k-1 untuk pendekatan sederhana).
- Optimasi kecil: jika ada pembagi, tandai bukan prima.

Solusi (pseudocode, versi sederhana):
1. Baca N
2. For k = 2 to N: isPrime = true; for d = 2 to k-1: if k % d == 0: isPrime = false; break; if isPrime tampilkan k

---

## Soal 10 — Hitung Frekuensi Digit (Sukar)
Deskripsi: Dari suatu bilangan positif X, hitung berapa kali setiap digit (0-9) muncul.

Input: satu bilangan bulat positif X
Output: frekuensi untuk digit 0 sampai 9 (format bebas, bisa tiap baris atau satu baris)

Contoh:
- Input: X = 112203
- Output:
  - 0:1
  - 1:2
  - 2:2
  - 3:1
  - 4:0 ... dan seterusnya

Hint:
- Inisialisasi array freq[0..9] = 0
- Loop: while X > 0: d = X % 10; freq[d]++; X = X // 10

Solusi (pseudocode):
1. Baca X
2. Inisialisasi freq[0..9] = 0
3. Jika X == 0 maka freq[0] = 1
4. While X > 0: d = X % 10; freq[d]++; X = X / 10
5. Tampilkan freq

---

## Bonus: Panduan singkat membuat Flowgorithm untuk soal
- Mulai dari simbol Start.
- Gunakan simbol Input/Output untuk membaca dan menampilkan nilai.
- Gunakan simbol Assignment untuk inisialisasi variabel (sum = 0, i = 1, dll.).
- Untuk loop, pakai simbol Loop (while/for) di Flowgorithm dan pastikan kondisi diperbarui bila memakai While.
- Gunakan simbol If untuk cabang (contoh: cek genap/ganjil).
- Akhiri dengan simbol End.

---

## Kriteria penilaian singkat
- Flowchart benar dan terminasi benar (tidak infinite loop).
- Hasil sesuai contoh kasus uji minimal 3 kasus.
- Penggunaan struktur loop yang logis.

---

Jika Anda ingin, saya dapat menambahkan:
- File .fprg (Flowgorithm) contoh untuk 2-3 soal.
- Soal tambahan dengan variasi (nested loop, pola bintang, dll.).

Selamat berlatih!
