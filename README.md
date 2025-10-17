# Soal Cerita Tunggal — Analisis Tinggi (3 contoh + pembagian poin 30/30/40)

Di sebuah kota kecil, terdapat program bantuan pangan "PanganPeduli" yang menerima sumbangan dari rumah tangga. Setiap kali relawan mencatat sumbangan, mereka mencatat tiga informasi: ID rumah tangga (string tanpa spasi), jumlah item yang disumbangkan (integer), dan tipe item (kata, mis. "rice", "beans"). Catatan terkadang berisi kesalahan (jumlah tidak valid atau bukan angka). Di akhir hari, koordinator meminta laporan ringkas yang dihasilkan oleh program Flowgorithm:

- total item yang valid dikumpulkan,
- jumlah rumah tangga unik yang menyumbang (hanya hitung entri valid),
- jumlah item per tipe,
- daftar rumah tangga yang menyumbang lebih dari threshold tertentu (mis. > T item),
- rumah tangga penyumbang terbanyak (bisa lebih dari satu jika tie),
- jumlah entri tidak valid.

Buat program yang membaca N baris catatan dan menghasilkan ringkasan lengkap seperti yang diminta koordinator. Anda harus membuat asumsi yang wajar jika ada ambiguitas 

Format input yang diasumsikan:
Baris pertama: N (jumlah catatan)
Baris berikutnya (N baris): <ID> <Jumlah> <Tipe>
Contoh entri: H001 3 rice

Kriteria penilaian: tugas ini dinilai berdasarkan tiga level keluaran untuk setiap contoh tes berikut:
- Level A (30 poin): keluaran minimal yang benar (total item valid).
- Level B (30 poin): keluaran yang lebih lengkap termasuk per-tipe dan jumlah rumah tangga unik serta invalid_count.
- Level C (40 poin): keluaran lengkap termasuk daftar penyumbang >T (T diasumsikan 3 jika tidak disebut), top donor(s) dan penanganan tie; validasi lebih kuat.

Tentukan juga: jika jumlah atau tipe tidak valid, abaikan catatan tersebut dan tambahkan ke counter invalid_count. Jika semua catatan tidak valid, laporkan "Tidak ada data valid" pada Level C.

---

Contoh 1 (kasus normal, tidak ada invalid):

Input:
5
H001 3 rice
H002 2 rice
H001 1 beans
H003 5 rice
H004 4 beans

Expected output - Level A (30p):
Total items = 15

Expected output - Level B (30p):
Total items = 15
Distinct households = 4
Items per type: rice=10 beans=5
invalid_count = 0

Expected output - Level C (40p):
Total items = 15
Distinct households = 4
Items per type: rice=10 beans=5
Households with >3 items: H003(5) H004(4)
Top donor(s): H003 (5)
invalid_count = 0

---

Contoh 2 (mengandung invalid dan tie top donor):

Input:
7
A1 2 rice
A2 -1 beans
A3 3 rice
A2 3 beans
A4 3 rice
A5 abc beans
A6 3 rice

Penjelasan: entry A2 -1 dan A5 abc dianggap invalid dan diabaikan.

Expected output - Level A (30p):
Total items = 14

Expected output - Level B (30p):
Total items = 14
Distinct households = 5
Items per type: rice=11 beans=3
invalid_count = 2

Expected output - Level C (40p):
Total items = 14
Distinct households = 5
Items per type: rice=11 beans=3
Households with >3 items: (none)
Top donor(s): A3 A2 A4 A6 (each 3)
invalid_count = 2

---

Contoh 3 (kasus tepi: banyak nilai nol/semua nol/invalid):

Input:
4
X1 0 rice
X2 0 beans
X3 -5 rice
X4 abc rice

Penjelasan: X3 dan X4 invalid; X1/X2 valid dengan jumlah 0.

Expected output - Level A (30p):
Total items = 0

Expected output - Level B (30p):
Total items = 0
Distinct households = 2
Items per type: rice=0 beans=0
invalid_count = 2

Expected output - Level C (40p):
Tidak ada data valid
invalid_count = 2

---

Petunjuk implementasi singkat untuk Flowgorithm :
- Baca N.
- Inisialisasi total=0, map/type->count, map/ID->sum, invalid_count=0.
- Untuk i = 1..N: baca ID, rawJumlah, tipe; coba parse jumlah sebagai integer dan pastikan >=0; jika invalid maka invalid_count++ dan continue; tambahkan ke total, update map tipe, update map ID.
- Setelah loop: jika Level A maka cukup tampilkan total; Level B tampilkan total + distinct households + items per type + invalid_count; Level C tampilkan laporan penuh: jika tidak ada data valid tampil "Tidak ada data valid", selain itu tampilkan daftar households >T (T=3 default) dan top donor(s) (cari max dari map ID), serta invalid_count.

