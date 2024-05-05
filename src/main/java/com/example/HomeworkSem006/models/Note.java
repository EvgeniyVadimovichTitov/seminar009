package com.example.HomeworkSem006.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

//Структура заметки:
//        - ID (автоинкрементное)(тип - Long)
//        - Заголовок (не может быть пустым)(тип - String)
//        - Содержимое (не может быть пустым)(тип - String)
//        - Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)
//

@Entity
@Data
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="header_note", nullable = false, length = 50)
    private String header;

    @Column(name = "body_note", nullable = false)
    private String body;

    @Column(name = "dt_created")
    private LocalDateTime created = LocalDateTime.now();

}
