package geekfest.com.byldafarm;

import java.util.Scanner;

/**
 * Created by raghav on 28/04/15.
 */
public class random {
    public static FarmCalculationResult efficientFarm(int budget, int farmArea)//, ArrayList<Crop> crop)
    {
        FarmCalculationResult farmCalculationResult = new FarmCalculationResult();
        double area = (double) farmArea;

        int crop1CostPrice = 4086;
        int crop1SellingPrice = 8945;
        int crop2CostPrice = 5714;
        int crop2SellingPrice = 11565;
        double max = 0.0;


        double totalCostPrice = 0.0, totalSellingPrice = 0.0;

//        for(int a = 0; a < crop.size(); a++) {
//            if (a == 0) {
//                crop1CostPrice = crop.get(a).costPrice;
//                crop1SellingPrice = crop.get(a).sellingPrice;
//            } else if (a == 1) {
//                crop2CostPrice = crop.get(a).costPrice;
//                crop2SellingPrice = crop.get(a).sellingPrice;
//            }
//        }

        for(int i = 0; i <= 100; i++){
            for(int j = 0; j <= 100; j++) {
                totalCostPrice = crop1CostPrice * i * area / 100 + crop2CostPrice * (100 - i) * area / 100;
                if (totalCostPrice <= budget) {

                    totalSellingPrice = crop1SellingPrice * i * area / 100 + crop2SellingPrice * (100 - i) * area / 100;

                    if (totalSellingPrice - totalCostPrice > max) {
                        max = totalSellingPrice - totalCostPrice;
                        farmCalculationResult.maxAreaCrop1 = i * area / 100;
                        farmCalculationResult.maxAreaCrop2 = (100 - i) * area / 100;
                        farmCalculationResult.totalCost = totalCostPrice;
                        farmCalculationResult.totalProfit = max;
                        System.out.println(farmCalculationResult.totalProfit + " " + farmCalculationResult.maxAreaCrop1 + " " + farmCalculationResult.maxAreaCrop2 + " " + farmCalculationResult.totalCost);

                    }
                }
            }

        }
        return farmCalculationResult;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //    int bugdet = s.nextInt();
        //      int noOfCrops = s.nextInt();
//        int area = s.nextInt();

        int crop1sellingprice, crop2sellingprice, crop3sellingprice, crop1costprice, crop2costprice, crop3costprice;




        FarmCalculationResult farmCalculationResult = efficientFarm(120000, 25);

        System.out.println(farmCalculationResult.totalProfit+ " " + farmCalculationResult.maxAreaCrop1+ " " + farmCalculationResult.maxAreaCrop2+ " " + farmCalculationResult.totalCost);
//        System.out.println(maxProf + " " + (maxcrop1Area/100)*area + " " + (maxcrop2Area/100)*area + " " + (maxcrop3Area/100)*area);
    }
}
