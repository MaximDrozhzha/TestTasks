package task670;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Main {
	
	String inputFileName = "input.txt";
	String outputFileName = "output.txt";
	Integer searchPosition;

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.readData();
		Integer result = m.MaxNumberWithoutIdenticalDigits(m.searchPosition);
		m.writeData(result);
	}

	void readData() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
			searchPosition = Integer.valueOf(br.readLine());
		} catch (IOException e) {
			throw e;
		}
	}

	void writeData(Integer result) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
			bw.write(String.valueOf(result));
		} catch (IOException e) {
			throw e;
		}
	}

	Integer MaxNumberWithoutIdenticalDigits(Integer searchPosition) {
		Integer result = 0;
		int numberOfElements = 0;
		int i = 0;
		while (numberOfElements < searchPosition) {
			i++;
			result++;
			if (!hasIdenticalDigit(i)) {
				numberOfElements++;
			}
		}
		return result;
	}

	static boolean hasIdenticalDigit(Integer inputNumber) {
		String s = Integer.toString(inputNumber);
		HashSet<Character> hSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			hSet.add(s.charAt(i));
		}

		if (hSet.size() == s.length()) {
			return false;
		} else {
			return true;
		}
	}

}