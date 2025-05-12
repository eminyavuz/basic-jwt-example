# Basic JWT Example

Bu proje, Spring Boot kullanılarak geliştirilmiş temel bir JWT (JSON Web Token) tabanlı kimlik doğrulama sistemidir. Kullanıcılar giriş yaptıktan sonra token alabilir ve bu token ile korunan API endpoint'lerine erişebilir.

## 🔧 Kullanılan Teknolojiler

- Java 17  
- Spring Boot  
- Spring Security  
- JWT (JSON Web Token)  
- MySQL  
- Maven  

## 🚀 Projenin Amacı

JWT tabanlı kimlik doğrulama sisteminin nasıl kurulacağını ve kullanılacağını göstermek. Bu proje:

- Kullanıcı kaydı ve girişi sağlar  
- Girişte JWT token üretir  
- Token ile kimlik doğrulaması yapar  

> **Not:** Rol bazlı yetkilendirme (ROLE_USER, ROLE_ADMIN gibi) bu sürümde henüz uygulanmamıştır. İlerleyen sürümlerde eklenecektir.

## ⚙️ Veritabanı Konfigürasyonu (MySQL)

Proje, MySQL veritabanı ile çalışmaktadır. Aşağıdaki ayarları `src/main/resources/application.properties` dosyasında güncelleyin:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_example_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

MySQL'de `jwt_example_db` adında bir veritabanı oluşturduğunuzdan emin olun:

```sql
CREATE DATABASE jwt_example_db;
```

## 📁 Proje Yapısı

```
src/
├── main/
│   ├── java/com/example/jwtexample/
│   │   ├── controller/    # API endpoint'leri
│   │   ├── model/         # Entity ve DTO sınıfları
│   │   ├── repository/    # JPA Repository'ler
│   │   ├── security/      # JWT filtreleri ve konfigürasyon
│   │   └── service/       # Kullanıcı işlemleri
│   └── resources/
│       └── application.properties
```

## 🛠️ Uygulamanın Çalıştırılması

1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/eminyavuz/basic-jwt-example.git
   cd basic-jwt-example
   ```

2. Gerekli veritabanını oluşturun ve `application.properties` dosyasını düzenleyin.

3. Uygulamayı çalıştırın:
   ```bash
   mvn spring-boot:run
   ```

Uygulama `http://localhost:8080` adresinde yayına alınır.

## 🔐 API Kullanımı

### 1. Kullanıcı Kaydı

**POST** `/api/auth/register`

```json
{
  "username": "testuser",
  "password": "123456"
}
```

### 2. Giriş Yap (Token Al)

**POST** `/api/auth/login`

```json
{
  "username": "testuser",
  "password": "123456"
}
```

Dönen JWT token ile API'lere erişim sağlanabilir:

```
Authorization: Bearer <token>
```

### 3. Korunan Endpoint

**GET** `/api/hello`  
→ Sadece doğrulanmış token ile erişilebilir.

## 📄 Lisans

MIT License
