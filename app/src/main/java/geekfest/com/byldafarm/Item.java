/*
 * Copyright 2014 IBM Corp. All Rights Reserved
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package geekfest.com.byldafarm;

import com.ibm.mobile.services.data.IBMDataObject;
import com.ibm.mobile.services.data.IBMDataObjectSpecialization;

@IBMDataObjectSpecialization("Item")
public class Item extends IBMDataObject {
    public static final String CLASS_NAME = "Item";
    private static final String STATE = "State";
    private static final String DISTRICT = "District";
    private static final String CROP = "Crop";
    private static final String SEASON = "Season";
    //SeedCost,Fertilizer,LaourCost,SellingPrice,CostPrice

    public String getState() {
        return (String) getObject(STATE);
    }

    public String getDistrict() {
        return (String) getObject(DISTRICT);
    }

    public String getCrop() {
        return (String) getObject(CROP);
    }

    public String getSeason() {
        return (String) getObject(SEASON);
    }


}