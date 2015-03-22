package geekfest.com.byldafarm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by raghav on 22/03/15.
 */
public class AlgorithmBadCase {

//    public static FarmCalculationResult efficientFarm(int budget, int farmArea, int crop1CostPice, int crop1SellingPrice,
//                                                 int crop2CostPrice, int crop2SellingPrice);

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int bugdet = s.nextInt();
        int noOfCrops = s.nextInt();
        int area = s.nextInt();
        int crop1sellingprice, crop2sellingprice, crop3sellingprice, crop1costprice, crop2costprice, crop3costprice;
        crop1costprice = s.nextInt();
        crop1sellingprice = s.nextInt();

        crop2costprice = s.nextInt();
        crop2sellingprice = s.nextInt();

        crop3costprice = s.nextInt();
        crop3sellingprice = s.nextInt();




        int n = 100;int totalCost = 0, totalProfit = 0;
        float crop1Area, crop2Area, crop3Area;
        int minCost = Integer.MAX_VALUE;
        float maxProf = -1, maxcrop1Area = 0,maxcrop2Area = 0,maxcrop3Area = 0;
        for(int i = 0; i<=100; i++){
            for(int j = 0; j<=100; j++){
                for(int k = 0; k<=100; k++) {
                    if(i+j+k == 100)
                    {
                        totalCost = i * crop1costprice + j * crop2costprice + k * crop3costprice;
                        totalCost = totalCost/100;
                        totalCost = totalCost * area;
                        if(totalCost <= bugdet && totalCost <= minCost) {
                            minCost = totalCost;
                            System.out.println(minCost + " " + i+" "+j+" "+k);
                            totalProfit = i * (crop1sellingprice - crop1costprice) + j * (crop2sellingprice - crop2costprice) + k * (crop3sellingprice - crop3costprice);

                            totalProfit = (totalProfit*area) / 100;

                            if (maxProf <= totalProfit) {
                                maxProf = totalProfit;
                                maxcrop1Area = i;
                                maxcrop2Area = j;
                                maxcrop3Area = k;
                            }
                        }
                        else if (totalCost > bugdet)
                            continue;


                    }
                }
            }
        }

        System.out.println(maxProf + " " + maxcrop1Area + " " + maxcrop2Area + " " + maxcrop3Area);
        System.out.println(maxProf + " " + (maxcrop1Area/100)*area + " " + (maxcrop2Area/100)*area + " " + (maxcrop3Area/100)*area);
    }

}
