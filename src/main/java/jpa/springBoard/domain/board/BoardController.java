package jpa.springBoard.domain.board;

import jpa.springBoard.domain.board.dto.BoardRequest;
import jpa.springBoard.domain.board.dto.BoardResponse;
import jpa.springBoard.domain.board.dto.BoardSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/api/v1/board")
    public ResponseEntity<Page<BoardResponse>> list(BoardSearchCondition condition, Pageable pageable) {
        return ResponseEntity.ok(boardService.getBoardList(condition, pageable));
    }

    @GetMapping("/api/v1/board/{id}")
    public ResponseEntity<Optional<BoardResponse>> read(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardInfo(id));
    }

    @PostMapping("/api/v1/board")
    public Long save(BoardRequest request) {
        return boardService.saveBoard(request.toEntity());
    }

    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, BoardRequest boardRequest) {
        return boardService.updateBoardInfo(id, boardRequest.toEntity());
    }

    @DeleteMapping("/api/v1/board/{id}")
    public Long delete(@PathVariable Long id) {
        return boardService.deleteBoardInfo(id);
    }


}
