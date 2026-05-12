package application;

import model.entities.MenuItem;
import model.entities.Order;
import model.entities.OrderItem;
import model.enums.MenuCategory;
import model.enums.PaymentMethod;
import model.services.OrderService;
import model.services.PaymentService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main() {

        Scanner sc = new Scanner(System.in);

        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();
        List<MenuItem> menuItemList = initializeMenu();

        while (true) {

            System.out.print("Informe a mesa: ");
            int tableNumber = sc.nextInt();
            sc.nextLine();

            Order order = orderService.createOrder(tableNumber);

            while (true) {

                showMenu(menuItemList);
                System.out.print("Escolha o pedido: ");
                int chooseItemOfMenu = sc.nextInt();
                sc.nextLine();

                MenuItem menuItem = findItemByOption(menuItemList, chooseItemOfMenu);

                System.out.print("Quantidade: ");
                int quantity = sc.nextInt();
                sc.nextLine();

                orderService.addItem(order, menuItem, quantity);

                System.out.print("Deseja adicionar mais itens? (s/n): ");
                char option = sc.next().charAt(0);

                if (option == 'n') {
                    break;
                }

            }

            showOrderSummary(order, orderService);

            boolean paymentValid = false;

            while (!paymentValid) {
                System.out.println("Por favor, escolha uma das formas de pagamento abaixo: ");
                System.out.println("1 - PIX");
                System.out.println("2 - Debito");
                System.out.println("3 - Credito");
                System.out.println("4 - Dinheiro");

                System.out.print("Forma de pagamento selecionada: ");
                int choosePayment = sc.nextInt();
                sc.nextLine();

                switch (choosePayment) {

                    case 1: {
                        PaymentMethod paymentMethod = PaymentMethod.PIX;
                        paymentService.processPayment(order, paymentMethod);
                        System.out.println("Pedido pago com sucesso!");
                        paymentValid = true;
                        break;
                    }

                    case 2: {
                        PaymentMethod paymentMethod = PaymentMethod.DEBIT_CARD;
                        paymentService.processPayment(order, paymentMethod);
                        System.out.println("Pedido pago com sucesso!");
                        paymentValid = true;
                        break;
                    }

                    case 3: {
                        PaymentMethod paymentMethod = PaymentMethod.CREDIT_CARD;
                        paymentService.processPayment(order, paymentMethod);
                        System.out.println("Pedido pago com sucesso!");
                        paymentValid = true;
                        break;
                    }

                    case 4: {
                        PaymentMethod paymentMethod = PaymentMethod.MONEY;
                        paymentService.processPayment(order, paymentMethod);
                        System.out.println("Pedido pago com sucesso!");
                        paymentValid = true;
                        break;
                    }

                    default: {
                        System.out.println("Opção invalida.");
                    }
                }

            }


            System.out.print("Deseja criar um novo pedido? (s/n): ");
            char chooseNewOrder = sc.next().charAt(0);

            if (chooseNewOrder == 'n') {
                break;
            }

        }

    }

    private static List<MenuItem> initializeMenu() {

        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("X-Bacon", 25.0, MenuCategory.MAIN_COURSE));
        menuItemList.add(new MenuItem("X-Egg", 18.0, MenuCategory.MAIN_COURSE));
        menuItemList.add(new MenuItem("X-Salada", 21.0, MenuCategory.MAIN_COURSE));
        menuItemList.add(new MenuItem("X-Tudo", 30.0, MenuCategory.MAIN_COURSE));
        menuItemList.add(new MenuItem("Cola", 10.0, MenuCategory.BEVERAGE));
        menuItemList.add(new MenuItem("Guaraná", 8.0, MenuCategory.BEVERAGE));
        menuItemList.add(new MenuItem("Sorvete", 7.50, MenuCategory.DESSERT));
        menuItemList.add(new MenuItem("Bolo", 11.0, MenuCategory.DESSERT));

        return menuItemList;

    }

    private static void showMenu(List<MenuItem> menuItemList) {

        boolean hamburguerImpresso = false;
        boolean bebidaImpresso = false;
        boolean sobremesaImpresso = false;


        for (int i = 0; i < menuItemList.size(); i++) {
            MenuItem itemAtual = menuItemList.get(i);

            if (itemAtual.getCategory() == MenuCategory.MAIN_COURSE) {
                if (!hamburguerImpresso) {
                    System.out.println("===== HAMBURGUER =====");
                    hamburguerImpresso = true;
                }
            } else if (itemAtual.getCategory() == MenuCategory.BEVERAGE) {
                if (!bebidaImpresso) {
                    System.out.println("===== BEBIDAS =====");
                    bebidaImpresso = true;
                }
            } else if (itemAtual.getCategory() == MenuCategory.DESSERT) {
                if (!sobremesaImpresso) {
                    System.out.println("===== SOBREMESA =====");
                    sobremesaImpresso = true;
                }
            }

            System.out.println((i + 1) + " - " + itemAtual.getName() + " - R$" + String.format("%.2f", itemAtual.getPrice()));

        }
    }

    private static MenuItem findItemByOption(List<MenuItem> menuItemList, int option) {
        return menuItemList.get(option - 1);
    }

    private static void showOrderSummary(Order order, OrderService orderService) {

        System.out.println();
        System.out.println("===== RESUMO DO PEDIDO =====");
        System.out.println("Mesa: " + order.getTableNumber());
        System.out.println("Horario do pedido: " + order.getTime());

        for (OrderItem i : order.getItems()) {
            System.out.println(i.getQuantity() + "x " + i.getItem().getName() + " - R$" + String.format("%.2f", i.getSubtotal()));
        }

        System.out.println("===== VALORES DO PEDIDO =====");
        System.out.println("Subtotal: R$" + String.format("%.2f", orderService.calculatedSubtotal(order)));
        System.out.println("Desconto: R$" + String.format("%.2f", orderService.calculatedDiscount(order)));
        System.out.println("Taxa: R$" + String.format("%.2f", orderService.calculatedServiceFee(order)));
        System.out.println("===== VALOR FINAL =====");
        System.out.println("TOTAL: R$" + String.format("%.2f", orderService.calculateTotal(order)));
        System.out.println("Forma de pagamento: " + order.getPaymentMethod());
        System.out.println("Status: " + order.getStatus());
        System.out.println("-----------------------");
    }

}
