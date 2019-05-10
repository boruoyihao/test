package com.callabe;

import java.util.concurrent.Callable;

/**
 * Created by zhaolizhen on 17-6-15.
 */

public class SessionCallable implements Callable<Result>{
    @Override
    public Result call() throws Exception {
        Result result=new Result();
        result.setCode("0000");
        result.setMsg("SUCCESS");
        Thread.sleep(3000);
        return result;
    }
}
