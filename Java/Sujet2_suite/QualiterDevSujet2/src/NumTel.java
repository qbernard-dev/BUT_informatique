
public class NumTel {
	private String valeur;

	public NumTel(String valeur) throws ExceptionNumero {
		this.valeur = valeur;
		if(this.valeur.length() != 10) {
			throw new ExceptionNumero();
		}
		char[] chars = this.valeur.toCharArray();
		for (char c : chars) {
			if(!Character.isDigit(c)) {
				throw new ExceptionNumero();
			}
		}
	}

	@Override
	public String toString() {
		return "NumTel [valeur=" + valeur + "]";
	}
	
	public static void main(String[] args) {
		try {
			NumTel a = new NumTel("0679708256");
		} catch(ExceptionNumero e) {
			System.out.println("catch");
		}
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
}
