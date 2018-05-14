package com.alipay.parking.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.alipay.parking.service.integration.IAlipayConfig;

/**
 * @author liuzhuang
 * 使用场景说明：配置的Test，商户信息配置，商户信息查询、录入停车场、停车场修改
 */
public class ParkingConfigTest extends BaseTest {
    @Resource
    private IAlipayConfig iAlipayConfig;
    @Test
    public void configSet() throws UnsupportedEncodingException {
     /*   Map<String, String> params = new HashMap<String, String>();
        params.put("merchant_name", "linking");
        params.put("merchant_service_phone", "18802058397");
        params.put("account_no", "linking1231");
        params.put("merchant_logo", "");
        params.put("interface_url", URLEncoder.encode("https://139.196.175.54:9091","UTF-8"));//链接转码
       iAlipayConfig.configSet(params);*/
    }
    public void configQuery() {
        iAlipayConfig.configQuery(null);
    }

    /**
     * 更新，创建停车场，去掉废弃代码
     */
    @Test
    public void parkingCreate() {
        Map<String, String> params = new HashMap<String, String>();//组织json串
        //注:非必填项可用双绰号""代替
        params.put("out_parking_id", "10000110001");//停车场ID
        params.put("parking_address", "浙江省杭州市古墩路与疏港公路的交汇处");//停车场地址
        params.put("parking_lot_type", "1");//停车场类型，1为小区停车场、2为商圈停车场、3为路面停车场、4为园区停车场、5为写字楼停车场、6为私人停车场
        params.put("parking_poiid", "B00155FTSJ");//高德地图唯一标识
        params.put("parking_mobile", "18802058397");//停车场客服电话 手机号
        params.put("pay_type", "2");//支付方式（1为支付宝在线缴费，2为支付宝代扣缴费
        params.put("shopingmall_id", "100001008");//商圈id 100001008   非必填
        params.put("parking_fee_description", "小车一小时10元");//收费说明  小车一小时10元  非必填
        params.put("parking_name", "深圳市五洲宾馆南1停车场");//停车场名称
        params.put("time_out", "13");//支付超时时间 非必填
        iAlipayConfig.parkingCreate(params);
    }

    /**
     * /**
     * 更新，修改停车场，去掉废弃代码
     */
    @Test
    public void parkingUpdate() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("parking_id", "PI1525940089921464233");
        params.put("out_parking_id", "10000110001");
        params.put("parking_address", "上海市静安区延安西路396号上海美丽园大酒店");
        params.put("parking_name", "美丽园大酒店停车场(延安西路)");
        params.put("time_out", "13");
        params.put("parking_lot_type", "1");
        params.put("pay_type", "2");
        params.put("parking_poiid", "B0FFHQ3M0P");
        params.put("parking_mobile", "18802058397");
        params.put("shopingmall_id", "100001008");
        params.put("parking_fee_description", "小车一小时9元");
        iAlipayConfig.parkingUpdate(params);
    }
}
