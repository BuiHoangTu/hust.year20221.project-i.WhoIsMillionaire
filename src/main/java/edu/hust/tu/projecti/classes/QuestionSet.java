package edu.hust.tu.projecti.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * A wrapper for {@link Set}<{@link Question}>, which is not very helpful.
 */
@Deprecated
public class QuestionSet {
    private final Set<Question> questionSet;


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
