
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

import resource.AbstractResource;
import resource.collaborationtype.CollaborationType;
import resource.project.Project;
import resource.project.ProjectResource;
import resource.scheduledevent.ScheduledEvent;
import resource.service.Service;
import resource.source.Source;
import resource.type.Type;

public class DocumentCreater {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String fileName =  args[0];
        String projectName = fileName.substring(fileName.lastIndexOf("/") + 1).replace(".zip", "");

        Project project;
        List<Service> serviceList;
        List<CollaborationType> collaborationTypeList;
        List<Source> sources;
        List<Type> types;
        List<ScheduledEvent> scheduledEvents;

        try (ZipFile zip = new ZipFile(fileName)) {
            // Resource情報の読み込み
            String projectEntryPath = projectName + "/projects/" + projectName + ".json";
            project = readEntry(zip, projectName, projectEntryPath, Project.class);
            serviceList = readEntries(zip, projectName, project.getServices(), Service.class);
            collaborationTypeList = readEntries(zip, projectName, project.getCollaborationTypes(),
                    CollaborationType.class);
            types = readEntries(zip, projectName, project.getTypes(), Type.class);
            sources = readEntries(zip, projectName, project.getSources(), Source.class);
            scheduledEvents = readEntries(zip, projectName, project.getScheduledEvents(), ScheduledEvent.class);

            // Topic情報の読み込み
            // Procedures情報の読み込み
            // Documents情報の読み込み
        }

        // 設計書の出力
        saveDocument(projectName, project, ResourceDefinition.Project);
        saveDocument(projectName, collaborationTypeList, ResourceDefinition.CollaborationType);
        saveDocument(projectName, serviceList, ResourceDefinition.Service);
        saveDocument(projectName, types, ResourceDefinition.Type);
        saveDocument(projectName, sources, ResourceDefinition.Source);
        saveDocument(projectName, scheduledEvents, ResourceDefinition.ScheduledEvent);
    }

    public static <T extends AbstractResource> List<T> readEntries(ZipFile zip, String projectName,
            List<ProjectResource> resourceInfos, Class<T> clazz) throws IOException {
        List<T> resources = new ArrayList<>();
        for (ProjectResource resourceInfo : resourceInfos) {
            resources.add(readEntry(zip, projectName, resourceInfo, clazz));
        }
        return resources;

    }

    public static <T extends AbstractResource> T readEntry(ZipFile zip, String projectName,
            ProjectResource resourceInfo, Class<T> clazz) throws IOException {
        String entryPath = projectName + resourceInfo.getResourcePath().replace(".", "/") + ".json";
        return readEntry(zip, projectName, entryPath, clazz);
    }

    public static <T extends AbstractResource> T readEntry(ZipFile zip, String projectName,
            String entryPath, Class<T> clazz) throws IOException {
        try (InputStream inputStream = zip.getInputStream(zip.getEntry(entryPath))) {
            return mapper.readValue(inputStream, clazz);
        }
    }

    public static <T extends AbstractResource> void saveDocument(String projectName, List<T> resources,
            ResourceDefinition resourceDefinition) throws IOException {
        for (AbstractResource resource : resources) {
            saveDocument(projectName, resource, resourceDefinition);
        }
    }

    public static void saveDocument(String projectName, AbstractResource resource,
            ResourceDefinition resourceDefinition)
            throws IOException {
        String outputPath = projectName + "/" + resourceDefinition.getResourceName() + "/" + resource.getName() + ".md";
        Context context = new Context();
        context.setVariable(resourceDefinition.getVariableName(), resource);
        saveDocument(resourceDefinition.getTemplateName(), context, outputPath);
    }

    private static void saveDocument(String template, Context context, String outputPath) throws IOException {
        File file = new File(outputPath);
        file.getParentFile().mkdirs();
        try (Writer writer = new FileWriter(file)) {
            TemplateEngine engine = getTemplateEngen();
            engine.process(template, context, writer);
        }
    }

    private static TemplateEngine getTemplateEngen() {
        ClassLoaderTemplateResolver resolver = getTemplateResolver();
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        return engine;
    }

    private static ClassLoaderTemplateResolver getTemplateResolver() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("TEXT");
        resolver.setPrefix("templates/");
        resolver.setSuffix(".template");
        return resolver;
    }
}
