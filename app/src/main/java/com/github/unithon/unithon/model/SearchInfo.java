package com.github.unithon.unithon.model;

public class SearchInfo {
    String model_Bookname;
    String model_Writer;
    int model_Code;

    public SearchInfo(String Bookname, String Writer, int Code) {
        this.model_Bookname = Bookname;
        this.model_Writer = Writer;
        this.model_Code = Code;
    }

    public String getModel_Bookname() {
        return model_Bookname;
    }

    public void setModel_Bookname(String model_Bookname) {
        this.model_Bookname = model_Bookname;
    }

    public String getModel_Writer() {
        return model_Writer;
    }

    public void setModel_Writer(String model_Writer) {
        this.model_Writer = model_Writer;
    }

    public int getMode_Code() {
        return model_Code;
    }

    public void setMode_Code(int mode_Code) {
        this.model_Code = mode_Code;
    }
}
