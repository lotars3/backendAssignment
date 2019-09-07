package pl.szymonsmenda.backendAssignment.models.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RevisionTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "notes")
@Audited
public class NotesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String content;


    @Column(name = "create_date", nullable = false, updatable = false)
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    private Date createDate;
    @Column(name = "last_modified_date", nullable = false)
    @Temporal( TemporalType.TIMESTAMP )
    @UpdateTimestamp
    private Date  lastModifiedDate;
}
