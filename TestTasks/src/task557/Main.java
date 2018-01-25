package task557;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	String inputFileName = "input.txt";
	String outputFileName = "output.txt";
	Integer numberOfMatrix;
	Integer matrixDemension;
	Integer resultLine;
	Integer resultColumn;
	Integer absBase;
	ArrayList<int[][]> matrixList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.readData();
		int[] resultMatrix = m.matrixList.get(0)[m.resultLine];
		for (int i = 0; i < m.numberOfMatrix - 1; i++) {
			resultMatrix = m.particalMatrixMultipication(resultMatrix, m.matrixList.get(i + 1), m.absBase);
		}
		Integer result = resultMatrix[m.resultColumn];
		m.writeData(result);
	}

	void readData() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {

			String[] sArr = br.readLine().split("\\s");
			numberOfMatrix = Integer.valueOf(sArr[0]);
			matrixDemension = Integer.valueOf(sArr[1]);

			sArr = br.readLine().split("\\s");
			resultLine = Integer.valueOf(sArr[0]) - 1;
			resultColumn = Integer.valueOf(sArr[1]) - 1;

			absBase = Integer.valueOf(br.readLine());
			br.readLine();

			for (int i = 0; i < numberOfMatrix; i++) {
				int[][] intArr = new int[matrixDemension][matrixDemension];
				for (int k = 0; k < matrixDemension; k++) {
					sArr = br.readLine().split("\\s");
					for (int m = 0; m < matrixDemension; m++) {
						intArr[k][m] = Integer.valueOf(sArr[m]);
					}
				}
				br.readLine();
				matrixList.add(intArr);
			}
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

	int[] particalMatrixMultipication(int[] m1, int[][] m2, int absBase) {
		int[] result = new int[matrixDemension];
		for (int j = 0; j < matrixDemension; j++) {
			for (int k = 0; k < matrixDemension; k++) {
				result[j] = (result[j] + m1[k] * m2[k][j]) % absBase;
			}
		}
		return result;
	}

}
