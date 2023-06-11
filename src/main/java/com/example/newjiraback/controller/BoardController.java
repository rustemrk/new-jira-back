package com.example.newjiraback.controller;

import com.example.newjiraback.dto.FilterRequestBody;
import com.example.newjiraback.dto.todo.TodoKanbanOrderDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusWithTodosDTO;
import com.example.newjiraback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/search")
    public ResponseEntity<List<TodoStatusWithTodosDTO>> search(@RequestBody FilterRequestBody params) {
        List<TodoStatusWithTodosDTO> list = boardService.search(params.getFilter());
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/save-order")
    public ResponseEntity<HttpStatus> saveOrder(@Valid @RequestBody List<TodoKanbanOrderDTO> kanbanOrderDTOList) {
        boardService.saveOrder(kanbanOrderDTOList);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}