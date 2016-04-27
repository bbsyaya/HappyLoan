package fly.com.happyloan.Object;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by Candy-X on 2016/4/27/0027.
 */
public class Happy_reward extends BmobObject{//悬赏类

    String name ;//悬赏人(与用户表关联)
    String content;//悬赏内容
    List photos;//悬赏图片
    Double money;//悬赏金额
    Integer count;//赏金个数
    String appoint;//指定好友(objecteId)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List getPhotos() {
        return photos;
    }

    public void setPhotos(List photos) {
        this.photos = photos;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAppoint() {
        return appoint;
    }

    public void setAppoint(String appoint) {
        this.appoint = appoint;
    }
}
