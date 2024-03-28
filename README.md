DBConnection dosyasına giderek kendi MySQL veri tabanınızın bilgilerini giriniz.
Veri tabanınızda bulunması gereken table isimleri ve columnlar:
admin: adminName(varchar, primary key) , adminPassword(varchar)
customers: customerID(int, primary key, unique) , customerName(varchar) , email(varchar, unique) , password(varchar)
employees: empID(int, primary key, unique) , empName(varchar) , empPassword(varchar)
rooms: RoomID(int, primary key, unique) , RoomType(varchar) , Price(double) , Status(varchar)
