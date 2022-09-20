package jpa.springBoard.domain.board.dto;

import lombok.Getter;

@Getter
public class BoardSearchCondition {
    private String title;
    private String content;
    private String username;
}
