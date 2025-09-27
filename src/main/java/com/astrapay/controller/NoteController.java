package com.astrapay.controller;

import com.astrapay.entity.Note;
import com.astrapay.dto.NoteDto;
import com.astrapay.utils.LogUtils;
import com.astrapay.service.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "NoteController")
@Slf4j

@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Retrieve all notes
     */
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK", response = NoteDto.class)
            }
    )
    public ResponseEntity<Note[]> getNotes() {
        LogUtils.logInfo("start","get all notes");
        Note[] notes = noteService.getAllNotes();
        LogUtils.logInfo("end",  "retrieve notes: " + Arrays.toString(notes));
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    /*
     * Create a new noteDao
     *
     * @param note request body object for new noteDao
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@Valid @RequestBody NoteDto noteDto){
        LogUtils.logInfo("start","post new note");
        Note myNote = noteService.addNote(noteDto);
        LogUtils.logInfo("end", "new note: " + myNote);
        return new ResponseEntity<>(myNote, HttpStatus.OK);
    }

    /*
     * Delete note by id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Integer id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}