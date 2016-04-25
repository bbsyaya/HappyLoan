package fly.com.happyloan.Activity.Finds.Activity;

/**
 * Created by Administrator on 2016/4/17 0017.
 */
public class Activities {
    private int img;
    private String title;
    private String content;

    public Activities(int img, String title, String content) {
        this.img = img;
        this.title = title;
        this.content = content;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
