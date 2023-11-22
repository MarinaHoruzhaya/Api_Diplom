<h1 >Проект по автоматизации тестирования API сервиса <a href="https://reqres.in/"> Reqres</a></h1>
<a href="https://reqres.in/"><img  src="media/screens/Reqresin.png">

# :man_student:: Содержание:

- <a href="#checking"> Реализованные проверки</a>
- <a href="#jenkins"> Сборка в Jenkins</a>
- <a href="#console"> Запуск тестов </a>
- <a href="#allureReport"> Allure отчет</a>
- <a href="#allure"> Интеграция с Allure TestOps</a>
- <a href="#tg"> Уведомления в Telegram с использованием бота</a>

<a id="tools"></a>
## 🧰: Стек используемых технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://rest-assured.io/"><img src="media/logo/RestAssured.png" width="50" height="50"  alt="Rest-Assured"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://https://qameta.io/"><img src="media/logo/AllureTestOps.svg" width="50" height="50"  alt="AllureTestOps"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://https://telegram.org/"><img src="media/logo/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

<a id="checking"></a>
## :male_detective:: Реализованные проверки

- ✓ Проверка имени, фамилии и ID пользователя
- ✓ Проверка данных пользователя в списке пользователей
- ✓ Создание нового пользователя
- ✓ Обновление данных пользователя
- ✓ Удаление пользователя

<a id="jenkins"></a>
## <img src="media/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Сборка в <a target="_blank" href="https://jenkins.autotests.cloud/job/api-diplom-Horuzhaya/"> Jenkins </a>    
<p align="center">
<a href=""><img src="media/screens/Jenkins.png" alt="Jenkins1"/></a>
</p>
После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.


## Пример авто-тест кейса
<p align="center">
<img title="AllureSuite" src="media/screens/Test-case.png">
</p>

<a id="console"></a>
## :rocket:: Запуск тестов из терминала
Команда запуска тестов:
```
gradle clean test
```


<a id="allureReport"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure.svg"> </a> Пример <a target="_blank" href="https://jenkins.autotests.cloud/job/api-diplom-Horuzhaya/7/allure/"> Allure-отчета </a>
## Основной отчет

<p align="center">
<img title="Allure Overview" src="media/screens/AllureReport.png">
</p>

<a id="allure"></a>
## <img src="media/logo/AllureTestOps.svg" width="25" height="25"  alt="Allure_TO"/></a> Интеграция с  <a target="_blank" href="https://allure.autotests.cloud/project/3839/dashboards"> Allure TestOps</a>

## :bar_chart:: Доска
На *Dashboard* в <code>Allure TestOps</code> видна статистика количества тестов. Новые тесты, а так же результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/AllureTestOps.png">
</p>

## Пример тест-кейса
<p align="center">
<img title="AllureTC" src="media/screens/TestCaseAllureTestOps.png">
</p>

##  Запуски
<p align="center">
<img title="Allure Tests" src="media/screens/Launches.png">
</p>

<a id="tg"></a>
## <img src="media/logo/Telegram.svg" width="25" height="25"  alt="Telegram"/></a> Уведомления в телеграм с использованием бота
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="telegram" src="media/screens/TelegramBot.png">
</p>
