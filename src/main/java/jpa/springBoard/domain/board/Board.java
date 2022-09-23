package jpa.springBoard.domain.board;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private boolean deleted;

    @Builder
    public Board(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void update(final Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    }

    public void delete() {
        this.deleted = true;
    }
}
