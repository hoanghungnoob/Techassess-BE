package com.example.sourcebase.controller;

import com.example.sourcebase.domain.dto.reqdto.AnswerReqDto;
import com.example.sourcebase.service.IAnswerService;
import com.example.sourcebase.util.ResponseData;
import com.example.sourcebase.util.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerRestController {
    private final IAnswerService answerService;

    @GetMapping("/search")
    public ResponseEntity<?> searchAnswersByQuestionId(@RequestParam Long questionId,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size,
                                                       @RequestParam(defaultValue = "id") String sortBy,
                                                       @RequestParam(defaultValue = "true") boolean asc
    ) {
        return ResponseEntity.ok(ResponseData.builder()
                .code(SuccessCode.GET_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(answerService.getAnswersByQuestionId(questionId, page, size, sortBy, asc))
                .build()
        );
    }

    @PostMapping
    public ResponseEntity<?> addAnswer(@RequestBody AnswerReqDto answerReqDto) {
        return ResponseEntity.ok(ResponseData.builder()
                .code(SuccessCode.CREATED.getCode())
                .message(SuccessCode.CREATED.getMessage())
                .data(answerService.addAnswer(answerReqDto))
                .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnswer(@PathVariable Long id, @RequestBody AnswerReqDto answerReqDto) {
        return ResponseEntity.ok(ResponseData.builder()
                .code(SuccessCode.UPDATED.getCode())
                .message(SuccessCode.UPDATED.getMessage())
                .data(answerService.updateAnswer(id, answerReqDto))
                .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAnswers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean asc
    ) {
        return ResponseEntity.ok(ResponseData.builder()
                .code(SuccessCode.GET_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(answerService.getAllAnswers(page, size, sortBy, asc))
                .build()
        );
    }

}