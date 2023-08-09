package com.allianz.example.service;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseService;
import com.allianz.example.util.dbutil.BaseEntity;

public interface CommentService <T extends BaseEntity, ResponseDTO extends BaseDTO, RequestDTO extends BaseDTO>
        extends IBaseService<T, ResponseDTO, RequestDTO> {
}
