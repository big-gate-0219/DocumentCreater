package resource.source;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import resource.AbstractResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Source extends AbstractResource{
    private String activationConstraint;
    private boolean active;
    private String messageType;
    private String name;
    private String type;
    private SourceConfig config;

    public String getActivationConstraint() {
        return activationConstraint;
    }

    public void setActivationConstraint(String activationConstraint) {
        this.activationConstraint = activationConstraint;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SourceConfig getConfig() {
        return config;
    }

    public void setConfig(SourceConfig config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
