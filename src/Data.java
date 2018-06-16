import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

	// list for data
	ArrayList<String> data;
	String[] systemsArray;
	String[] classesArray;
	String simetry;
	String hms;
	String weiss;
	String miller;

	// constructors
	public Data() {
		loadData();
	}

	// getters
	public ArrayList<String> getData() {
		return data;
	}

	public String[] getSystemsArray() {
		return systemsArray;
	}

	// getting classes with index of system
	public String[] getClassesArray(int index) {
		String temp = data.get(index);
		String[] tempArray = temp.split("-");
		classesArray = tempArray[1].split(",");
		return classesArray;
	}

	public String getSimetry(int index) {
		String temp = data.get(index);
		String[] tempArray = temp.split("-");
		return tempArray[2];
	}

	public String getHms(int index) {
		String temp = data.get(index);
		String[] tempArray = temp.split("-");
		return tempArray[3];
	}

	public String getWeiss(int index) {
		String temp = data.get(index);
		String[] tempArray = temp.split("-");
		return tempArray[4];
	}

	public String getMiller(int index) {
		String temp = data.get(index);
		String[] tempArray = temp.split("-");
		return tempArray[5];
	}

	// loading data from file
	public void loadData() {
		data = new ArrayList<String>();

		// reading file lines to list
		try {
			Scanner file = new Scanner(new File("crystallography.txt"));

			while (file.hasNext()) {
				data.add(file.nextLine());
			}

			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		}

		// getting system names from list
		String[] temp;
		systemsArray = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			temp = data.get(i).split("-");
			systemsArray[i] = temp[0];
			temp = null;
		}
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
