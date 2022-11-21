package edu.hust.tu.projecti.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuestionSet {
    private Set<Question> questionSet;


    public QuestionSet(){
        questionSet = new HashSet<>();
    }
    public QuestionSet(int capacity){
        questionSet = new HashSet<>(capacity);
    }

    public boolean add(Question question){
        /*if(! this.contain(question)){
            questionSet.add(question);
            return true;
        }else return false;*/
        return questionSet.add(question);
    }

    public boolean contain(Question question){
        return questionSet.contains(question);
    }

    public Question get(int index){
        return questionSet.toArray(Question[]::new)[index];
    }
}
