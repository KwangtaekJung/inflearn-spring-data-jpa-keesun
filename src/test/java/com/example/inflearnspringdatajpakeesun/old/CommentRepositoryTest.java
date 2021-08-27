package com.example.inflearnspringdatajpakeesun.old;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {

        createComment(100, "spring data jpa");
        createComment(55, "HIBERNATE SPRING");

        List<Comment> comments = commentRepository.findByCommentContains("spring");
        assertThat(comments.size()).isEqualTo(1);

        List<Comment> comments1 = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("Spring", 60);
        assertThat(comments1.size()).isEqualTo(1);

        List<Comment> comments2 = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("spring");
        assertThat(comments2.size()).isEqualTo(2);
        assertThat(comments2).first().hasFieldOrPropertyWithValue("likeCount", 100);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));
        Page<Comment> comments3 = commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        assertThat(comments3.getNumberOfElements()).isEqualTo(2);
        assertThat(comments2).first().hasFieldOrPropertyWithValue("likeCount", 100);

        try (Stream<Comment> comments4 = commentRepository.findStreamByCommentContainsIgnoreCase("Spring", pageRequest)) {
            Comment firstComment = comments4.findFirst().get();
            assertThat(firstComment.getLikeCount()).isEqualTo(100);
        }
    }

    private void createComment(int likeCount, String description) {
        Comment comment = new Comment();
        comment.setLikeCount(likeCount);
        comment.setComment(description);
        commentRepository.save(comment);
    }
}