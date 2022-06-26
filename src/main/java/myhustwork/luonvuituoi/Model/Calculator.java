
package myhustwork.luonvuituoi.Model;

public class Calculator {
    public static Boolean WarningBalance(double balance) { //canh bao
        return balance < 0;
    }
    public static void PercentCategories(int Month) {
        double sum;
        double[] sumCategories = new double[12];
        double[] percentCategories = new double[12];
        int i;
        if(Transaction.Date.getMonth == Month){
            sum += Transaction.Fluctuation.getAmount;
            i = Transaction.Categories.getResult;
            sumCategories[i] += Transaction.Fluctuation.getAmount;
        }
        for(int j = 0; j < 12; j++) {
            percentCategories[j] = sumCategories[j]/sum;
        }
    }
}
