package geekfest.com.byldafarm;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by raghav on 22/03/15.
 */
public class AlgorithmBadCase {

    public static FarmCalculationResult efficientFarm(int budget, int farmArea, ArrayList<Crop> crop)
    {
        FarmCalculationResult farmCalculationResult = new FarmCalculationResult();

        int crop1CostPrice = 0;
        int crop1SellingPrice = 0;
        int crop2CostPrice = 0;
        int crop2SellingPrice = 0;
        int crop3CostPrice = 0;
        int crop3SellingPrice = 0;

        for(int a = 0; a < crop.size(); a++){
            if(a == 0){
                crop1CostPrice = crop.get(a).costPrice;
                crop1SellingPrice = crop.get(a).sellingPrice;
            } else if (a == 1) {
                crop2CostPrice = crop.get(a).costPrice;
                crop2SellingPrice = crop.get(a).sellingPrice;
            } else if (a ==2) {
                crop3CostPrice = crop.get(a).costPrice;
                crop3SellingPrice = crop.get(a).sellingPrice;
            }
        }


        int n = 100;
        int totalCost = 0, totalProfit = 0;

        int minCost = Integer.MAX_VALUE;
        float maxProf = -1, maxcrop1Area = 0,maxcrop2Area = 0,maxcrop3Area = 0;
        for(int i = 0; i<=100; i++){
            for(int j = 0; j<=100; j++){
                for(int k = 0; k<=100; k++) {
                    if(i+j+k == 100)
                    {
                        totalCost = i * crop1CostPrice + j * crop2CostPrice + k * crop3CostPrice;
                        totalCost = totalCost/100;
                        totalCost = totalCost * farmArea;
                        if(totalCost <= budget && totalCost <= minCost) {
                            minCost = totalCost;
                           Log.d("RaghavFunction", "" + minCost + " " + i + " " + j + " " + k);
                            totalProfit = i * (crop1SellingPrice - crop1CostPrice) + j * (crop2SellingPrice - crop2CostPrice) +
                                    k * (crop3SellingPrice - crop3CostPrice);

                            totalProfit = (totalProfit * farmArea) / 100;

                            if (maxProf <= totalProfit) {
                                maxProf = totalProfit;
                                maxcrop1Area = i;
                                maxcrop2Area = j;
                                maxcrop3Area = k;
                            }
                        }
                        else if (totalCost > budget)
                            continue;


                    }
                }
            }
        }
        farmCalculationResult.totalProfit = maxProf;
        farmCalculationResult.maxAreaCrop1 = (maxcrop1Area/100) * farmArea;
        farmCalculationResult.maxAreaCrop2 = (maxcrop2Area/100) * farmArea;
        farmCalculationResult.maxAreaCrop3 = (maxcrop3Area/100) * farmArea;

        return farmCalculationResult;
    }

//    public static void main(String[] args){
//        Scanner s = new Scanner(System.in);
//        int bugdet = s.nextInt();
//        int noOfCrops = s.nextInt();
//        int area = s.nextInt();
//        int crop1sellingprice, crop2sellingprice, crop3sellingprice, crop1costprice, crop2costprice, crop3costprice;
//        crop1costprice = s.nextInt();
//        crop1sellingprice = s.nextInt();
//
//        crop2costprice = s.nextInt();
//        crop2sellingprice = s.nextInt();
//
//        crop3costprice = s.nextInt();
//        crop3sellingprice = s.nextInt();
//
//
//
//
//        int n = 100;int totalCost = 0, totalProfit = 0;
//        float crop1Area, crop2Area, crop3Area;
//        int minCost = Integer.MAX_VALUE;
//        float maxProf = -1, maxcrop1Area = 0,maxcrop2Area = 0,maxcrop3Area = 0;
//        for(int i = 0; i<=100; i++){
//            for(int j = 0; j<=100; j++){
//                for(int k = 0; k<=100; k++) {
//                    if(i+j+k == 100)
//                    {
//                        totalCost = i * crop1costprice + j * crop2costprice + k * crop3costprice;
//                        totalCost = totalCost/100;
//                        totalCost = totalCost * area;
//                        if(totalCost <= bugdet && totalCost <= minCost) {
//                            minCost = totalCost;
//                            System.out.println(minCost + " " + i+" "+j+" "+k);
//                            totalProfit = i * (crop1sellingprice - crop1costprice) + j * (crop2sellingprice - crop2costprice) + k * (crop3sellingprice - crop3costprice);
//
//                            totalProfit = (totalProfit*area) / 100;
//
//                            if (maxProf <= totalProfit) {
//                                maxProf = totalProfit;
//                                maxcrop1Area = i;
//                                maxcrop2Area = j;
//                                maxcrop3Area = k;
//                            }
//                        }
//                        else if (totalCost > bugdet)
//                            continue;
//
//
//                    }
//                }
//            }
//        }
//
//        System.out.println(maxProf + " " + maxcrop1Area + " " + maxcrop2Area + " " + maxcrop3Area);
//        System.out.println(maxProf + " " + (maxcrop1Area/100)*area + " " + (maxcrop2Area/100)*area + " " + (maxcrop3Area/100)*area);
//    }

}
