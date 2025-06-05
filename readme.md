# 🛒 Magnesium
Magnesium — это интернет-магазин продуктов питания, вдохновлённый известной сетью Magnum в Казахстане. Проект был создан как учебный, с полноценной архитектурой и разделением на фронтенд и бэкенд.

# 📌 О проекте
Этот проект — результат командной работы, в которой я выступал лидером и занимался разработкой всего full stack-кода. Остальные участники команды (2 человека) помогали в поиске багов и добавляли отдельные архитектурные файлы.

Magnesium позволяет пользователям:

просматривать каталог продуктов;

видеть наличие и стоимость товаров;

оформлять онлайн-заказы;

оплачивать заказы онлайн (имитация).

# 🧠 Технологии
🔧 Backend (Java + Spring Boot)
Архитектура построена с чётким разделением по слоям:

src/
├── config
├── controllers
├── dto
├── entity
├── exception
├── mapper
├── observer
├── repository
└── service
REST-контроллеры

Обработка исключений

DTO и мапперы

Хранение данных в PostgreSQL

Тестирование API с помощью Postman

# 🎨 Frontend
HTML, CSS, JavaScript

Thymeleaf — для динамических шаблонов

Bootstrap — для адаптивной вёрстки

# 💼 Возможности
Регистрация и авторизация пользователей

Поддержка корзины и оформления заказов

Хранение данных пользователей (в т.ч. хешированных паролей)

Интеграция с базой данных PostgreSQL

Визуальный интерфейс с адаптивной вёрсткой

# ✅ Проверка и тестирование
Ручное тестирование с использованием Postman

Проверка архитектурной целостности и логики API

Логирование ошибок и откликов

# 👥 Команда
👨‍💻 Я — full-stack разработка, архитектура, логика, интеграции

👨‍🔧 Участники (2 чел.) — багрепорты, внесение изменений в архитектурные слои

# 🚀 Запуск проекта
Клонируйте репозиторий:
git clone https://github.com/Dan5365/Magnesium.git
Настройте базу данных PostgreSQL и обновите application.properties

Запустите Spring Boot приложение

Откройте в браузере http://localhost:8080

# 🧪 Как использовать Postman для CRUD и входа
Для тестирования API использовался Postman. Ниже приведены основные действия:

🔐 Вход (Login)
POST /api/auth/login

В теле запроса:

{
  "email": "admin", 
  "password": "admin123"
}
Ответ: токен авторизации (если реализован JWT)
Чтобы изменить фиксированные парамерты email или password, редактируйте файл SecurityConfig

## 📋 CRUD-операции
📍 Создание (Create)
POST http://localhost:8080/api/products
{
  "name": "Milk",
  "price": 500,
  "quantity": 10
}
📖 Чтение (Read)
GET http://localhost:8080/api/products

GET http://localhost:8080/api/products{id}

✏️ Обновление (Update)
PUT http://localhost:8080/api/products/{id}

{
  "name": "Updated Milk",
  "price": 550,
  "quantity": 15
}
🗑️ Удаление (Delete)
DELETE http://localhost:8080/api/products/[id}

Убедитесь, что вы авторизованы, если API требует токен.

Вход как User или Admin
![image](https://github.com/user-attachments/assets/ac1ff378-d09e-4f01-821b-c1390fb793aa)
![image](https://github.com/user-attachments/assets/1d884598-e00d-4da8-ae9f-9ead80c22187)

Добавление продукта:
![image](https://github.com/user-attachments/assets/a16475cd-3d92-4b69-8ff1-afe23f39425c)

![image](https://github.com/user-attachments/assets/dcdea2c4-2aef-492a-9f7e-ec03839fa078)

“Учебный проект. Все логотипы и изображения принадлежат их владельцам и используются исключительно в образовательных целях.” 





