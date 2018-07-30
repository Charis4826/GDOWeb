package herbalife.testcase.lib;

public class myConfigHelper {
	private static  Configuration mComfiguration ;
	
	public static Configuration getConfig() {
		if(mComfiguration==null) {
			mComfiguration= new Configuration(Configuration.getFilePath());
		}
		
		return mComfiguration;
	}
	
	

}
