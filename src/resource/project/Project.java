package resource.project;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import resource.AbstractResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends AbstractResource {
    private ProjectOption options;
    private List<ProjectResource> resources;

    public ProjectOption getOptions() {
        return options;
    }

    public void setOptions(ProjectOption options) {
        this.options = options;
    }

    public List<ProjectResource> getResources() {
        return resources;
    }

    public void setResources(List<ProjectResource> resources) {
        this.resources = resources;
    }

    public String getDescription() {
        return this.options.getDescription().replace("#","");
    }
    public List<ProjectResource> getProjectResource(int type) {
        return this.resources.stream()
                .filter(resource -> resource.getType() == type)
                .collect(Collectors.toList());
    }

    public List<ProjectResource> getServices() {
        return this.getProjectResource(63);
    }

    public List<ProjectResource> getCollaborationTypes() {
        return this.getProjectResource(12);
    }

    public List<ProjectResource> getProcedures() {
        return this.getProjectResource(3);
    }

    public List<ProjectResource> getSources() {
        return this.getProjectResource(4);
    }

    public List<ProjectResource> getScheduledEvents() {
        return this.getProjectResource(17);
    }

    public List<ProjectResource> getTypes() {
        return this.getProjectResource(1);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
