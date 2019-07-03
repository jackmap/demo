package com.example.service.admin.impl;

import com.example.dao.sys.CateDao;
import com.example.entity.sys.*;
import com.example.service.admin.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CateServiceImpl implements CateService {
    @Autowired
    CateDao  cateDao;

    @Override
    public JSONResult findAllCate(Integer page, Integer pageSize) {
        Pageable pageable=new PageRequest(page-1,pageSize);
        List<Cate> list=cateDao.findAll(pageable).getContent();
        int count=cateDao.findAll().size();
        return new JSONResult(0,"查询权限分类列表成功",list,count);
    }

    @Override
    public JSONResult addCate(Cate cate) {
        Cate cate_data= cateDao.findByCatename(cate.getCatename());
        if(cate_data==null){
            cate.setCreateUser("");
            cate.setCreateTime(new Date());
            cateDao.save(cate);
            return  new JSONResult(0,"添加权限分类列表成功");
        }else {
            return  new JSONResult(1,"添加权限分类列表失败，权限分类名称已存在");
        }
    }

    @Override
    public JSONResult deleteCate(Integer cateid) {
        Cate cate_data= cateDao.findById(cateid).get();
        if(cate_data==null){
            cateDao.deleteById(cate_data.getCateid());
            return  new JSONResult(0,"删除权限分类列表成功");
        }else {
            return  new JSONResult(1,"删除权限分类列表失败，权限分类id不存在");
        }
    }

    @Override
    public JSONResult updateCate(Cate cate) {
        Cate cate_data= cateDao.findByCatename(cate.getCatename());
        if(cate_data==null){
            cate.setModifier("");
            cate.setModifyTime(new Date());
            cateDao.save(cate);
            return  new JSONResult(0,"修改权限分类列表成功");
        }else {
            return  new JSONResult(1,"修改权限分类列表失败，权限分类名称已存在");
        }
    }


}
