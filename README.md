# AutomatizationDiplomaProject
___
### CI/CD

[<img align="right" src="https://user-images.githubusercontent.com/47859608/125795732-5a2bbcf6-7144-4902-92b2-1ee7ada306ef.jpg"/>](https://ci.appveyor.com/project/DoroshenkoDenis/automatizationdiplomaproject/branch/master)

[![Build status](https://ci.appveyor.com/api/projects/status/kur6hbmt73uwwlcs/branch/master?svg=true)](https://ci.appveyor.com/project/DoroshenkoDenis/automatizationdiplomaproject/branch/master)      [![Gradle Package](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml/badge.svg)](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml)

___
[Tasks](https://github.com/netology-code/qa-diploma)

[Test Plan](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/blob/master/Docs/TestPlan.md)

[Test summary reports](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/blob/master/Docs/Report.md)

[Test automation reporting]()
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
___
## Test Summaries
* [Gradle Test Summary](https://automatization-diploma-project-reports.vercel.app/)
* [Allure Test Summary](https://automatization-diploma-project-allure-test-summary.vercel.app/)
