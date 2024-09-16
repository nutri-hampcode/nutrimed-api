package com.hampcode.api;

import com.hampcode.model.entity.History;
import com.hampcode.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<List<History>> list() {
        List<History> history = historyService.findAll();
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> get(@PathVariable Integer id) {
        History history = historyService.getOne(id);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @PostMapping("/id_user")
    public ResponseEntity<History> create(@PathVariable Integer idUser) {
        History newHistory = historyService.save(idUser);
        return ResponseEntity.ok(newHistory);
    }
}
