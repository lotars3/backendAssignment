package pl.szymonsmenda.backendAssignment.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.repositiories.audit.INotesHistoryRepository;
import pl.szymonsmenda.backendAssignment.models.repositiories.audit.NotesHistoryRepository;
import pl.szymonsmenda.backendAssignment.models.services.HistoryService;


@RestController
@RequestMapping("history")
public class NotesHistoryRestController {

    @Autowired
    private NotesHistoryRepository historyRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity notesHistoryById(@PathVariable("id") long id) {
        historyRepository.listNotesHistoryAudit(id);
        return ResponseEntity.ok().build();
    }

}
