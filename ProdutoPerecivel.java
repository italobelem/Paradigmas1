public class ProdutoPerecivel extends Product {
    private int diasParaVencer;

    public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParaVencer) throws QuantidadeInvalidaException {
        super(nome, preco, quantidade);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcularValorTotal() {
        double valorBase = getPreco() * getQuantidade();
        if (diasParaVencer <= 3) {
            double desconto = valorBase * 0.8;
            return valorBase * desconto; //20% de desconto
        }
        return valorBase;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " | Dias para Vencer: " + diasParaVencer;
    }
}