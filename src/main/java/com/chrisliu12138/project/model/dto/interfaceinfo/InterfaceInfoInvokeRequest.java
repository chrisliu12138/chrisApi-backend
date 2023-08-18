package com.chrisliu12138.project.model.dto.interfaceinfo;

import lombok.Data;

@Data
public class InterfaceInfoInvokeRequest {

    private Long id;
    private String requestParams;
    private String requestHeader;
    private String responseHeader;
    private Integer status;
    private String method;
    private static final long serialVersionUID = 1L;
}
