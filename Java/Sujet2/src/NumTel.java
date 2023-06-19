
public class NumTel {
	
	private String valeur;
	private String type;
	
	public NumTel(String valeur, String type) throws ExceptionNumero {
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
		
		this.type = type;
	}

	@Override
	public String toString() {
		return "NumTel [valeur=" + valeur + "type= "+ type + "]";
	}
	
	public static void main(String[] args) {
		try {
			NumTel a = new NumTel("0123456789","perso");
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
