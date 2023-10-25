Самые первые класс и метод при входе, которые попадают в StackTraceElement - класс JUnitStarter и метод main (массив
стека отсортирован в обратном порядке)

<br>
JUnit вызывает метод main() класса JUnitStarter.

* main() - точка входа - запускается самым первым
* Метод main() класса JUnitStarter вызывает метод prepareStreamsAndStart().
* Метод prepareStreamsAndStart() класса JUnitStarter выполняет подготовку к запуску тестов.
* ...
* Метод prepareStreamsAndStart() класса JUnitStarter вызывает метод run() класса JUnitCore.
* Метод run() класса JUnitCore запускает все тесты, которые были указаны в командной строке.

![alt text](https://sun9-31.userapi.com/impg/HIq-9CP5Rfddy7Yal9lZaWoQhDbecwtKGgfWtA/pNf0Pj3JdtI.jpg?size=1179x269&quality=96&sign=baf0cd90af9522847c778d7c019e55c9&type=album)

<br>
Значение StackTraceElement под индексом 0 - самый последний выполненный метод:  

![alt text](https://sun9-38.userapi.com/impg/Fz7IXWPwPORG2P18iJAY6zcQfGPz3Vw-IAWhQA/Lz6poJqZZrI.jpg?size=1163x514&quality=96&sign=244b000dd3751e4dfb19dee8e0985659&type=album)

