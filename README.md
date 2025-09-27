# Spring Boot Astrapay My Simple Note Application
Berikut adalah Simple Note Application untuk Spring Boot yang telah dilakukan pengembangan,
sesuai dengan konvensi yang digunakan pada Astrapay.

## Author Information:  
- **Daniel Buala Kristo Zalukhu**

## Requirements
- **Java 11**

## 🚀 Cara Menjalankan Aplikasi 
- mvn spring-boot:run **atau**
- Klik kanan pada class **AstrapayBaseExternal** → Run
  
## 📌 Notes API Documentation
**Base URL**
http://localhost:8080/api/notes

## 📖 Endpoints
### Get All Notes
* Endpoint  : **GET** - **/api/notes**
* Deskripsi : Untuk menampilkan seluruh catatan yang tercatat dalam memori internal sistem yang di urutkan 
berdarkan ID dari yang terakhir.

**Response**
    
![Screenshot 2025-09-27 at 16.08.57.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_BKMgLM%2FScreenshot%202025-09-27%20at%2016.08.57.png)

### Create New Note
* Endpoint  : **POST** - **/api/notes**
* Deskripsi : Menambahkan catatan baru

**Request**

![Screenshot 2025-09-27 at 16.15.14.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_ZmDl8x%2FScreenshot%202025-09-27%20at%2016.15.14.png)

**Response (Sukses)**

![Screenshot 2025-09-27 at 16.16.06.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_QlR019%2FScreenshot%202025-09-27%20at%2016.16.06.png)

**Response (Validasi Error)**

![Screenshot 2025-09-27 at 16.16.47.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_n0yhJ7%2FScreenshot%202025-09-27%20at%2016.16.47.png)
![Screenshot 2025-09-27 at 16.16.29.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_EU7wkT%2FScreenshot%202025-09-27%20at%2016.16.29.png)
![Screenshot 2025-09-27 at 16.26.20.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_peGB2h%2FScreenshot%202025-09-27%20at%2016.26.20.png)
![Screenshot 2025-09-27 at 16.26.57.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_XusmNh%2FScreenshot%202025-09-27%20at%2016.26.57.png)

### Delete Note by Id
* Endpoint  : **DELETE** - **/api/notes/{id}**
* Deskripsi : Menghapus catatan berdasarkan ID

**Response (Sukses): 204 No Content**

![Screenshot 2025-09-27 at 16.31.49.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_7w97oz%2FScreenshot%202025-09-27%20at%2016.31.49.png)

**Response (Data tidak ditemukan): 404 Not Found**

![Screenshot 2025-09-27 at 16.32.10.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fh6%2F366ffd5n6379c070fdn9l81m0000gp%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_uF3wg6%2FScreenshot%202025-09-27%20at%2016.32.10.png)

## ⚠️ Error Handling
Semua error ditangani dengan Global Exception Handler (NoteAdvice):
1. 400 Bad Request → Validasi DTO gagal (@NotEmpty).
2. 404 Not Found → Note tidak ditemukan (NoteNotFoundException).
3. 500 Internal Server Error → Error umum / tak terduga.