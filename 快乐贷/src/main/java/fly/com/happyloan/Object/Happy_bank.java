package fly.com.happyloan.Object;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2016/4/27 0027.
 */
public class Happy_bank extends BmobObject{

    String cardNo; //银行卡号
    String holder; //持有人
    Double money; //银行卡余额
    String backType; //开户银行
    String cardType; //卡的类型(信用卡、储蓄卡等)
    BmobFile bankBrand; //银行商标
    String rservedPhone; //预留号码
    String username; //用户名(与用户表关联)

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getBackType() {
        return backType;
    }

    public void setBackType(String backType) {
        this.backType = backType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public BmobFile getBankBrand() {
        return bankBrand;
    }

    public void setBankBrand(BmobFile bankBrand) {
        this.bankBrand = bankBrand;
    }

    public String getRservedPhone() {
        return rservedPhone;
    }

    public void setRservedPhone(String rservedPhone) {
        this.rservedPhone = rservedPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
