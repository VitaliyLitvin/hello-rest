[![Build Status](https://travis-ci.org/VitaliyLitvin/hello-rest.svg?branch=master)](https://travis-ci.org/VitaliyLitvin/hello-rest)

Для запуска приложения необходимо выполнить следующие действия:

1. Установить и настроить PostgreSQL server. 
2. Создать базу данных:
 - Открыть PgAdmin.
 - В разделе [Object browser] выбрать сервер.
 - Нажать правой кнопкой мыши на пункт [Databases] и выбрать [New Database].
 - Заполнить поле [name] и нажимать кнопку [Ok].
3. Скачать проект с приложением с репозитория.
3. В файле application.properties указать параметры для подключения к БД:
 - spring.datasource.url - Путь к базе дынных(jdbc:postgresql://[IP-adress]:[PORT]/[название созданной БД])
 - spring.datasource.username - Имя пользователя для БД
 - spring.datasource.password - Пароль для пользователя
4. Cобрать проект:
 - открыть командную строку и перейти в какталог проекта
 - выполнить [mvn package]. 
 - файл для запуска приложения будет собран в папке [target], название файла [hello-rest-1.0-SNAPSHOT.jar]. 
5. Запустить приложение 
 - открыть командную строку и перейти в какталог с файлом [hello-rest-1.0-SNAPSHOT.jar].
 - выполнить [java -jar hello-rest-1.0-SNAPSHOT.jar].


