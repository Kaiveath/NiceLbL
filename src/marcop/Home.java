package marcop;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import com.itextpdf.text.Rectangle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


//		TO DO:
//			INTERFACE, PODGLAD
//			String obraz - za du¿o tego jest, trzeba usun¹æ
//			IF do oddzielnej klasy!!
//
//

public class Home extends JFrame {

	private JPanel contentPane;
	private static JPanel panel;
	private JTextField txtSciezkaFolderZapisuPDF;
	private JTextField txtLiczbaEtykiet;
	private JComboBox cBoxRodzajJezyka;

    
	public Wiersz wiersz;
	public String nazwa = null;
    public String szablonJezyk;
    public static String sciezkaFolderZapisuPDF;
    public static String sciezkaBazaDanychExcel;
   
    public static String fnameH;
    public static String lnameH;
    public static String sciezkaFolderZapisuH;
    public static String sciezkaExcelaH;
    public static String textLine1H;
    public static String textLine2H;
    public static String textLine3H;
    public static String textLine4H;
    public static String textLine5H;
    JTextField txtSciezkaExcela = new JTextField();
    public static String obraz;
	public static String obrazADR;
	public int value;
    public static int liczba_etykiet; 
    public static int szablonInt; 
    public static int szablonIntUklad; 
    public static int arkusz;
    private JTextField txtPusta1;
    private JTextField txtPusta2;
    private JTextField txtPusta3;
    private JTextField txtPusta4;
    private JTextField txtPusta5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					Home frame = new Home();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *  
	 */
	
	public Home() throws IOException {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1519, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(442, 92, 1036, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		

		txtSciezkaExcela.setColumns(10);
		txtSciezkaExcela.setBounds(148, 92, 266, 22);
		contentPane.add(txtSciezkaExcela);
		sciezkaBazaDanychExcel = txtSciezkaExcela.getText();
		

		JLabel lblSciezkaZapisuPDF = new JLabel("\u015Acie\u017Cka zapisu:");
		lblSciezkaZapisuPDF.setBounds(42, 127, 109, 22);
		contentPane.add(lblSciezkaZapisuPDF);
		
		JLabel lblSumaEtykiet = new JLabel("Liczba etykiet:");
		lblSumaEtykiet.setBounds(42, 162, 109, 22);
		contentPane.add(lblSumaEtykiet);
		
		txtLiczbaEtykiet = new JTextField();
		txtLiczbaEtykiet.setText("1");
		txtLiczbaEtykiet.setColumns(10);
		txtLiczbaEtykiet.setBounds(150, 162, 116, 22);
		contentPane.add(txtLiczbaEtykiet);
		
		JLabel lblPodgld = new JLabel("Podgl\u0105d");
		lblPodgld.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodgld.setFont(new Font("Tahoma", Font.PLAIN, 46));
		lblPodgld.setBounds(442, 13, 1036, 73);
		contentPane.add(lblPodgld);
		
		JLabel lblJezyk = new JLabel("J\u0119zyk:");
		lblJezyk.setBounds(42, 203, 109, 22);
		contentPane.add(lblJezyk);
		
		JLabel lblSzablon = new JLabel("Szablon:");
		lblSzablon.setBounds(42, 250, 109, 22);
		contentPane.add(lblSzablon);
		
		JLabel lblSciekaExcela = new JLabel("Wczydaj dane z:");
		lblSciekaExcela.setBounds(42, 92, 109, 22);
		contentPane.add(lblSciekaExcela);
		
		JButton btnSaveProperties = new JButton("Zapisz");
		btnSaveProperties.setBounds(317, 162, 97, 25);
		contentPane.add(btnSaveProperties);
		btnSaveProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				SettingGeterSetter.setProperty("fname", "set fname in progress");
				SettingGeterSetter.setProperty("lname", "set lname in progress");
				SettingGeterSetter.setProperty("sciezkaExcela", txtSciezkaExcela.getText());
				SettingGeterSetter.setProperty("sciezkaFolderZapisu", txtSciezkaFolderZapisuPDF.getText());
				SettingGeterSetter.setProperty("textLine1", txtPusta1.getText());
				SettingGeterSetter.setProperty("textLine2", txtPusta2.getText());
				SettingGeterSetter.setProperty("textLine3", txtPusta3.getText());
				SettingGeterSetter.setProperty("textLine4", txtPusta4.getText());
				SettingGeterSetter.setProperty("textLine5", txtPusta5.getText());

			}
		});
		txtSciezkaFolderZapisuPDF = new JTextField();
		txtSciezkaFolderZapisuPDF.setBounds(150, 127, 266, 22);
		contentPane.add(txtSciezkaFolderZapisuPDF);
		txtSciezkaFolderZapisuPDF.setColumns(10);
		
		
		cBoxRodzajJezyka = new JComboBox();
		cBoxRodzajJezyka.setBounds(150, 203, 116, 22);
		contentPane.add(cBoxRodzajJezyka);
			for(RodzajJezyka rodzaj : RodzajJezyka.values())
			{
				cBoxRodzajJezyka.addItem(rodzaj);
			}
		
		JComboBox cBoxRodzajSzablonu = new JComboBox();
		cBoxRodzajSzablonu.setBounds(150, 250, 116, 22);
		contentPane.add(cBoxRodzajSzablonu);
			for(RodzajSzablonu rodzaj : RodzajSzablonu.values())
			{
				cBoxRodzajSzablonu.addItem(rodzaj);
			}
		

		
		txtPusta1 = new JTextField();
		txtPusta1.setColumns(10);
		txtPusta1.setBounds(148, 350, 266, 25);
		contentPane.add(txtPusta1);
		
		txtPusta2 = new JTextField();
		txtPusta2.setColumns(10);
		txtPusta2.setBounds(148, 375, 266, 25);
		contentPane.add(txtPusta2);
		
		txtPusta3 = new JTextField();
		txtPusta3.setColumns(10);
		txtPusta3.setBounds(148, 400, 266, 25);
		contentPane.add(txtPusta3);
		
		txtPusta4 = new JTextField();
		txtPusta4.setColumns(10);
		txtPusta4.setBounds(148, 425, 266, 25);
		contentPane.add(txtPusta4);
		
		txtPusta5 = new JTextField();
		txtPusta5.setColumns(10);
		txtPusta5.setBounds(148, 450, 266, 25);
		contentPane.add(txtPusta5);
		

		
		JLabel lblEtykietaPusta = new JLabel("Etykieta pusta:");
		lblEtykietaPusta.setBounds(42, 351, 109, 22);
		contentPane.add(lblEtykietaPusta);
		
		
		
		JButton btnPdfMaker = new JButton("PDF Maker");
		btnPdfMaker.setBounds(317, 200, 97, 25);
		contentPane.add(btnPdfMaker);
		
		JButton btnTEST = new JButton("Default Set");
		btnTEST.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SettingGeterSetter.ustawDomyslneWartosci();
				ustawFormularzZUstawien();
			}
		});
		btnTEST.setBounds(317, 276, 97, 25);
		contentPane.add(btnTEST);
		btnPdfMaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			sciezkaFolderZapisuPDF = txtSciezkaFolderZapisuPDF.getText();
			sciezkaBazaDanychExcel = txtSciezkaExcela.getText();
			String liczba_etykietSubString = txtLiczbaEtykiet.getText();
			liczba_etykiet = Integer.valueOf(liczba_etykietSubString) + 1;
			Object objRodzajJezyka = cBoxRodzajJezyka.getSelectedItem(); 
					cBoxRodzajJezyka.setSelectedItem("PL");
					objRodzajJezyka = cBoxRodzajJezyka.getSelectedItem(); 
					cBoxRodzajJezyka.setSelectedItem("EN");
					objRodzajJezyka = cBoxRodzajJezyka.getSelectedItem(); 
					objRodzajJezyka.toString();		    
				
					RodzajJezyka jezyk = RodzajJezyka.valueOf(objRodzajJezyka.toString());
			   										 
				ISzablon szablon = FabrykaSzablonow.createSzablon(
						cBoxRodzajSzablonu.getSelectedItem().toString(),
						txtSciezkaFolderZapisuPDF.getText(), liczba_etykiet,
						jezyk, txtPusta1.getText(), txtPusta2.getText(),
						txtPusta3.getText(), txtPusta4.getText(),
						txtPusta5.getText());
	    	
			sciezkaFolderZapisuPDF = txtSciezkaFolderZapisuPDF.getText();
			sciezkaBazaDanychExcel = txtSciezkaExcela.getText();
			String obraz = sciezkaFolderZapisuPDF + "ttttt.png";
			ReadDataFromExcel readDataFromExcel = null;
				try
				{
					readDataFromExcel = new ReadDataFromExcel(0,0);
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			Wiersz wiersz = readDataFromExcel.pobierzWiersz(3);
			pokazEtykiete(wiersz, szablon.getSzerokoscNapisu(), szablon.getWysokoscNapisu());	
	    	
		    PdfCreator.addPage = 0;
			PdfCreator.start( sciezkaFolderZapisuPDF, szablon);
			
			}
			});
		
		ustawFormularzZUstawien();
		
		System.out.println(fnameH);
		System.out.println(lnameH);
		System.out.println(sciezkaFolderZapisuH);
		System.out.println(sciezkaExcelaH);
	}
	
	protected void ustawFormularzZUstawien() {
		fnameH= SettingGeterSetter.getProperty("fname");
		lnameH= SettingGeterSetter.getProperty("lname");
		sciezkaFolderZapisuH= SettingGeterSetter.getProperty("sciezkaFolderZapisu");
		sciezkaExcelaH= SettingGeterSetter.getProperty("sciezkaExcela");
		textLine1H = SettingGeterSetter.getProperty("textLine1");
		textLine2H = SettingGeterSetter.getProperty("textLine2");
		textLine3H = SettingGeterSetter.getProperty("textLine3");
		textLine4H = SettingGeterSetter.getProperty("textLine4");
		textLine5H = SettingGeterSetter.getProperty("textLine5");
		txtPusta1.setText(textLine1H);
		txtPusta2.setText(textLine2H);
		txtPusta3.setText(textLine3H);
		txtPusta4.setText(textLine4H);
		txtPusta5.setText(textLine5H);
		txtSciezkaExcela.setText(sciezkaExcelaH);
		txtSciezkaFolderZapisuPDF.setText(sciezkaFolderZapisuH); 
	}

	public void pokazEtykiete(Wiersz wiersz, int szer, int wysok ) {
		
		wiersz.getEx2A();
		int szerEtyk = 100;
		int wysEtyk = 1;
		
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        BufferedImage awtImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics gg = awtImage.getGraphics();
        panel.printAll(gg);
		BufferedImage przeskalowanyObrazek = createResizedCopy(awtImage, szerEtyk, wysEtyk, false);
		panel.getGraphics().drawImage(przeskalowanyObrazek, 0,0, panel);
		paint(wiersz.getEx2A(), panel.getGraphics(), szer, wysok);
		System.out.println(wiersz.getEx2A());															//TEST NAZWA FARBY
   	}

	static  BufferedImage createResizedCopy(Image originalImage,
                                   int scaledWidth, int scaledHeight,
                                   boolean preserveAlpha) {
		
        System.out.println("resizing...");
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
	        if (preserveAlpha)
	        {
	            g.setComposite(AlphaComposite.Src);
	        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }
      
   public void paint (String text, Graphics g, int szerokoscNapisu, int wysokoscNapisu){
	   
       String s = text;
       BufferedImage img = new BufferedImage(szerokoscNapisu, wysokoscNapisu, BufferedImage.TYPE_INT_ARGB);
       Graphics2D g2d = img.createGraphics();
       
       g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
       g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
       g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
       g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
       g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
       g2d.drawImage(createImage(s, wysokoscNapisu),0,0, szerokoscNapisu, wysokoscNapisu, null);
       g2d.dispose();
	       try 
	       {
	    	   panel.getGraphics().clearRect(0,0,panel.getX(), panel.getY());
	   		panel.getGraphics().drawImage(img, 0,0, panel) ;
	   		String obraz = sciezkaFolderZapisuPDF + "ttttt.png";
	   		System.out.println(sciezkaFolderZapisuPDF+" " +obraz);
	   		ImageIO.write(img, "png", new FileOutputStream(obraz));
	   		
	       }
	       catch (IOException ex)
	       {
	           ex.printStackTrace();
	       }
	   }

   private static BufferedImage createImage(String label, int wysokoscNapisu) {
	   
       Font font = new Font("Arial Black", Font.PLAIN, (int)(wysokoscNapisu*0.4f));
       FontRenderContext frc = new FontRenderContext(null, true, true);
       TextLayout layout = new TextLayout(label, font, frc);
       BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
       Graphics2D gg = img.createGraphics();
       gg.setFont(font);
       FontMetrics fm = gg.getFontMetrics();
       int width = fm.stringWidth(label);
       int height = fm.getHeight();
       gg.dispose();
       BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       Graphics2D g2d = (Graphics2D) bi.getGraphics();
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setColor(Color.WHITE);
       g2d.fillRect(0, 0, bi.getWidth(), bi.getHeight());
       g2d.setColor(Color.BLACK);
       layout.draw(g2d, 0, (int)(height*0.6f));
       g2d.dispose();
       return bi;
   }
}
