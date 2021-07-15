# AutomatizationDiplomaProject
___
## CI/CD
[<img width="175" height="35" src="https://user-images.githubusercontent.com/47859608/125804325-a2f81782-9191-4400-b44b-3575b3cbe5ee.jpg" />](https://ci.appveyor.com/project/DoroshenkoDenis/automatizationdiplomaproject/branch/master)

[![Build status](https://ci.appveyor.com/api/projects/status/kur6hbmt73uwwlcs/branch/master?svg=true)](https://ci.appveyor.com/project/DoroshenkoDenis/automatizationdiplomaproject/branch/master)

[<img width="116" height="89" src="https://user-images.githubusercontent.com/47859608/125807916-bdcaa4bd-6165-4c56-ae3c-90102c961362.png" />](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml)

[![Gradle Package](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml/badge.svg)](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml)
___
## Test Summaries
* [Gradle Test Summary](https://automatization-diploma-project-reports.vercel.app/)
* [Allure Test Summary](https://automatization-diploma-project-allure-test-summary.vercel.app/)
___
## Docs

[Tasks](https://github.com/netology-code/qa-diploma)

[Test Plan](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/blob/master/Docs/TestPlan.md)

[Test summary reports](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/blob/master/Docs/Report.md)

[Test automation reporting](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/blob/master/Docs/Summary.md)
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
  `./gradlew clean test --info`

### Отчёты Allure:
* Создать отчёты Allure и открыть в браузере   
  `./gradlew allureReport allureServe`

### По умолчанию подключается MySQL

### Для работы с PostgreSQL:

* перезапустить SUT  
  `java -jar aqa-shop/aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app &`
* запустить тесты, используя PostgreSQL  
  `./gradlew clean test -DdataBase.url=jdbc:postgresql://localhost:5432/app -Dusername=app -Dpassword=pass --info`
