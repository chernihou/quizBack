package com.quiz.Controller;

import com.quiz.Service.QuestionsService;
import com.quiz.Service.QuizService;
import com.quiz.entity.quiz.Questions;
import com.quiz.entity.quiz.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Questions> add(@RequestBody Questions question){
        return ResponseEntity.ok(this.questionsService.addQuestion(question));
    }
    //update question
    @PutMapping("/")
    public ResponseEntity<Questions> update(@RequestBody Questions question){
        return ResponseEntity.ok(this.questionsService.UpdateQestion(question));
    }

    //get all questions
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
        //Quiz quiz=new Quiz();
        // quiz.setQid(questionId);
        // Set<Questions> questionsOfQuiz=this.questionsService.getQuestionsOfQuiz(quiz);
       // return ResponseEntity.ok(questionsOfQuiz);
        Quiz quiz=this.quizService.getQuiz(qid);
        Set<Questions> questions=quiz.getQuestions();
        List list=new ArrayList(questions);
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

    }

    //get all questions
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid){
         Quiz quiz=new Quiz();
         quiz.setQid(qid);
         Set<Questions> questionsOfQuiz=this.questionsService.getQuestionsOfQuiz(quiz);
         return ResponseEntity.ok(questionsOfQuiz);

    }

    //get question
    @GetMapping("/{questionId}")
    public Questions question(@PathVariable("questionId") Long questionId){
        return this.questionsService.getQuestion(questionId);
    }

    //delete question
    @DeleteMapping("/{questionId}")
    public void delete(@PathVariable("questionId") Long questionId){
        this.questionsService.deleteQuestion(questionId);
    }



}
