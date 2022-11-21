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
        return questionSet.add(question);
    }

    public boolean contain(Question question){
        return questionSet.contains(question);
    }

    public Question get(int index){
        return questionSet.toArray(Question[]::new)[index];
    }
}
