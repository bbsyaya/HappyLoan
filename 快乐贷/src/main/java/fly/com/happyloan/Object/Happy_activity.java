package fly.com.happyloan.Object;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2016/4/27 0027.
 */
public class Happy_activity extends BmobObject{

    String name; //发起人(与用户表关联)
    String headImage; //发起人头像(与用户表关联)
    List joinName; //参加人 (与用户表关联)
    String type; //活动类型
    String time; //活动时间
    String address; //活动地点
    Integer count; //参加人数(可限制)
    List photos; //活动地点景色图片

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public List<String> getJoinName() {
        return joinName;
    }

    public void setJoinName(List<String> joinName) {
        this.joinName = joinName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<BmobFile> getPhotos() {
        return photos;
    }

    public void setPhotos(List<BmobFile> photos) {
        this.photos = photos;
    }
}
