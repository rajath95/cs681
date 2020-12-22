package edu.umb.cs681.hw12;

public class MultiThread implements Runnable {

    public void run() {
        Customer customer = new Customer(new Address("Tom Brady", "Boston", "MA", 27717));
        customer.getAddress().change("Oracle Beach", "Miami", "FL", 89703);
        customer.setAddress(new Address("Roman St", "Tampa", "FL", 10929));
        System.out.println(customer.getAddress());
    }

    public static void main(String[] args) {
        MultiThread t1 = new MultiThread();
        MultiThread t2 = new MultiThread();
        MultiThread t3 = new MultiThread();
        MultiThread t4 = new MultiThread();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
    }
}
