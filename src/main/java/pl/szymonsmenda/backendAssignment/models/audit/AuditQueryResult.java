package pl.szymonsmenda.backendAssignment.models.audit;

import lombok.Data;
import org.hibernate.envers.RevisionType;

@Data
public class AuditQueryResult<T> {

    private final T entity;
    private final NotesAudEntity revision;
    private final RevisionType type;


}
