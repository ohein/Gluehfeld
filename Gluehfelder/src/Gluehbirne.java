
public class Gluehbirne {
	boolean zustand = false;

	public boolean getZustand() {
		return zustand;
	}

	public void setZustand(boolean zustand) {
		this.zustand = zustand;
	}

	public void anschalten() {
		zustand = true;
	}

	public void ausschalten() {
		zustand = false;
	}

	public String toString() {
		if (zustand)
			return "X";
		else
			return "_";
	}
}
