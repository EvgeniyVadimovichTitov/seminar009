package com.example.HomeworkSem006.servises;

import com.example.HomeworkSem006.aspect.log;
import com.example.HomeworkSem006.models.Note;
import com.example.HomeworkSem006.repositories.IRepisitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//Все методы контроллера возвращают ResponseEntity(как на семинаре)
//        1. Добавление заметки. (Подсказка @PostMapping )
//        2. Просмотр всех заметок.(Подсказка @GetMapping )
//        3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
//        4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
//        5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
//

@Service
@RequiredArgsConstructor
public class NoteServise {

    private final IRepisitory rep;

    @log
    public Note addNote(Note noteNew){
        return rep.save(noteNew);
    }


    public List<Note> findAll(){
        return rep.findAll();
    }

    @log
    public Note findById(Long id){
        return rep.findById(id).orElseThrow(null);
    }

    @log
    public Note updateNote(Note note){
        Note noteFind = findById(note.getId());

        noteFind.setBody(note.getBody());
        noteFind.setHeader(note.getHeader());

        return rep.save(noteFind);
    }

    @log
    public void deleteById(Long id){
        rep.delete(findById(id));
    }
}
