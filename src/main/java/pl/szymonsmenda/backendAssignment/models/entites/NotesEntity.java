package pl.szymonsmenda.backendAssignment.models.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "notes")
public class NotesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
}
