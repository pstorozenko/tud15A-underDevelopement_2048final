package ned.tud15a.underDevelopment;

import java.awt.event.KeyEvent;

public class ActionUp implements Action {
	Cells main_cells = Cells.getInstance();
	int[][] cells = main_cells.matrix.data;
	int r = main_cells.matrix.data.length;
	int c = main_cells.matrix.data[0].length;

	public ActionUp() { }

	private void merge() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c-1; j++) {
				if (cells[i][j] == cells[i][j + 1]) {
					cells[i][j] = 2 * cells[i][j];
					cells[i][j + 1] = 0;
				}
			}
		}
	}

	private void shift() {
		for (int i = 0; i < cells.length; i++) {
			int[] tab = new int[cells[0].length];
			int index = 0;
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j] != 0) {
					tab[index] = cells[i][j];
					index++;
				}
			}
			for (int p = 0; p < cells[0].length; p++) {
				cells[i][p] = tab[p];
			}

		}
	}

	public void move() {
		shift();
		merge();
		shift();
	}

}