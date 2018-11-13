import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

// constructor for frame
public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * @author Mertcan Kirtay
	 * 
	 */

	// declaring GUI elements
	private JPanel left;
	private JPanel right;
	private JLabel skech;
	private JLabel model;
	private JComboBox<String> systems;
	private JComboBox<String> classes;
	private JButton showSkech;
	private JButton showModel;
	private JButton showPyk;
	private JButton showCreated;
	private JLabel firstHeader;
	private JLabel simetries;
	private JLabel secondHeader;
	private JLabel hms;
	private JLabel thirdHeader;
	private JLabel weiss;
	private JLabel fourthHeader;
	private JLabel miller;
	private JLabel counterForSkechs;
	private int skechCounter = 0;
	private int modelCounter = 0;

	public Main() {

		skech = new JLabel();

		Data data = new Data();

		// creating unique border for panels
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

		// setting left panel
		left = new JPanel();
		left.setLayout(null);
		left.setBorder(border);
		left.setSize(350, 750);
		add(left);

		// setting first dropbox
		systems = new JComboBox<String>(data.getSystemsArray());
		systems.setVisible(true);
		systems.setSize(240, 20);
		systems.setLocation(10, 10);
		systems.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = systems.getSelectedIndex();
				String[] newList = data.getClassesArray(index);

				classes.removeAllItems();

				for (int i = 0; i < newList.length; i++) {
					classes.insertItemAt(newList[i], i);
				}

				classes.setSelectedIndex(0);
			}
		});
		left.add(systems);

		// setting second dropbox
		classes = new JComboBox<String>(data.getClassesArray(0));
		classes.setVisible(true);
		classes.setSize(240, 20);
		classes.setLocation(10, 40);
		classes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				simetries.setText(data.getSimetry(systems.getSelectedIndex()));
				hms.setText(data.getHms(systems.getSelectedIndex()));
				weiss.setText(data.getWeiss(systems.getSelectedIndex()));
				miller.setText(data.getMiller(systems.getSelectedIndex()));

				skechCounter = 0;
				modelCounter = 0;

				counterForSkechs.setText("Count!");

			}
		});
		left.add(classes);

		// setting show button
		showSkech = new JButton("Skech");
		showSkech.setVisible(true);
		showSkech.setSize(90, 55);
		showSkech.setLocation(10, 70);
		showSkech.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				skechCounter++;

				String skechPath = "images/" + classes.getSelectedItem().toString() + "/" + skechCounter + ".png";
				skech.setIcon(new ImageIcon(skechPath));
				right.add(skech);

				counterForSkechs.setText(skechCounter + "");
				setSize(801, 750);

			}

		});

		skechCounter = 0;

		left.add(showSkech);

		// setting other show button
		showModel = new JButton("Model");
		showModel.setVisible(true);
		showModel.setSize(90, 55);
		showModel.setLocation(120, 70);
		showModel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modelCounter++;

				String modelPath = "images/" + classes.getSelectedItem().toString() + "_Model/" + modelCounter + ".png";

				new Model(modelPath, classes.getSelectedItem().toString(), modelCounter);

			}
		});
		left.add(showModel);

		// setting first header
		firstHeader = new JLabel("Simetri Unsurları");
		firstHeader.setFont(new Font("Serif", Font.BOLD, 25));
		firstHeader.setForeground(Color.RED);
		firstHeader.setVisible(true);
		firstHeader.setSize(180, 40);
		firstHeader.setLocation(30, 160);
		left.add(firstHeader);

		// setting first label
		simetries = new JLabel(data.getSimetry(0));
		simetries.setFont(new Font("Serif", Font.BOLD, 20));
		simetries.setVisible(true);
		simetries.setSize(350, 25);
		simetries.setLocation(30, 200);
		left.add(simetries);

		// setting second header
		secondHeader = new JLabel("Hermann Mauguin Sembolü");
		secondHeader.setFont(new Font("Serif", Font.BOLD, 25));
		secondHeader.setForeground(Color.RED);
		secondHeader.setVisible(true);
		secondHeader.setSize(300, 40);
		secondHeader.setLocation(30, 240);
		left.add(secondHeader);

		// setting second label
		hms = new JLabel(data.getHms(0));
		hms.setFont(new Font("Serif", Font.BOLD, 20));
		hms.setVisible(true);
		hms.setSize(350, 25);
		hms.setLocation(30, 280);
		left.add(hms);

		// setting third header
		thirdHeader = new JLabel("Weiss Rumuzu");
		thirdHeader.setFont(new Font("Serif", Font.BOLD, 25));
		thirdHeader.setForeground(Color.RED);
		thirdHeader.setVisible(true);
		thirdHeader.setSize(300, 40);
		thirdHeader.setLocation(30, 320);
		left.add(thirdHeader);

		// setting third label
		weiss = new JLabel(data.getWeiss(0));
		weiss.setFont(new Font("Serif", Font.BOLD, 20));
		weiss.setVisible(true);
		weiss.setSize(350, 25);
		weiss.setLocation(30, 360);
		left.add(weiss);

		// setting fourth header
		fourthHeader = new JLabel("Miller Rumuzu");
		fourthHeader.setFont(new Font("Serif", Font.BOLD, 25));
		fourthHeader.setForeground(Color.RED);
		fourthHeader.setVisible(true);
		fourthHeader.setSize(300, 40);
		fourthHeader.setLocation(30, 400);
		left.add(fourthHeader);

		// setting fourth label
		miller = new JLabel(data.getMiller(0));
		miller.setFont(new Font("Serif", Font.BOLD, 20));
		miller.setVisible(true);
		miller.setSize(350, 25);
		miller.setLocation(30, 440);
		left.add(miller);

		// setting bottom first button
		showPyk = new JButton("Projeksiyon Yapma Kuralları");
		showPyk.setVisible(true);
		showPyk.setSize(250, 30);
		showPyk.setLocation(40, 600);
		showPyk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, String.format("PROJEKSİYON YAPMA KURALLARI\n\n\r\n"
						+ "Kristallerde bulunan yüzeylerin bulunduğu yerleri şematik bir şekilde göstermek için kristal yüzeyleri\n (ki noktalarla gösterilir) yerine kristallerin yönleri esas alınır. Yüzeylere indirilen veya yüzeylerden\n çıkarılan dikler esas alınır) \n\r\n"
						+ "Projeksiyonu çıkarılmak istenen kristalin genel kurallara göre a ekseni önde, b ekseni yanda c ekseni \nonlara dik olarak kürenin içine yerleştirildiği ve küre merkezinden kristal yüzeylerine dikler\n çıkarıldığı düşünülür bu uzanan diklerin küre yüzeyini delip çıktığı noktalar kristal yüzeylerini\n oluşturur. Bu durum kristal yüzeylerinin bulunduğu durumu gösterir. Diklerin küre yüzeyinde\n yaptıkları ya da oluşturduğu noktalara (kristal yüzeyleridir) yüzey kutupları denir.\n\r\n"
						+ "Küredeki kristal bir düzlem üzerinde gösterilmelidir. (Kürenin merkezinden hayali bir düzlemin geçtiği\n\r\n"
						+ "düşünülerek = projeksiyon düzlemi) bu projeksiyon düzlemine kürede bulunan bütün yüzey kutupları \r\n"
						+ "(kristal yüzeyleri) projeksiyon edilir. Ekvator düzlemi projeksiyon düzlemi olarak kullanılabilir.  \r\n"
						+ "Projeksiyon düzlemine dik olan bütün yüzeylerin kutupları bu temel daire üzerinde bulunur. Kürenin \r\n"
						+ "kuzey yarısı için güney kutupta ve güney yarısı içinde kuzeyden bakarak projeksiyon düzlemine yüzey \r\n"
						+ "kutupları projekte edilir ve elde edilen noktalar yüzeylerin projeksiyon noktaları olur. \n\r\n"
						+ "\r\n"
						+ "Dip Not: Projeksiyon düzlemine dik olan yüzeyler daima projeksiyon çemberinin üzerinde,  \r\n"
						+ "Projeksiyon düzlemine paralel olan yüzeyler merkezde, Projeksiyon düzlemine eğik olan yüzeyler ise \r\n"
						+ "çember ile merkez arasında yer alır. \n\r\n" + "\r\n" + "PROJEKSİYON SIRASI\n\r\n"
						+ "1)Verilen kristal şeklin sistemi bulunur. (Eksenler arası açı, uzunluk, eksen sayısı.) \n\r\n"
						+ "2)Verilen kristal şeklin simetri unsurları bulunur. (Simetri merkezi, ekseni, düzlemi) \n\r\n"
						+ "3)Simetri unsurlarına bakarak kristal şeklin sınıfı belirlenir. \n\r\n"
						+ "4)Yüzeyleri rumuzlanır. (Basit-bileşik) \n\r\n" + "5)Şeklin projeksiyonu çizilir. \n\r\n"
						+ "6)Yüzeyler projeksiyon üzerinde gösterilir. \n\r\n" + "7)Yüzeylerin rumuzu yazılır. \n\r\n"
						+ "8)Şekil basit şekil ise ismi yazılır. Birleşik şekil ise isim verilmez “birleşik şekil” denir \n bırakılır.\r\n"
						+ "", showPyk.getActionCommand()));

			}
		});
		left.add(showPyk);

		// setting bottom second button
		showCreated = new JButton("Created By");
		showCreated.setVisible(true);
		showCreated.setSize(250, 30);
		showCreated.setLocation(40, 645);
		showCreated.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null,
						String.format(
								"Created By:\n\r\n" + "\r\n" + "Idea and Content by Yiğitcan DERYA\r\n"
										+ "Developed by Mertcan KIRTAY\r\n" + "Desinged by Özge ÇAKIR",
								showCreated.getActionCommand()));

			}
		});
		left.add(showCreated);

		// setting right panel
		right = new JPanel();
		right.setLayout(new GridLayout(2, 1));
		right.setBorder(border);
		right.setSize(650, 750);
		right.setLocation(350, 0);
		add(right);

		// setting counter label
		counterForSkechs = new JLabel("Count!", SwingConstants.CENTER);
		counterForSkechs.setFont(new Font("Serif", Font.BOLD, 50));
		counterForSkechs.setVisible(true);
		right.add(counterForSkechs);

		// setting frame
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 750);
		setLocation(50, 50);
		setTitle("Crystallography");

	}

	// main trigger method
	public static void main(String[] args) {
		new Main();
	}

}
