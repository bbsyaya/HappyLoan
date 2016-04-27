package fly.com.happyloan.Activity.Login;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/4/26 0026.
 */
public class Happy_user extends BmobUser{

    //对应Bmob里面的_User表

    Integer id; //用户id
    String nickname; //昵称
    String IDCard; //身份证号码
    String transaction_pwd; //支付密码
    String signature; //个性签名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getTransaction_pwd() {
        return transaction_pwd;
    }

    public void setTransaction_pwd(String transaction_pwd) {
        this.transaction_pwd = transaction_pwd;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
