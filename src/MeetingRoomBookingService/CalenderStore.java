package MeetingRoomBookingService;

import DesignPatterns.VisitorDesignPattern.InterfaceElement.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalenderStore {
    public final Map<Integer, User> users = new HashMap<>();
    public final Map<Integer, MeetingRoom> rooms = new HashMap<>();
    public final Map<Integer, List<Meeting>> roomMeetings = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void addRoom(MeetingRoom room) {
        rooms.put(room.getMeetingRoomId(), room);
        roomMeetings.put(room.getMeetingRoomId(), new ArrayList<>());
    }

    public List<Meeting> getMeetingsForRoom(String roomId) {
        return roomMeetings.getOrDefault(roomId, new ArrayList<>());
    }

    public void saveMeeting(Meeting meeting) {
        MeetingRoom room = meeting.getRoom();
        roomMeetings.get(meeting.getRoom().getMeetingRoomId()).add(meeting);
    }
}
