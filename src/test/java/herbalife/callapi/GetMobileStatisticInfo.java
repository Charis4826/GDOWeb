package herbalife.callapi;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import herbalife.modules.MobileStatisticInfo;
import herbalife.testcase.lib.Configuration;
import herbalife.testcase.lib.myConfigHelper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetMobileStatisticInfo {
	public Configuration rc = myConfigHelper.getConfig();

	@Test
	public void getMobileStatisticInfo() {
		String locale = rc.getValue("locale");
		String username = rc.getValue("username");
		String token = rc.getValue("token");
		
		String strUrl = rc.getValue("url") + "Ordering/V6/"+ username +"/MobileStatisticInfo";

		try {

			OkHttpClient okHttpClient = new OkHttpClient();

			MediaType mediaType = MediaType.parse("application/json;charset=utf-8");

			Request request = new Request.Builder().url(strUrl)
					.addHeader("Content-Type", "application/json")
					.addHeader("X-HLLocale", locale)
					.addHeader("X-HLUSER-TOKEN", token)
					.addHeader("X-HLClient", "IKIOSk").get().build();

			final MyLock myLock = new MyLock();
			myLock.shouldLock = true;

			Response response = okHttpClient.newCall(request).execute();

			if (response != null && response.body() != null) {

				String test=response.body().string();
				
			/*	Gson gson = new Gson();
				MobileStatisticInfo ar = gson.fromJson(test, MobileStatisticInfo.class);
				*/
				ObjectMapper mapper= new ObjectMapper();
				MobileStatisticInfo ar= mapper.readValue(test,  MobileStatisticInfo.class);
				
				System.out.println(ar.getData().getUserCountInfo().getFavoriteCount());
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public class MyLock {
		public boolean shouldLock;
	}
	

}
