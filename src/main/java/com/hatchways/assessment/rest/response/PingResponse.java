package com.hatchways.assessment.rest.response;

public class PingResponse extends Response{

    private boolean success;

    public boolean getSuccess(){
        return success;
    }

    public void setSuccess(int success){
        this.success = (success == 200) ? true : false;
    }
}
