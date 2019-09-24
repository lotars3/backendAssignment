package pl.szymonsmenda.backendAssignment.models.audit;

import lombok.Data;
import org.hibernate.envers.RevisionType;

@Data
public class AuditResult<T> {

    private final T entity;
    private final NoteAudEntity revision;
    private final RevisionType type;
}
