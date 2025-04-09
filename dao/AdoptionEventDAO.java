package dao;

import entity.model.AdoptionEvent;
import java.util.List;

public interface AdoptionEventDAO {
    void addEvent(AdoptionEvent event) throws Exception;
    List<AdoptionEvent> listEvents() throws Exception;
    void registerParticipant(int eventId, String participantName) throws Exception;
}