package jpa.springBoard.domain.board.repository;

import jpa.springBoard.domain.board.dto.BoardRequest;
import jpa.springBoard.domain.board.dto.BoardResponse;
import jpa.springBoard.domain.board.dto.BoardSearchCondition;

import java.util.List;

public interface BoardRepositoryCustom {
    List<BoardResponse> search(BoardSearchCondition condition);
}
