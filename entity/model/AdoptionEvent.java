package entity.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdoptionEvent {
    private int eventId;
    private String eventName;
    private LocalDate eventDate;
    private List<IAdoptable> participants;

    // Constructor with arguments
    public AdoptionEvent(int eventId, String eventName, LocalDate eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.participants = new ArrayList<>();
    }

    // Constructor with String and LocalDate arguments
    public AdoptionEvent(String eventName, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    // Constructor without arguments
    public AdoptionEvent() {
        this.participants = new ArrayList<>();
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    // Register a participant
    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
    }

    // Host the adoption event
    public void hostEvent() {
        System.out.println("Hosting adoption event...");
        for (IAdoptable participant : participants) {
            participant.adopt();
        }
    }

    @Override
    public String toString() {
        return "AdoptionEvent{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}