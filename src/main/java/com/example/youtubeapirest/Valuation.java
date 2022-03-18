package com.example.youtubeapirest;

public class Valuation {

    private int valuation;
    private String comment;

    public Valuation() {

    }

    public Valuation(int valuation, String coment) throws Exception {

        checkValuation(valuation);
        checkComment(comment);
        this.valuation = valuation;
        this.comment = coment;
    }

    private void checkValuation(int valuation) throws Exception {
       if(valuation<0||valuation>6) throw new Exception();
    }

    private void checkComment(String comment) throws Exception {
        if (comment.equals("")) throw new Exception();
    }


    public int getValuation() {
        return valuation;
    }

    public void setValuation(int valuation) throws Exception {
        checkValuation(valuation);
        this.valuation = valuation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) throws Exception {
        checkComment(comment);
        this.comment = comment;
    }
}
