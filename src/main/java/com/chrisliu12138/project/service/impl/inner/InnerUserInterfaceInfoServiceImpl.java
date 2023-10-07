package com.chrisliu12138.project.service.impl.inner;

import com.chrisliu12138.chrisapicommon.service.InnerUserInterfaceInfoService;
import com.chrisliu12138.project.service.UserInterfaceInfoService;

import javax.annotation.Resource;

public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
