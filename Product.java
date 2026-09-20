public abstract class Product implements Vendavel {
    private String nome;
    private double preco;
    private int quantidade;

    public Product(String nome, double preco, int quantidade) throws QuantidadeInvalidaException {
        if (preco < 0 || quantidade < 0) {
            throw new QuantidadeInvalidaException("O preço e a quantidade não podem ser negativos.");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public abstract double calcularValorTotal();

    public String getDescricao() {
        return String.format("Produto: %s | Preço: R$ %.2f | Quantidade: %d", nome, preco, quantidade);
    }

    @Override
    public void vender(int quantidadeDesejada) throws ProdutoIndisponivelException {
        if (quantidadeDesejada > this.quantidade) {
            throw new ProdutoIndisponivelException("Estoque insuficiente para o produto: " + nome + ". Quantidade disponível: " + this.quantidade);
        }
        this.quantidade -= quantidadeDesejada;
    }

    public void aplicarDesconto(double percentual) {
        this.preco -= this.preco * (percentual / 100.0);
    }

    public void aplicarDesconto(double percentual, double descontoMaximo) {
        double valorDesconto = this.preco * (percentual / 100.0);
        if (valorDesconto > descontoMaximo) {
            valorDesconto = descontoMaximo;
        }
        this.preco -= valorDesconto;
    }
}