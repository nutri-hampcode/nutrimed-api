package com.hampcode.service.impl;

import com.hampcode.model.entity.History;
import com.hampcode.repository.HistoryRepository;
import com.hampcode.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Transactional(readOnly = true)
    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public History getOne(Integer id) {
        return historyRepository.findById(id).
                orElseThrow(() -> new RuntimeException("History not found with id: " + id));
    }

    @Transactional
    @Override
    public History save(Integer id){
        return historyRepository.save(getOne(id));
    }
}
