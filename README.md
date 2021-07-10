# AutomatizationDiplomaProject
![CICDSecurity](https://user-images.githubusercontent.com/47859608/123905410-58482b80-d983-11eb-9af7-a21b30b6cde3.jpg)

[![Build status](https://ci.appveyor.com/api/projects/status/kur6hbmt73uwwlcs/branch/master?svg=true)](https://ci.appveyor.com/project/DoroshenkoDenis/automatizationdiplomaproject/branch/master)   :octocat:   [![Gradle Package](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml/badge.svg)](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/actions/workflows/gradle-publish.yml)



[Test Plan](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/blob/master/TestPlan.md)
___
По умолчанию подключается MySQL.  
Для работы с PostgreSQL:
* перезапустить SUT `java -jar aqa-shop/aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app`
* запустить тесты, используя PostgreSQL `gradlew clean test -Ddatasourse.url=postgresql.url -Dusername=app -Dpassword=pass`
___
