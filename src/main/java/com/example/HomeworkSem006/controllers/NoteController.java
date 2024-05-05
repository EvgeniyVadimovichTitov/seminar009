package com.example.HomeworkSem006.controllers;


import com.example.HomeworkSem006.models.Note;
import com.example.HomeworkSem006.servises.NoteServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Все методы контроллера возвращают ResponseEntity(как на семинаре)
//        1. Добавление заметки. (Подсказка @PostMapping )
//        2. Просмотр всех заметок.(Подсказка @GetMapping )
//        3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
//        4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
//        5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
//

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteServise sev;

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return new ResponseEntity<>(sev.addNote(note), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAll(){
        return new ResponseEntity<>(sev.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Note> findById(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(sev.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note updNote){
        return new ResponseEntity<>(sev.updateNote(updNote), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delNote(@PathVariable(name="id") Long id){
        sev.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
