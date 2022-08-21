package ru.pkuzmin.logs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pkuzmin.logs.entities.MessageEntity;

@Repository
public interface LogsRepository extends JpaRepository<MessageEntity,Integer> {
}
