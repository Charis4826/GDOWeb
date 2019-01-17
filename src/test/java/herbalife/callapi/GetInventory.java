package herbalife.callapi;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import herbalife.modules.Inventory;
import herbalife.testcase.lib.Configuration;
import herbalife.testcase.lib.myConfigHelper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetInventory {
	public Configuration rc = myConfigHelper.getConfig();

	@Test
	public void getInventory() {
		String locale = rc.getValue("locale");
		String username = rc.getValue("username");
		String token = rc.getValue("token");
		
		String strUrl = rc.getValue("url") + "Ordering/V6/"+ username +"/Inventory/%E5%8C%97%E4%BA%AC/%E5%8C%97%E4%BA%AC%E5%B8%82";

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
				
				System.out.println(test);
				
				/*Gson gson = new Gson();
				MobileStatisticInfo ar = gson.fromJson(test, MobileStatisticInfo.class);*/
				
				ObjectMapper mapper= new ObjectMapper();
				Inventory ar= mapper.readValue(test,  Inventory.class);
				
				String testdata = ar.getData().getProducts().get(0).getSKU();
				System.out.println(testdata);
				Assert.assertEquals("022U", testdata);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public class MyLock {
		public boolean shouldLock;
	}
}
