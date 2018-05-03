package com.example.demo.web;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/school")
public class AreaController {
    @Autowired
    private AreaService areaService;

    // http://localhost:8082/demo/school/listarea
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }

    // http://localhost:8082/demo/school/getareabyid?areaId=1
    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    // http://localhost:8082/demo/school/addarea {"areaName": "南区","priority": 2}
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    // http://localhost:8082/demo/school/modifyarea {"areaId": 4,"areaName": "南区","priority": 3}
    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    // http://localhost:8082/demo/school/removearea?areaId=4
    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    private Map<String,Object> removeArea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }
}
