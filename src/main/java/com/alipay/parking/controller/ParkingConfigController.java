package com.alipay.parking.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.alipay.parking.modols.ParkingConfigQueryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alipay.parking.service.integration.IAlipayConfig;

/**
 * @author liuzhuang
 * 使用场景说明：商户信息配置
 */
@Controller
@RequestMapping("/parkingconfig")
public class ParkingConfigController extends baseController {

    @Resource
    private IAlipayConfig iAlipayConfig; // 对内数据

    /**
     * 商户信息配置
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/configset")
    public String configSet(HttpServletRequest request, HttpServletResponse response , @ModelAttribute("aliResponse") ParkingConfigQueryResponse aliResponse) {
        Map<String, String> params = super.getParametersFromPage(request);
        AlipayEcoMycarParkingConfigSetResponse alipayEcoMycarParkingConfigSetResponse = iAlipayConfig.configSet(params);
        if (alipayEcoMycarParkingConfigSetResponse==null){
            request.setAttribute("msg","出现异常联系管理员");
            return "error";
        }
        if (!alipayEcoMycarParkingConfigSetResponse.isSuccess()){
            String msg = alipayEcoMycarParkingConfigSetResponse.getSubMsg();
            request.setAttribute("msg",msg);
            return "error";
        }
        return "isvinfo_config";
    }

    /**
     * 商户配置信息查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/configquery")
    public String configQuery(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
        Map<String, String> params = super.getParametersFromPage(request);
        ParkingConfigQueryResponse aliResponse = iAlipayConfig.configQuery(params);
        if (aliResponse==null){
            request.setAttribute("msg","出现异常联系管理员");
            return "error";
        }
        if (!aliResponse.isSuccess()){
            String msg = aliResponse.getSubMsg();
            request.setAttribute("msg",msg);
            return "error";
        }
        aliResponse.getInterfaceInfoList().get(0).setInterfaceUrl(URLDecoder.decode(aliResponse.getInterfaceInfoList().get(0).getInterfaceUrl(),"UTF-8") );
        model.addAttribute("aliResponse",aliResponse);
        return "isvinfo_config";
    }

    /**
     * 创建停车场
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/creaceParking")
    public String creaceParking(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> params = super.getParametersFromPage(request);
        String isSuccess = iAlipayConfig.parkingCreate(params);
        return isSuccess;
    }
    
    /**
     * 修改停车场
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/updateParking")
    public String updateParking(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> params = super.getParametersFromPage(request);
        String isSuccess = iAlipayConfig.parkingUpdate(params);
        return isSuccess;
    }
}
