package jpa.springBoard.domain.board.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpa.springBoard.domain.board.QBoard;
import jpa.springBoard.domain.board.dto.BoardResponse;
import jpa.springBoard.domain.board.dto.BoardSearchCondition;
import jpa.springBoard.domain.board.dto.QBoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

import static jpa.springBoard.domain.board.QBoard.*;

public class BoardRepositoryImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public BoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<BoardResponse> search(BoardSearchCondition condition, Pageable pageable) {
        List<BoardResponse> result = queryFactory
                .select(new QBoardResponse(
                        board.id,
                        board.title,
                        board.content,
                        board.deleted))
                .from(board)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(board.count())
                .from(board);

        return PageableExecutionUtils.getPage(result, pageable, countQuery::fetchOne);

    }
}
