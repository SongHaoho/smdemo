package com.example.demo.service;

import com.example.demo.bean.Area;
import com.example.demo.bean.vo.AreaVo;
import com.example.demo.entity.Page;

import java.util.List;

public interface AreaService {
    /**
     * 获取区域列表
     *
     * @return areaList
     */
    List<Area> getAreaList();

    /**
     * 获取区域列表(分页)
     *
     * @return areaList
     */
    Page queryAreaByPage(AreaVo areaVo);

    /**
     * 通过区域Id获取区域信息
     *
     * @return area
     */
    Area getAreaById(int areaId);

    /**
     * 增加区域信息
     *
     * @param area
     * @return
     */
    void addArea(Area area);

    /**
     * 修改区域信息
     *
     * @param area
     * @return
     */
    void modifyArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    void deleteArea(int areaId);
}
