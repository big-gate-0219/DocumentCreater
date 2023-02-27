package resource.collaborationtype;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import resource.AbstractResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollaborationType extends AbstractResource {
    private String description;
    private boolean active;
    private boolean appType;
    private String boundService;
    private Map<String, CollaborationTypeAssembly> assembly;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAppType() {
        return appType;
    }

    public void setAppType(boolean appType) {
        this.appType = appType;
    }

    public String getBoundService() {
        return boundService;
    }

    public void setBoundService(String boundService) {
        this.boundService = boundService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, CollaborationTypeAssembly> getAssembly() {
        return assembly;
    }

    public void setAssembly(Map<String, CollaborationTypeAssembly> assembly) {
        this.assembly = assembly;
    }

    public String getServiceName() {
        return getSimpleName().split("_")[0];
    }

    public String getCollaborationTypeName() {
        return getSimpleName().split("_")[1];
    }

    public String getSimpleName() {
        return getName().substring(getName().lastIndexOf(".") + 1);
    }

    public String getPackageName() {
        return getName().substring(0, getName().lastIndexOf("."));
    }

    public List<FlowPart> getFlowParts() {
        List<FlowPart> flowPartList = new ArrayList<>();

        for (String assemblyName : assembly.keySet()) {
            CollaborationTypeAssembly subAssembly = assembly.get(assemblyName);
            List<String> childStreams = subAssembly.getConfiguration().getChildStreams();
            if (childStreams != null) {
                for (String childActibity : childStreams) {
                    FlowPart part = new FlowPart(assemblyName, childActibity);
                    flowPartList.add(part);
                }
            }
        }
        return flowPartList;
    }

    public List<CollaborationTypeAssembly> getActivities() {
        assembly.entrySet().forEach(map -> map.getValue().setName(map.getKey()));
        return assembly.entrySet().stream().map(map -> map.getValue()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
