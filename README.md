##Тестовое приложение выполняющее сохранение полученного сообщения об ошибке в БД и текстовый файл

### Приложение реализует Restfull API:
При формировании 'POST' запроса к endpoint '/log', c requestContent, содержащим необходимую информацию о сообщении, запись добавляется в БД и в файл лога.
Настройка подключения к БД и путь к фалу выполнятеся в application.yml

При формировании 'GET' запроса к endpoint '/log', возвращается список всех записей, сохраненных в БД.