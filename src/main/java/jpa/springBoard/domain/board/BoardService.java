package jpa.springBoard.domain.board;

import jpa.springBoard.domain.board.dto.BoardResponse;
import jpa.springBoard.domain.board.dto.BoardSearchCondition;
import jpa.springBoard.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(Board request) {

        return boardRepository.save(request).getId();
    }

    public Page<BoardResponse> getBoardList(BoardSearchCondition condition, Pageable pageable) {
        return boardRepository.search(condition, pageable);
    }

    public Optional<BoardResponse> getBoardInfo(Long id) {
        Optional<Board> result = boardRepository.findById(id);

        //entity -> dto 변환
        return result.map(BoardResponse::new);
    }

    @Transactional
    public Long updateBoardInfo(Long id, Board request) {
        Board result = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        //변경감지
        result.update(request);

        return id;
    }

    @Transactional
    public Long deleteBoardInfo(Long id) {
        Board result = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        //변경감지
        result.delete();

        return id;
    }



}
