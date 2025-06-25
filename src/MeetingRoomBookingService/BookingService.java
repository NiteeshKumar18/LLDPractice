package MeetingRoomBookingService;

import DesignPatterns.VisitorDesignPattern.InterfaceElement.Room;

import java.util.Date;
import java.util.List;

public class BookingService {
    private CalenderStore calenderStore;

    public BookingService(CalenderStore calenderStore) {
        this.calenderStore = calenderStore;
    }

    public boolean bookMeetingRoom(String title, String organizerId, String roomId,
                                   Date start, Date end,
                                   List<User> attendees) {
        User user = calenderStore.users.get(organizerId);
        MeetingRoom room = calenderStore.rooms.get(roomId);
        if (room == null || user == null) {
            return false;
        }

        List<Meeting> allMeetings = calenderStore.roomMeetings.get(roomId);
        Meeting meeting = new Meeting(attendees, room, new Date(), new Date(), user);
        boolean overlapFound = false;
        for (Meeting o : allMeetings) {
            if (meeting.meetingOverlaps(o)) {
                overlapFound = true;
                break;
            }
        }
        if (overlapFound) {
            return false;
        }

        calenderStore.saveMeeting(meeting);
        return true;
    }
}
