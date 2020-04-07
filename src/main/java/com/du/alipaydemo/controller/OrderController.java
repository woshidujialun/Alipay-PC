package com.du.alipaydemo.controller;

import com.alipay.api.AlipayApiException;
import com.du.alipaydemo.bean.AlipayBean;
import com.du.alipaydemo.service.PayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private PayService payService;//调用支付服务

    /*阿里支付*/
    @PostMapping(value = "alipay")
    public String alipay(String out_trade_no,String subject,String total_amount,String body) throws AlipayApiException{

        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setBody(body);
        alipayBean.setOut_trade_no(out_trade_no);
        alipayBean.setTotal_amount(new StringBuffer().append(total_amount));
        alipayBean.setSubject(subject);

        return payService.aliPay(alipayBean);
    }
}
