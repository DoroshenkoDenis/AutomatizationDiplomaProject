# AutomatizationDiplomaProject

![CICDSecurity](https://user-images.githubusercontent.com/47859608/123905410-58482b80-d983-11eb-9af7-a21b30b6cde3.jpg)

[![Build status](https://ci.appveyor.com/api/projects/status/kur6hbmt73uwwlcs/branch/master?svg=true)](https://ci.appveyor.com/project/DoroshenkoDenis/automatizationdiplomaproject/branch/master)   :octocat:   [![Gradle Package](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml/badge.svg)](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml)

___
[Задание на дипломную работу профессии «Тестировщик»](https://github.com/netology-code/qa-diploma)
___

[Test Plan](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/blob/master/TestPlan.md)
___

## Процедура запуска авто-тестов

### Перед запуском тестов необходимо установить окружение:

* [AdoptOpenJDK 11.0.11+9](https://adoptopenjdk.net/index.html)
* [Docker Desktop](https://www.docker.com/products/docker-desktop)

### Запуск:

* Скачать код проекта с [репозитория](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject)
* Запустить Docker Desktop
* Открыть терминал в папке с проектом
* Выполнить  
  `docker-compose up -d`
* Запустить SUT aqa-shop.jar командой  
  `java -jar aqa-shop/aqa-shop.jar &`
* Запустить авто тесты командой  
  `./gradlew clean test --info -Dselenide.headless=true`

### Отчёты Allure:
* Создать отчёты Allure и открыть в браузере   
  `./gradlew allureReport allureServe`

### По умолчанию подключается MySQL

### Для работы с PostgreSQL:

* перезапустить SUT  
  `java -jar aqa-shop/aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app &`
* запустить тесты, используя PostgreSQL  
  `./gradlew clean test -Ddatasourse.url=postgresql.url -Dusername=app -Dpassword=pass`
___

