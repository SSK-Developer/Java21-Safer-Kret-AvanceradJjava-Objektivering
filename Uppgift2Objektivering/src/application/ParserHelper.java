package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParserHelper {

	public static ArrayList<RowReaderBean> CSVrows = new ArrayList<>();
	public static ArrayList<RowReaderBean> JSONrows = new ArrayList<>();

	public ParserHelper() {

	}

	public void CSVmode() throws FileNotFoundException {

		try (BufferedReader br = new BufferedReader(new FileReader("src/sample.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",", 8);
				addCSVRow(new RowReaderBean(values[0], values[1], values[2], values[3], values[4], values[5], values[6],
						values[7]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CSVrows.remove(0);
		for (var item : CSVrows) {
			String num1 = item.getUnits();
			String num2 = item.getUnitCost().replace(".00", "");
			item.setUnitCost(num2);

			float f1 = Float.valueOf(num1);
			float f2 = Float.valueOf(num2);
			float tot = f1 * f2;

			item.setTotal(String.valueOf(tot));

		}
	}

	public void JSONmode() {

		JSONParser parser = new JSONParser();

		try {
			JSONArray a = (JSONArray) parser.parse(new FileReader("src/sample.json"));

			for (Object o : a) {

				String[] values = new String[8];

				JSONObject entry = (JSONObject) o;

				String OrderDate = (String) entry.get("OrderDate");
				values[0] = OrderDate;

				String Region = (String) entry.get("Region");
				values[1] = Region;

				String Rep1 = (String) entry.get("Rep1");
				values[2] = Rep1;

				String Rep2 = (String) entry.get("Rep2");
				values[3] = Rep2;

				String Item = (String) entry.get("Item");
				values[4] = Item;

				String Units = String.valueOf(entry.get("Units"));
				values[5] = Units;

				String UnitCost = (String) entry.get("UnitCost");
				values[6] = UnitCost;

				String Total = (String) entry.get("Total");
				values[7] = Total;

				addJSONRow(new RowReaderBean(values[0], values[1], values[2], values[3], values[4], values[5],
						values[6], values[7]));

			}
			for (var item : JSONrows) {

				String num1 = item.getUnits();
				String num2 = item.getUnitCost().replace(".00", "");
				item.setUnitCost(num2);

				float f1 = Float.valueOf(num1);
				float f2 = Float.valueOf(num2);
				float tot = f1 * f2;

				item.setTotal(String.valueOf(tot));

				// System.out.println(item);

			}
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void addCSVRow(RowReaderBean row) {
		CSVrows.add(row);
	}

	public static void addJSONRow(RowReaderBean row) {
		JSONrows.add(row);
	}

}
