package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._2Exersices._03CardsWithPower;

public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;
    private int power;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
        this.power = this.cardRank.getPowerRank() + this.cardSuit.getSuitPower();
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }


}
