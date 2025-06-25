package MeetingRoomBookingService;

import DesignPatterns.VisitorDesignPattern.InterfaceElement.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Meeting {

    private int meetingId;
    private Date startTime;
    private Date endTime;
    private User organiser;
    private MeetingRoom room;
    private List<User> participants;

    public Meeting(List<User> participants, MeetingRoom room,Date startTime, Date endTime,User organiser) {
        this.participants = participants;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.organiser = organiser;
        this.meetingId = ThreadLocalRandom.current().nextInt(0, 100);
    }


    // --- Getters ---

    public int getMeetingId() {
        return meetingId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public User getOrganiser() {
        return organiser;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public List<User> getParticipants() {
        return participants;
    }

    // --- Setters ---

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setOrganiser(User organiser) {
        this.organiser = organiser;
    }

    public void setRoom(MeetingRoom room) {
        this.room = room;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }


    public boolean meetingOverlaps(Meeting meeting) {
        return this.startTime.before(meeting.getEndTime()) && meeting.getStartTime().before(this.endTime);
    }
}
