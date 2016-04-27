package fly.com.happyloan.Object;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by Candy-X on 2016/4/27/0027.
 */
public class Happy_notice extends BmobObject{//公告类

    String title;//标题
    List noticeImages;//公告图片
    String content;//公告内容
    BmobDate noticeTime;//发布时间


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getNoticeImages() {
        return noticeImages;
    }

    public void setNoticeImages(List noticeImages) {
        this.noticeImages = noticeImages;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BmobDate getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(BmobDate noticeTime) {
        this.noticeTime = noticeTime;
    }
}
