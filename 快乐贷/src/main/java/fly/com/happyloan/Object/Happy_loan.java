package fly.com.happyloan.Object;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Candy-X on 2016/4/27/0027.
 */
public class Happy_loan extends BmobObject{//借还款类

    String loanName;//借款人(与用户表关联)
    BmobFile headImage;//借款人头像(与用户表关联)
    Double yearInterestRate;//年利率
    BmobDate deadline;//借款期限
    Double loanMoney;//借款金额
    String outName;//借出人(与用户表关联)
    Double repaymentMoney;//还款金额
    Boolean exceedDate;//是否逾期(默认false)

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public BmobFile getHeadImage() {
        return headImage;
    }

    public void setHeadImage(BmobFile headImage) {
        this.headImage = headImage;
    }

    public Double getYearInterestRate() {
        return yearInterestRate;
    }

    public void setYearInterestRate(Double yearInterestRate) {
        this.yearInterestRate = yearInterestRate;
    }

    public BmobDate getDeadline() {
        return deadline;
    }

    public void setDeadline(BmobDate deadline) {
        this.deadline = deadline;
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }

    public Double getRepaymentMoney() {
        return repaymentMoney;
    }

    public void setRepaymentMoney(Double repaymentMoney) {
        this.repaymentMoney = repaymentMoney;
    }

    public Boolean getExceedDate() {
        return exceedDate;
    }

    public void setExceedDate(Boolean exceedDate) {
        this.exceedDate = exceedDate;
    }
}
