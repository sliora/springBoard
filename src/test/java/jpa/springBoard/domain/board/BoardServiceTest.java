package jpa.springBoard.domain.board;

import jpa.springBoard.domain.board.dto.BoardResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void save_test() {

        //given
        Board build = Board.builder()
                .title("테스트A")
                .content("내용")
                .build();

        //when
        Long board = boardService.saveBoard(build);
        BoardResponse response = boardService.getBoardInfo(board).get();

        //then
        Assertions.assertThat(response.getId()).isEqualTo(board);
    }

}