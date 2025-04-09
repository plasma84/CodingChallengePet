package dao;

import entity.model.AdoptionEvent;
import exception.AdoptionException;
import java.util.List;

public interface AdoptionEventDAO {
    void addEvent(AdoptionEvent event) throws AdoptionException;
    List<AdoptionEvent> listEvents() throws AdoptionException;
    void registerParticipant(int eventId, String participantName) throws AdoptionException;
}