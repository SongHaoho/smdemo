package com.example.demo.service.impl;

import com.example.demo.bean.vo.AreaVo;
import com.example.demo.dao.AreaDao;
import com.example.demo.bean.Area;
import com.example.demo.entity.Page;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.DemoException;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Page queryAreaByPage(AreaVo areaVo) {
        // 接收页面的值
        int currentPage = areaVo.getPageNum();
        int pageNumber = areaVo.getPageSize();
        // 根据查询条件查询总条数
        int totalNumber = areaDao.count(areaVo);
        // 创建分页对象,组织分页查询参数
        Page page = new Page();
        page.setCurrentPage(currentPage);
        page.setPageNumber(pageNumber);
        page.setTotalNumber(totalNumber);
        Map<String,Object> parameter = new HashMap<String,Object>();
        parameter.put("area",areaVo);
        parameter.put("page",page);
        List<Area> areaList = areaDao.queryAreaByPage(parameter);
        page.setData(areaList);
        return page;
    }


    @Override
    public Area getAreaById(int areaId) {
//        int a = 1/0;//制造异常
        return areaDao.queryAreaById(areaId);
    }

    @Transactional//事务控制默认接收RuntimeException回滚
    @Override
    public void addArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if(effectedNum == 0){
                    throw new DemoException(ResultEnum.DATABASE_OPERATE);
                }
            }catch (Exception e){
                throw new DemoException(ResultEnum.DATABASE_OPERATE);
            }
        }else {
            throw new DemoException(ResultEnum.PARAMETER_NULL);
        }
    }

    @Override
    public void modifyArea(Area area) {
        if(area.getAreaId() != null && area.getAreaId() > 0){
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum == 0){
                    throw new DemoException(ResultEnum.DATABASE_OPERATE);
                }
            }catch (Exception e){
                throw new DemoException(ResultEnum.DATABASE_OPERATE);
            }
        }else {
            throw new DemoException(ResultEnum.PARAMETER_NULL);
        }
    }

    @Override
    public void deleteArea(int areaId) {
        if(areaId > 0){
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if(effectedNum == 0){
                    throw new DemoException(ResultEnum.DATABASE_OPERATE);
                }
            }catch (Exception e){
                throw new DemoException(ResultEnum.DATABASE_OPERATE);
            }
        }else {
            throw new DemoException(ResultEnum.PARAMETER_NULL);
        }
    }
}
