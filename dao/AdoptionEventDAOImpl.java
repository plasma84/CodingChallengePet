package dao;

import entity.model.AdoptionEvent;
import util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdoptionEventDAOImpl implements AdoptionEventDAO {
    private static final String DB_PROPERTIES_FILE = "db.properties";

    @Override
    public void addEvent(AdoptionEvent event) throws Exception {
        String query = "INSERT INTO adoption_events (event_name, event_date) VALUES (?, ?)";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, event.getEventName());
            stmt.setDate(2, Date.valueOf(event.getEventDate()));
            stmt.executeUpdate();
        }
    }

    @Override
    public List<AdoptionEvent> listEvents() throws Exception {
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
        }
        return events;
    }

    @Override
    public void registerParticipant(int eventId, String participantName) throws Exception {
        String query = "INSERT INTO participants (event_id, participant_name) VALUES (?, ?)";
        try (Connection conn = DBConnUtil.getConnection(DB_PROPERTIES_FILE);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, eventId);
            stmt.setString(2, participantName);
            stmt.executeUpdate();
        }
    }
}