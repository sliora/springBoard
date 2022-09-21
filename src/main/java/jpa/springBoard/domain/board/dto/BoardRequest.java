package jpa.springBoard.domain.board.dto;

import jpa.springBoard.domain.board.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequest {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    //Request -> Entity 로 변환 시 사용
    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
