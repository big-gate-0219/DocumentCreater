package resource;

public abstract class AbstractResource {
    // リソース名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
