package resource.collaborationtype;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollaborationTypeConfiguration {
    private List<String> childStreams;
    private List<String> parentStreams;
    private String outboundProperty;
    private String unwindProperty;
    private String inboundResource;
    private String inboundResourceId;
    private String imports;
    // private List<String> parameters;
    private String partitionKey;
    private String procedure;
    private String returnBehavior;
    private String returnProperty;
    private String schema;
    private String topic;
    private String catalog;
    private String event;
    private String processedByClause;
    private boolean transformInPlace;
    private boolean upsert;

    private String condition;
    private String eventTypeName;
    private String op;
    private String outboundResource;
    private String outboundResourceConfig;
    private String outboundResourceId;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOutboundResource() {
        return outboundResource;
    }

    public void setOutboundResource(String outboundResource) {
        this.outboundResource = outboundResource;
    }

    public String getOutboundResourceConfig() {
        return outboundResourceConfig;
    }

    public void setOutboundResourceConfig(String outboundResourceConfig) {
        this.outboundResourceConfig = outboundResourceConfig;
    }

    public String getOutboundResourceId() {
        return outboundResourceId;
    }

    public void setOutboundResourceId(String outboundResourceId) {
        this.outboundResourceId = outboundResourceId;
    }

    public List<String> getChildStreams() {
        return childStreams;
    }

    public void setChildStreams(List<String> childStreams) {
        this.childStreams = childStreams;
    }

    public List<String> getParentStreams() {
        return parentStreams;
    }

    public void setParentStreams(List<String> parentStreams) {
        this.parentStreams = parentStreams;
    }

    public String getOutboundProperty() {
        return outboundProperty;
    }

    public void setOutboundProperty(String outboundProperty) {
        this.outboundProperty = outboundProperty;
    }

    public String getUnwindProperty() {
        return unwindProperty;
    }

    public void setUnwindProperty(String unwindProperty) {
        this.unwindProperty = unwindProperty;
    }

    public String getInboundResource() {
        return inboundResource;
    }

    public void setInboundResource(String inboundResource) {
        this.inboundResource = inboundResource;
    }

    public String getInboundResourceId() {
        return inboundResourceId;
    }

    public void setInboundResourceId(String inboundResourceId) {
        this.inboundResourceId = inboundResourceId;
    }

    public String getImports() {
        return imports;
    }

    public void setImports(String imports) {
        this.imports = imports;
    }

    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getReturnBehavior() {
        return returnBehavior;
    }

    public void setReturnBehavior(String returnBehavior) {
        this.returnBehavior = returnBehavior;
    }

    public String getReturnProperty() {
        return returnProperty;
    }

    public void setReturnProperty(String returnProperty) {
        this.returnProperty = returnProperty;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getProcessedByClause() {
        return processedByClause;
    }

    public void setProcessedByClause(String processedByClause) {
        this.processedByClause = processedByClause;
    }

    public boolean isTransformInPlace() {
        return transformInPlace;
    }

    public void setTransformInPlace(boolean transformInPlace) {
        this.transformInPlace = transformInPlace;
    }

    public boolean isUpsert() {
        return upsert;
    }

    public void setUpsert(boolean upsert) {
        this.upsert = upsert;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
