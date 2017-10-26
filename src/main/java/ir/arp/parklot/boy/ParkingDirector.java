package ir.arp.parklot.boy;

import ir.arp.parklot.report.ReportItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 10/26/2017.
 */
class ParkingDirector {
    private List<ParkingManager> parkingManagers = new ArrayList<>();

    List<ReportItem> generateReport() {
        List<ReportItem> reportItems = new ArrayList<>();
        for (ParkingManager parkingManager : parkingManagers) {
            ReportItem mReportItem = new ReportItem("M", parkingManager.getNumOfParkedCars(), parkingManager.getParkingSpaces());
            reportItems.add(mReportItem);
            reportItems.add(mReportItem);
            reportItems.add(mReportItem);
        }
        return reportItems;
    }

    void addParkingManager(ParkingManager parkingManager) {
        parkingManagers.add(parkingManager);
    }

}
