package com.du.alipaydemo.service.impl;

import com.alipay.api.AlipayApiException;
import com.du.alipaydemo.bean.AlipayBean;
import com.du.alipaydemo.config.AlipayUtil;
import com.du.alipaydemo.service.PayService;
import org.springframework.stereotype.Service;

/* 支付服务 */
@Service(value = "alipayOrderService")
public class PayServiceImpl implements PayService {
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }
}
