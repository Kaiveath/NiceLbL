package marcop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;


public class SettingGeterSetter {
	
	public static void ustawDomyslneWartosci(){
		loadPropertiesFromFile(p,Plik.DOMYSLNY);
		savePropertyToFile();
	}
	
	static Properties p=new Properties();
	public static String getProperty(String key) {
		loadPropertiesFromFile(p,Plik.ZWYKLY);
		String property =  p.getProperty(key);
		if(property==null){
			
			loadPropertiesFromFile(p,Plik.DOMYSLNY);
			property = p.getProperty(key);
		}
		return property;
	}
	
	public static void setProperty(String key, String value){
	
		p.setProperty(key, value);
		savePropertyToFile();
		
	}
	
	enum Plik {DOMYSLNY,ZWYKLY}
	private static void  loadPropertiesFromFile(Properties p, Plik plik)
	{
		FileInputStream fis=null;
		try {
			if(plik==Plik.DOMYSLNY){
				fis = new FileInputStream(new File(".//default_settings.properties"));
			}else{
				fis = new FileInputStream(new File(".//settings.properties"));
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		System.out.println("changed value for fname is "+p.getProperty("fname"));
		System.out.println("changed value for lname is "+p.getProperty("lname"));
		System.out.println("changed value for sciezkaExcela is "+p.getProperty("sciezkaExcela"));
		System.out.println("changed value for sciezkaFolderZapisu is "+p.getProperty("sciezkaFolderZapisu"));

		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	} 
	
	static void savePropertyToFile()
	{	

		FileOutputStream fos=null;
		try 
		{
			fos = new FileOutputStream(new File(".//settings.properties"));
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		try 
		{
			p.store(fos, "Properties");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		try 
		{
			fos.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
