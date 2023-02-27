package resource.type;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import resource.AbstractResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type extends AbstractResource {
    private String name;
    private String role;
    private Map<String, Property> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map<String, Property> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }

    public String getServiceName() {
        return getSimpleName().split("_")[0];
    }

    public String getTypeName() {
        return getSimpleName().split("_")[1];
    }

    public String getSimpleName() {
        return getName().substring(getName().lastIndexOf(".") + 1);
    }

    public String getPackageName() {
        return getName().substring(0, getName().lastIndexOf("."));
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
