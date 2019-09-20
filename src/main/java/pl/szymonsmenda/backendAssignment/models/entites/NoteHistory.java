package pl.szymonsmenda.backendAssignment.models.entites;

import lombok.Data;
import org.hibernate.envers.RevisionType;

@Data
public class NoteHistory {

    private final NoteEntity noteEntity;
    private final Number revision;
    private final RevisionType revisionType;
}
