package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class NoteController {

  @Autowired
  NoteRepository noteRepository;

  // Get all notes
  @GetMapping("/notes")
  // in full: @RequestMapping(value="/notes", method=RequestMethod.GET).
  public List<Note> getAllNotes() {
    return noteRepository.findAll();
  }

  // Create a new note
  @PostMapping("/notes")
  public Note creaNote(@Valid @RequestBody Note note) {
    // @Valid makes sure the request body is valid
    // @RequestBody binds the request body within the method parameter
    return noteRepository.save(note);
  }

  // Get a single note
  @GetMapping("/notes/{id}")
  public Note getNoteById(@PathVariable(value = "id") Long noteId) {
    // @PathVariable binds a path variable with a method parameter
    return noteRepository.findById(noteId)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
  }

  // Update a note
  @PutMapping("/notes/{id}")
  public Note updateNote(@PathVariable(value="id") Long noteId, @Valid @RequestBody Note noteDetails) {
    //TODO: process PUT request
    Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    note.setTitle(noteDetails.getTitle());
    note.setContent(noteDetails.getContent());
    
    Note updatedNote = noteRepository.save(note);
    return updatedNote;
  }

  // Delete a note
  @DeleteMapping("/notes/{id}")
  public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
    Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    noteRepository.delete(note);

    return ResponseEntity.ok().build();
  }
}
