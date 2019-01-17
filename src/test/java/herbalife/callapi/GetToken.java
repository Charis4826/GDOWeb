package herbalife.callapi;

import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import herbalife.modules.AuthResponse;
import herbalife.testcase.lib.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetToken {
	public Configuration rc = myConfigHelper.getConfig();

	@Test
	public String getTokenByLogin() {
		String token = null;
		
		String locale = rc.getValue("locale");
		String username = rc.getValue("username");
		String pwd = rc.getValue("pwd");
		String strUrl = rc.getValue("url") + "account/api/V5/auth?dsInfo=true&volumeInfo=3";

		try {

			OkHttpClient okHttpClient = new OkHttpClient();

			MediaType mediaType = MediaType.parse("application/json;charset=utf-8");

			// 第一种：在string里面直接存储request
			/*
			 * String json="{\"data\": { \"locale\":\"" + locale + "\" ,\"memberId\":\"" +
			 * username + "\",\"password\":\"" + pwd + "\" } }"; RequestBody body =
			 * RequestBody.create(mediaType, json);
			 */

			// 第二种：通过JsonObject存储request
			JsonObject jsonObject1 = new JsonObject();
			JsonObject jsonObject2 = new JsonObject();

			jsonObject2.addProperty("locale", locale);
			jsonObject2.addProperty("memberid", username);
			jsonObject2.addProperty("password", pwd);

			jsonObject1.add("data", jsonObject2);
			RequestBody body = RequestBody.create(mediaType, jsonObject1.toString());

			Request request = new Request.Builder().url(strUrl).addHeader("Content-Type", "application/json")
					.addHeader("X-HLLocale", "zh-CN").addHeader("X-HLClientApp", "HLStore/1.0.1")
					.addHeader("X-HLClientOS", "ios/8.0").addHeader("X-HLClientDevice", "iphone/1234")
					.addHeader("X-HLBuild", "production/03242FEA324").post(body).build();

			final MyLock myLock = new MyLock();
			myLock.shouldLock = true;

			Response response = okHttpClient.newCall(request).execute();

			if (response != null && response.body() != null) {

				String test=response.body().string();
				
				Gson gson = new Gson();
				AuthResponse ar = gson.fromJson(test, AuthResponse.class);
				
				/*ObjectMapper mapper= new ObjectMapper();
				AuthResponse ar= mapper.readValue(test,  AuthResponse.class);*/				
				
				token = ar.getData().getToken();
				System.out.println("token:" + token);
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return token;
	}

	public class MyLock {
		public boolean shouldLock;
	}
}
