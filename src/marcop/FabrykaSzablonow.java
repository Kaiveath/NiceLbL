package marcop;

import marcop.szablony.SzPelna;
import marcop.szablony.SzPusta;
import marcop.szablony.SzWazona1;
import marcop.szablony.SzWazona2;
import marcop.szablony.SzWazona3;
import marcop.szablony.SzWazona4;

public class FabrykaSzablonow {

	public static ISzablon createSzablon(String szablonUklad, String sciezkaFolderZapisuPDF, int liczbaEtykiet, RodzajJezyka jezyk,
			String pusta1, String pusta2, String pusta3, String pusta4, String pusta5) {
		 if(szablonUklad.equals(RodzajSzablonu.Pe³na.name()))
	    	{
			 return new SzPelna(sciezkaFolderZapisuPDF, liczbaEtykiet, jezyk);
	   
	    	}
	    else if (szablonUklad.equals(RodzajSzablonu.Podk³ad.name()))
		    {
	    	
	    	return new SzPodklad(sciezkaFolderZapisuPDF, liczbaEtykiet, jezyk);
		    }
	    else if (szablonUklad.equals(RodzajSzablonu.Wa¿ona1.name()))
		    {
	    	return new SzWazona1(jezyk);
		    }
	    else if (szablonUklad.equals(RodzajSzablonu.Wa¿ona2.name()))
	    	{
	    	return new SzWazona2(jezyk);
	    	}		    
	    else if (szablonUklad.equals(RodzajSzablonu.Wa¿ona3.name()))
	    	{
	    	return new SzWazona3(jezyk);
	    	}
	    else if (szablonUklad.equals(RodzajSzablonu.Wa¿ona4.name()))
	    	{
	    	return new SzWazona4(jezyk);
	    	}
	    else if (szablonUklad.equals(RodzajSzablonu.Pusta.name()))
	    	{
	    	return new SzPusta(pusta1, pusta2, pusta3, pusta4, pusta5);
	    	}
		 return null;
	}

}
