package com.example.newjiraback.service.impl;

import com.example.newjiraback.dto.mapper.TodoMapper;
import com.example.newjiraback.dto.mapper.TodoStatusMapper;
import com.example.newjiraback.dto.todo.TodoKanbanOrderDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusWithTodosDTO;
import com.example.newjiraback.model.Todo;
import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.repository.BoardRepository;
import com.example.newjiraback.repository.TodoStatusRepository;
import com.example.newjiraback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class BoardServiceImpl implements BoardService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private TodoStatusRepository todoStatusRepository;

    @Override
    public List<TodoStatusWithTodosDTO> search(Map<String, Object> filter) {
        List<TodoStatus> todoStatuses = todoStatusRepository.findAll();
        List<TodoStatusWithTodosDTO> statusWithTodoDTOsList = new ArrayList<>();

        String from = "from Todo";
        String where = "\n where 1 = 1";
        String typeCond = "";
        String statusCond = "";
        String orderBy = "\n order by kanban_order nulls first";

        for (TodoStatus status : todoStatuses) {
            List todoDTOS;
            StringBuilder query = new StringBuilder(from + where);
            statusCond = "\n and status = " + status.getId();


            if (filter != null && !filter.isEmpty()) {
                if (filter.containsKey("todoTypes") && ((List<Integer>) filter.get("todoTypes")).size() > 0) {
                    String types = ((List<Integer>) filter.get("todoTypes")).stream()
                            .map(String::valueOf)
                            .reduce((a, b) -> a + ", " + b)
                            .orElse("");

                    typeCond = "\n and type in (" + types + ")";
                }
            }

            query.append(typeCond);
            query.append(statusCond);
            query.append(orderBy);

            todoDTOS = em.createQuery(String.valueOf(query), Todo.class).getResultList()
                    .stream()
                    .map(TodoMapper.INSTANCE::toDTO).toList();

            TodoStatusWithTodosDTO statusWithTodosDTO = TodoStatusMapper.INSTANCE.toDTOWithTodos(status);
            statusWithTodosDTO.setTodos(todoDTOS);
            statusWithTodoDTOsList.add(statusWithTodosDTO);
        }

        return statusWithTodoDTOsList;
    }

    @Override
    public void saveOrder(List<TodoKanbanOrderDTO> kanbanOrderDTOList) {
        kanbanOrderDTOList.forEach(element -> {
            long todoId = element.getTodoId();
            long statusId = element.getStatusId();
            long kanbanOrder = element.getKanbanOrder() + 1;

            boardRepository.saveOrder(todoId, statusId, kanbanOrder);
        });
    }
}
