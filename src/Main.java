import java.util.ArrayList;
class Sphere {
    private double radius;
    private double[] pos = new double[3];
    public Sphere() {
        this.radius = 1.0;
        this.pos[0] = 1.0;
        this.pos[1] = 1.0;
        this.pos[2] = 1.0;
    }
    public Sphere(double radius, double x, double y, double z) {
        this.radius = radius;
        this.pos[0] = x;
        this.pos[1] = y;
        this.pos[2] = z;
    }
    public Sphere(Sphere other) {
        this.radius = other.radius;
        this.pos[0] = other.pos[0];
        this.pos[1] = other.pos[1];
        this.pos[2] = other.pos[2];
    }
    public double[] getPos() {
        return pos;
    }
    public void setPos(double[] pos) {
        this.pos[0] = pos[0];
        this.pos[1] = pos[1];
        this.pos[2] = pos[2];
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
    public void moveCone(double deltaX, double deltaY, double deltaZ) {
        pos[0] = deltaX;
        pos[1] = deltaY;
        pos[2] = deltaZ;
        System.out.println("Нові координати: \nx: " + pos[0] + "\ny: " + pos[1] + "\nz: " + pos[2]);
    }
}

class BankCard {

    private String cardNumber;
    private String expiryDate;
    private String cvv2Code;
    private String pinCode;
    private String cardType;
    private Double balance;

    // Конструктор без параметрів
    public BankCard() {
        this.cardNumber = "";
        this.expiryDate = "";
        this.cvv2Code = "";
        this.pinCode = "";
        this.cardType = "";
        this.balance = 0.0;
    }

    // Конструктор з параметрами
    public BankCard(String cardNumber, String expiryDate, String cvv2Code, String pinCode, String cardType, double balance) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv2Code = cvv2Code;
        this.pinCode = pinCode;
        this.cardType = cardType;
        this.balance = balance;
    }

    // Конструктор копіювання
    public BankCard(BankCard other) {
        this.cardNumber = other.cardNumber;
        this.expiryDate = other.expiryDate;
        this.cvv2Code = other.cvv2Code;
        this.pinCode = other.pinCode;
        this.cardType = other.cardType;
        this.balance = other.balance;
    }

    // Get-методи та set-методи
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getCvv2Code() {
        return cvv2Code;
    }
    public void setCvv2Code(String cvv2Code) {
        this.cvv2Code = cvv2Code;
    }
    public String getPinCode() {
        return pinCode;
    }
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    public String getCardType() {
        return cardType;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String toString() {
        return "Номер картки: " + cardNumber.substring(0, 4) + " " + cardNumber.substring(4, 8) + " " +
                cardNumber.substring(8, 12) + " " + cardNumber.substring(12) + "\n" +
                "Придатна до: " + expiryDate.substring(0, 2) + "/" + expiryDate.substring(2) + "\n" +
                "Тип картки: " + cardType;
    }


}

    class BankClient {
        private String fullName;
        private String dateOfBirth;
        private ArrayList<BankCard> cards;

        // Конструктор без параметрів
        public BankClient() {
            cards = new ArrayList<>();
        }

        // Конструктор з параметрами
        public BankClient(String fullName, String dateOfBirth, int numberOfCards) {
            this.fullName = fullName;
            this.dateOfBirth = dateOfBirth;
            this.cards = new ArrayList<>(numberOfCards);
        }

        // Конструктор копіювання
        public BankClient(BankClient other) {
            this.fullName = other.fullName;
            this.dateOfBirth = other.dateOfBirth;
            this.cards = new ArrayList<>(other.cards.size());
            for (BankCard card : other.cards) {
                this.cards.add(new BankCard(card));
            }
        }

        // Get-методи та set-методи
        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public ArrayList<BankCard> getCards() {
            return cards;
        }
        public void setCards(ArrayList<BankCard> cards) {
            this.cards = cards;
        }
        // Метод для додавання картки в масив карток
        public void addCard(BankCard card) {
            cards.add(card);
        }
        public int getNumberOfCards() {
            return cards.size();
        }

        // Метод для витрачання грошей в звичайній торгівельній мережі
        public void makePurchase(int cardIndex, double amount, String pinCode) {
            BankCard card = cards.get(cardIndex);
            if (card != null && card.getPinCode().equals(pinCode) && amount <= card.getBalance()) {
                // Логіка витрати грошей
                System.out.println("Операція успішно виконана.");
            } else {
                System.out.println("Помилка: недостатньо коштів або невірний PIN-код.");
            }
        }

        // Метод для витрачання грошей в інтернеті
        public void makeOnlinePurchase(int cardIndex, double amount, String cvv2Code) {
            BankCard card = cards.get(cardIndex);
            if (card != null && card.getCvv2Code().equals(cvv2Code) && amount <= card.getBalance()) {
                // Логіка витрати грошей в інтернеті
                System.out.println("Операція успішно виконана.");
            } else {
                System.out.println("Помилка: недостатньо коштів або невірний CVV2-код.");
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder("Клієнт: " + fullName + "\nДата народження: " + dateOfBirth + "\nКартки:\n");
            for (BankCard card : cards) {
                result.append(card.toString()).append("\n");
            }
            return result.toString();
        }
}

public class Main {
    public static void main(String[] args) {
        //Task 1
        Sphere sphere1 = new Sphere();
        System.out.println("Об'єм кулі 1: " + sphere1.calculateVolume());
        Sphere sphere2 = new Sphere(3.0, 1.3,1.5,1.3);
        System.out.println("Об'єм кулі 2: " + sphere2.calculateVolume());
        sphere1.setRadius(2.0);
        System.out.println("Радіус кулі 1: " + sphere1.getRadius());

        sphere1.moveCone(1.0, 2.0, 3.0);

        Sphere sphere3 = new Sphere(sphere1);
        System.out.println("Об'єм кулі 3: " + sphere3.calculateVolume());

        //Task 2
        BankCard card = new BankCard("1234567812345678", "1225", "123", "9876", "Visa", 3553);
        System.out.println(card.toString());


        BankClient client = new BankClient("John Doe", "01012000", 2);
        client.addCard(new BankCard("1111222233334444", "0523", "456", "7890", "Mastercard", 5343));
        client.addCard(new BankCard("2222333344445555", "1122", "789", "0123", "Visa", 332.32));
        System.out.println(client.toString());
        client.makePurchase(0, 50.0, "7890");
        client.makeOnlinePurchase(0, 30.0, "456");
    }
}