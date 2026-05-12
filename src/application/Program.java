package application;

import model.entities.MenuItem;
import model.entities.Order;
import model.entities.OrderItem;
import model.enums.MenuCategory;
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




        sc.close();
    }

    private static List<MenuItem> initializeMenu() {

        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("X-Bacon", 25.0, MenuCategory.MAIN_COURSE));
        menuItemList.add(new MenuItem("X-Egg", 25.0, MenuCategory.MAIN_COURSE));
        menuItemList.add(new MenuItem("X-Salada", 25.0, MenuCategory.MAIN_COURSE));
        menuItemList.add(new MenuItem("X-Tudo", 25.0, MenuCategory.MAIN_COURSE));
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
           } else if (itemAtual.getCategory() == MenuCategory.DESSERT){
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

        System.out.println(order.getTableNumber());
        System.out.println(order.getTime());

        for (OrderItem i : order.getItems()) {
            System.out.println(i.getQuantity() + "x " + i.getItem().getName() + " - R$" + String.format("%.2f", i.getSubtotal()));
        }

        System.out.println("===== RESUMO DO PEDIDO =====");
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
