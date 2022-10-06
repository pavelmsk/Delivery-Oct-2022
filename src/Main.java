public class Main {

    interface Delivery {
        void supply();
    }

    static class Human implements Delivery {
        @Override
        public void supply() {
            System.out.println("Human supply");
        }
    }

    static class Bike implements Delivery {
        @Override
        public void supply() {
            System.out.println("Bike supply");
        }
    }

    interface DeliveryFactory {
        Delivery createDelivery();
    }

    static class BikeDeliveryFactory implements DeliveryFactory {
        public Delivery createDelivery() {
            return new Bike();
        }
    }

    static class HumanDeliveryFactory implements DeliveryFactory {
        public Delivery createDelivery() {
            return new Human();
        }
    }

    public static void main(String[] args) {
        DeliveryFactory deliveryFactory = supplyDelivery(2);
        Delivery delivery = deliveryFactory.createDelivery();
        delivery.supply();
    }

    static DeliveryFactory supplyDelivery(int a) {
        switch (a) {
            case 1:
                return new BikeDeliveryFactory();
            case 2:
                return new HumanDeliveryFactory();
            default:
                throw new RuntimeException("Such a factory does not exist ");
        }
    }
}