package marcop.szablony;
import java.io.IOException;
import java.net.MalformedURLException;

import marcop.ISzablon;
import marcop.PdfCreator;
import marcop.ReadDataFromExcel;
import marcop.RodzajJezyka;
import marcop.Wiersz;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

//PE£NA
public class SzPelna implements ISzablon{


//	TO DO:
//		CLEAN, PARAMETRY, UK£AD
//
//
//
//


private int arkusz=0;
private String obraz;
private int liczbaEtykiet;
private RodzajJezyka jezyk;
private int wysokoscNapisu = 80;
private int szerokoscNapisu = 550;

public SzPelna(String sciezkaFolderZapisuPDF, int liczbaEtykiet, RodzajJezyka jezyk) {
	this.liczbaEtykiet=liczbaEtykiet;
	this.jezyk=jezyk;
	obraz = sciezkaFolderZapisuPDF + "ttttt.png";
	System.out.println(obraz + "   obraz!!! IF IF");
	}

@Override
public void wypelnijDokument(Document document) throws IOException, DocumentException {
	
		Image img = Image.getInstance(obraz);											// £adowanie obrazu img tylko do [PE£NA]
		img.setAbsolutePosition(20, 280);
		document.add(img);
		document.add(createTable1());
}

@Override
public int getArkusz() {
	return arkusz;
}

@Override
public int getLiczbaEtykiet() {
	return liczbaEtykiet;
}

@Override
public int getWysokoscNapisu() {
	return wysokoscNapisu;
}
@Override
public int getSzerokoscNapisu() {
	return szerokoscNapisu;
}

public  PdfPTable createTable1() throws DocumentException, IOException {
	
    PdfPTable table = new PdfPTable(4);							// a table with 4 columns
    
    table.setSpacingBefore(300);
    table.setSpacingAfter(0);    
    table.setTotalWidth(550);
    table.setLockedWidth(true);
    table.setWidths(new int[]{10, 12, 10, 10});

//    FontFactory.register("c:\\windows\\fonts\\arial-black.ttf");

    FontFactory.register("arial-black.ttf");
    PdfPCell cell;
    float fntSize = 0,
    	fntSizeSmall = 0,
    	fntSizeMiddle = 0,
    	lineSpacing,
    	cellHeight;
    String 	kom1, 
	    	kom2,
    		kom11, 		  kom13, kom14,
	    	kom21,        kom23, kom24,
	    	kom31, kom32, kom33, kom34,
	    	kom41,        kom43, kom44,
	    	kom51, kom52, kom53, kom54;
    
    PdfCreator.addPage++;
    System.out.println("--  "+PdfCreator.addPage);
	ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel(0, arkusz);
	Wiersz wiersz = readDataFromExcel.pobierzWiersz(PdfCreator.addPage+2);
	Wiersz wiersz2 = readDataFromExcel.pobierzWiersz(jezyk.getNr());

    kom1 = "";//wiersz.getEx2A();								// EX Pe³na nazwa
    kom2 = wiersz.getEx2G();								// EX PLX/PLD
    
    kom11 = wiersz2.getEx2E();							// TEMPERATURA
    kom13 = wiersz2.getEx2B();									// KOD
    kom14 = (wiersz.getEx2B().split("\\.")[0]);								// EX KOD

    kom21 = wiersz.getEx2E();								// EX TEMPERATURA
    kom23 = wiersz2.getEx2C();										// PARTIA
    kom24 = (wiersz.getEx2C().split("\\.")[0]);								// EX PARTIA
    	
    kom31 = " ";											// 
    kom32 = " ";											// 
    kom33 = wiersz2.getEx2I();										// TERMIN
    kom34 = wiersz.getEx2I();								// EX TERMIN
    
    kom41 = wiersz2.getEx2H();								// ZAKRES
    kom43 = wiersz2.getEx2D();									// WAGA
    kom44 = wiersz.getEx2D();								// EX WAGA
    
    kom51 = wiersz.getEx2H();								// EX ZAKRES
    kom52 = " ";											// 
    kom53 = wiersz2.getEx2J();										// NUMER
    kom54 = (wiersz.getEx2J().split("\\.")[0]);								// EX NUMER
		
//    kom1 = wiersz.getEx2A();				// Pe³na nazwa
    fntSize = 27f;
    lineSpacing = 30;
    cellHeight = 120;
    Paragraph p = new Paragraph(new Phrase(lineSpacing,kom1,
    		FontFactory.getFont("Arial-Black", fntSize, Font.BOLD, new CMYKColor(0, 0, 0, 255))));
    cell = new PdfPCell(p);
    cell.setColspan(4);													// scalanie kolumn
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(70);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
 //   kom2 = "FARBA PROSZKOWA POLIESTROWA";				// Opis
    fntSize = 25;
    fntSizeSmall = 14;
    fntSizeMiddle = 14;
    lineSpacing = 30;
    cellHeight = 50;
    BaseFont bf = BaseFont.createFont("arial-black.ttf", 							//USTAWIENIA CZCIONKI
      		BaseFont.CP1250, BaseFont.EMBEDDED); 
    BaseFont bf2 = BaseFont.createFont("arial.ttf", 							//USTAWIENIA CZCIONKI
      		BaseFont.CP1250, BaseFont.EMBEDDED);
      		Font font = new Font(bf, fntSize, Font.NORMAL, new CMYKColor(0, 0, 0, 255)); 
      		Font font2 = new Font(bf2, fntSizeSmall, Font.NORMAL, new CMYKColor(0, 0, 0, 255));
      		Font font3 = new Font(bf, fntSizeMiddle, Font.NORMAL, new CMYKColor(0, 0, 0, 255));
      		
    Paragraph p2 = new Paragraph(new Phrase(lineSpacing,kom2,font));
    cell = new PdfPCell(p2);
    cell.setColspan(4);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(10);
    cell.setPaddingBottom(10);
    table.addCell(cell);

    
    
    fntSize = 27f;
    lineSpacing = 30;
    cellHeight = 10;
    Paragraph pp = new Paragraph(new Phrase(lineSpacing,kom1,
    		FontFactory.getFont("Arial-Black", fntSize, Font.BOLD, new CMYKColor(0, 0, 0, 255))));
    cell = new PdfPCell(pp);
    cell.setColspan(4);													// scalanie kolumn
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(70);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
    
 																			// scalanie wierszy 

//    kom11 = "ZALECANA TEMPERATURA UTWARDZANIA";		Opis
    fntSize = 14;
    lineSpacing = 30;
    cellHeight = 30;
    Paragraph p11 = new Paragraph(new Phrase(lineSpacing,kom11,font3));
    cell = new PdfPCell(p11);
    cell.setColspan(2);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

    
    

    
    fntSize = 14;
    lineSpacing = 30;
    cellHeight = 30;
    
    cell.setColspan(1);												

//    kom13 = "KOD: ";				// Opis
    Paragraph p13 = new Paragraph(new Phrase(lineSpacing,kom13,font3));
    cell = new PdfPCell(p13);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
 //   kom14 = "400307";				// Opis
    Paragraph p14 = new Paragraph(new Phrase(lineSpacing,kom14,font2));
    cell = new PdfPCell(p14);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

    

//    kom21 = "15 MINUT 180 C";				// Opis
    Paragraph p21 = new Paragraph(new Phrase(lineSpacing,kom21,font2));
    cell = new PdfPCell(p21);
    cell.setColspan(2);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    

 
//    kom23 = "PARTIA: ";				// Opis
 
    Paragraph p23 = new Paragraph(new Phrase(lineSpacing,kom23,font3));

    cell = new PdfPCell(p23);
    cell.setColspan(1);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

//    kom24 = "1100";				// Opis
    Paragraph p24 = new Paragraph(new Phrase(lineSpacing,kom24,font2));
    cell = new PdfPCell(p24);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

//    kom31 = " ";				// Opis
    Paragraph p31 = new Paragraph(new Phrase(lineSpacing,kom31,font3));
    cell = new PdfPCell(p31);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
  
//    kom32 = " ";				// Opis
    Paragraph p32 = new Paragraph(new Phrase(lineSpacing,kom32,font2));
    cell = new PdfPCell(p32);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

//    kom33 = "TERMIN PRZYDATNOŒCI:";				// Opis
    Paragraph p33 = new Paragraph(new Phrase(lineSpacing,kom33,font3));
    cell = new PdfPCell(p33);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
//    kom34 = "04/2017";				// Opis
    Paragraph p34 = new Paragraph(new Phrase(lineSpacing,kom34,font2));
    cell = new PdfPCell(p34);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

//   kom41 = "ZAKRES PO£YSKU: ";				// Opis
    Paragraph p41 = new Paragraph(new Phrase(lineSpacing,kom41,font3));
    cell = new PdfPCell(p41);
    cell.setColspan(2);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
       
 //   kom43 = "OPAKOWANIE: ";				// Opis
    Paragraph p43 = new Paragraph(new Phrase(lineSpacing,kom43,font3));
    cell = new PdfPCell(p43);
    cell.setColspan(1);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

//    kom44 = "20 KG";				// Opis
    Paragraph p44 = new Paragraph(new Phrase(lineSpacing,kom44,font2));
    cell = new PdfPCell(p44);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
//    kom51 = "75-85%";				// Opis
    Paragraph p51 = new Paragraph(new Phrase(lineSpacing,kom51,font2));
    cell = new PdfPCell(p51);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

//    kom52 = " ";				// Opis
    Paragraph p52 = new Paragraph(new Phrase(lineSpacing,kom52,font2));
    cell = new PdfPCell(p52);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
 
//    kom53 = "NUMER: ";				// Opis
    Paragraph p53 = new Paragraph(new Phrase(lineSpacing,kom53,font3));
    cell = new PdfPCell(p53);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

//    kom54 = "54";				// Opis
    Paragraph p54 = new Paragraph(new Phrase(lineSpacing,kom54,font2));
    cell = new PdfPCell(p54);
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

    return table;
     
}


}