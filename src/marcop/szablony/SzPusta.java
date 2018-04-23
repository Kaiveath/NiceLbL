package marcop.szablony;
import java.io.IOException;

import marcop.ISzablon;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
// PUSTA
public class SzPusta implements ISzablon{

	int arkusz = 1;
	private int liczbaEtykiet=2;
	private String pusta1;
	private String pusta2;
	private String pusta3;
	private String pusta4;
	private String pusta5;
	private int wysokoscNapisu = 120;
	private int szerokoscNapisu = 450;
	
	
	public SzPusta(String pusta1, String pusta2, String pusta3, String pusta4, String pusta5) {
		this.pusta1=pusta1;
		this.pusta2=pusta2;
		this.pusta3=pusta3;
		this.pusta4=pusta4;
		this.pusta5=pusta5;
		
	}
	@Override
	public void wypelnijDokument(Document document) throws IOException, DocumentException {
		
		Rectangle one = new Rectangle(596, 425); 
		document.add(createTable1());
		document.setPageSize(one);
		document.setMargins(2, 2, 2, 2);
		document.newPage();
		document.add(createTable1());
	}
	@Override
	public int getLiczbaEtykiet() {
		return liczbaEtykiet;
	}
	
	@Override
	public int getArkusz() {
		return arkusz;
	}
	public  PdfPTable createTable1() throws DocumentException,
			IOException {

		PdfPTable table = new PdfPTable(4);

		table.setSpacingBefore(300);
		table.setSpacingAfter(0);
		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new int[] { 1, 0, 0, 0 });

		PdfPCell cell;
		float fntSize = 20, lineSpacing, cellHeight;
		String komPusta = ""; 	
					

		BaseFont bf = BaseFont.createFont("arial.ttf",
				BaseFont.CP1250, BaseFont.EMBEDDED);
		Font font = new Font(bf, fntSize, Font.BOLD,
				new CMYKColor(0, 0, 0, 255));


				
		// ////////////////////////////////////////////////
		// kom1B = Pe³na nazwa

		lineSpacing = 30;
		cellHeight = 80;
		Paragraph p = new Paragraph(new Phrase(lineSpacing, komPusta, font));

		cell = new PdfPCell(p);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// ////////////////////////////////////////////////
		// kom1B = Pe³na nazwa

		lineSpacing = 0;
		cellHeight = 20;
		Paragraph p2 = new Paragraph(new Phrase(lineSpacing, pusta1, font));
		cell = new PdfPCell(p2);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);
		// ////////////////////////////////////////////////
		// kom1B = Pe³na nazwa

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p3 = new Paragraph(new Phrase(lineSpacing, pusta2, font));

		cell = new PdfPCell(p3);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// //////////////////////////////////////////
		// kom2 =

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p4 = new Paragraph(new Phrase(lineSpacing, pusta3, font));

		cell = new PdfPCell(p4);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// ////////////////////////////////////////////////
		// kom3 =

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p5 = new Paragraph(new Phrase(lineSpacing, pusta4, font));

		cell = new PdfPCell(p5);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);
		
		// ////////////////////////////////////////////////
		// kom3 =

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p6 = new Paragraph(new Phrase(lineSpacing, pusta5, font));

		cell = new PdfPCell(p6);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);



		return table;

	}
	@Override
	public int getWysokoscNapisu() {
		return wysokoscNapisu;
	}
	@Override
	public int getSzerokoscNapisu() {
		return szerokoscNapisu;
	}

}