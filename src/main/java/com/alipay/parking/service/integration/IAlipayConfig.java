package com.alipay.parking.service.integration;

import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.alipay.parking.modols.ParkingConfigQueryResponse;

import java.util.Map;

/**
 * @author liuzhuang
 * 使用场景说明：商户信息配置，配置的信息如下：商户注册、查询，停车场创建，修改
 */
public interface IAlipayConfig {
    
    /**
     * 商户配置
     * @param params
     * @return
     */
    public AlipayEcoMycarParkingConfigSetResponse configSet(Map<String, String> params);

    /**
     * 商户查询
     * @param params
     * @return
     */
    public ParkingConfigQueryResponse configQuery(Map<String,String> params);
    
    /**
     * 创建停车场
     * @param params
     * @return
     */
    public String parkingCreate(Map<String,String> params);
    
    /**
     * 修改停车场信息
     * @param params
     * @return
     */
    public String parkingUpdate(Map<String,String> params);
}
