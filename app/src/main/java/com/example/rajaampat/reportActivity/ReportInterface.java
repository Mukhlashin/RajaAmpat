package com.example.rajaampat.reportActivity;

public interface ReportInterface {

    interface View{
        void setDataReport();
        void addNewReport();
    }

    interface Presenter{
        void getDataReport();
    }

}
