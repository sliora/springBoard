package jpa.springBoard.domain.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jpa.springBoard.domain.board.QBoard;
import jpa.springBoard.domain.board.dto.BoardResponse;
import jpa.springBoard.domain.board.dto.BoardSearchCondition;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

import static jpa.springBoard.domain.board.QBoard.*;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public BoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<BoardResponse> search(BoardSearchCondition condition) {
        return null;
    }
}
