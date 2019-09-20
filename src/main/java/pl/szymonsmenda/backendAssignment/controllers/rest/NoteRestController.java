package pl.szymonsmenda.backendAssignment.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.ResourceNotFoundException;
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

    @GetMapping(value = "/note/{id}", produces = "application/json")
    public ResponseEntity<NoteEntity> getNoteById(@PathVariable("id") long id) throws ResourceNotFoundException {
        return notesService.findById(id)
                .map(s -> ResponseEntity.ok(s))
                .orElseThrow(() -> new ResourceNotFoundException("Not found id: " + id));
    }

    @PostMapping(value = "/addNote/{id}", consumes = "application/json")
    public ResponseEntity addNotes(@RequestBody NoteEntity noteEntity,
                                   @PathVariable("id") long id) throws ResourceNotFoundException {
        if (noteEntity.getTitle() == null || noteEntity.getContent() == null) {
            throw new ResourceNotFoundException("Title or Content is required");
        } else if (notesService.findById(id).isPresent()) {
            throw new ResourceNotFoundException(" This id is already in database: " + id);
        }
        notesService.saveNotes(noteEntity);
        return ResponseEntity.status(HttpStatus.OK).body("Post successfully");
    }

    @PutMapping(value = "/updateNote/{id}", consumes = "application/json")
    public ResponseEntity updateNotes(@RequestBody NoteEntity noteEntity,
                                      @PathVariable("id") long id) throws ResourceNotFoundException {
        if (noteEntity.getTitle() == null || noteEntity.getContent() == null) {
            throw new ResourceNotFoundException("Title or Content is required");
        } else if (!notesService.existsById(id)) {
            throw new ResourceNotFoundException("Not found id: " + id);
        }
        notesService.saveNotes(noteEntity);
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
    }

    @DeleteMapping(value = "/remove/{id}", produces = "application/json")
    public ResponseEntity removeById(@PathVariable("id") long id) throws ResourceNotFoundException {
        if (!notesService.existsById(id)) {
            throw new ResourceNotFoundException("Not found id: " + id);
        }
        notesService.removeNoteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }
}