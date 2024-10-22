package com.dataservice.service;

import com.dataservice.model.Map;
import com.dataservice.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;

@Service
public class MapService {
    @Autowired
    private MapRepository mapRepository;

    public List<Map> getAllMaps() {
        return mapRepository.findAll();
    }

    public Optional<Map> getMapById(Long id) {
        return mapRepository.findById(id);
    }

    public Map saveMap(Map map) {
        return mapRepository.save(map);
    }

    public void deleteMap(Long id) {
        mapRepository.deleteById(id);
    }
}
