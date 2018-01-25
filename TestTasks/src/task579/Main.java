package task579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	String inputFileName = "input.txt";
	String outputFileName = "output.txt";
	Integer numberOfElements;
	Integer[] inputSequence;

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.readData();
		ArrayList<Integer> result = m.maxAbsSummSequence(m.inputSequence);
		m.writeData(result);
	}

	void readData() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {

			numberOfElements = Integer.valueOf(br.readLine());

			String[] sArr = br.readLine().split("\\s");
			Integer[] iArr = new Integer[numberOfElements];
			for (int i = 0; i < numberOfElements; i++) {
				iArr[i] = Integer.valueOf(sArr[i]);
			}
			inputSequence = iArr;

		} catch (IOException e) {
			throw e;
		}
	}

	ArrayList<Integer> maxAbsSummSequence(Integer[] sequence) {

		int n = sequence.length;
		ArrayList<Integer> result = new ArrayList<>();

		Integer summ = 0;
		for (int i = 0; i < n; i++) {
			summ += sequence[i];
		}

		if (summ >= 0) {
			for (int i = 0; i < n; i++) {
				if (sequence[i] >= 0) {
					result.add(i + 1);
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				if (sequence[i] < 0) {
					result.add(i + 1);
				}
			}
		}
		return result;
	}

	void writeData(ArrayList<Integer> result) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
			bw.write(String.valueOf(result.size()));
			bw.newLine();
			for (Integer i : result) {
				bw.write(String.valueOf(i) + " ");
			}
		} catch (IOException e) {
			throw e;
		}
	}
}
