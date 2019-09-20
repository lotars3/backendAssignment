package pl.szymonsmenda.backendAssignment.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;
import pl.szymonsmenda.backendAssignment.models.services.NotesService;

@RestController
@RequestMapping("rest")
public class NoteRestController {

    @Autowired
    private NotesService notesService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity allNotes() {
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    @GetMapping(value = "/notes/{id}", produces = "application/json")
    public ResponseEntity<NoteEntity> getNoteById(@PathVariable("id") Long id) {
        return notesService.getOneNote(id)
                .map(s -> ResponseEntity.ok(s))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(value = "/addNotes", consumes = "application/json")
    public ResponseEntity addNotes(@RequestBody NoteEntity noteEntity) {
        if (noteEntity.getTitle() == null || noteEntity.getContent() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Title/Content is required");
        }
        notesService.saveNotes(noteEntity);
        return ResponseEntity.status(HttpStatus.OK).body("Post successfully");
    }

    @PutMapping(value = "/updateNotes/{id}", consumes = "application/json")
    public ResponseEntity updateNotes(@RequestBody NoteEntity noteEntity,
                                      @PathVariable("id") int id) {
        if (noteEntity.getTitle() == null || noteEntity.getContent() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Title/Content is required");
        }
        notesService.saveNotes(noteEntity);
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
    }

    @DeleteMapping(value = "/remove/{id}", produces = "application/json")
    public ResponseEntity removeById(@PathVariable("id") int id) {
        if (!notesService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Content");
        }
        notesService.removeNoteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }
}