package exceptions;

public class NotEnoughMoney extends Exception{
    public NotEnoughMoney(int hisMoney, int check){
        super(String.format("Недостаточно средств для оплаты такси. Ваш счет: %s. Чек за такси: %s.", hisMoney, check));
    }
}
