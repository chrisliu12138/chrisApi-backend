package com.chrisliu12138.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chrisliu12138.chrisapiclientsdk.client.ChrisApiClient;
import com.chrisliu12138.chrisapiclientsdk.model.User;
import com.chrisliu12138.project.common.ErrorCode;
import com.chrisliu12138.project.exception.BusinessException;
import com.chrisliu12138.project.exception.ThrowUtils;
import com.chrisliu12138.project.mapper.InterfaceInfoMapper;
import com.chrisliu12138.project.model.dto.interfaceinfo.InterfaceInfoInvokeRequest;
import com.chrisliu12138.project.model.enums.InterfaceInfoStatusEnum;
import com.chrisliu12138.project.service.InterfaceInfoService;
import com.chrisliu12138.project.model.entity.InterfaceInfo;
import com.chrisliu12138.project.service.UserService;
import com.google.gson.Gson;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 接口信息服务实现类
 *
 * @author <a href="https://github.com/lichrisliu12138">chrisliu12138</a>
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Resource
    private UserService userService;

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }

    @Override
    @Transactional
    public Object invokeInterfaceInfo(InterfaceInfoInvokeRequest interfaceInfoInvokeRequest, HttpServletRequest request) {
        // todo 全局变量来判定接口是否可以调通，但是有些接口调用不成功返回错误信息是字符串，因此这里要优化判定接口没有调用的方法
        ImmutablePair<Integer, String> res = null;
        // 判断传参是否规范
        ThrowUtils.throwIf(ObjectUtils.isEmpty(interfaceInfoInvokeRequest) || interfaceInfoInvokeRequest.getId() < 1, ErrorCode.PARAMS_ERROR);
        Long id = interfaceInfoInvokeRequest.getId();
        String params = interfaceInfoInvokeRequest.getUserRequestParams();
        // 判断接口是否存在
        InterfaceInfo oldInterfaceInfo = getById(id);
        ThrowUtils.throwIf(ObjectUtils.isEmpty(oldInterfaceInfo), ErrorCode.NOT_FOUND_ERROR);
        // 判断接口状态是否已关闭
        ThrowUtils.throwIf(oldInterfaceInfo.getStatus() != InterfaceInfoStatusEnum.ONLINE.getValue(), ErrorCode.NOT_FOUND_ERROR, "接口已关闭");
        // 判断传入的 ak、sk 与分配的是否一致
        // todo 可以使用 yml 配置中的 ak、sk，减少查库
        com.chrisliu12138.project.model.entity.User loginUser = userService.getLoginUser(request);
        String accessKey = loginUser.getAccessKey();
        String secretKey = loginUser.getSecretKey();
        ChrisApiClient tempClient = new ChrisApiClient(accessKey, secretKey);
        // todo 取消注释 随机笑话
//        if (oldInterfaceInfo.getUrl().contains("randomMessage")) {
//            res = tempClient.randomMessage(interfaceInfoInvokeRequest.getRequestParams());
//        }

        if (oldInterfaceInfo.getUrl().contains("name")) {
            Gson gson = new Gson();
            User user = gson.fromJson(params, User.class);
            return tempClient.getUsernameByPost(user);
        }
        if (res.getLeft() != 200) {
            throw new BusinessException(res.getLeft(), res.getRight());
        }
        return res.getRight();
    }
}




