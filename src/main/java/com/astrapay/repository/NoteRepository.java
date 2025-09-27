package com.astrapay.repository;

import com.astrapay.entity.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteRepository {
    Note[] getAll();

    Optional<Note> findById(Integer id);

    Note add(Note note);

    void deleteById(Integer id);
}
