package pl.szymonsmenda.backendAssignment.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.Dto.Converters;
import pl.szymonsmenda.backendAssignment.models.Dto.NotesHistoryDto;
import pl.szymonsmenda.backendAssignment.models.entites.NotesHistory;
import pl.szymonsmenda.backendAssignment.models.repositiories.audit.INotesHistoryRepository;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("history")
public class NotesHistoryRestController {

    private  final INotesHistoryRepository repository;
    @Autowired
    public NotesHistoryRestController(INotesHistoryRepository repository) {
        this.repository = repository;
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public List<NotesHistoryDto> getHistory(@PathVariable("id") Long id) {
        // Get History:
        List<NotesHistory> history = repository.listNotesHistoryAudit(id);

        // Return the DTO List:
        return history.stream()
                .map(Converters::convert)
                .collect(Collectors.toList());
    }

}
