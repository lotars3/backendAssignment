package pl.szymonsmenda.backendAssignment.models.entites;

import lombok.Data;
import org.hibernate.envers.RevisionType;
@Data
public class NotesHistory {

    private final NotesEntity notesEntity;
    private final Number revision;
    private final RevisionType revisionType;
}
