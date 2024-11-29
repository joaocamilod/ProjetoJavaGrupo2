import mochila.ResolutorMochila;
import mochila.ResolutorMochila.Item;

public class Main {
    public static void main(String[] args) {
        Item[] itens = {
                new Item(2, 3),
                new Item(3, 4),
                new Item(4, 5),
                new Item(5, 6)
        };
        int capacidade = 10;

        int valorMaximo = ResolutorMochila.resolverMochila(itens, capacidade);
        System.out.println("Valor máximo que pode ser alcançado: " + valorMaximo);
        System.out.println("\nItens selecionados para alcançar esse valor:");
        ResolutorMochila.imprimirItensSelecionados(itens, capacidade);
    }
}