package com.example.laptop.truckmanv5;

import java.util.HashMap;
import java.util.Map;

public class AT_RiskAssessment_model {


    private String user_name;
    private String user_email;
    private String user_department_area;
    private String user_contact_number;
    private String startDate;
    private String endDate;

    private String traffic_ppe;
    private String traffic_roads_or_footpath;
    private String traffic_following_guidelines;
    private String traffic_beacons;
    private String traffic_left_site_in_good_order;

    private String heights_fall_arrest_system;
    private String heights_harness_inspection;
    private String heights_ladder_inspection;
    private String heights_laddertied;
    private String heights_manholebarrier;

    private String riverlifejacket;
    private String riverwaders;
    private String rivertieoffpoint;
    private String riversafeaccess;

    private String overheadpowerlines;

    private String undergrounddrawings;
    private String undergroundcat;

    private String manhandleloadassessed;
    private String manhandlemechanical;
    private String manhandletwomanlift;

    private String confinedspace;

    private String powertools;

    private String generalppesafetygoogles;
    private String generalppehearing;
    private String generalppegloves;
    private String generalppedustoverall;
    private String generalppehivis;
    private String generalppehardhat;
    private String generalppedustmask;



    public AT_RiskAssessment_model () {
    }
    //////////////////////////////////////////////////////////////////////////////////

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getuser_name() {
        return user_name;
    }

    public void setuser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getuser_email() {
        return user_email;
    }

    public void setuser_department_area(String user_department_area) {
        this.user_department_area = user_department_area;
    }
    public String getuser_department_area() {
        return user_department_area;
    }

    public void setuser_contact_number(String user_contact_number) {
        this.user_contact_number = user_contact_number;
    }
    public String getuser_contact_number() {
        return user_contact_number;
    }

    public void setstartDate(String startDate) {
        this.startDate =startDate;
    }
    public String getstartDate() {
        return this.startDate;
    }

    public void setendDate(String endDate) {
        this.endDate =endDate;
    }
    public String getendDate() {
        return this.endDate;
    }


    ///////////////////////////////////////1 Traffic/////////////////////////////////////////////////

    public void settraffic_ppe(String traffic_ppe) {
        this.traffic_ppe = traffic_ppe;
    }
    public String gettraffic_ppe() {
        return traffic_ppe;
    }

    public void settraffic_roads_or_footpath(String traffic_roads_or_footpath) {
        this.traffic_roads_or_footpath = traffic_roads_or_footpath;
    }
    public String gettraffic_roads_or_footpath() {
        return traffic_roads_or_footpath;
    }

    public void settraffic_following_guidelines(String traffic_following_guidelines) {
        this.traffic_following_guidelines = traffic_following_guidelines;
    }
    public String gettraffic_following_guidelines() {
        return traffic_following_guidelines;
    }

    public void settraffic_beacons(String traffic_beacons) {
        this.traffic_beacons = traffic_beacons;
    }
    public String gettraffic_beacons() {
        return traffic_beacons;
    }

    public void settraffic_left_site_in_good_order(String traffic_left_site_in_good_order) {
        this.traffic_left_site_in_good_order = traffic_left_site_in_good_order;
    }
    public String gettraffic_left_site_in_good_order() {
        return traffic_left_site_in_good_order;
    }

    ///////////////////////////////////////2 Heights/////////////////////////////////////////////////

    public void setheights_fall_arrest_system(String heights_fall_arrest_system) {
        this.heights_fall_arrest_system = heights_fall_arrest_system;
    }
    public String getheights_fall_arrest_system() {
        return heights_fall_arrest_system;
    }

    public void setheights_harness_inspection(String heights_harness_inspection) {
        this.heights_harness_inspection = heights_harness_inspection;
    }
    public String getheights_harness_inspection() {
        return heights_harness_inspection;
    }

    public void setheights_ladder_inspection(String heights_ladder_inspection) {
        this.heights_ladder_inspection = heights_ladder_inspection;
    }
    public String getheights_ladder_inspection() {
        return heights_ladder_inspection;
    }

    public void setheights_laddertied(String heights_laddertied) {
        this.heights_laddertied = heights_laddertied;
    }
    public String getheights_laddertied() {
        return heights_laddertied;
    }

    public void setheights_manholebarrier(String heights_manholebarrier) {
        this.heights_manholebarrier = heights_manholebarrier;
    }
    public String getheights_manholebarrier() {
        return heights_manholebarrier;
    }

    ///////////////////////////////////////3 River Cleaning/////////////////////////////////////////////////

    public void setriverlifejacket(String riverlifejacket) {
        this.riverlifejacket = riverlifejacket;
    }
    public String getriverlifejacket() {
        return riverlifejacket;
    }
    public void setriverwaders(String riverwaders) {
        this.riverwaders = riverwaders;
    }
    public String getriverwaders() {
        return riverwaders;
    }
    public void setrivertieoffpoint(String rivertieoffpoint) {
        this.rivertieoffpoint = rivertieoffpoint;
    }
    public String getrivertieoffpoint() {
        return rivertieoffpoint;
    }
    public void setriversafeaccess(String riversafeaccess) {
        this.riversafeaccess = riversafeaccess;
    }
    public String getriversafeaccess() {
        return riversafeaccess;
    }

    ///////////////////////////////////////4 Overhead Powerlines/////////////////////////////////////////////////

    public void setconfinedspace(String confinedspace) {
        this.confinedspace = confinedspace;
    }
    public String getconfinedspace() {
        return confinedspace;
    }

    ///////////////////////////////////////5 Underground Services/////////////////////////////////////////////////

    public void setundergrounddrawings(String undergrounddrawings) {
        this.undergrounddrawings = undergrounddrawings;
    }
    public String getundergrounddrawings() {
        return undergrounddrawings;
    }
    public void setundergroundcat(String undergroundcat) {
        this.undergroundcat = undergroundcat;
    }
    public String getundergroundcat() {
        return undergroundcat;
    }

    ///////////////////////////////////////6 Manual Handling/////////////////////////////////////////////////

    public void setmanhandleloadassessed(String manhandleloadassessed) {
        this.manhandleloadassessed = manhandleloadassessed;
    }
    public String getmanhandleloadassessed() {
        return manhandleloadassessed;
    }
    public void setmanhandlemechanical(String manhandlemechanical) {
        this.manhandlemechanical = manhandlemechanical;
    }
    public String getmanhandlemechanical() {
        return manhandlemechanical;
    }
    public void setmanhandletwomanlift(String manhandletwomanlift) {
        this.manhandletwomanlift = manhandletwomanlift;
    }
    public String getmanhandletwomanlift() {
        return manhandletwomanlift;
    }

    ///////////////////////////////////////7 Confined Space////////////////////////////////////////////////

    public void setoverheadpowerlines(String overheadpowerlines) {
        this.overheadpowerlines = overheadpowerlines;
    }
    public String getoverheadpowerlines() {
        return overheadpowerlines;
    }

    ///////////////////////////////////////8 power Tools////////////////////////////////////////////////

    public void setpowertools(String powertools) {
        this.powertools = powertools;
    }
    public String getpowertools() {
        return powertools;
    }

    ///////////////////////////////////////9 General PPE////////////////////////////////////////////////

    public void setgeneralppesafetygoogles(String generalppesafetygoogles) {
        this.generalppesafetygoogles = generalppesafetygoogles;
    }
    public String getgeneralppesafetygoogles() {
        return generalppesafetygoogles;
    }
    public void setgeneralppehearing(String generalppehearing) {
        this.generalppehearing = generalppehearing;
    }
    public String getgeneralppehearing() {
        return generalppehearing;
    }
    public void setgeneralppegloves(String generalppegloves) {
        this.generalppegloves = generalppegloves;
    }
    public String getgeneralppegloves() {
        return generalppegloves;
    }
    public void setgeneralppedustoverall(String generalppedustoverall) {
        this.generalppedustoverall = generalppedustoverall;
    }
    public String getgeneralppedustoverall() {
        return generalppedustoverall;
    }
    public void setgeneralppehivis(String generalppehivis) {
        this.generalppehivis = generalppehivis;
    }
    public String getgeneralppehivis() {
        return generalppehivis;
    }
    public void setgeneralppehardhat(String generalppehardhat) {
        this.generalppehardhat = generalppehardhat;
    }
    public String getgeneralppehardhat() {
        return generalppehardhat;
    }
    public void setgeneralppedustmask(String generalppedustmask) {
        this.generalppedustmask = generalppedustmask;
    }
    public String getgeneralppedustmask() {
        return generalppedustmask;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////


//--------------------------------------------------------------------------------------

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("user_name", user_name);
        result.put("user_email", user_email);
        result.put("user_department_area", user_department_area);
        result.put("user_contact_number", user_contact_number);
        result.put("startDate", startDate);
        result.put("endDate", endDate);

        //--------------------------------------------------------------------------------------

        result.put("traffic_ppe", traffic_ppe);
        result.put("traffic_roads_or_footpath", traffic_roads_or_footpath);
        result.put("traffic_following_guidelines", traffic_following_guidelines);
        result.put("traffic_beacons", traffic_beacons);
        result.put("traffic_left_site_in_good_order", traffic_left_site_in_good_order);

        //--------------------------------------------------------------------------------------

        result.put("heights_fall_arrest_system", heights_fall_arrest_system);
        result.put("heights_harness_inspection", heights_harness_inspection);
        result.put("heights_ladder_inspection", heights_ladder_inspection);
        result.put("heights_laddertied", heights_laddertied);
        result.put("heights_manholebarrier", heights_manholebarrier);

        //--------------------------------------------------------------------------------------

        result.put("riverlifejacket", riverlifejacket);
        result.put("riverwaders", riverwaders);
        result.put("rivertieoffpoint", rivertieoffpoint);
        result.put("riversafeaccess", riversafeaccess);

        //--------------------------------------------------------------------------------------

        result.put("overheadpowerlines", overheadpowerlines);

        //--------------------------------------------------------------------------------------

        result.put("undergrounddrawings", undergrounddrawings);
        result.put("undergroundcat", undergroundcat);

        //--------------------------------------------------------------------------------------

        result.put("manhandleloadassessed", manhandleloadassessed);
        result.put("manhandlemechanical", manhandlemechanical);
        result.put("manhandletwomanlift", manhandletwomanlift);

        //--------------------------------------------------------------------------------------

        result.put("confinedspace", confinedspace);

        //--------------------------------------------------------------------------------------

        result.put("powertools", powertools);

        //--------------------------------------------------------------------------------------

        result.put("generalppesafetygoogles", generalppesafetygoogles);
        result.put("generalppehearing", generalppehearing);
        result.put("generalppegloves", generalppegloves);
        result.put("generalppedustoverall", generalppedustoverall);
        result.put("generalppehivis", generalppehivis);
        result.put("generalppehardhat", generalppehardhat);
        result.put("generalppedustmask", generalppedustmask);

        //--------------------------------------------------------------------------------------




        return result;
    }

}