package pl.szymonsmenda.backendAssignment.models.audit;

import lombok.Data;

import javax.persistence.*;

import org.hibernate.envers.RevisionEntity;

import javax.persistence.Entity;

@Entity
@RevisionEntity
@Data
@Table(name = "revinfo")
public class RevInfoEntity extends NotesAudEntity {
}
