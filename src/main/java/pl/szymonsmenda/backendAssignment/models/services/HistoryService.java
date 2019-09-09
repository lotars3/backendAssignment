package pl.szymonsmenda.backendAssignment.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.backendAssignment.models.entites.NotesHistory;
import pl.szymonsmenda.backendAssignment.models.repositiories.audit.INotesHistoryRepository;

import java.util.List;


@Service
public class HistoryService {

    @Autowired
    private INotesHistoryRepository notesHistoryRepository;

    public List<NotesHistory> getAllHistoryAudit(Long id) {
        return notesHistoryRepository.listNotesHistoryAudit(id);
    }
}
