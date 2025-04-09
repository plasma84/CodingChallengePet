package dao;

import entity.model.AdoptionEvent;
import exception.AdoptionException;
import util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdoptionEventDAOImpl implements AdoptionEventDAO {
    private static final String DB_PROPERTIES_FILE = "db.properties";

    @Override
    public void addEvent(AdoptionEvent event) throws AdoptionException {
        String query = "INSERT INTO adoption_events (event_name, event_date) VALUES (?, ?)";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, event.getEventName());
            stmt.setDate(2, Date.valueOf(event.getEventDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new AdoptionException("Error adding adoption event to the database: " + e.getMessage());
        } catch (Exception e) {
            throw new AdoptionException("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    public List<AdoptionEvent> listEvents() throws AdoptionException {
        List<AdoptionEvent> events = new ArrayList<>();
        String query = "SELECT * FROM adoption_events";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int eventId = rs.getInt("event_id");
                String eventName = rs.getString("event_name");
                Date eventDate = rs.getDate("event_date");
                events.add(new AdoptionEvent(eventId, eventName, eventDate.toLocalDate()));
            }
        } catch (SQLException e) {
            throw new AdoptionException("Error retrieving adoption events from the database: " + e.getMessage());
        } catch (Exception e) {
            throw new AdoptionException("Unexpected error: " + e.getMessage());
        }
        return events;
    }

    @Override
    public void registerParticipant(int eventId, String participantName) throws AdoptionException {
        String query = "INSERT INTO participants (event_id, participant_name) VALUES (?, ?)";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, eventId);
            stmt.setString(2, participantName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new AdoptionException("Error registering participant for the adoption event: " + e.getMessage());
        } catch (Exception e) {
            throw new AdoptionException("Unexpected error: " + e.getMessage());
        }
    }
}