package com.chrisliu12138.project.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;


/**
 * 接口调用请求
 *
 * @Tablename product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    private Long id;
    private String userRequestParams;
    private String requestHeader;
    private String responseHeader;
    private Integer status;
    private String method;
    private static final long serialVersionUID = 1L;
}
