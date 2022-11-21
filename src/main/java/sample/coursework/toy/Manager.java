package sample.coursework.toy;

public class Manager {

    static private int budget;
    static private boolean budgetCheck = true;

    static public void checkBudget(int price) {
        budget -= price;
        if (budget < 0) {
            budgetCheck = false;
            budget = 0;
        }
    }

    static public void setBudget(int budget1) {
        budget = budget1;
    }

    static public boolean isBudgetCheck() {
        return budgetCheck;
    }

    static public int getBudget() {
        return budget;
    }
}
