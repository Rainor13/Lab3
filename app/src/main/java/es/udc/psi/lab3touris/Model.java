package es.udc.psi.lab3touris;

public class Model {

    private String title;
    private String subTitle;
    private String description;

    public Model(String title, String subTitle, String description) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
