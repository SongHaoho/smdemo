package com.example.demo.dao;

import com.example.demo.bean.Area;
import com.example.demo.bean.vo.AreaVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;//idea可能会报找不到实现类的错

    @Test
    public void queryArea() throws Exception {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() throws Exception {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东区",area.getAreaName());
    }

    @Test
    public void insertArea() throws Exception {
        Area area = new Area();
        area.setAreaName("南区");
        area.setPriority(1);
        // 返回影响的行数
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateArea() throws Exception {
        Area area = new Area();
        area.setAreaName("西区");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteArea() throws Exception {
        int effectedNum = areaDao.deleteArea(3);
        assertEquals(1,effectedNum);
    }

    @Test
    public void queryAreaByPage() {
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("dbIndex",0);
            map.put("dbNumber",4);
            List<Area> areaList = areaDao.queryAreaByPage(map);
            for(Area ui:areaList){
                System.out.println(ui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void count() {
        AreaVo area = new AreaVo();
        area.setActive("0");
        int i = areaDao.count(area);
        System.out.println(i);
    }
}