package pl.szymonsmenda.backendAssignment.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.backendAssignment.models.entites.NotesEntity;
import pl.szymonsmenda.backendAssignment.models.repositiories.NotesRepository;

@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;

    public  Iterable<NotesEntity> getAllNotes(){
        return notesRepository.findAll();
    }

    public void saveNotes(NotesEntity notesEntity){
        notesRepository.save(notesEntity);
    }

    public void deleteNoteById(int id){
        notesRepository.deleteById(id);
    }

}
