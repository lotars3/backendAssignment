package pl.szymonsmenda.backendAssignment.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.entites.NotesEntity;
import pl.szymonsmenda.backendAssignment.models.services.NotesService;

@RequestMapping("rest")
@RestController
public class NotesRestController {

    @Autowired
    private NotesService notesService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity allNotes() {
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    @PostMapping(value = "/notes", consumes = "application/json")
    public ResponseEntity addNotes(@RequestBody NotesEntity notesEntity){
        notesService.saveNotes(notesEntity);
        return ResponseEntity.ok(notesEntity);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity deleteNotes(@PathVariable("id") int id){
        notesService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/notes", consumes = "application/json")
    public ResponseEntity updateNotes(@RequestBody NotesEntity notesEntity){
        notesService.saveNotes(notesEntity);
        return ResponseEntity.ok(notesEntity);
    }
}
