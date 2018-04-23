package marcop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//		TO DO:
//			CLEAN, PARAMETRY, WYBÓR ARKUSZA
//
//
//
//

public class ReadDataFromExcel {
	XSSFSheet sheet;
	
	//public static int nrArkusza = 1;

	public ReadDataFromExcel(int sheetNr, int arkusz) throws IOException {

		FileInputStream file = new FileInputStream(new File(Home.sciezkaBazaDanychExcel)); 							// œcie¿ka bazy danych EXCEL
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(arkusz);																				// NR ARKUSZA, START OD 0
		file.close();
	}

		
	public Wiersz pobierzWiersz(int i) {
		
		Wiersz wiersz = new Wiersz();
		Row row = (Row) sheet.getRow(i);
		
		String Ex2A;
		if (row.getCell(0) == null) 
			{
				Ex2A = "0";
			} 
		else
			{
				Ex2A = row.getCell(0).toString();
			}
		wiersz.setEx2A(Ex2A);

		String Ex2B;
		if (row.getCell(1) == null) 
			{
				Ex2B = "1";
			} 
		else 
			{
				Ex2B = row.getCell(1).toString();
			}
		wiersz.setEx2B(Ex2B);

		String Ex2C;
		if (row.getCell(2) == null) 
			{
				Ex2C = "2";
			} 
		else 
			{
				Ex2C = row.getCell(2).toString();
			}
		wiersz.setEx2C(Ex2C);

		String Ex2D;
		if (row.getCell(3) == null)
			{
				Ex2D = "3";
			}
		else 
			{
				Ex2D = row.getCell(3).toString();
			}
		wiersz.setEx2D(Ex2D);

		String Ex2E;
		if (row.getCell(4) == null)
			{
				Ex2E = "4";
			}
		else 
			{
				Ex2E = row.getCell(4).toString();
			}
		wiersz.setEx2E(Ex2E);

		String Ex2F;
		if (row.getCell(5) == null) 
			{
				Ex2F = "5";
			} 
		else 
			{
				Ex2F = row.getCell(5).toString();
			}
		wiersz.setEx2F(Ex2F);

		String Ex2G;
		if (row.getCell(6) == null) 
			{
				Ex2G = "6";
			} 
		else
			{
				Ex2G = row.getCell(6).toString();
			}
		wiersz.setEx2G(Ex2G);

		String Ex2H;
		if (row.getCell(7) == null) 
			{
				Ex2H = "7";
			} 
		else 
			{
				Ex2H = row.getCell(7).toString();
			}
		wiersz.setEx2H(Ex2H);

		String Ex2I;
		if (row.getCell(8) == null)
			{
				Ex2I = "8";
			} 
		else
			{
				Ex2I = row.getCell(8).toString();
			}
		wiersz.setEx2I(Ex2I);

		String Ex2J;
		if (row.getCell(9) == null)
			{
				Ex2J = "9";
			} 
		else 
			{
				Ex2J = row.getCell(9).toString();
			}
		wiersz.setEx2J(Ex2J);
		
		String Ex2K;
		if (row.getCell(10) == null)
			{
				Ex2K = "10";
			} 
		else 
			{
				Ex2K = row.getCell(10).toString();
			}
		wiersz.setEx2K(Ex2K);

		return wiersz;
	}
}