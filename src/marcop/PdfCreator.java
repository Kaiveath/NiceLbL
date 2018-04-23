package marcop;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JPanel;

//		TO DO:
//			PARAMETRY, 
//			klasa do ścieżek!!
//		
//		
//		

public class PdfCreator {
	
	public Home home;
	public static JPanel panel;
	public static PdfWriter writer;
	public static String szablonJezyk;
	public static Wiersz wiersz2;
	public static ReadDataFromExcel readDataFromExcel;
	public static Document document;
	public static int addPage;
	public static int rodzaj;

	public static void start(String sciezkaWynikowa,
			 ISzablon szablon)	{
		try 
		{
			ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel(0, szablon.getArkusz());
			Wiersz wiersz = readDataFromExcel.pobierzWiersz(1); 								// NUMER WIERSZA
			createPdf("", wiersz, sciezkaWynikowa, szablon);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void createPdf(String dest, Wiersz wiersz,
			 String sciezkaWynikowa,
			 ISzablon szablon) throws IOException, DocumentException {
		
		Document document = new Document();
		ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel(0,szablon.getArkusz());
		wiersz = readDataFromExcel.pobierzWiersz(3);											// NUMER WIERSZA!!!
		String partia = (wiersz.getEx2C().split("\\.")[0]);
		String farba = (wiersz.getEx2B().split("\\.")[0]);
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(sciezkaWynikowa + partia + "_" + farba + ".pdf"));			// ścieżka zapisu gotowego PDFa
		Rectangle one = new Rectangle(596, 425); 												// Rozmiar etykiety 72pt (1 inch) 1cm 0,3937 inch
		document.setPageSize(one);
		document.setMargins(2, 2, 2, 2);
		document.open();
		
		int addPage = 1;
		while (addPage < szablon.getLiczbaEtykiet()) 											// ŁADOWANIE KOLEJNYCH STRON PDF
		{
			addPage++;
			szablon.wypelnijDokument(document );
			document.setPageSize(one);
			document.setMargins(2, 2, 2, 2);
			document.newPage();
		}
		document.close();
	}
}
