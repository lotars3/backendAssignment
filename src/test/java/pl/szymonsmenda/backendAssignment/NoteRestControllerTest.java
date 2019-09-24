package pl.szymonsmenda.backendAssignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import pl.szymonsmenda.backendAssignment.models.entity.NoteEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendAssignmentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoteRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void testGetAllNote() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/rest/all",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testGetNoteById() {
        NoteEntity note = restTemplate.getForObject(getRootUrl() + "/rest/note/5", NoteEntity.class);
        assertNotNull(note);
    }

    @Test
    public void testCreateNote() {
        NoteEntity note = new NoteEntity();
        note.setId(1L);
        note.setContent("test");
        note.setTitle("Testyyy");
        ResponseEntity<NoteEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/rest/addNote/", note, NoteEntity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }


    @Test
    public void testUpdatedNote() {
        int id = 1;
        NoteEntity note = restTemplate.getForObject(getRootUrl() + "/rest/updateNote/" + id, NoteEntity.class);
        note.setContent("test");
        note.setTitle("Testyyy");
        restTemplate.put(getRootUrl() + "/rest/update/" + id, note);
        NoteEntity updatedNote = restTemplate.getForObject(getRootUrl() + "/rest/updateNote/" + id, NoteEntity.class);
        assertNotNull(updatedNote);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        NoteEntity note = restTemplate.getForObject(getRootUrl() + "/rest/updateNote/" + id, NoteEntity.class);
        assertNotNull(note);
        restTemplate.delete(getRootUrl() + "/rest/remove/" + id);
        try {
            note = restTemplate.getForObject(getRootUrl() + "/rest/remove/" + id, NoteEntity.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}