package delhi.android.nit.com.terratechnica.Sponsor;

/**
 * Created by Directioner on 3/18/2017.
 */

public class SponsorModel {

    private String name;
    private String img;
    private String supportLevel;

    private String link;

    public SponsorModel(String name, String img, String link, String supportLevel) {
        this.name = name;
        this.img = img;
        this.link = link;
        this.supportLevel = supportLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSupportLevel() {
        return supportLevel;
    }

    public void setSupportLevel(String supportLevel) {
        this.supportLevel = supportLevel;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
