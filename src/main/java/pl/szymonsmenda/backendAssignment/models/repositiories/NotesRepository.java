package pl.szymonsmenda.backendAssignment.models.repositiories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.backendAssignment.models.entites.NotesEntity;

@Repository
public interface NotesRepository extends CrudRepository<NotesEntity, Long> {

}
