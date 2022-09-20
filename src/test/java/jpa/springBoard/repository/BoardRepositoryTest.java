package jpa.springBoard.repository;

import jpa.springBoard.domain.board.repository.BoardRepository;
import jpa.springBoard.domain.board.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    void basic_test() {
        Board board = new Board("titleA", "contentA");

        boardRepository.save(board);

        Board result = boardRepository.findById(board.getId()).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));

        Assertions.assertThat(result.getId()).isEqualTo(board.getId());
    }

}