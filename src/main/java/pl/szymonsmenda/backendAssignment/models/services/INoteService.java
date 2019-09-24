package pl.szymonsmenda.backendAssignment.models.services;

import pl.szymonsmenda.backendAssignment.models.entity.NoteEntity;

import java.util.List;
import java.util.Optional;

public interface INoteService {

    List<NoteEntity> getAllNote();

    Optional<NoteEntity> findNoteById(long id);

    void saveNotes(NoteEntity noteEntity);

    void removeNoteById(long id);

    boolean existsById(long id);
}