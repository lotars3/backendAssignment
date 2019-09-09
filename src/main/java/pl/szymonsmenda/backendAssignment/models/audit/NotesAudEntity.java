package pl.szymonsmenda.backendAssignment.models.audit;

import lombok.Data;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class NotesAudEntity {
    @Id
    @RevisionNumber
    @GeneratedValue
    @Column(name = "rev")
    private int revisionNumber;

    @RevisionTimestamp
    @Column(name = "revtstmp")
    private long revisionTimestamp;

    @Transient
    public Date getRevisionDate() {
        return new Date(this.revisionTimestamp);
    }

}
