package resource.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceEventType {
    private String name;
    private String direction;
    private String description;
    private String implementingResource;
    private String implementingEventPath;
    private String eventSchema;
    private boolean isReliable;

    public String getEventSchema() {
        return eventSchema;
    }

    public void setEventSchema(String eventSchema) {
        this.eventSchema = eventSchema;
    }

    public boolean isReliable() {
        return isReliable;
    }

    public void setReliable(boolean isReliable) {
        this.isReliable = isReliable;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getImplementingResource() {
        return implementingResource;
    }

    public String getImplementingResourcePath() {
        if (this.getImplementingResource().endsWith("/TimeTrigger")) {
            return implementingResource.substring(0, implementingResource.length() - 12);
        }
        return this.implementingResource;
    }

    public void setImplementingResource(String implementingResource) {
        this.implementingResource = implementingResource;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImplementingEventPath() {
        return implementingEventPath;
    }

    public void setImplementingEventPath(String implementingEventPath) {
        this.implementingEventPath = implementingEventPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}