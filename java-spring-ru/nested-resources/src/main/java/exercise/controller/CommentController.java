package exercise.controller;

import exercise.dto.CommentDto;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    // BEGIN
    @GetMapping("/{postId}/comments")
    public Iterable<Comment> getAllComments(@PathVariable("postId") long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    public Comment getComment(@PathVariable("postId") long postId,
                              @PathVariable("commentId") long id) {

        return commentRepository.findByIdAndPostId(id, postId)
                .orElseThrow(() -> new ResourceNotFoundException("No such comment"));
    }

    @PostMapping("/{postId}/comments")
    public void createComment(@RequestBody Comment comment,
                              @PathVariable("postId") Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("No such post"));
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @PatchMapping("/{postId}/comments/{commentId}")
    public void updateComment(@PathVariable("postId") long postId,
                              @PathVariable("commentId") long commentId,
                              @RequestBody Comment comment) {

        Comment commentFromDB = commentRepository.findByIdAndPostId(commentId, postId)
                .orElseThrow(() -> new ResourceNotFoundException("No such comment"));
        commentFromDB.setContent(comment.getContent());
        commentRepository.save(comment);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable("postId") long postId,
                              @PathVariable("commentId") long commentId) {

        Comment commentFromDB = commentRepository.findByIdAndPostId(postId, commentId)
                .orElseThrow(() -> new ResourceNotFoundException("No such comment"));
        commentRepository.delete(commentFromDB);
    }
    // END
}
