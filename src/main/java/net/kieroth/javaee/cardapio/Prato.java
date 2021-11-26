package net.kieroth.javaee.cardapio;

public class Prato {
	 	protected int id;
	    protected String nome;
	    protected String ingredientes;
	    protected float preco;
	 
	    public Prato() {
	    }
	 
	    public Prato(int id) {
	        this.id = id;
	    }
	 
	    public Prato(int id, String nome, String ingredientes, float preco) {
	        this(nome, ingredientes, preco);
	        this.id = id;
	    }
	     
	    public Prato(String nome, String ingredientes, float preco) {
	        this.nome = nome;
	        this.ingredientes = ingredientes;
	        this.preco = preco;
	    }
	 
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public String getNome() {
	        return nome;
	    }
	 
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	 
	    public String getIngredientes() {
	        return ingredientes;
	    }
	 
	    public void setIngredientes(String ingredientes) {
	        this.ingredientes = ingredientes;
	    }
	 
	    public float getPreco() {
	        return preco;
	    }
	 
	    public void setPreco(float preco) {
	        this.preco = preco;
	    }
}
