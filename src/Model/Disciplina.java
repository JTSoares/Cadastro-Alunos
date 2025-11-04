package Model;

public class Disciplina {
	
	//*******************************ATRIBUTOS*******************************
	private String nome;
	private String codigo;
	private int cargaHoraria; 

	//*******************************CONSTRUTOR*******************************
	public Disciplina(String nome, String codigo, int carga) {
		this.setNome(nome);
		this.setCargaHoraria(carga);
		this.setCodigo(codigo);
	}
	
	//*******************************GETTER E SETTER*******************************

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		if(!codigo.isEmpty()){
			this.codigo = codigo;
		}
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		if(cargaHoraria>0){
			this.cargaHoraria = cargaHoraria;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(!nome.isEmpty()){
			this.nome = nome;
		}
	}

	@Override
	public String toString() {
		return "Disciplina{" +
				"Nome='" + nome + '\'' +
				", Codigo='" + codigo + '\'' +
				", Carga Horaria=" + cargaHoraria +
				'}';
	}
}
