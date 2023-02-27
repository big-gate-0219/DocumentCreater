package resource.collaborationtype;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollaborationTypeAssembly {
    private String name;
    private String description;
    private String pattern;
    private int patternVersion;
    private String uuid;
    private CollaborationTypeConfiguration configuration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getPatternVersion() {
        return patternVersion;
    }

    public void setPatternVersion(int patternVersion) {
        this.patternVersion = patternVersion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public CollaborationTypeConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(CollaborationTypeConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
