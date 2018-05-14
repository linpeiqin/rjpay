package com.alipay.parking.service.integration.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alipay.parking.modols.ParkingConfigQueryRequest;
import com.alipay.parking.modols.ParkingConfigQueryResponse;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingConfigQueryRequest;
import com.alipay.api.request.AlipayEcoMycarParkingConfigSetRequest;
import com.alipay.api.request.AlipayEcoMycarParkingParkinglotinfoCreateRequest;
import com.alipay.api.request.AlipayEcoMycarParkingParkinglotinfoUpdateRequest;
import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoCreateResponse;
import com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoUpdateResponse;
import com.alipay.parking.common.AliPayUtil;
import com.alipay.parking.service.integration.IAlipayConfig;
@Service
public class AlipayConfigImpl implements IAlipayConfig {

	@Resource(name = "aliPayUtil")
	private AliPayUtil aliPayUtil;

	public AlipayEcoMycarParkingConfigSetResponse configSet(Map<String, String> params) {
		try {
			AlipayClient alipayClient = aliPayUtil.getInstance();
			AlipayEcoMycarParkingConfigSetRequest request = new AlipayEcoMycarParkingConfigSetRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数
			// 此次只是参数展示，未进行字符串转义，实际情况下请转义
			request.setBizContent(processParams(params, "1"));// 业务数据
			AlipayEcoMycarParkingConfigSetResponse response = alipayClient.execute(request);
            if (response.isSuccess()){
                response.getBody();
            }
			// 判断调用是否成功
			return response;
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String processParams(Map<String, String> param, String type) {

		String map2Json = "";

		if ("1".equals(type)) {// config.set商户信息配置请求参数
			Map<String, String> params = new HashMap<String, String>();
			params.put("merchant_name", param.get("merchantName"));
			params.put("merchant_service_phone", param.get("merchantServicePhone"));
			params.put("account_no", param.get("accountNo"));
			params.put("merchant_logo", param.get("merchantLogo"));
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> arrMap = new HashMap<String, String>();
			arrMap.put("interface_name", "alipay.eco.mycar.parking.userpage.query");
			arrMap.put("interface_type", "interface_page");
			String interfaceUrl = param.get("interfaceInfoList[0].interfaceUrl");
			try {
				arrMap.put("interface_url", URLEncoder.encode(interfaceUrl,"UTF-8"));// 链接转码
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			list.add(arrMap);

			params.put("interface_info_list", JSON.toJSONString(list));
			map2Json = JSON.toJSONString(params);
		} else if ("2".equals(type)) {// config.query查询商户信息请求参数
			Map<String, String> params = new HashMap<String, String>();
			params.put("interface_name", "alipay.eco.mycar.parking.userpage.query");
			params.put("interface_type", "interface_page");
			map2Json = JSON.toJSONString(params);
		} else if ("3".equals(type)) {
			Map<String, String> params = new HashMap<String, String>();// 组织json串
			// 注:非必填项可用双绰号""代替
			params.put("out_parking_id", param.get("out_parking_id"));//停车场ID
			params.put("parking_address", param.get("parking_address"));//停车场地址
			params.put("parking_lot_type", param.get("parking_lot_type"));//停车场类型，1为小区停车场、2为商圈停车场、3为路面停车场、4为园区停车场、5为写字楼停车场、6为私人停车场
			params.put("parking_poiid", param.get("parking_poiid"));//高德地图唯一标识
			params.put("parking_mobile", param.get("parking_mobile"));//停车场客服电话 手机号
			params.put("pay_type", param.get("pay_type"));//支付方式（1为支付宝在线缴费，2为支付宝代扣缴费
			params.put("shopingmall_id", param.get("shopingmall_id"));//商圈id 100001008   非必填
			params.put("parking_fee_description", param.get("parking_fee_description"));//收费说明  小车一小时10元  非必填
			params.put("parking_name", param.get("parking_name"));//停车场名称
			params.put("time_out", param.get("time_out"));//支付超时时间 非必填
			map2Json = JSON.toJSONString(params);
		} else if ("4".equals(type)) {
			// 修改停车场
			Map<String, String> params = new HashMap<String, String>();// 组织json串
			// 注:非必填项可用双绰号""代替
			params.put("parking_id", param.get("parking_id"));//停车场支付宝ID
			params.put("out_parking_id", param.get("out_parking_id"));//停车场ID
			params.put("parking_address", param.get("parking_address"));//停车场地址
			params.put("parking_lot_type", param.get("parking_lot_type"));//停车场类型，1为小区停车场、2为商圈停车场、3为路面停车场、4为园区停车场、5为写字楼停车场、6为私人停车场
			params.put("parking_poiid", param.get("parking_poiid"));//高德地图唯一标识
			params.put("parking_mobile", param.get("parking_mobile"));//停车场客服电话 手机号
			params.put("pay_type", param.get("pay_type"));//支付方式（1为支付宝在线缴费，2为支付宝代扣缴费
			params.put("shopingmall_id", param.get("shopingmall_id"));//商圈id 100001008   非必填
			params.put("parking_fee_description", param.get("parking_fee_description"));//收费说明  小车一小时10元  非必填
			params.put("parking_name", param.get("parking_name"));//停车场名称
			params.put("time_out", param.get("time_out"));//支付超时时间 非必填
			map2Json = JSON.toJSONString(params);
			// TODO
		}

		return map2Json;
	}

	public ParkingConfigQueryResponse configQuery(Map<String, String> params) {
		try {
			AlipayClient alipayClient = aliPayUtil.getInstance();
			// 实例化具体API对应的request类,类名称和接口名称对应,
			ParkingConfigQueryRequest request = new ParkingConfigQueryRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数
			// 此次只是参数展示，未进行字符串转义，实际情况下请转义
			request.setBizContent(processParams(null, "2"));// 业务数据
            ParkingConfigQueryResponse response = alipayClient.execute(request);
			// 判断调用是否成功
			return response;
		} catch (AlipayApiException e) {
			// 调用异常逻辑处理
			e.printStackTrace();
		}
		return null;
	}

	public String parkingCreate(Map<String, String> params) {
		String returnMsg = "";
		try {
			AlipayClient alipayClient = aliPayUtil.getInstance();
			// 实例化具体API对应的request类,类名称和接口名称对应,
			AlipayEcoMycarParkingParkinglotinfoCreateRequest request = new AlipayEcoMycarParkingParkinglotinfoCreateRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数
			// 此次只是参数展示，未进行字符串转义，实际情况下请转义
			request.setBizContent(processParams(params, "3"));// 业务数据
			AlipayEcoMycarParkingParkinglotinfoCreateResponse response = alipayClient.execute(request);
			// 判断调用是否成功
			if (response.isSuccess()) {
				// 获取相应数据
				Map<String, String> responseParams = response.getParams();
				// 通过返回数据进行业务处理，可以通过responseParams获取到返回的键值数据
				returnMsg = JSON.toJSONString(responseParams);
			} else {
				// 调用失败处理逻辑
			}
		} catch (AlipayApiException e) {
			// 调用异常逻辑处理
			e.printStackTrace();
		}
		return returnMsg;
	}

	public String parkingUpdate(Map<String, String> params) {
		String isSuccess = "false";
		try {
			AlipayClient alipayClient = aliPayUtil.getInstance();

			AlipayEcoMycarParkingParkinglotinfoUpdateRequest request = new AlipayEcoMycarParkingParkinglotinfoUpdateRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数

			request.setBizContent(processParams(params, "4"));

			AlipayEcoMycarParkingParkinglotinfoUpdateResponse response = alipayClient.execute(request);

			if (response.isSuccess()) {
				System.out.println("调用成功");
				isSuccess = "success";
			} else {
				System.out.println("调用失败");
			}
		} catch (AlipayApiException e) {
			// 调用异常逻辑处理
			e.printStackTrace();
		}
		return isSuccess;
	}

}
