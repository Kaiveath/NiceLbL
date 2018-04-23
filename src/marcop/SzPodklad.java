package marcop;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

//PODK£AD
//			TO DO:
//				  Uk³ad
//
//
//


public class SzPodklad implements ISzablon{



private int arkusz=0;
private String obraz;
private int liczbaEtykiet;
private RodzajJezyka jezyk;
private int wysokoscNapisu = 80;
private int szerokoscNapisu = 400;

public SzPodklad(String sciezkaFolderZapisuPDF, int liczbaEtykiet, RodzajJezyka jezyk) {
	this.jezyk=jezyk;
	this.liczbaEtykiet=liczbaEtykiet;
	obraz = sciezkaFolderZapisuPDF + "ttttt.png";
	System.out.println(obraz + "   obraz!!! IF IF");
}

@Override
public void wypelnijDokument(Document document) throws IOException, DocumentException {
	
	Image img = Image.getInstance(obraz);											// £adowanie obrazu2 img tylko  do [PODK£AD]
	img.setAbsolutePosition(20, 280);
	document.add(img);
	Image img2 = Image.getInstance("rybkaResize.jpg");
	img2.setAbsolutePosition(430, 100);
	document.add(img2);
	document.add(createTable1());
	
	Rectangle rect = new Rectangle(430, 360, 550, 300);
    rect.setBorder(Rectangle.BOX);
    rect.setBorderWidth(1);
    document.add(rect);
}

@Override
public int getLiczbaEtykiet() {
	return liczbaEtykiet;
}

@Override
public int getArkusz() {
	return arkusz;
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
    table.setWidths(new int[]{14, 6, 40, 20});

    FontFactory.register("arial-black.ttf");
    
    PdfPCell cell;
    float 	fntSize1,
    		fntSize2,
			fntSize3,
			fntSize4,
    		lineSpacing,
    		cellHeight;
    
    // struktura komórek:
    String 	komPusta,
    		kom11, kom12, kom13, kom14, 
    		kom21, kom22, kom23, kom24,
    		kom31, kom32, kom33, kom34,
    		kom41, kom42, kom43, kom44,
    		kom51, kom52, kom53, kom54,
    		kom61, kom62, kom63, kom64,		
    		kom71, kom72, kom73, kom74,		 
    		kom81, kom82, kom83, kom84,
      		kom9;
    //			 pêtla opisu:
   	//	 	kom				     kom
    //		kom					 kom (...)

      		
    PdfCreator.addPage++;
    System.out.println("--  "+PdfCreator.addPage);
	ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel(0, arkusz);
	int i = 0;
	Wiersz wiersz = readDataFromExcel.pobierzWiersz(PdfCreator.addPage+2+i);
	Wiersz wiersz2 = readDataFromExcel.pobierzWiersz(jezyk.getNr());
	Wiersz wiersz3 = readDataFromExcel.pobierzWiersz(jezyk.getNr());




	komPusta = "";
	
	kom11 = "";
	kom12 = "";
	kom13 = "";
    kom14 = "UN: 3077";
    
    kom21 = "";
    kom22 = "";
    kom23 = "";
    kom24 = "9,III,(E)";
        
    kom31 = wiersz2.getEx2B();
    kom32 = (wiersz.getEx2B().split("\\.")[0]);
    kom33 = "";
    kom34 = "";
    
    kom41 = wiersz2.getEx2C(); 
    kom42 = (wiersz.getEx2C().split("\\.")[0]); 
    kom43 = "ZALECANA TEMPERATURA WYPALANIA"; 
    kom44 = wiersz3.getEx2K();
    	
    kom51 = wiersz2.getEx2I();
    kom52 = wiersz.getEx2I();
    kom53 = wiersz.getEx2E();
    kom54 = ""; 
    
    kom61 = wiersz2.getEx2D();
    kom62 = wiersz.getEx2D();
    kom63 = "";
    kom64 = "";
        			    
    kom71 = wiersz2.getEx2J();
    kom72 = (wiersz.getEx2J().split("\\.")[0]);
    kom73 = "";
    kom74 = "";
    
    kom81 = wiersz2.getEx2H();
    kom82 = wiersz.getEx2H();	
    kom83 = "";
    kom84 = "";
    
    kom9  = "";					

/////  pêtla z komórkami opisu na samym dole!!!
    

//  cell.setRowspan(1);																				// scalanie wierszy 
   
  
 //////////////////////////////////////////////// pustaKoM   
    
    fntSize1 = 10;
    fntSize2 = 10;
    fntSize3 = 17;
    fntSize4 = 17;

    
    lineSpacing = 30;
    cellHeight = 70;
    BaseFont bf = BaseFont.createFont("arial-black.ttf", 							//USTAWIENIA CZCIONKI
      		BaseFont.CP1250, BaseFont.EMBEDDED); 
    BaseFont bf2 = BaseFont.createFont("arial.ttf", 							//USTAWIENIA CZCIONKI
      		BaseFont.CP1250, BaseFont.EMBEDDED); 
      		Font font = new Font(bf, fntSize1, Font.BOLD, new CMYKColor(0, 0, 0, 255)); 
      		Font font1 = new Font(bf2, fntSize1, Font.BOLD, new CMYKColor(0, 0, 0, 255)); 
      		Font font2 = new Font(bf, fntSize2, Font.BOLD, new CMYKColor(0, 0, 0, 255)); 
      		Font font3 = new Font(bf2, fntSize3, Font.BOLD, new CMYKColor(0, 0, 0, 255)); 
      		Font font4 = new Font(bf, fntSize4, Font.BOLD, new CMYKColor(0, 0, 0, 255)); 

      		
      		

    Paragraph pP = new Paragraph(new Phrase(lineSpacing, komPusta, font));    		
    cell = new PdfPCell(pP);
    cell.setColspan(4);													// scalanie kolumn
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
////////////////////////////////////////////////////////////////////////////////////    1
    
    
    lineSpacing = 30;
    cellHeight = 25;
    Paragraph p11 = new Paragraph(new Phrase(lineSpacing, kom11, font3));    		
    cell = new PdfPCell(p11);
    cell.setColspan(1);													
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
    Paragraph p12 = new Paragraph(new Phrase(lineSpacing, kom12, font3));    		
    cell = new PdfPCell(p12);
    cell.setColspan(1);													
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
    Paragraph p13 = new Paragraph(new Phrase(lineSpacing, kom13, font3));    		
    cell = new PdfPCell(p13);
    cell.setColspan(1);													
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
    Paragraph p14 = new Paragraph(new Phrase(lineSpacing, kom14, font3));
    cell = new PdfPCell(p14);
    cell.setColspan(1);													
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(20);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
///////////////////////////////////////////////////////////////////////////////////////////////    2

    Paragraph p21 = new Paragraph(new Phrase(lineSpacing, kom21, font3));
    cell = new PdfPCell(p21);
    cell.setColspan(1);													
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);

    Paragraph p22 = new Paragraph(new Phrase(lineSpacing, kom22, font3));    		
    cell = new PdfPCell(p22);
    cell.setColspan(1);													
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
    Paragraph p23 = new Paragraph(new Phrase(lineSpacing, kom23, font3));    		
    cell = new PdfPCell(p23);
    cell.setColspan(1);													
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(0);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
    Paragraph p24 = new Paragraph(new Phrase(lineSpacing, kom24, font3));
    cell = new PdfPCell(p24);
    cell.setColspan(1);													
    cell.setFixedHeight(cellHeight);
    cell.setBorder(PdfPCell.NO_BORDER);
    cell.setPaddingLeft(20);
    cell.setPaddingRight(0);
    cell.setPaddingTop(0);
    cell.setPaddingBottom(0);
    table.addCell(cell);
    
    
    
	///////////////////////////////////////////////////////////////////////////////////////////////    3

    
    lineSpacing = 30;
    cellHeight = 35;
    Paragraph p31 = new Paragraph(new Phrase(lineSpacing, kom31, font2));    		
    cell = new PdfPCell(p31);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(20);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p32 = new Paragraph(new Phrase(lineSpacing, kom32, font1));    		
	cell = new PdfPCell(p32);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(20);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p33 = new Paragraph(new Phrase(lineSpacing, kom33, font));    		
	cell = new PdfPCell(p33);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p34 = new Paragraph(new Phrase(lineSpacing, kom34, font));
	cell = new PdfPCell(p34);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	///////////////////////////////////////////////////////////////////////////////////////////////    4
    lineSpacing = 30;
    cellHeight = 15;
    Paragraph p41 = new Paragraph(new Phrase(lineSpacing, kom41, font2));    		
    cell = new PdfPCell(p41);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p42 = new Paragraph(new Phrase(lineSpacing, kom42, font1));    		
	cell = new PdfPCell(p42);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p43 = new Paragraph(new Phrase(lineSpacing, kom43, font));    		
	cell = new PdfPCell(p43);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(30);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p44 = new Paragraph(new Phrase(lineSpacing, kom44, font4));
	cell = new PdfPCell(p44);
	cell.setRowspan(2);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	///////////////////////////////////////////////////////////////////////////////////////////////    5

    Paragraph p51 = new Paragraph(new Phrase(lineSpacing, kom51, font2));    		
    cell = new PdfPCell(p51);
	cell.setColspan(1);		
	cell.setRowspan(1);
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p52 = new Paragraph(new Phrase(lineSpacing, kom52, font1));    		
	cell = new PdfPCell(p52);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p53 = new Paragraph(new Phrase(lineSpacing, kom53, font1));    		
	cell = new PdfPCell(p53);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(70);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
//	Paragraph p54 = new Paragraph(new Phrase(lineSpacing, kom54, font));
//	cell = new PdfPCell(p54);
//	cell.setColspan(1);													
//	cell.setFixedHeight(cellHeight);
//	cell.setBorder(PdfPCell.NO_BORDER);
//	cell.setPaddingLeft(0);
//	cell.setPaddingRight(0);
//	cell.setPaddingTop(0);
//	cell.setPaddingBottom(0);
//	table.addCell(cell);

	///////////////////////////////////////////////////////////////////////////////////////////////    6

    Paragraph p61 = new Paragraph(new Phrase(lineSpacing, kom61, font2));    		
    cell = new PdfPCell(p61);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p62 = new Paragraph(new Phrase(lineSpacing, kom62, font1));    		
	cell = new PdfPCell(p62);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p63 = new Paragraph(new Phrase(lineSpacing, kom63, font2));    		
	cell = new PdfPCell(p63);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p64 = new Paragraph(new Phrase(lineSpacing, kom64, font));
	cell = new PdfPCell(p64);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	///////////////////////////////////////////////////////////////////////////////////////////////   7

    Paragraph p71 = new Paragraph(new Phrase(lineSpacing, kom71, font2));    		
    cell = new PdfPCell(p71);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p72 = new Paragraph(new Phrase(lineSpacing, kom72, font1));    		
	cell = new PdfPCell(p72);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p73 = new Paragraph(new Phrase(lineSpacing, kom73, font2));    		
	cell = new PdfPCell(p73);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p74 = new Paragraph(new Phrase(lineSpacing, kom74, font));
	cell = new PdfPCell(p74);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	///////////////////////////////////////////////////////////////////////////////////////////////    8

    Paragraph p81 = new Paragraph(new Phrase(lineSpacing, kom81, font2));    		
    cell = new PdfPCell(p81);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p82 = new Paragraph(new Phrase(lineSpacing, kom82, font1));    		
	cell = new PdfPCell(p82);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p83 = new Paragraph(new Phrase(lineSpacing, kom83, font2));    		
	cell = new PdfPCell(p83);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	Paragraph p84 = new Paragraph(new Phrase(lineSpacing, kom84, font));
	cell = new PdfPCell(p84);
	cell.setColspan(1);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);
	
	///////////////////////////////////////////////////////// 9
  
	
	cellHeight = 40;
    Paragraph p9 = new Paragraph(new Phrase(lineSpacing, kom9, font));
	cell = new PdfPCell(p9);
	cell.setColspan(4);													
	cell.setFixedHeight(cellHeight);
	cell.setBorder(PdfPCell.NO_BORDER);
	cell.setPaddingLeft(0);
	cell.setPaddingRight(0);
	cell.setPaddingTop(0);
	cell.setPaddingBottom(0);
	table.addCell(cell);

	///////////////////////////////////////////////////////// 10 - OPIS
	
    cellHeight = 12;
	
		int opis = (jezyk.getNr() * 14 + 3);
		int colspan = 3;
		for (int j = 0; j < 14; j++) {

			Wiersz row = readDataFromExcel.pobierzWiersz(opis + j);
			Paragraph pOpis = new Paragraph(new Phrase(lineSpacing, row.getEx2K(), font1));
			cell = new PdfPCell(pOpis);
			cell.setColspan(colspan);
			cell.setFixedHeight(cellHeight);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setPaddingLeft(0);
			cell.setPaddingRight(0);
			cell.setPaddingTop(0);
			cell.setPaddingBottom(0);

			table.addCell(cell);
			if (colspan == 3) {
				colspan = 1;
			} else {
				colspan = 3;
			}

		}

    return table;
     
}

}