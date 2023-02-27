package resource.scheduledevent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import resource.AbstractResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduledEvent extends AbstractResource {
    private boolean active;
    private long interval;
    private String occursAt;
    private boolean periodic;
    private String topic;

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public long getInterval() {
        return interval;
    }
    public void setInterval(long interval) {
        this.interval = interval;
    }
    public String getOccursAt() {
        return occursAt;
    }
    public void setOccursAt(String occursAt) {
        this.occursAt = occursAt;
    }
    public boolean isPeriodic() {
        return periodic;
    }
    public void setPeriodic(boolean periodic) {
        this.periodic = periodic;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getSimpleName() {
        return getName().substring(getName().lastIndexOf(".") + 1);
    }

    public String getPackageName() {
        return getName().substring(0, getName().lastIndexOf("."));
    }
}
