package jpa.springBoard.domain.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import jpa.springBoard.domain.board.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponse {
    private Long id;
    private String title;
    private String content;
    private boolean deleted;

    @QueryProjection
    public BoardResponse(Long id, String title, String content, boolean deleted) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.deleted = deleted;
    }

    // Service 단에서 Entity -> Dto 변환
    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
