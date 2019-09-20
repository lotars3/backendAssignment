package pl.szymonsmenda.backendAssignment.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.services.Converters;
import pl.szymonsmenda.backendAssignment.models.dto.NoteHistoryDto;
import pl.szymonsmenda.backendAssignment.models.entites.NoteHistory;
import pl.szymonsmenda.backendAssignment.models.repositiories.audit.INotesHistoryRepository;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("history")
public class NoteHistoryRestController {

    private final INotesHistoryRepository repository;

    @Autowired
    public NoteHistoryRestController(INotesHistoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<NoteHistoryDto> getHistory(@PathVariable("id") Long id) {
        List<NoteHistory> history = repository.listNotesHistoryAudit(id);

        return history.stream()
                .map(Converters::convert)
                .collect(Collectors.toList());
    }
}
