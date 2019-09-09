package pl.szymonsmenda.backendAssignment.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.backendAssignment.models.entites.NotesEntity;
import pl.szymonsmenda.backendAssignment.models.repositiories.NotesRepository;

@Service
public class NotesService {
    @Autowired
    private NotesRepository NotesRepository;

    public Iterable<NotesEntity> getAllNotes() {
        return NotesRepository.findAll();
    }

    public void saveNotes(NotesEntity notesEntity) {
        NotesRepository.save(notesEntity);
    }

    public void deleteNoteById(long id) {
        NotesRepository.deleteById(id);
    }

}
