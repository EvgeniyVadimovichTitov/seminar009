package com.example.HomeworkSem006.repositories;

import com.example.HomeworkSem006.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IRepisitory extends JpaRepository<Note, Long> {

    public Optional<Note> findById(Long id);
}
