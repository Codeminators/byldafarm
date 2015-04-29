package geekfest.com.byldafarm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by raghav on 28/04/15.
 */
public class random {
    public static FarmCalculationResult efficientFarm(int budget, double farmArea)//, ArrayList<Crop> crop)
    {
        FarmCalculationResult farmCalculationResult = new FarmCalculationResult();
        double area = (double) farmArea;

        int crop1CostPrice = 5714;
        int crop1SellingPrice = 9565;
        int crop2CostPrice = 9931;
        int crop2SellingPrice = 12984;
        int crop3CostPrice = 5730;
        int crop3SellingPrice = 7230;
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

        for (int i = 0; i <= 100; i++) {

            for (int j = 0; j + i <= 100; j++) {

                totalCostPrice = crop1CostPrice * i * area / 100 + crop2CostPrice * (j) * area / 100 + crop3CostPrice * (100 - i - j) * area / 100;
//                System.out.println(i + " " + j + " " + (100 -i -j));

                if (totalCostPrice <= budget) {

                    totalSellingPrice = crop1SellingPrice * i * area / 100 + crop2SellingPrice * (j) * area / 100 + crop3SellingPrice * (100 - i - j) * area / 100;

                    if (totalSellingPrice - totalCostPrice > max) {
                        max = totalSellingPrice - totalCostPrice;
                        farmCalculationResult.maxAreaCrop1 = i * area / 100;
                        farmCalculationResult.maxAreaCrop2 = (j) * area / 100;
                        farmCalculationResult.maxAreaCrop3 = (100 - i - j) * area / 100;
                        farmCalculationResult.totalCost = totalCostPrice;
                        farmCalculationResult.totalProfit = max;
                        System.out.println(farmCalculationResult.totalProfit + " " + farmCalculationResult.maxAreaCrop1 + " " + farmCalculationResult.maxAreaCrop2 + " " + farmCalculationResult.maxAreaCrop3 + " " + farmCalculationResult.totalCost);
                    }
                }
                //175421.0 18.25 0.0 119889.0
            }
        }
        if(farmCalculationResult.totalProfit == 0.0){
            return efficientFarm(budget, area * 99.0/100.0 );
        }
        return farmCalculationResult;
    }

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        //    int bugdet = s.nextInt();
//        //      int noOfCrops = s.nextInt();
////        int area = s.nextInt();
//
//        int crop1sellingprice, crop2sellingprice, crop3sellingprice, crop1costprice, crop2costprice, crop3costprice;
//
//
//        FarmCalculationResult farmCalculationResult = efficientFarm(12, 200);
//
//        System.out.println(farmCalculationResult.totalProfit + " " + farmCalculationResult.maxAreaCrop1 + " " + farmCalculationResult.maxAreaCrop2 + " " + farmCalculationResult.totalCost);
////        System.out.println(maxProf + " " + (maxcrop1Area/100)*area + " " + (maxcrop2Area/100)*area + " " + (maxcrop3Area/100)*area);
//
//        System.out.println("Hello World");
//        String a = "balrampur, nandgaon, wardha, lalitpur, kantha, kawardha, nanded, gorakhpur, ahmednagar, dhule, moradabad, auraiya, ngr., mau, kanker, sant, s.ravi, crops, deoria, jalaun, raebareli, bhavnagar, kutch, ramabai, das, chandrapur, broach, kanpur, mandurbar, kabir, mainpuri, raj, latur, porbandar, unnao, muzaffarnagar, banda, dohad, patan, bijnor, bilaspur, basti, mahasmund, rajkot, bagpat, tapi, ahmedabad, banas, gonda, meerut, jashpur, dangs, mahals, durg, g.buddha, surat, varanasi, sarguja, kheda, etawah, jalgaon, jhansi, solapur, surendranagar, akola, anand, raipur, navsari, mahamaya, firozabad, mixed, jamnagar, ballia, mahoba, sitapur, etah, ambedkar, kannauj, mathura, narmada, shivasti, valsad, panch, bastar, mehsana, kheri, gandhinagar, pratapgarh, koriya, bareilly, sonbhadra, nasik, junagarh, hingoli, (kabirdham), badaun, nagpur, bahraich, kushi, rampur, dantewara, satara, j.b.phule, yavatmal, allahabad, fatehpur, pune, maharahganj, ghaziabad, azamgarh, nagar, sultanpur, hardoi, dhamtari, aurangabad, amravati, hamirpur, city, kaushambi, chitrakut, washim, aligarh, sabarkantha, faizabad, ghazipur, jaunpur, vadodara, barabanki, gadchiroli, saharanpur, parbhani, korba, farrukhabad, beed, raigarh, mirzapur, shahjahanpur, amreli, janjgir-champa, lucknow, sangli, chandauli, kolhapur, osmanabad, buldhana, siddharth, pilibhit, bullandshahr, jalana, agra";
//        for(int i = 0; i < a.length(); i++){
//            if(a.substring(i,i+1).equals(",")){
//                a = a.substring(0,i) + "\",\"" + a.substring(i+2, a.length());
//            }
//        }
//        System.out.println(a);
////        String[] districts = {"bastar","bilaspur","dantewara","dhamtari","durg","janjgir-champa","jashpur","kanker","kawardha","(kabirdham)","korba","koriya","mahasmund","raigarh","raipur","raj","nandgaon","sarguja","bastar","bilaspur","dantewara","dhamtari","durg","janjgir-champa","jashpur","kanker","kawardha","(kabirdham)","korba","koriya","mahasmund","raigarh","raipur","raj","nandgaon","sarguja","bastar","bilaspur","ahmedabad","ahmedabad","amreli","amreli","anand","anand","banas","kantha","banas","kantha","bhavnagar","bhavnagar","broach","broach","dangs","dohad","gandhinagar","gandhinagar","jamnagar","jamnagar","junagarh","junagarh","kheda","kheda","kutch","kutch","mehsana","mehsana","narmada","navsari","panch","mahals","panch","mahals","panch","mahals","patan","patan","porbandar","porbandar","rajkot","rajkot","sabarkantha","sabarkantha","surat","surat","surendranagar","surendranagar","tapi","tapi","vadodara","vadodara","valsad","ahmedabad","amreli","anand","banas","kantha","bhavnagar","broach","gandhinagar","jamnagar","junagarh","kheda","kutch","mehsana","narmada","panch","mahals","patan","porbandar","rajkot","sabarkantha","surendranagar","vadodara","ahmednagar","ahmednagar","akola","akola","akola","amravati","amravati","amravati","aurangabad","aurangabad","aurangabad","beed","beed","beed","buldhana","buldhana","buldhana","chandrapur","chandrapur","dhule","dhule","dhule","gadchiroli","hingoli","hingoli","hingoli","jalana","jalana","jalana","jalgaon","jalgaon","jalgaon","kolhapur","kolhapur","latur","latur","latur","mandurbar","mandurbar","mandurbar","nagpur","nagpur","nanded","nanded","nasik","nasik","nasik","osmanabad","osmanabad","osmanabad","parbhani","parbhani","parbhani","pune","pune","sangli","sangli","sangli","satara","satara","satara","solapur","solapur","solapur","wardha","wardha","washim","washim","washim","yavatmal","yavatmal","yavatmal","ahmednagar","akola","amravati","aurangabad","beed","buldhana","chandrapur","dhule","gadchiroli","hingoli","jalana","jalgaon","kolhapur","latur","mandurbar","nagpur","nanded","nasik","osmanabad","parbhani","pune","sangli","satara","solapur","wardha","washim","yavatmal","agra","agra","agra","agra","aligarh","aligarh","aligarh","aligarh","allahabad","allahabad","allahabad","allahabad","ambedkar","ngr.","ambedkar","ngr.","ambedkar","ngr.","ambedkar","ngr.","ambedkar","ngr.","auraiya","auraiya","auraiya","auraiya","azamgarh","azamgarh","azamgarh","azamgarh","azamgarh","badaun","badaun","badaun","badaun","bagpat","bagpat","bahraich","bahraich","bahraich","bahraich","ballia","ballia","ballia","ballia","ballia","balrampur","balrampur","balrampur","balrampur","banda","banda","banda","barabanki","barabanki","barabanki","barabanki","barabanki","bareilly","bareilly","bareilly","bareilly","basti","basti","basti","basti","bijnor","bijnor","bijnor","bullandshahr","bullandshahr","bullandshahr","bullandshahr","chandauli","chandauli","chandauli","chandauli","chitrakut","chitrakut","chitrakut","deoria","deoria","deoria","deoria","deoria","etah","etah","etah","etah","etawah","etawah","etawah","etawah","faizabad","faizabad","faizabad","faizabad","farrukhabad","farrukhabad","farrukhabad","farrukhabad","fatehpur","fatehpur","fatehpur","fatehpur","firozabad","firozabad","firozabad","firozabad","g.buddha","ngr.","g.buddha","ngr.","g.buddha","ngr.","ghaziabad","ghaziabad","ghaziabad","ghaziabad","ghazipur","ghazipur","ghazipur","ghazipur","ghazipur","gonda","gonda","gonda","gonda","gorakhpur","gorakhpur","gorakhpur","gorakhpur","gorakhpur","hamirpur","hamirpur","hamirpur","hardoi","hardoi","hardoi","hardoi","j.b.phule","ngr.","j.b.phule","ngr.","j.b.phule","ngr.","j.b.phule","ngr.","jalaun","jalaun","jalaun","jalaun","jaunpur","jaunpur","jaunpur","jaunpur","jhansi","jhansi","jhansi","kannauj","kannauj","kannauj","kannauj","kanpur","city","kanpur","city","kanpur","city","kanpur","city","kaushambi","kaushambi","kaushambi","kaushambi","kheri","kheri","kheri","kheri","kheri","kushi","ngr.","kushi","ngr.","kushi","ngr.","kushi","ngr.","kushi","ngr.","lalitpur","lalitpur","lucknow","lucknow","lucknow","lucknow","lucknow","mahamaya","nagar","mahamaya","nagar","mahamaya","nagar","mahamaya","nagar","maharahganj","maharahganj","maharahganj","mahoba","mahoba","mahoba","mainpuri","mainpuri","mainpuri","mainpuri","mathura","mathura","mathura","mau","mau","mau","mau","meerut","meerut","meerut","meerut","mirzapur","mirzapur","mirzapur","mirzapur","mixed","crops","mixed","crops","mixed","crops","mixed","crops","moradabad","moradabad","moradabad","moradabad","muzaffarnagar","muzaffarnagar","muzaffarnagar","pilibhit","pilibhit","pilibhit","pratapgarh","pratapgarh","pratapgarh","pratapgarh","raebareli","raebareli","raebareli","raebareli","raebareli","ramabai","nagar","ramabai","nagar","ramabai","nagar","ramabai","nagar","ramabai","nagar","rampur","rampur","rampur","rampur","s.ravi","das","ngr.","s.ravi","das","ngr.","s.ravi","das","ngr.","saharanpur","saharanpur","saharanpur","sant","kabir","ngr.","sant","kabir","ngr.","sant","kabir","ngr.","sant","kabir","ngr.","sant","kabir","ngr.","shahjahanpur","shahjahanpur","shahjahanpur","shahjahanpur","shivasti","shivasti","shivasti","siddharth","ngr.","siddharth","ngr.","siddharth","ngr.","sitapur","sitapur","sitapur","sitapur","sitapur","sonbhadra","sonbhadra","sonbhadra","sonbhadra","sultanpur","sultanpur","sultanpur","sultanpur","sultanpur","unnao","unnao","unnao","unnao","unnao","varanasi","varanasi","varanasi","varanasi","dantewara","dhamtari","durg","janjgir-champa","jashpur","kanker","kawardha","(kabirdham)","korba","koriya","mahasmund","raigarh","raipur","raj","nandgaon","sarguja"};
//
//        System.out.println(a);
    }
}
