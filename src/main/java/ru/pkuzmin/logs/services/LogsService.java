package ru.pkuzmin.logs.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.pkuzmin.logs.entities.MessageEntity;
import ru.pkuzmin.logs.repositories.LogsRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
public class LogsService {

    private final LogsRepository logsRepository;

    @Value("${appConfig.filePath}")
    private String filePath;

    public LogsService(LogsRepository logsRepository) {//внедрили зависимость через конструктор
        this.logsRepository = logsRepository;
    }

    /**
     * Сохраняет сообщение в БД и записывает текст сообщения в файл
     * @param message объект Соообщение {@link MessageEntity}
     * @throws Exception
     */
    public void save(MessageEntity message) throws Exception {
        logsRepository.save(message);
        Path path = Paths.get(filePath);
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        Files.write(path, (message.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
    }

    /**
     * Возвращает все записи с сообщениями из БД
     * @return список Сообщений {@link MessageEntity}
     */
    public List<MessageEntity> getAll() {
        return logsRepository.findAll();
    }
}
