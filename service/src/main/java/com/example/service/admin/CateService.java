package com.example.service.admin;

import com.example.entity.sys.Cate;
import com.example.entity.sys.JSONResult;
public interface CateService {
    JSONResult findAllCate(Integer page, Integer limit);
    JSONResult addCate(Cate cate);
    JSONResult deleteCate(Integer cateid);
    JSONResult updateCate(Cate cate);
}
