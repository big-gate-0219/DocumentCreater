public class ResourceDefinition {
    public static ResourceDefinition Project = new ResourceDefinition("", "project", "Project");
    public static ResourceDefinition CollaborationType = new ResourceDefinition("collaborationtypes",
            "collaborationType", "CollaborationType");
    public static ResourceDefinition Service = new ResourceDefinition("services", "service", "Service");
    public static ResourceDefinition Type = new ResourceDefinition("types", "type", "Type");
    public static ResourceDefinition Source = new ResourceDefinition("sources", "source", "Source");
    public static ResourceDefinition ScheduledEvent = new ResourceDefinition("scheduledevents", "scheduledevent", "ScheduledEvent");

    private final String resourceName;
    private final String variableName;
    private final String templateName;

    private ResourceDefinition(String resourceName, String variableName, String templateName) {
        this.resourceName = resourceName;
        this.variableName = variableName;
        this.templateName = templateName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getTemplateName() {
        return templateName;
    }

}