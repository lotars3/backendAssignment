package pl.szymonsmenda.backendAssignment.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.backendAssignment.models.ResourceNotFoundException;
import pl.szymonsmenda.backendAssignment.models.services.ConvertService;
import pl.szymonsmenda.backendAssignment.models.dto.NoteHistoryDto;
import pl.szymonsmenda.backendAssignment.models.entity.NoteHistory;
import pl.szymonsmenda.backendAssignment.models.repositiories.INoteHistoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("history")
public class NoteHistoryRestController {

    @Autowired
    private INoteHistoryRepository repository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<NoteHistoryDto> getHistory(@PathVariable("id") long id) throws ResourceNotFoundException {
        List<NoteHistory> history = repository.listNoteHistoryAudit(id);
        if (history.isEmpty()) {
            throw new ResourceNotFoundException("Empty history");
        }
        return history.stream()
                .map(ConvertService::convert)
                .collect(Collectors.toList());
    }
}
