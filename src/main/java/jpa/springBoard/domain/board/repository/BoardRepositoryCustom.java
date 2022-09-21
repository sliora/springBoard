package jpa.springBoard.domain.board.repository;

import jpa.springBoard.domain.board.dto.BoardRequest;
import jpa.springBoard.domain.board.dto.BoardResponse;
import jpa.springBoard.domain.board.dto.BoardSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepositoryCustom {
    Page<BoardResponse> search(BoardSearchCondition condition, Pageable pageable);
}
