package pl.szymonsmenda.backendAssignment.models.repositiories;

import org.springframework.stereotype.Repository;
import pl.szymonsmenda.backendAssignment.models.entity.NoteHistory;

import java.util.List;

@Repository
public interface INoteHistoryRepository {

    List<NoteHistory> listNoteHistoryAudit(long id);
}
