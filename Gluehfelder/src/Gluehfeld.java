
public class Gluehfeld {
	private static int X = 12;
	private static int Y = 12;
	private static int SCHWELLE = 2;
	private static int ANZAHLITERATIONEN = 20;

	private Gluehbirne[][] feld = new Gluehbirne[Gluehfeld.X][Gluehfeld.Y];
	private boolean[][] naechsterZustand = new boolean[Gluehfeld.X][Gluehfeld.Y];

	public Gluehfeld() {
		for (int i = 0; i < feld.length; i++)
			for (int j = 0; j < feld[i].length; j++)
				feld[i][j] = new Gluehbirne();
	}

	private void ausgabe() {
		for (int j = 1; j < Gluehfeld.X - 1; j++) {
			System.out.println();
			for (int k = 1; k < Gluehfeld.X - 1; k++)
				System.out.print(feld[j][k]);
		}
	}

	public void fallA() {
		feld[3][3].anschalten();
		feld[4][3].anschalten();
		feld[3][2].anschalten();
		feld[3][3].anschalten();
		feld[3][4].anschalten();
	}

	public void fallB() {
		fallA();
		feld[3][7].anschalten();
		ausgabe();
	}

	public void doit() {
		ausgabe();
		for (int i = 0; i < Gluehfeld.ANZAHLITERATIONEN; i++) {
			for (int j = 1; j < Gluehfeld.X - 1; j++)
				for (int k = 1; k < Gluehfeld.Y - 1; k++)
					naechsterZustand[j][k] = neuerZustand(getNachbarn(j, k), Gluehfeld.SCHWELLE);
			for (int j = 1; j < Gluehfeld.X - 1; j++)
				for (int k = 1; k < Gluehfeld.Y - 1; k++)
					feld[j][k].setZustand(naechsterZustand[j][k]);
			ausgabe();
		}
	}

	private Gluehbirne[] getNachbarn(int i, int j) {
		Gluehbirne[] nb = new Gluehbirne[4];
		nb[0] = feld[i][j - 1];
		nb[1] = feld[i - 1][j];
		nb[2] = feld[i + 1][j];
		nb[3] = feld[i][j + 1];
		return nb;
	}

	private boolean neuerZustand(Gluehbirne[] nachbarn, int schwelle) {
		int zaehl = 0;
		for (int i = 0; i < nachbarn.length; i++)
			if (nachbarn[i] != null)
				if (nachbarn[i].getZustand())
					zaehl++;
		if (zaehl >= schwelle)
			return true;
		else
			return false;
	}
}
