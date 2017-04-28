package com.haibei.pojo.lock;

public class Event {
    private Short eventId;

    private String eventName;

    private Short eventType;

    public Short getEventId() {
        return eventId;
    }

    public void setEventId(Short eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

//    public Short getEventType() {
//        return eventType;
//    }
    public String getEventStr() {
        return eventType==null?"":eventType.toString();
    }
//    public void setEventType(Short eventType) {
//        this.eventType = eventType;
//    }
    public void setEventStr(String eventType) {
        this.eventType = Short.parseShort(eventType==null?"0":eventType);
    }
}