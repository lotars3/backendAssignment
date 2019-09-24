package pl.szymonsmenda.backendAssignment.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.ResourceNotFoundException;
import pl.szymonsmenda.backendAssignment.models.entity.NoteEntity;
import pl.szymonsmenda.backendAssignment.models.services.NoteService;

import java.util.List;

@RestController
@RequestMapping("rest")
public class NoteRestController {

    @Autowired
    private NoteService noteService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<NoteEntity>> allNotes() {
        return ResponseEntity.ok(noteService.getAllNote());
    }

    @GetMapping(value = "/note/{id}", produces = "application/json")
    public ResponseEntity<NoteEntity> getNoteById(@PathVariable("id") long id) throws ResourceNotFoundException {
        return noteService.findNoteById(id)
                .map(s -> ResponseEntity.ok(s))
                .orElseThrow(() -> new ResourceNotFoundException("Not found ID: " + id));
    }

    @PostMapping(value = "/addNote/{id}", consumes = "application/json")
    public ResponseEntity addNote(@RequestBody NoteEntity noteEntity,
                                  @PathVariable("id") long id) throws ResourceNotFoundException {
        if (noteEntity.getTitle() == null || noteEntity.getContent() == null) {
            throw new ResourceNotFoundException("Title or Content is required");
        } else if (noteService.findNoteById(id).isPresent()) {
            throw new ResourceNotFoundException("This ID is already in database: " + id);
        }
        noteService.saveNotes(noteEntity);
        return ResponseEntity.status(HttpStatus.OK).body("Post successfully");
    }

    @PutMapping(value = "/updateNote/{id}", consumes = "application/json")
    public ResponseEntity updateNote(@RequestBody NoteEntity noteEntity,
                                     @PathVariable("id") long id) throws ResourceNotFoundException {
        if (noteEntity.getTitle() == null || noteEntity.getContent() == null) {
            throw new ResourceNotFoundException("Title or Content is required");
        } else if (!noteService.existsById(id)) {
            throw new ResourceNotFoundException("Not found ID to update: " + id);
        }
        noteService.saveNotes(noteEntity);
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
    }

    @DeleteMapping(value = "/remove/{id}", produces = "application/json")
    public ResponseEntity removeNoteById(@PathVariable("id") long id) throws ResourceNotFoundException {
        if (!noteService.existsById(id)) {
            throw new ResourceNotFoundException("Not found ID: " + id);
        }
        noteService.removeNoteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }
}