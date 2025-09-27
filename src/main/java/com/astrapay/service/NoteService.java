package com.astrapay.service;

import com.astrapay.dto.NoteDto;
import com.astrapay.entity.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    Note[] getAllNotes();

    Note addNote(NoteDto dto);

    void deleteNote(Integer id);
}
