package MeetingRoomBookingService;

import java.util.concurrent.ThreadLocalRandom;

public class MeetingRoom {

    private int meetingRoomId;
    private String meetingRoomName;

    public MeetingRoom(String meetingRoomName) {
        this.meetingRoomId = ThreadLocalRandom.current().nextInt(10000);
        this.meetingRoomName = meetingRoomName;
    }

    public int getMeetingRoomId() {
        return meetingRoomId;
    }

    public String getMeetingRoomName() {
        return meetingRoomName;
    }

    // --- Setters ---

    public void setMeetingRoomId(int meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public void setMeetingRoomName(String meetingRoomName) {
        this.meetingRoomName = meetingRoomName;
    }
}
