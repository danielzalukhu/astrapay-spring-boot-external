package com.astrapay.service;

import com.astrapay.dto.NoteDto;
import com.astrapay.entity.Note;
import com.astrapay.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;


@Service
@Slf4j
public class NoteServiceImpl implements NoteService {
    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /*
     * Mocking data
    @PostConstruct
    public void initMockData() {
        noteRepository.add(new Note(1, "Do math home work", "Do math home work before 30 September 2025", LocalDateTime.of(2025, 9, 1, 10, 30)));
        noteRepository.add(new Note(2, "Clean my bedroom", "Clean all the stuffs at my bedroom every morning!", LocalDateTime.of(2025, 9, 5, 8, 0)));
    }
    */

    @Override
    public Note[] getAllNotes() {
        return noteRepository.getAll();
    }

    @Override
    public Note addNote(NoteDto dto) {
        Note note = new Note(null, dto.getTitle(), dto.getContent(), LocalDateTime.now());
        return noteRepository.add(note);
    }

    @Override
    public void deleteNote(Integer id) {
        noteRepository.deleteById(id);
    }
}