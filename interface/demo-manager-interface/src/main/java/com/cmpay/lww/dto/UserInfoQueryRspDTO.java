package com.cmpay.lww.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoQueryRspDTO extends  PageableRspDTO{
    private List<UserInfoDTO> list;
}
