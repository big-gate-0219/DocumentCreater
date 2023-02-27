package resource.collaborationtype;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class FlowPart {
    private String from;
    private String to;

    public FlowPart(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
