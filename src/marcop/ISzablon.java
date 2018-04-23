package marcop;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;


public interface ISzablon {

	void wypelnijDokument(Document document) throws IOException, DocumentException ;

	int getLiczbaEtykiet();

	int getArkusz();

	int getWysokoscNapisu();

	int getSzerokoscNapisu();
	
	

}
