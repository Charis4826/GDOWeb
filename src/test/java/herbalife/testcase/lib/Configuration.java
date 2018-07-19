package herbalife.testcase.lib;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.util.Properties;


public class Configuration {
	
	public static String filePath="";
	 private Properties propertie; 
     private FileInputStream inputFile; 
     private FileOutputStream outputFile;
     
     /*@Parameters("env")
     public static String getFilePath(String env) {   
    	 if (env.equalsIgnoreCase("stage")||env.equalsIgnoreCase("prod")) {
    		filePath= Configuration.class.getResource("/"+env+".properties").getPath().substring(1);			
		}    	 
    	 else {
			System.out.println("测试环境配置错误：" + env);
		} 
		return filePath;		 
	}*/
	
	 public static String getFilePath() {       	 
		String userDir = System.getProperty("user.dir");  
		System.out.print(userDir);
    	filePath=userDir+"/herbalife.properties";     			
    	//System.out.println(filePath);  
		return filePath;		 
	}
     
     /** *//** 
      * 初始化Configuration类 
      */ 
     public Configuration() 
     { 
         propertie = new Properties(); 
     } 
     /** *//** 
      * 初始化Configuration类 
      * @param filePath 要读取的配置文件的路径+名称 
      */ 
     public Configuration(String filePath) 
     { 
         propertie = new Properties(); 
         try { 
             inputFile = new FileInputStream(filePath); 
             propertie.load(inputFile); 
             inputFile.close(); 
         } catch (FileNotFoundException ex) { 
             System.out.println("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在"); 
             ex.printStackTrace(); 
         } catch (IOException ex) { 
             System.out.println("装载文件--->失败!"); 
             ex.printStackTrace(); 
         } 
     }//end ReadConfigInfo(...) 
     
     /** *//** 
      * 重载函数，得到key的值 
      * @param key 取得其值的键 
      * @return key的值 
      */ 
     public String getValue(String key) 
     { 
         if(propertie.containsKey(key)) { 
             String value = propertie.getProperty(key);//得到某一属性的值 
             return value; 
         } 
         else 
             return ""; 
     }//end getValue(...) 
     /** *//** 
      * 重载函数，得到key的值 
      * @param fileName properties文件的路径+文件名 
      * @param key 取得其值的键 
      * @return key的值 
      */ 
     public String getValue(String fileName, String key) 
     { 
         try { 
             String value = ""; 
             inputFile = new FileInputStream(fileName); 
             propertie.load(inputFile); 
             inputFile.close(); 
             if(propertie.containsKey(key)){ 
                 value = propertie.getProperty(key); 
                 return value; 
             }else 
                 return value; 
         } catch (FileNotFoundException e) { 
             e.printStackTrace(); 
             return ""; 
         } catch (IOException e) { 
             e.printStackTrace(); 
             return ""; 
         } catch (Exception ex) { 
             ex.printStackTrace(); 
             return ""; 
         } 
     }//end getValue(...) 
     
     /** *//** 
      * 清除properties文件中所有的key和其值 
      */ 
     public void clear() 
     	{ 
         propertie.clear(); 
     }//end clear(); 
     
     /** *//** 
      * 改变或添加一个key的值，当key存在于properties文件中时该key的值被value所代替， 
      * 当key不存在时，该key的值是value 
      * @param key 要存入的键 
      * @param value 要存入的值 
      */ 
/*     @Parameters("env")
     public void setValue(String key, String value, String env) 
 		{ 
         propertie.setProperty(key, value); 
         saveFile(Configuration.getFilePath(env), "Update RequestID");
     }//end setValue(...) 
*/  
     public void setValue(String key, String value) 
		{ 
      propertie.setProperty(key, value); 
      saveFile(Configuration.getFilePath(), "Update RequestID");
  }//end setValue(...) 
     /** *//** 
      * 将更改后的文件数据存入指定的文件中，该文件可以事先不存在。 
      * @param fileName 文件路径+文件名称 
      * @param description 对该文件的描述 
      */ 
     public void saveFile(String fileName, String description) 
     	{ 
         try  { 
             outputFile = new FileOutputStream(fileName); 
             propertie.store(outputFile, description); 
             outputFile.close(); 
         } catch (FileNotFoundException e)  { 
             e.printStackTrace(); 
         } catch (IOException ioe) { 
             ioe.printStackTrace(); 
         } 
     }//end saveFile(...) 

     //@Parameters("env")
    public static void main(String[] args)
     {
    	System.out.println(Configuration.class.getResource(""));
    	System.out.println(Configuration.class.getResource("/"));
    	System.out.println(Configuration.class.getResource("herbalife.properties"));
      Configuration rc = new Configuration(Configuration.getFilePath());
      String url = rc.getValue("url");//以下读取properties文件的值      
      System.out.println(url);//以下输出properties读出的值      
  }
}
