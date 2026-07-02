package com.example.kafkaeda;

public class StudentEvent {
    private int id;
    private String studentName;
    private String eventType;
    private String message;

    public StudentEvent() {
    }

    public StudentEvent(int id, String studentName, String eventType, String message) {
        this.id = id;
        this.studentName = studentName;
        this.eventType = eventType;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "StudentEvent{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                
                ", eventType='" + eventType + '\'' +

                ", message='" + message + '\'' +

                '}';
    }
}