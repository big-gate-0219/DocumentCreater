package resource.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectResource {
    private String name;
    private String resourceReference;
    private String timestamp;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceReference() {
        return resourceReference;
    }

    public void setResourceReference(String resourceReference) {
        this.resourceReference = resourceReference;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getResourcePath() {
        if (resourceReference.startsWith("/system")) {
            return "/" + resourceReference.substring(8).replace(".", "/");
        }
        return resourceReference.replace(".", "/");
    }

    @Override
    public String toString() {
        return "VantiqProjectResource [name=" + name + ", resourceReference=" + resourceReference + ", type=" + type
                + ", timestamp=" + timestamp + "]";
    }

}
