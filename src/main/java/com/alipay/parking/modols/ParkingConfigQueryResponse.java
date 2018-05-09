package com.alipay.parking.modols;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.InterfaceInfoList;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class ParkingConfigQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2318838633247655859L;
    @ApiField("account_no")
    private String accountNo;
    @ApiListField("interface_info_list")
    private List<InterfaceInfoList> interfaceInfoList;
    @ApiField("merchant_logo")
    private String merchantLogo;
    @ApiField("merchant_name")
    private String merchantName;
    @ApiField("merchant_service_phone")
    private String merchantServicePhone;

    public ParkingConfigQueryResponse() {
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public List<InterfaceInfoList> getInterfaceInfoList() {
        return interfaceInfoList;
    }

    public void setInterfaceInfoList(List<InterfaceInfoList> interfaceInfoList) {
        this.interfaceInfoList = interfaceInfoList;
    }

    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }

    public String getMerchantLogo() {
        return this.merchantLogo;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantServicePhone(String merchantServicePhone) {
        this.merchantServicePhone = merchantServicePhone;
    }

    public String getMerchantServicePhone() {
        return this.merchantServicePhone;
    }
}
