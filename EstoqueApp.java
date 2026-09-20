public class EstoqueApp {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        System.out.println("--- 1. CADASTRANDO PRODUTOS ---");
        try {
            ProdutoComum p1 = new ProdutoComum("Arroz 5kg", 25.0, 10);
            ProdutoComum p2 = new ProdutoComum("Feijão 1kg", 8.5, 20);
            ProdutoPerecivel p3 = new ProdutoPerecivel("Leite", 4.5, 15, 10);
            ProdutoPerecivel p4 = new ProdutoPerecivel("Iogurte", 5.0, 10, 2);

            estoque.adicionarProduto(p1);
            estoque.adicionarProduto(p2);
            estoque.adicionarProduto(p3);
            estoque.adicionarProduto(p4);

            estoque.exibirProdutos();

            System.out.println("\n--- 2. TESTANDO EXCEÇÃO: QUANTIDADE INVÁLIDA ---");
            ProdutoComum pInvalido = new ProdutoComum("Produto Falso", 10.0, -5);

        } catch (QuantidadeInvalidaException e) {
            System.out.println(">> ERRO CAPTURADO: " + e.getMessage());

        } catch (EstoqueException e) {
            System.out.println(">> ERRO GENÉRICO DE ESTOQUE: " + e.getMessage());
        }

        System.out.println("\n--- 3. TESTANDO VENDAS E EXCEÇÃO: ESTOQUE INDISPONÍVEL ---");
        try {
            System.out.println("Efetuando venda de 3 unidades do Arroz...");
            estoque.venderProduto(0, 3);
            System.out.println("Venda efetuada com sucesso!");

            System.out.println("Tentando vender 15 unidades de Iogurte...");
            estoque.venderProduto(3, 15);


        } catch (ProdutoIndisponivelException e) {
            System.out.println(">> ERRO CAPTURADO: " + e.getMessage());

        } catch (EstoqueException e) {
            System.out.println(">> ERRO GENÉRICO DE ESTOQUE: " + e.getMessage());
        }

        System.out.println("\n--- 4. RESUMO FINAL E VALOR TOTAL ---");
        estoque.exibirProdutos();
        System.out.printf("Valor Total do Estoque: R$ %.2f\n", estoque.calcularValorTotalEstoque());
    }
}