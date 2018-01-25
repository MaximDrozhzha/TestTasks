package task278;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	String inputFileName = "input.txt";
	String outputFileName = "output.txt";
	String sequenceS;
	String sequenceT;

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.readData();
		String result = m.tCanBeEvolutedFromS(m.sequenceS, m.sequenceT);
		m.writeData(result);
	}

	void readData() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
			sequenceS = br.readLine();
			sequenceT = br.readLine();
		} catch (IOException e) {
			throw e;
		}
	}

	void writeData(String result) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
			bw.write(result);
		} catch (IOException e) {
			throw e;
		}
	}

	String tCanBeEvolutedFromS(String s, String t) {
		int lastPos = 0;
		for (int i = 0; i < s.length(); i++) {
			boolean charWasFound = false;
			for (int k = lastPos; k < t.length(); k++) {
				lastPos++;
				if (s.charAt(i) == t.charAt(k)) {
					charWasFound = true;
					break;
				}
			}
			if (lastPos == t.length() & !charWasFound) {
				return "NO";
			}
		}
		return "YES";
	}

}
