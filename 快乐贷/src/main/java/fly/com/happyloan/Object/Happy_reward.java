package fly.com.happyloan.Object;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by Candy-X on 2016/4/27/0027.
 */
public class Happy_reward extends BmobObject{//悬赏类

    String headImage;//头像
    String name ;//悬赏人(与用户表关联)
    String content;//悬赏内容
    Double money;//悬赏金额
    Integer count;//赏金个数
    String time;//时间
    List appoint;//指定好友(objecteId)

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List getAppoint() {
        return appoint;
    }

    public void setAppoint(List appoint) {
        this.appoint = appoint;
    }
}
