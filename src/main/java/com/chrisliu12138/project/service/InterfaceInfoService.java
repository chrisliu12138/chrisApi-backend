package com.chrisliu12138.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chrisliu12138.project.model.dto.interfaceinfo.InterfaceInfoInvokeRequest;
import com.chrisliu12138.project.model.entity.InterfaceInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口信息服务
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    Object invokeInterfaceInfo(InterfaceInfoInvokeRequest interfaceInfoInvokeRequest, HttpServletRequest request);

}
