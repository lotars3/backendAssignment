package pl.szymonsmenda.backendAssignment.models.repositiories.audit;

import org.springframework.stereotype.Repository;
import pl.szymonsmenda.backendAssignment.models.entites.NotesHistory;

import java.util.List;

@Repository
public interface INotesHistoryRepository {

    List<NotesHistory> listNotesHistoryAudit(Long id);


}
