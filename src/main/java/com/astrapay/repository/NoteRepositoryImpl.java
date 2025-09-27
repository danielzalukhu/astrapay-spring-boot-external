package com.astrapay.repository;

import com.astrapay.entity.Note;
import com.astrapay.exception.NoteNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class NoteRepositoryImpl implements NoteRepository{
    private final List<Note> notes = new ArrayList<>();
    private int counter = 0;

    @Override
    public Note[] getAll() {
        return notes.stream()
                .sorted(Comparator.comparingInt(Note::getId).reversed())
                .toArray(Note[]::new);
    }

    @Override
    public Optional<Note> findById(Integer id) {
        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst();
    }

    @Override
    public Note add(Note noteToAdd) {
        int newId = ++counter;
        Note note = new Note(newId, noteToAdd.getTitle(), noteToAdd.getContent(), noteToAdd.getCreatedAt());
        notes.add(note);

        return note;
    }

    @Override
    public void deleteById(Integer id) {
        Note note = findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note with ID " + id + " not found"));
        notes.remove(note);
    }
}
