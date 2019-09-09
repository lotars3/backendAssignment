package pl.szymonsmenda.backendAssignment.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.entites.NotesEntity;
import pl.szymonsmenda.backendAssignment.models.services.NotesService;

@RestController
@RequestMapping("rest")
public class NotesRestController {

    @Autowired
    private NotesService notesService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity allNotes() {
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    @GetMapping(value = "/notes/{id}", produces = "application/json")
    public ResponseEntity getNoteById(@PathVariable("id") Long id) {
        return notesService.getOneNote(id)
                .map(s -> ResponseEntity.ok(s))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(value = "/addNotes", consumes = "application/json")
    public ResponseEntity addNotes(@RequestBody NotesEntity notesEntity) {
        if (notesEntity.getTitle() == null || notesEntity.getContent() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Title/Content is required");

        }
        notesService.saveNotes(notesEntity);
        return ResponseEntity.ok(notesEntity);
    }

    @PutMapping(value = "/updateNotes", consumes = "application/json")
    public ResponseEntity updateNotes(@RequestBody NotesEntity notesEntity) {
        if (notesEntity.getTitle() == null || notesEntity.getContent() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Title/Content is required");

        }
        notesService.saveNotes(notesEntity);
        return ResponseEntity.ok(notesEntity);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity deleteNotes(@PathVariable("id") int id) {
        notesService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }


}