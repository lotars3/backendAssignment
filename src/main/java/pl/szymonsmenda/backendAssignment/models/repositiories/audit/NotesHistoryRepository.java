package pl.szymonsmenda.backendAssignment.models.repositiories.audit;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.szymonsmenda.backendAssignment.models.audit.AuditQueryResult;
import pl.szymonsmenda.backendAssignment.models.audit.AuditQueryUtils;
import pl.szymonsmenda.backendAssignment.models.entites.NotesEntity;
import pl.szymonsmenda.backendAssignment.models.entites.NotesHistory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NotesHistoryRepository implements INotesHistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<NotesHistory> listNotesHistoryAudit(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(NotesEntity.class, false, true)
                .add(AuditEntity.id().eq(id));

        return AuditQueryUtils.getAuditQueryResults(auditQuery, NotesEntity.class).stream()
                // Turn into the CustomerHistory Domain Object:
                .map(x -> getCustomerHistory(x))
                // And collect the Results:
                .collect(Collectors.toList());
    }

    private static NotesHistory getCustomerHistory(AuditQueryResult<NotesEntity> auditQueryResult) {
        return new NotesHistory(
                auditQueryResult.getEntity(),
                auditQueryResult.getRevision().getRevisionNumber(),
                auditQueryResult.getType()
        );
    }
}

