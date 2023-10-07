package com.chrisliu12138.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chrisliu12138.chrisapicommon.model.entity.InterfaceInfo;
import com.chrisliu12138.chrisapicommon.service.InnerInterfaceInfoService;
import com.chrisliu12138.project.common.ErrorCode;
import com.chrisliu12138.project.exception.BusinessException;
import com.chrisliu12138.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;

//public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {
//    @Resource
//    private InterfaceInfoMapper interfaceInfoMapper;
//
//    @Override
//    public InterfaceInfo getInterfaceInfo(String url, String method) {
//        if (StringUtils.isAnyBlank(url, method)) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("url", url);
//        queryWrapper.eq("method", method);
//        return interfaceInfoMapper.selectOne(queryWrapper);
//    }
//
//}
