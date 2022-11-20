package edu.hust.tu.projecti.classes;

import java.util.ArrayList;
import java.util.List;

public class QuestionSet {
    private List<Question> questionSet;


    public QuestionSet(){
        questionSet = new ArrayList<>();
    }
    public QuestionSet(int capacity){
        questionSet = new ArrayList<>(capacity);
    }

    public boolean add(Question question){
        if(! this.contain(question)){
            questionSet.add(question);
            return true;
        }else return false;
    }

    public boolean contain(Question question){
        for(var q : questionSet){
            if(q.equals(question)) return true;
        }
        return false;
    }

    public Question get(int index){
        return questionSet.get(index);
    }
}
