package com.example.demo.dao;

import com.example.demo.bean.Area;
import com.example.demo.bean.vo.AreaVo;

import java.util.List;
import java.util.Map;

/**
 * Created by SongHao on 2018/4/17.
 */
public interface AreaDao {//Alt+Enter => Create Test(创建单元测试类)

    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Area> queryArea();

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     *
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);


    /**
     * 列出区域列表(分页)
     *
     * @return areaList
     */
    List<Area> queryAreaByPage(Map<String,Object> map);

    /**
     * 查询总数量(分页)
     * @param areaVo
     * @return
     */
    int count(AreaVo areaVo);
}
