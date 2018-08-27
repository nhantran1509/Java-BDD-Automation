package pages.fe;

import commons.Commons;
import constants.Controls;
import keywords.WebUI;
import pages.BasePages;
import utilities.Utility;

public class CarsPage extends BasePages {
    static String btnAirportPickup = "//button[.=' Airport Pickup']";

    public static void filerSearch(String startGrade, String carType, String airportPickup){
        Commons.filerSearch(startGrade, null, null, carType, airportPickup );
    }

    public static void setPriceRange(Integer from, Integer to) {
        Commons.setPriceRange(from, to);
    }

    public static void verifyGreenAirportPickupButton() {
        String xpathTableRow = Utility.convertXpath(Controls.table, "bgwhite table table-striped") + "/*/tr";
        int rows = WebUI.countItemsOnList(xpathTableRow, null);
        for(int n=1; n<= rows; n++){
            String newXpath = String.format("%s[%d]%s", xpathTableRow, n, btnAirportPickup);
            WebUI.verifyCssValue(newXpath, null, "background-color", "rgba(92, 184, 92, 1)");
        }
    }
}
