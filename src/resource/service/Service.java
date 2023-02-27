package resource.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import resource.AbstractResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Service extends AbstractResource {
    private String description;
    private int replicationFactor;
    private boolean active;
    private String globalType;
    private Map<String, ServiceEventType> eventTypes;

    public boolean isActive() {
        return active;
    }

    public String getGlobalType() {
        return globalType;
    }

    public void setGlobalType(String globalType) {
        this.globalType = globalType;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, ServiceEventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(Map<String, ServiceEventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public String getSimpleName() {
        return getName().substring(getName().lastIndexOf(".") + 1);
    }

    public String getPackageName() {
        return getName().substring(0, getName().lastIndexOf("."));
    }

    public List<ServiceEventType> getInbounds() {
        eventTypes.entrySet().stream().forEach(map -> map.getValue().setName(map.getKey()));
        return eventTypes.entrySet().stream()
                .filter(map -> map.getValue().getDirection().equals("INBOUND"))
                .map(map -> map.getValue())
                .collect(Collectors.toList());
    }

    public List<ServiceEventType> getOutbounds() {
        eventTypes.entrySet().stream().forEach(map -> map.getValue().setName(map.getKey()));
        return eventTypes.entrySet().stream()
                .filter(map -> map.getValue().getDirection().equals("OUTBOUND"))
                .map(map -> map.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int getReplicationFactor() {
        return replicationFactor;
    }

    public void setReplicationFactor(int replicationFactor) {
        this.replicationFactor = replicationFactor;
    }

}
