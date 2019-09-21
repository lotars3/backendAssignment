package pl.szymonsmenda.backendAssignment.models.services;

import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;

import java.util.List;
import java.util.Optional;

public interface INotesService {

    List<NoteEntity> getAllNotes();


    Optional<NoteEntity> findById(long id);

    void saveNotes(NoteEntity noteEntity);

    void removeNoteById(long id);

    boolean existsById(long id);
}