package fly.com.happyloan.Object;

import cn.bmob.v3.BmobObject;

/**
 * Created by Candy-X on 2016/4/27/0027.
 */
public class Happy_friend extends BmobObject{//好友类

    String meName;//我
    String friendName;//好友
    String friendImage;//好友头像
    String name;//好友名字

    public String getMeName() {
        return meName;
    }

    public void setMeName(String meName) {
        this.meName = meName;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendImage() {
        return friendImage;
    }

    public void setFriendImage(String friendImage) {
        this.friendImage = friendImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
