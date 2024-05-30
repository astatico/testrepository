package testcode.javadoc;

/**
 * Класс для работы с банковскими счетами.
 */
public class BankAccount {

    private double balance;

    /**
     * Конструктор для создания нового банковского счета с начальным балансом.
     *
     * @param initialBalance начальный баланс счета.
     */
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Метод для внесения денег на счет.
     *
     * @param amount сумма для внесения.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Метод для снятия денег со счета.
     *
     * @param amount сумма для снятия.
     * @throws IllegalArgumentException если сумма для снятия превышает баланс.
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств на счете");
        }
        balance -= amount;
    }

    /**
     * Получить текущий баланс счета.
     *
     * @return текущий баланс.
     */
    public double getBalance() {
        return balance;
    }
}
