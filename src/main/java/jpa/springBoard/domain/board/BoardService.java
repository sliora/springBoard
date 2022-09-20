package jpa.springBoard.domain.board;

import jpa.springBoard.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

}
