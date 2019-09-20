package pl.szymonsmenda.backendAssignment.models.repositiories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;

@Repository
public interface NotesRepository extends CrudRepository<NoteEntity, Long> {

}
