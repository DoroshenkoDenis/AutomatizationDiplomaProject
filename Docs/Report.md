# Отчет по итогам автоматизированного тестирования

 Протестирована работа комплексного сервиса, взаимодействующего с двумя СУБД и API Банка согласно [тест-плану]().
___
### Тестируемые базы данных:
* MySQL - успешно
* PostgreSQL - успешно

Реализованные тест-кейсы проходят одинаково независимо от базы данных
___
### Реализованных тест-кейсов: 41

* Успешно пройденных: 34 (82.92%)
* Пройденных с ошибкой: 7 (17.08%)
___
### [Issue](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues) заведено: 9

* 6 багов
    * [Неправильное название заголовка страницы](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/8)
    * [Отсутствует предупреждение об ошибке, при заполнении поля "Владелец" некорректными данными](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/7)
    * [Неверное уведомление при покупке в кредит картой со статусом "DECLINED"](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/4)
    * [Отсутствует предупреждение при вводе CVC кода "000"](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/3)
    * [Не записывается в нужное поле в базе данных информация credit_id](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/2)
    * [Неверное уведомление при дебетовой покупке картой со статусом "DECLINED"](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/1)
* 3 замечания
    * [Ложное двойное уведомление, при оплате картой, не входящей в набор тестовых](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/9)
    * [Неправильное поведение уведомления об ошибке после исправления](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/6)
    * [Ложное сообщение об ошибке в поле "Владелец" при пустом поле CVC](https://github.com/DoroshenkoDenis/AutomatizationDiplomaProject/issues/5)
___
Test Summaries:
* [Gradle Test Summary](https://automatization-diploma-project-reports.vercel.app/)
* [Allure Test Summary](https://automatization-diploma-project-allure-test-summary.vercel.app/)
___
### Рекомендации
* Реализовать валидацию поля "Владелец" согласно шаблону "NAME SURNAME"  
  Ввести подсказку "Укажите имя как на карте"  
  Реализовать преобразование строчных букв в заглавные  
* Реализовать валидацию номера карты: для вычисления правильности ввода номера использовать [«Алгоритм Луна»](https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%9B%D1%83%D0%BD%D0%B0)
