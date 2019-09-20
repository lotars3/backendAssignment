package pl.szymonsmenda.backendAssignment.models.repositiories.audit;

import org.springframework.stereotype.Repository;
import pl.szymonsmenda.backendAssignment.models.entites.NoteHistory;

import java.util.List;

@Repository
public interface INotesHistoryRepository {

    List<NoteHistory> listNotesHistoryAudit(long id);
}
