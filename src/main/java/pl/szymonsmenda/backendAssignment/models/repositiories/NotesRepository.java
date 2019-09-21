package pl.szymonsmenda.backendAssignment.models.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Long> {

}
