package herbalife.callapi;

import org.testng.annotations.Test;
import herbalife.testcase.lib.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
 

public class GetToken {
	public Configuration rc = myConfigHelper.getConfig();
	
  @Test
  public void getTokenByLogin() {
	  String locale = rc.getValue("locale");
	  String username = rc.getValue("username");
	  String pwd = rc.getValue("pwd");
	  String strUrl = rc.getValue("url") + "account/api/V5/auth?dsInfo=true&volumeInfo=3";
	  
      try {
    	  MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
    	  
    	  String json="{\"data\": { \"locale\":\"" + locale + "\" ,\"memberId\":\"" + username + "\",\"password\":\"" + pwd + "\" } }";
     	 
    	  RequestBody body = RequestBody.create(mediaType, json);
    	 
    	  Request request = new Request.Builder()
    	          .url(strUrl)
    	          .addHeader("Content-Type", "application/json")
    	          .addHeader("X-HLLocale", "zh-CN")
    	          .addHeader("X-HLClientApp", "HLStore/1.0.1")
    	          .addHeader("X-HLClientOS", "ios/8.0")
    	          .addHeader("X-HLClientDevice", "iphone/1234")
    	          .addHeader("X-HLBuild", "production/03242FEA324")
    	          .post(body)
    	          .build();
    	  
    	  OkHttpClient okHttpClient = new OkHttpClient();
    	  
    	  final  MyLock myLock =  new MyLock();
    	  myLock.shouldLock=true;
    	  	  
    	  Response response =  okHttpClient.newCall(request).execute(); 
    	  
    	  if(response!=null&&response.body()!=null) {
    		  System.out.println(response.body().string());
    	  }
         
      } catch (Exception e) {
    	  System.out.println(e.getMessage());
     }
	  
  }
  
  public class MyLock{
	  public boolean shouldLock;
  }
}
