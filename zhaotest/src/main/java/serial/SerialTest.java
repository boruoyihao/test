package serial;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaolizhen on 17-3-22.
 */
public class SerialTest {
}
class Student implements Serializable{


    public static void main(String args[]) throws InterruptedException {

        String str="{\"actionId\":0,\"destination\":\"cmf.upay.fundsResultQueue\",\"destinationType\":0,\"deliveryMode\":2,\"acknowledgeMode\":1,\"transacted\":true,\"requestTime\":\"\\/Date(1533626441535)\\/\",\"requestType\":0,\"expirationTime\":0\n" +
                ",\"messageFormat\":2,\"properties\":null,\"content\":{\"paymentSeqNo\":\"20180807152032342021610670007\",\"requestNo\":null,\"returnCode\":\"0000\",\"returnMessage\":\"处理成功 交易成功\",\"fundsChannelCode\":\"ICBC60102\",\"channelPayNo\n" +
                "\":\"20162018080745790207\",\"instPayNo\":\"20162018080745790207\",\"instPayTime\":\"\\/Date(1533626441526)\\/\",\"amount\":\"1.00\",\"unityResultCode\":\"S0001\",\"unityResultMessage\":\"\",\"extension\":\"{\\\"invokerCode\\\":\\\"SUCCESS\\\",\\\"IC\n" +
                "BC_API_RETMSG\\\":\\\"success\\\",\\\"ICBC_API_TIMESTAMP\\\":\\\"2018-08-07 15:20:41\\\",\\\"invokerMsg\\\":\\\"交易成功\\\",\\\"unityResultMessage\\\":\\\"\\\",\\\"unityResultCode\\\":\\\"S0001\\\",\\\"hostRspCode\\\":\\\"00000\\\",\\\"hostRspMsg\\\":\\\"交易成功\n" +
                "\\\",\\\"instChannelSettleTime\\\":\\\"\\\",\\\"apiResultMessage\\\":\\\"交易成功\\\",\\\"fee\\\":\\\"0\\\",\\\"response\\\":\\\"{\\\\\"subInstId\\\\\":\\\\\"test_001\\\\\",\\\\\"tradeType\\\\\":\\\\\"NATIVE\\\\\",\\\\\"instId\\\\\":\\\\\"12010000000000000271\\\\\",\\\\\"tradeNo\\\\\":\n" +
                "\\\\\"2018080721001004940200633938\\\\\",\\\\\"doubtf\\\\\":\\\\\"0\\\\\",\\\\\"txDate\\\\\":\\\\\"20180807\\\\\",\\\\\"stlAmt\\\\\":\\\\\"1\\\\\",\\\\\"oriOrderNo\\\\\":\\\\\"20162018080745789999\\\\\",\\\\\"amount\\\\\":\\\\\"1\\\\\",\\\\\"resultMsg\\\\\":\\\\\"交易成功\\\\\",\\\\\"serialNo\n" +
                "\\\\\":\\\\\"0021900200494\\\\\",\\\\\"txTime\\\\\":\\\\\"152041\\\\\",\\\\\"orderNo\\\\\":\\\\\"20162018080745790207\\\\\",\\\\\"wxpay\\\\\":{\\\\\"appid\\\\\":\\\\\"2016081600254821\\\\\",\\\\\"subAppid\\\\\":\\\\\"\\\\\"},\\\\\"resultCode\\\\\":\\\\\"00000\\\\\",\\\\\"payMethod\\\\\":\\\\\"9\\\n" +
                "\\\"}\\\",\\\"channelTransTime\\\":\\\"20180807\\\",\\\"apiResultCode\\\":\\\"00000\\\",\\\"bizType\\\":\\\"B\\\",\\\"channelSettleTime\\\":\\\"2018-08-07 15:20:41:518\\\",\\\"orgiInstOrderNo\\\":\\\"20162018080745789999\\\",\\\"ICBC_API_RETCODE\\\":\\\"0\\\",\\\"se\n" +
                "ttlementId\\\":\\\"20180807152032342027021610670007\\\",\\\"instCode\\\":\\\"NOT_APPLICABLE\\\"}\"},\"referenceId\":null}";

        new ConcurrentHashMap<String,String>(10);

        Date startTime = new Date(System.currentTimeMillis() - 11 * 60 * 1000);
        Date endTime = new Date(startTime.getTime() + 10 * 60 * 1000);

        System.out.println("startTime="+startTime+",endTime="+endTime);

//        System.out.println("2018-01-09".matches("2"));

//        inputStreamUpload();

//        System.out.println(new JsonParser().parse(str));
//        System.out.println("30153362265400057401".length());

//        Map<String,String>temp=new HashMap<String,String>();
//        temp.put("dd","aa");
//        temp.put("tt","tt");
//
//        Map<String,Object> m=new HashMap<String,Object>();
//        m.put("age","dd");
//        m.put("str",JSONObject.toJSON(temp));
//        m.put("xx",JSONObject.toJSON(temp).toString());
//        System.out.println(JSONObject.toJSON(m));
//
//        String result=JSONObject.toJSONString(m);
//        new JsonParser().parse(result);
//
//        new ConcurrentHashMap<String,String>();
//        new ArrayBlockingQueue<Integer>(2);

//        System.out.println("hHevkd/ywXOAI1VM4MNVL4SWizi8qXvvBCMrV5NuHVa17DMKMrfVUaRKrsS0HtRh+xuwdN80Kz6nI6/ySpF27iv+F6MMTSpHmMssKoNi+ZB7OxKimwTZcBB539uofgTInCRewp+Uo8wmgKFnB870ufpyZ1yiV+Icpp5tu2WNfBY=".length());
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Runnalbe out");
//            }
//        };
//
//        BlockingQueue<String>queue=new SynchronousQueue<String>();
//        queue.take();
//        queue.put("zhaolizhen");
//        queue.put("rrr");
//        System.out.println(queue.take());
//
//        try {
//            Class.forName("").getClassLoader().loadClass("");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        new ConcurrentHashMap<String,String>();

//        ExecutorService executorService= Executors.newCachedThreadPool();
//        executorService.execute(runnable);
//        Future<String>ff=executorService.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
////                Thread.sleep(1000);
//                return "Hello";
//            }
//        });
//
//        try {
//            if(ff.isDone()) {
//                System.out.println(ff.get());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        FutureTask futureTask = new FutureTask(new Callable<String>() {    //创建 Callable 任务
//            @Override
//            public String call() throws Exception {
//                String result = "zhao";
//                //do something
//                return result;
//            }
//        });
//        Future<?> submit = executorService.submit(futureTask);    //提交到线程池
//        try {
//            Object result = submit.get();    //获取结果
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        int i=0;
        while(true){
            System.out.println("i="+(i++));
            if(i==3){
                throw new IllegalArgumentException("参数不合法");
            }
        }
    }


    public static void inputStreamUpload() {
        //创建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //构建POST请求   请求地址请更换为自己的。
        //1)
        HttpPost post = new HttpPost("https://api.ucashier.mipay.com/api/trade/wxpaynotify");
        InputStream inputStream = null;
        try {
            //文件路径请换成自己的
            //2)
            inputStream = new FileInputStream("/home/mi/temp");

            System.out.println("发送的字串流：");
            CloseableHttpClient httpclient = HttpClients.createDefault();
            InputStreamEntity inputEntry = new InputStreamEntity(inputStream);
            post.setEntity(inputEntry);
            CloseableHttpResponse response2 = httpclient.execute(post);
            response2.close();
            httpclient.close();

            //第一个参数为 相当于 Form表单提交的file框的name值 第二个参数就是我们要发送的InputStream对象了
            //第三个参数是文件名
            //3)
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      }
    }
