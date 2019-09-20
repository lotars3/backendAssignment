package pl.szymonsmenda.backendAssignment.models.services;

import pl.szymonsmenda.backendAssignment.models.entites.NoteEntity;

import java.util.Optional;

public interface INotesService {

    Optional<NoteEntity> findById(long id);

    Iterable<NoteEntity> getAllNotes();

    void saveNotes(NoteEntity noteEntity);

    void removeNoteById(long id);

    boolean existsById(long id);
}