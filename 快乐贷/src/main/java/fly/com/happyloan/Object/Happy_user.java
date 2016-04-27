package fly.com.happyloan.Object;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2016/4/26 0026.
 */
public class Happy_user extends BmobUser{

    //对应Bmob里面的_User表

    String nickname; //昵称
    BmobFile headImage; //头像
    String IDCard; //身份证号码
    String name; //真实姓名
    Double balance; //余额
    String transactionPwd; //支付密码
    String signature; //个性签名

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public BmobFile getHeadImage() {
        return headImage;
    }

    public void setHeadImage(BmobFile headImage) {
        this.headImage = headImage;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getTransactionPwd() {
        return transactionPwd;
    }

    public void setTransactionPwd(String transactionPwd) {
        this.transactionPwd = transactionPwd;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
