###Приложение выполняет сохранение полученного сообщения об ошибке в базу данных и файл лога

### Приложение реализует Restfull API:
При формировании 'POST' запроса к endpoint '/log', c requestContent, содержащим необходимую информацию о сообщении, запись добавляется в БД и в файл лога.
Настройка подключения к БД и путь к файлу выполняется в application.yml

При формировании 'GET' запроса к endpoint '/log', возвращается список всех записей, сохраненных в БД.
