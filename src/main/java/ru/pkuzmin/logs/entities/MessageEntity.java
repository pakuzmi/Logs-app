
package ru.pkuzmin.logs.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "message_tbl")
public class MessageEntity {

    @Id
    @Column(name = "msg_id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "msg_text")
    private String message;

    @Column(name = "msg_type")
    private String type;

    @Column(name = "msg_level")
    private String level;

    @Column(name = "msg_timestamp")
    private Long time;

    public MessageEntity() { }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", message=" + message +
                ", type=" + type +
                ", level=" + level +
                ", timestamp=" + time ;
    }
}

