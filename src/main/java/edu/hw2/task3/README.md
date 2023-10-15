## PopularCommandExecutor

Исполняет команды на удаленном сервере через stable или faulty соединения

#### Схема - https://mm.tt/app/map/2988750588?t=cf90Aku2P0
<br>

```
PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(0), 1);
String command = "ls";

executor.tryExecute(command);

String output = StaticArray.getFirst();
```
<br>

#### Вероятность контролируется controllerOfFaultyProbability:
* если controllerOfFaultyProbability = 1, то это 100% Faulty
* если controllerOfFaultyProbability = 0, то это 100% Stable
  
<br>

  
### Логирование
* логирование записывается в StaticArray
```
private static ArrayList<String> values = new ArrayList<>();
```
