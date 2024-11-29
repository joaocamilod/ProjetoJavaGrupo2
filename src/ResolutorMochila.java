package mochila;

public class ResolutorMochila {
    public static class Item {
        int peso;
        int valor;

        public Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static int resolverMochila(Item[] itens, int capacidade) {
        int n = itens.length;
        int[][] dp = new int[n + 1][capacidade + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidade; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (itens[i - 1].peso <= w) {
                    dp[i][w] = Math.max(
                            itens[i - 1].valor + dp[i - 1][w - itens[i - 1].peso],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacidade];
    }

    public static void imprimirItensSelecionados(Item[] itens, int capacidade) {
        int n = itens.length;
        int[][] dp = new int[n + 1][capacidade + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidade; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (itens[i - 1].peso <= w) {
                    dp[i][w] = Math.max(
                            itens[i - 1].valor + dp[i - 1][w - itens[i - 1].peso],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int w = capacidade;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println("Item selecionado: peso = " + itens[i - 1].peso + ", valor = " + itens[i - 1].valor);
                w = w - itens[i - 1].peso; // Correção do índice
            }
        }
    }
}